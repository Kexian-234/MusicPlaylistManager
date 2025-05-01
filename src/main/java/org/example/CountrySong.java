package org.example;

public class CountrySong extends Song{
    public CountrySong(String title, String artist, int releaseYear, long playCount) {
        super(title, artist, releaseYear, playCount);
    }

    /**
     * Prints a message customized to country song, indicating the song being played, and also increases the playCount
     */
    @Override
    public void play() {
        increasePlayCount();
        System.out.println("Playing a heartfelt country tune: \"" + getTitle() + "\" by " + getArtist() + ". Yeehaw!");
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: Country";
    }
}
