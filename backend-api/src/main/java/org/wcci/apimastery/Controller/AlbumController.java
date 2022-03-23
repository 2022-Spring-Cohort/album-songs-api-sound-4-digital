package org.wcci.apimastery.Controller;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@RestController
public class AlbumController {

    private AlbumRepository albumRepo;
    private SongRepository songRepo;

    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo){
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
    }

    @GetMapping("/albums")
    public Iterable<Album> getAlbums() {
        return albumRepo.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album getSongs(@PathVariable long id) {
        return albumRepo.findById(id).get();
    }

    @DeleteMapping("/albums/{id}")
    public Iterable<Album> deleteAlbumById(@PathVariable Long id){
        albumRepo.deleteById(id);
        return albumRepo.findAll();
    }

    @PostMapping("/albums/addAlbum")
    public Iterable<Album> addAlbum(@RequestBody Album albumToAdd){
        albumRepo.save(albumToAdd);
        return albumRepo.findAll();
    }

    @PatchMapping("/albums/{id}/addComment")
    public Album addAlbumComment(@PathVariable Long id, @RequestBody String newComment){
        Album album = albumRepo.findById(id).get();
        album.addCommentToAlbum(newComment);
        albumRepo.save(album);
        return album;
    }

    @PatchMapping("/albums/{id}/addSong")
    public Album addSong(@PathVariable Long id, @RequestBody Song song){
        Album album = albumRepo.findById(id).get();
        songRepo.save(song);
        song.addToAlbum(album);
        album.addSong(song);
        albumRepo.save(album);
        return album;
    }

    @DeleteMapping("/albums/{id}/removeSong")
    public Album removeSongFromAlbum(@PathVariable long id, @RequestBody String songTitle){
        Album album = albumRepo.findById(id).get();
        Song song = songRepo.findById(id).get();
        songRepo.deleteById(id);
        albumRepo.save(album);
        return albumRepo.findById(id).get();
    }

    @PatchMapping("/albums/{id}")
    public Album changeAlbumTitle(@PathVariable long id, @RequestBody String title) {
        Album albumToEdit = albumRepo.findById(id).get();
        albumToEdit.changeAlbumTitle(title);
        albumRepo.save(albumToEdit);
        return albumToEdit;
    }
    @PatchMapping("/albums/{id}/addRating")
    public Album addAlbumRating(@PathVariable long id, @RequestBody Integer rating){
        Album album = albumRepo.findById(id).get();
        album.addAlbumRating(rating);
        albumRepo.save(album);
        return album;
    }
}
