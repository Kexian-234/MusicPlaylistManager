package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PremiumUser extends User {
    private Set<Song> favoriteSongs;

    /**
     * Creates a PremiumUser object with an empty myPlaylists, and empty favoriteSongs
     * @param username
     */
    public PremiumUser(String username) {
        super(username);
        this.favoriteSongs = new HashSet<>();
    }

    /**
     * Creates a PremiumUser object with empty favoriteSongs
     * @param username
     */
    public PremiumUser(String username, List<Playlist> myPlaylists) {
        super(username, myPlaylists);
        this.favoriteSongs =  new HashSet<>();
    }

    /**
     * Plays the song selected, with no ad.
     * @param song
     */
    @Override
    public void playSong(Song song) {
        song.play();
    }

    /**
     * Cycle through a playlist and play each song, with no ad.
     * @param playlist
     */
    @Override
    public void playPlaylist(Playlist playlist) {
        for (Song song : playlist.getSongs()) {
            playSong(song);
        }
    }

    //TODO: methods to create, load, manage playlists
    //TODO: methods to add and manage favorite songs
}
