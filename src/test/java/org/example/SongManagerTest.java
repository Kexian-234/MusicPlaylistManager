package org.example;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SongManagerTest {

    private static final String TEST_CSV = "test_songs.csv";

    @BeforeAll
    public static void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new File(TEST_CSV))) {
            writer.println("Blinding Lights,The Weeknd,Pop,2019,3800000000");
            writer.println("Bohemian Rhapsody,Queen,Rock,1975,1800000000");
        }
    }

    @AfterAll
    public static void deleteTestCSV() {
        new File(TEST_CSV).delete();
    }

    @Test
    public void testLoadFromCSV() throws FileNotFoundException {
        SongManager.loadFromCSV(TEST_CSV);

        List<Song> songs = SongManager.getSongs();
        Assertions.assertEquals(2, songs.size());

        Assertions.assertEquals("Blinding Lights", songs.get(0).getTitle());
        Assertions.assertEquals("Queen", songs.get(1).getArtist());
    }

    @Test
    public void testFilterByArtist() {
        List<Song> result = SongManager.filterByArtist("The Weeknd");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Blinding Lights", result.get(0).getTitle());
    }

}
