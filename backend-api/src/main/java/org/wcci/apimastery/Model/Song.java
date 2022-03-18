package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private long id;
    private String songTitle;
    private String duration;
    private int ratings;

    @Lob
    @ElementCollection
    private Collection<String> comments;

    @ManyToOne()
    @JsonIgnore
    private Album album;
    protected Song(){
    }
    public Song(Album album, String songTitle, String duration, int ratings, String...comments) {
        this.album = album;
        this.songTitle = songTitle;
        this.duration = duration;
        this.ratings = ratings;
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

    public int getRatings() {
        return ratings;
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

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void changeSongTitle(String newSongTitle){
        this.songTitle = newSongTitle;
    }
}
