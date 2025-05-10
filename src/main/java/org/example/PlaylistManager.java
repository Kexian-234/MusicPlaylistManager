package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static Playlist createPlaylist(String name, List<Song> songs) {
        Playlist playlist = new Playlist(name, songs);
        playlists.add(playlist);
        return playlist;
    }

    /**
     * saves the playlist data in a csv file
     * @param playlist
     * @throws IOException
     */
    public static void savePlaylistToFile(Playlist playlist) throws IOException {
        String filename = (playlist.getName() + ".csv").trim().replaceAll(" ", "_");
        try (FileWriter writer = new FileWriter(filename)) {
            for (Song song : playlist.getSongs()) {
                writer.write(song.getTitle() + "," + song.getArtist() + "," + song.getReleaseYear() + "," + song.getPlayCount() + "," + song.getClass().getSimpleName().replace("Song", "").toLowerCase() + "\n");
            }
        }
    }

    /**
     * loads a playlist from its csv file
     * @param name
     * @param filename
     * @return
     * @throws IOException
     */
    public static Playlist loadPlaylistFromFile(String name, String filename) throws IOException {
        Playlist playlist = new Playlist(name);
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] p = scanner.nextLine().split(",", 5);
                Song s = SongManager.createSongByGenre(p[0], p[1], p[4], Integer.parseInt(p[2]), Long.parseLong(p[3]));
                playlist.addSong(s);
            }
        }
        return playlist;
    }

    /**
     * checks if the global list of playlists contains the playlist with inputted name
     * @param name
     * @return boolean
     */
    public static boolean containsPlaylist(String name) {
        return playlists.stream().anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }

    /**
     * returns the playlist with the corresponding name
     * @param name
     * @return the playlist with the corresponding name
     */
    public static Playlist findPlaylistByName(String name) {
        for (Playlist p : playlists) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }





}
