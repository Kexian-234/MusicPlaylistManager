package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class PlaylistManagerTest {

    @Test
    public void testCreatePlaylist() {
        Playlist playlist = PlaylistManager.createPlaylist("Test");
        assertEquals("Test", playlist.getName());
    }

    @Test
    public void testCreatePlaylistWithSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new PopSong("Test", "Null", 2021, 0));
        Playlist playlist = PlaylistManager.createPlaylist("WithSongs", songs);
        assertEquals(1, playlist.getSongs().size());
    }
}
