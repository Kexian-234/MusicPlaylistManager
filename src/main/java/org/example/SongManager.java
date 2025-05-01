package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SongManager {
    private static List<Song> songs = new ArrayList<>();

    /**
     * Loads songs from a CSV file using Scanner and a helper method createSongByGenre.
     * Expected format: Title,Artist,Genre,Year, playCount
     */
    public static void loadFromCSV(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",", 5); // max 5 parts

            if (parts.length == 5) {
                String title = parts[0].trim();
                String artist = parts[1].trim();
                String genre = parts[2].trim();
                int year = Integer.parseInt(parts[3].trim());
                long playCount = Long.parseLong(parts[4].trim());

                Song song = createSongByGenre(title, artist, genre, year, playCount);
                songs.add(song);
            }
        }

        scanner.close();
    }

    /**
     * Base on the genre of the song, create a PopSong, RockSong or CountrySong. Default for other genre is PopSong
     * @param title
     * @param artist
     * @param genre
     * @param year
     * @param playCount
     * @return a Song object
     */
    private static Song createSongByGenre(String title, String artist, String genre, int year, long playCount) {
        switch (genre.toLowerCase()) {
            case "pop":
                return new PopSong(title, artist, year, playCount);
            case "rock":
                return new RockSong(title, artist, year, playCount);
            case "country":
                return new CountrySong(title, artist, year, playCount);
            default:
                // Load as PopSong if genre doesn't match known types
                System.out.println("Unknown genre \"" + genre + "\" — loading as PopSong by default.");
                return new PopSong(title, artist, year, playCount);
        }
    }

    /**
     * Filtering songs based on artist
     * @param artistName
     * @return Filtered list of songs
     */
    public static List<Song> filterByArtist(String artistName) {
        return songs.stream()
                .filter(song -> song.getArtist().equalsIgnoreCase(artistName))
                .toList();
    }

    public static List<Song> getSongs() {
        return songs;
    }

    // TODO: Add sorting method to sort songs by different attributes
    // TODO: Add method to get top 10 most played songs/artist
    // TODO: Add filtering by other attributes (e.g., genre, year)

}

