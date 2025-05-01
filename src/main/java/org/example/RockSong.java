package org.example;

public class RockSong extends Song{
    public RockSong(String title, String artist, int releaseYear, long playCount) {
        super(title, artist, releaseYear, playCount);
    }

    /**
     * Prints a message customized to Rock song, indicating the song being played, and also increases the playCount
     */
    @Override
    public void play() {
        increasePlayCount();
        System.out.println("Rocking out to \"" + getTitle() + "\" by " + getArtist() + "!Turn it up to 11!");
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: Rock";
    }
}
