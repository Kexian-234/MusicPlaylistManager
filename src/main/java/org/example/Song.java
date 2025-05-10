package org.example;

import java.util.Comparator;
import java.util.Objects;

public abstract class Song implements Playable, Comparable<Song> {
    private String title;
    private String artist;
    private int releaseYear;
    private long playCount;

    // INNER COMPARATOR CLASSES
    public static class CompareByPlayCount implements Comparator<Song> {
        @Override
        public int compare(Song a, Song b) {
            return Long.compare(b.playCount, a.playCount);
        }
    }
    public static class CompareByReleaseDate implements Comparator<Song> {
        @Override
        public int compare(Song a, Song b) {
            return Integer.compare(b.releaseYear, a.releaseYear);
        }
    }

    /**
     * Constructs a Song object
     * @param title
     * @param artist
     * @param releaseYear
     * @param playCount
     */
    public Song(String title, String artist, int releaseYear, long playCount) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.playCount = playCount;
    }

    /**
     * Increases the song's play count by 1
     */
    public void increasePlayCount() {
        playCount++;
    }

    /**
     * Compares two song objects by their title
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Song other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    // Comparators
    public static Comparator<Song> byPlayCountDescending() {
        return new CompareByPlayCount();
    }

    public static Comparator<Song> byReleaseYearDescending() {
        return new CompareByReleaseDate();
    }


    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return releaseYear == song.releaseYear && playCount == song.playCount && Objects.equals(title, song.title) && Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, releaseYear, playCount);
    }

    // toString
    @Override
    public String toString() {
        return  "Title: " + title + '\'' +
                ", Artist: " + artist + '\'' +
                ", Release Year: " + releaseYear +
                ", Play Count: " + playCount;
    }

    // Implementing play() from Playable
    /**
     * Prints a message indicating the song being played, and increases the play count of the song
     */
    @Override
    public void play() {
        increasePlayCount();
        System.out.println("Playing a song: " + this.title + " By " + this.artist);
    }

}


