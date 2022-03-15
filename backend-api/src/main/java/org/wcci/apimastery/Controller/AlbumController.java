package org.wcci.apimastery.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Entity.Album;
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
    public Iterable<Album> getAlbums(){
        return albumRepo.findAll();
    }
    @GetMapping("/albums/{id}")
    public Album getAlbum(@PathVariable long id){
        return albumRepo.findById(id).get();
    }
    @PostMapping("/albums/{id}/addSong")
    public Album addSongToAlbum(@PathVariable long id, @RequestAttribute String song){
        Album album = albumRepo.findById(id).get();
//        songRepo.save(newSong);
        return album;
    }

}
