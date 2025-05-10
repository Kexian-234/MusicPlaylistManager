package org.example;

import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * plays all songs in a playlist with random order
     */
    public void shufflePlay() {
        List<Song> shuffled = new ArrayList<>(songs);
        Collections.shuffle(shuffled);
        for (Song song : shuffled) {
            song.play();
        }
    }

    /**
     * gets the numbers of songs contained in a playlist
     * @return the numbers of songs contained in a playlist
     */
    public int getNumOfSongs() {
        return songs.size();
    }

    /**
     * adds a song to a playlist
     * @param song
     */
    public void addSong(Song song) {
        if (!songs.contains(song)) {
            songs.add(song);
        }
        else System.out.println("Failed to add song: This song is already in the playlist!");
    }

    /**
     * removes a song from a playlist
     * @param song
     */
    public void removeSong(Song song) {
        songs.remove(song);
    }

    /**
     * checks if a playlist contains the song selected
     * @param song
     * @return boolean
     */
    public boolean containsSong(Song song) {
        return songs.contains(song);
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

}
