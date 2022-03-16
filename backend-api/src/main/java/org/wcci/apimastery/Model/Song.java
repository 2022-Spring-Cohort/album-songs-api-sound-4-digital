
package org.wcci.apimastery.Model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String link;
    private int duration;
    @ElementCollection
    private String comment;
    private int ratings;

    @ManyToOne()
    private Album album;

    public Song(String title, String link, int duration, String comment, int ratings, Album album) {
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.comment = comment;
        this.ratings = ratings;
        this.album = album;
    }
    public Song(){

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public int getDuration() {
        return duration;
    }

    public String getComments() {
        return comment;
    }

    public int getRatings() {
        return ratings;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
