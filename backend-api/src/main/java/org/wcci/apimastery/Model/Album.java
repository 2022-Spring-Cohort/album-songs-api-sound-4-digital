
package org.wcci.apimastery.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String image;
    private String recordLabel;
    private int rating;

    @OneToMany
    private Collection<Song> songs;


    //private Collection<Integer> userRatings;

    private String comments;

    protected Album(){
    }

    public Album(String title, String image, String recordLabel, int rating, String comments) {
        this.title = title;
        this.image = image;
        this.recordLabel = recordLabel;
        this.rating = rating;
        this.songs = new ArrayList<Song>();
     //   this.userRatings = new ArrayList<Integer>();
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public String getComments() {
        return comments;
    }

    public int getRatings() {
        return rating;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void removeSong(Song song){
        songs.remove(song);
    }



}
