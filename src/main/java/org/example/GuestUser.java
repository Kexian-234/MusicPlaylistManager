package org.example;

import java.util.List;

public class GuestUser extends User {
    private int songsPlayedCount;

    /**
     * Constructs a GuestUser object, with an empty myPlaylists
     * @param username
     */
    public GuestUser(String username) {
        super(username);
        this.songsPlayedCount = 0;
    }

    /**
     * Constructs a GuestUser object
     * @param username
     */
    public GuestUser(String username, List<Playlist> myPlaylists) {
        super(username, myPlaylists);
        this.songsPlayedCount = 0;
    }

    /**
     * Plays the song selected, if 3 songs has been played, play an ad first.
     * @param song
     */
    @Override
    public void playSong(Song song) {
        this.songsPlayedCount++;
        if (songsPlayedCount == 3) {
            songsPlayedCount = 0;
            AdManager.getNextAd().play();
        }

        song.play();
    }

    /**
     * Cycle through a playlist and play each song. An ad will be played every 3 songs
     * @param playlist
     */
    @Override
    public void playPlaylist(Playlist playlist) {
        for (Song song : playlist.getSongs()) {
            playSong(song);
        }
    }
}
