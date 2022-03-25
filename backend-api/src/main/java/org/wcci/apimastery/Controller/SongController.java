package org.wcci.apimastery.Controller;

import org.springframework.http.converter.json.AbstractJsonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@RestController
public class SongController {
    private SongRepository songRepo;
    private AlbumRepository albumRepo;

    public SongController(SongRepository songRepo, AlbumRepository albumRepo) {
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
    }

    @GetMapping("/songs")
    public Iterable<Song> getSongs(){
        return songRepo.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song getSong(@PathVariable long id){
        return songRepo.findById(id).get();
    }

    @DeleteMapping("/songs/{id}")
    public Album deleteSongById(@PathVariable Long id){
        Song song = songRepo.findById(id).get();
        songRepo.deleteById(id);
        return albumRepo.findById(song.getAlbum().getId()).get();
    }
    @PatchMapping("/songs/{id}")
    public Album changeSongTitle(@PathVariable long id, @RequestBody String title) {
        Song song = songRepo.findById(id).get();
        song.changeSongTitle(title);
        songRepo.save(song);
        return song.getAlbum();
    }
    @PatchMapping("/songs/{id}/addSongComment")
    public Album addSongComment(@PathVariable long id, @RequestBody String newComment) {
        Song song = songRepo.findById(id).get();
        song.addCommentToSong(newComment);
        songRepo.save(song);
        return song.getAlbum();
    }
    @PatchMapping("/songs/{id}/addRating")
    public Album addSongRating(@PathVariable long id, @RequestBody Integer rating){
        Song song = songRepo.findById(id).get();
        song.addSongRating(rating);
        songRepo.save(song);
        return song.getAlbum();
    }
}
