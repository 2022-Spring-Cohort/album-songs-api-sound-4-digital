package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private SongRepository songRepo;

    public Populator(AlbumRepository albumRepo, SongRepository songRepo){
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Album heavyPettingZoo = new Album("Heavy Petting Zoo", "img_url", "self-published",
                5, "it rocks");
        albumRepo.save(heavyPettingZoo);
        Song hobophobic = new Song("title", "", 5, "", 5, heavyPettingZoo);
        songRepo.save(hobophobic);
        Song freedomLike = new Song("Freedom Like A Shopping Cart", "", 5, "", 5, heavyPettingZoo);
        songRepo.save(freedomLike);
    }
}