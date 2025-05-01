package org.example;

import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {
    private static List<Playlist> playlists = new ArrayList<>();

    public static List<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * creates a Playlist object with an empty list of songs and add it to the list of playlists
     * @param name
     * @return
     */
    public static Playlist createPlaylist(String name) {
        Playlist playlist = new Playlist(name);
        playlists.add(playlist);
        return playlist;
    }

    /**
     * creates a Playlist object with the selected list of songs and add it to the list of playlists
     * @param name
     * @return
     */
    public Playlist createPlaylist(String name, List<Song> songs) {
        Playlist playlist = new Playlist(name, songs);
        playlists.add(playlist);
        return playlist;
    }

    //TODO: adding methods to save, load playlists from csv file

}
