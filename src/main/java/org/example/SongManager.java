package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

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
    protected static Song createSongByGenre(String title, String artist, String genre, int year, long playCount) {
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

    /**
     * Sort songs based on playcount in descending order
     * @return a list of sorted songs
     */
    public static List<Song> sortByPlayCountDescending() {
        return songs.stream()
                .sorted(Song.byPlayCountDescending())
                .toList();
    }

    /**
     * Sort songs based on releaseYear in descending order
     * @return a list of sorted songs
     */
    public static List<Song> sortByReleaseYearDescending() {
        return songs.stream()
                .sorted(Song.byReleaseYearDescending())
                .toList();
    }

    /**
     * Get a list of top 10 most played songs in descending order
     * @return a list of top 10 most played songs
     */
    public static List<Song> getTopPlayed() {
        return songs.stream()
                .sorted(Song.byPlayCountDescending())
                .limit(10)
                .toList();
    }

    /**
     * Get a list of top 10 most popular artists based on total combined playcount in descending order
     * @return a list of top 10 most popular artists
     */
    public static List<String> getTopArtists() {
        Map<String, Long> totalPlays = new HashMap<>();
        for (Song s : songs) {
            String artist = s.getArtist();
            long plays = totalPlays.getOrDefault(artist, (long) 0);
            totalPlays.put(artist, plays + s.getPlayCount());
        }
        List<String> artists = new ArrayList<>(totalPlays.keySet());
        Collections.sort(artists, (a1, a2) -> Long.compare(totalPlays.get(a2), totalPlays.get(a1)));
        if(artists.size() > 10) return artists.subList(0, 10);
        else return artists;
    }

    /**
     * Searches songs with either matching(or partially matching) song name/ artist name
     * @param searching
     * @return a list of matching songs
     */
    public static List<Song> search(String searching){
        String search = searching.toLowerCase();
        return songs.stream()
                .filter(s -> s.getTitle().toLowerCase().contains(search) ||
                        s.getArtist().toLowerCase().contains(search))
                .toList();
    }

    /**
     * Get a list of songs that matches the selected genre
     * @param genre
     * @return a list of songs that matches the selected genre
     */
    public static List<Song> filterByGenre(String genre) {
        return songs.stream()
                .filter(song -> {
                    switch (genre.toLowerCase()) {
                        case "pop" -> {
                            return song instanceof PopSong;
                        }
                        case "rock" -> {
                            return song instanceof RockSong;
                        }
                        case "country" -> {
                            return song instanceof CountrySong;
                        }
                        default -> {
                            return false;
                        }
                    }
                })
                .toList();
    }

    /**
     * Get a list of songs which the release year falls between the input range
     * @param minYear
     * @param maxYear
     * @return list of songs which the release year falls between the input range
     */
    public static List<Song> filterByReleaseYearRange(int minYear, int maxYear) {
        return songs.stream()
                .filter(song -> song.getReleaseYear() >= minYear && song.getReleaseYear() <= maxYear)
                .toList();
    }

    /**
     * Get a list of songs with corresponding release year
     * @param year
     * @return a list of songs with corresponding release year
     */
    public static List<Song> filterByReleaseYear(int year) {
        return songs.stream()
                .filter(song -> song.getReleaseYear() == year)
                .toList();
    }

    public static List<Song> getSongs() {
        return songs;
    }
}

