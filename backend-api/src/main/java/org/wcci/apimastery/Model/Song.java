package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private long id;
    private String songTitle;
    private String duration;

    @ElementCollection
    private Collection<Integer> rating;

    @Lob
    @ElementCollection
    private Collection<String> comments;

    @ManyToOne()
    @JsonIgnore
    private Album album;
    protected Song(){
    }
    public Song(Album album, String songTitle, String duration, int rating, String...comments) {
        this.album = album;
        this.songTitle = songTitle;
        this.duration = duration;
        this.rating = new ArrayList<Integer>();
        this.rating.add(rating);
        this.comments = Set.of(comments);
    }

    public Album getAlbum() {
        return album;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getDuration() {
        return duration;
    }

    public Iterable<Integer> getSongRatings() {
        return rating;
    }

    public long getId() {
        return id;
    }

    public Iterable<String> getComments(){
        return comments;
    }

    public void addCommentToSong(String newCommentSong){
        this.comments.add(newCommentSong);
    }

    public void addToAlbum(Album album) {
        this.album = album;
    }

    public void changeSongTitle(String newSongTitle){
        this.songTitle = newSongTitle;
    }

    public void addSongRating(Integer rating) {
        this.rating.add(rating);
    }
}
