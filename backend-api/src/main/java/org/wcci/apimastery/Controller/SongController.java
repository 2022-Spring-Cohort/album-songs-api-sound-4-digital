package org.wcci.apimastery.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wcci.apimastery.Entities.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@Controller
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
    public Song getSongs(@PathVariable long id){
        return songRepo.findById(id).get();
    }
    //@PostMapping("")


}
