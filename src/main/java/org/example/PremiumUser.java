package org.example;

import java.io.IOException;
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

    /**
     * create a new playlist and add it to the User's myPlaylists and also the global playlists in PlaylistManager
     * @param name
     */
    public void createPlaylist(String name) {
        if (PlaylistManager.containsPlaylist(name)) {
            System.out.println("A playlist with that name already exists.");
            return;
        }
        this.myPlaylists.add(PlaylistManager.createPlaylist(name));
    }

    /**
     * adds a selected song to a selected playlist, then updates the playlist's csv file
     * @param playlist
     * @param song
     * @throws IOException
     */
    public void addSongToPlaylist(Playlist playlist, Song song) throws IOException {
        if (playlist.containsSong(song)) { System.out.println("This song is already in the selected playlist!"); }
        else {
            playlist.addSong(song);
            PlaylistManager.savePlaylistToFile(playlist);
        }
    }

    /**
     * removes a selected song from a selected playlist, then updates the playlist's csv file
     * @param playlist
     * @param song
     * @throws IOException
     */
    public void removeSongFromPlaylist(Playlist playlist, Song song) throws IOException {
        if (playlist.containsSong(song)) {
            playlist.removeSong(song);
            PlaylistManager.savePlaylistToFile(playlist);
        }
        else System.out.println("This song is not in the selected playlist!");
    }


    /**
     * adds the selected song from user's favorite songs
     * @param song
     */
    public void addFavoriteSong(Song song) {
        favoriteSongs.add(song);
    }

    /**
     * removes the selected song from user's favorite songs
     * @param song
     */
    public void removeFavoriteSong(Song song) {
        favoriteSongs.remove(song);
    }

    public Set<Song> getFavoriteSongs() {
        return favoriteSongs;
    }
}
