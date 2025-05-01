package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    public void testPlayIncrementsPlayCount() {
        Song song = new PopSong("Blinding Lights", "The Weeknd", 2019, 3000000);
        long before = song.getPlayCount();
        song.play();
        Assertions.assertEquals(before + 1, song.getPlayCount());
    }

    @Test
    public void testCompareTo() {
        Song songA = new PopSong("A Song", "Artist", 2020, 100);
        Song songB = new PopSong("B Song", "Artist", 2020, 100);
        Assertions.assertTrue(songA.compareTo(songB) < 0);
    }
}