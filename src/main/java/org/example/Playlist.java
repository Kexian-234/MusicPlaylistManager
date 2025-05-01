package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs;

    /**
     * Constructs a Playlist object with an empty list of songs
     * @param name
     */
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    /**
     * Constructs a Playlist object with selected list of songs
     * @param name
     * @param songs
     */
    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //TODO: shuffle(), getNumOfSongs()
    //TODO: add methods to add/remove/manage songs in a playlist
}
