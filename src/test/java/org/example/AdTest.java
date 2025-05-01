package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdTest {

    @Test
    public void testPlay() {
        Ad ad = new Ad("Nike", "Just do it.");
        ad.play();
        assertEquals("Nike", ad.getBrand());
        assertEquals("Just do it.", ad.getMessage());
    }
}
