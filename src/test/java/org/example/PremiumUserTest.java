package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PremiumUserTest {

    @Test
    public void testPlaySong() {
        PremiumUser user = new PremiumUser("premium");
        Song song = new RockSong("Hit", "Band", 2000, 0);
        user.playSong(song);
        assertEquals(1, song.getPlayCount());
    }

    @Test
    public void testPlayPlaylist() {
        PremiumUser user = new PremiumUser("premium");
        Playlist playlist = new Playlist("Favs");
        playlist.getSongs().add(new RockSong("A", "X", 2010, 0));
        playlist.getSongs().add(new PopSong("B", "Y", 2011, 0));
        user.playPlaylist(playlist);
        assertEquals(1, playlist.getSongs().get(0).getPlayCount());
        assertEquals(1, playlist.getSongs().get(1).getPlayCount());
    }
}
