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

    @PostMapping("/albums/{id}/addSong")
    public Album addSongToAlbum(@PathVariable long id, @RequestBody Song song){
        Album album = albumRepo.findById(id).get();
        song.setAlbum(album);
        songRepo.save(song);
        return album;
    }

    @PostMapping("/albums/addAlbum")
    public Iterable<Album> addAlbum(@RequestBody Album album){
        albumRepo.save(album);
        return albumRepo.findAll();
    }

}
