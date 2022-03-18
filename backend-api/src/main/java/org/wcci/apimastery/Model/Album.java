
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

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Song> songs;

    @Lob
    @ElementCollection
    private Collection<String> comments;

    protected Album(){
    }

    public Album(String title, String image, String recordLabel, int rating, String...comments) {
        this.title = title;
        this.image = image;
        this.recordLabel = recordLabel;
        this.rating = rating;
        this.songs = new ArrayList<Song>();
        this.comments = Set.of(comments);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void changeAlbumTitle(String newAlbumTitle) {
        title = newAlbumTitle;
    }

    public String getImage() {
        return image;
    }

    public String getRecordLabel() {
        return recordLabel;
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

    public Iterable<String> getComments() {
        return comments;
    }

    public void addCommentToAlbum(String newCommentAlbum){
        this.comments.add(newCommentAlbum);
    }
    }
