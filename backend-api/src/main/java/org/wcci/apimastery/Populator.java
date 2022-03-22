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

        Album imWithYou = new Album("I'm With You", "img_url", "Warner Records",
                5, "it rocks");
        albumRepo.save(imWithYou);
        Album takeCare = new Album("Take Care","img", "sd",80,"it's the worst");
        albumRepo.save(takeCare);
        Album starBoy = new Album("Star Boy","img_url2","Best One",10,"Awesome");
        albumRepo.save(starBoy);
        Album headlines = new Album("Headlines","img","ys",9,"great taste");
        albumRepo.save(headlines);
        Album punkInDrublic = new Album("Punk in Drublic", "", "Self-published", 10, "");
        albumRepo.save(punkInDrublic);


        Song goodbyeHooray = new Song(imWithYou, "", "5:20", 5, "great song");
        songRepo.save(goodbyeHooray);
        Song brutus = new Song(headlines, "this is a title", "7:00", 5, "excellent");
        songRepo.save(brutus);
        Song african = new Song(starBoy, "title of song", "2:37", 5, "popular");
        songRepo.save(african);
        Song shotforme = new Song(takeCare, "Make me proud", "4:20", 4, "dope");
        songRepo.save(shotforme);
        Song doingitwrong = new Song(takeCare, "Practice", "4:17", 3, "lmao");
        songRepo.save(doingitwrong);
        Song wavinflag = new Song(starBoy, "Coca-Cola", "2:45", 3, "great song");
        songRepo.save(wavinflag);
        Song ethiopia = new Song(imWithYou, "Ethiopia", "4:44", 7, "life changing song");
        songRepo.save(ethiopia);
        Song happiness = new Song(imWithYou, "Happiness Loves Company", "6:66", 6, "diabolical");
        songRepo.save(happiness);
        Song linoleum = new Song(punkInDrublic, "Linoleum", "4:00",6,"cuh-razy");
        songRepo.save(linoleum);
        Song theCause = new Song(punkInDrublic, "The Cause", "7:50", 7, "too quiet");
        songRepo.save(theCause);
        Song fleas = new Song(headlines, "Fleas", "3:00", 8, "dope stuff");
        songRepo.save(fleas);
        Song jeff = new Song(punkInDrublic, "Jeff Wears Birkenstocks", "4:10", 4, "hello-world");
        songRepo.save(jeff);
    }

}