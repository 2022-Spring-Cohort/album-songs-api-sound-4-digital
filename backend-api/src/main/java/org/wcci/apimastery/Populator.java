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
        Album albumOne = new Album("title","img", "sd",80,"it's the worst");
        albumRepo.save(albumOne);
        Album starBoy = new Album("Side Walk","img_url2","Best One",10,"Awesome");
        albumRepo.save(starBoy);
        Album takeCare = new Album("Headlines","img","ys",9,"great taste");
        albumRepo.save(takeCare);
        Album punkInDrublic = new Album("Punk in Drublic", "", "Self-published", 10, "");
        albumRepo.save(punkInDrublic);


        Song goodbyeHooray = new Song("Goodbye Hooray", "", 5, "", 5, imWithYou);
        songRepo.save(goodbyeHooray);
        Song brutus = new Song("Even You Brutus?", "", 5, "", 5, imWithYou);
        songRepo.save(brutus);
        Song african = new Song("habibi", "", 7, "", 5, starBoy);
        songRepo.save(african);
        Song shotforme = new Song("Make me proud", "", 5, "", 5, takeCare);
        songRepo.save(shotforme);
        Song doingitwrong = new Song("Practice", "", 5, "", 7, takeCare);
        songRepo.save(doingitwrong);
        Song wavinflag = new Song("Coca-Cola", "", 5, "", 7, starBoy);
        songRepo.save(wavinflag);
        Song ethiopia = new Song("Ethiopia", "", 4, "", 5, imWithYou);
        songRepo.save(ethiopia);
        Song happiness = new Song("Happiness Loves Company", "", 3, "", 5, imWithYou);
        songRepo.save(happiness);
        Song linoleum = new Song("Linoleum", "", 4, "", 5, punkInDrublic);
        songRepo.save(linoleum);
        Song theCause = new Song("The Cause", "", 4, "", 5, punkInDrublic);
        songRepo.save(theCause);
        Song fleas = new Song("Fleas", "", 4, "", 5, punkInDrublic);
        songRepo.save(fleas);
        Song jeff = new Song("Jeff Wears Birkenstocks", "", 5, "", 5, punkInDrublic);
        songRepo.save(jeff);



    }

}