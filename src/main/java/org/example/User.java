package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String username;
    private List<Playlist> myPlaylists;

    public User(String username) {
        this.username = username;
        this.myPlaylists = new ArrayList<>();
    }

    public User(String username, List<Playlist> myPlaylists) {
        this.username = username;
        this.myPlaylists = myPlaylists;
    }

    /**
     * Adds an existing playlist to user's saved playlists.
     * @param playlist
     */
    public void addPlaylist(Playlist playlist) {
        myPlaylists.add(playlist);
    }

    /**
     * abstract method that plays a song, to be implemented by subclasses of User
     * @param song
     */
    public abstract void playSong(Song song);

    /**
     * abstract method that plays a playlist, to be implemented by subclasses of User
     * @param playlist
     */
    public abstract void playPlaylist(Playlist playlist);
}
