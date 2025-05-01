package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuestUserTest {

    @Test
    public void testPlaySong() {
        GuestUser user = new GuestUser("guest");
        Song song = new PopSong("Song", "Artist", 2020, 0);
        user.playSong(song);
        user.playSong(song);
        user.playSong(song);
        assertEquals(3, song.getPlayCount());
    }

    @Test
    public void testPlayPlaylist() {
        GuestUser user = new GuestUser("guest");
        Playlist playlist = new Playlist("MyPlaylist");
        playlist.getSongs().add(new PopSong("1", "A", 2020, 0));
        playlist.getSongs().add(new RockSong("2", "B", 2021, 0));
        user.playPlaylist(playlist);
        assertEquals(1, playlist.getSongs().get(0).getPlayCount());
    }
}
