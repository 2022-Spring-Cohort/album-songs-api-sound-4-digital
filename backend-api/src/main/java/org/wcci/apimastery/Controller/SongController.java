package org.wcci.apimastery.Controller;

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

}
