package org.example;

public class PopSong extends Song{
    public PopSong(String title, String artist, int releaseYear, long playCount) {
        super(title, artist, releaseYear, playCount);
    }

    /**
     * Prints a message customized to Pop song, indicating the song being played, and also increases the playCount
     */
    @Override
    public void play() {
        increasePlayCount();
        System.out.println("Now playing a pop hit: \"" + getTitle() + "\" by " + getArtist() + "! Enjoy~");
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: Pop";
    }
}
