package org.example;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class AdManagerTest {

    private static final String TEST_ADS = "test_ads.csv";

    @BeforeAll
    public static void setupCSV() throws IOException {
        FileWriter writer = new FileWriter(TEST_ADS);
        writer.write("MPM,Enjoy ad-free music.\n");
        writer.write("Coca-cola,Open happiness.\n");
        writer.close();
    }

    @AfterAll
    public static void cleanupCSV() {
        new File(TEST_ADS).delete();
    }

    @Test
    public void testLoadFromCSVAndGetNextAd() throws FileNotFoundException {
        AdManager.loadFromCSV(TEST_ADS);
        Ad ad = AdManager.getNextAd();
        assertNotNull(ad);
        assertEquals("MPM", ad.getBrand());
        assertEquals("Enjoy ad-free music.", ad.getMessage());
    }

    @Test
    public void testGetNextAdCyclesCorrectly() {
        Ad first = AdManager.getNextAd();
        Ad second = AdManager.getNextAd();
        Ad third = AdManager.getNextAd();
        assertEquals(first.getBrand(), third.getBrand());
    }
}
