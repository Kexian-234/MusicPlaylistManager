package org.example;

import java.io.*;
import java.util.*;

public class AdManager {
    private static Queue<Ad> adQueue = new LinkedList<>();

    /**
     * Loads ads from a CSV file with format: Brand,Message
     */
    public static void loadFromCSV(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",", 2);
            if (parts.length == 2) {
                String brand = parts[0].trim();
                String message = parts[1].trim();
                adQueue.add(new Ad(brand, message));
            }
        }

        scanner.close();
    }

    /**
     * Rotates and returns the next ad in queue.
     */
    public static Ad getNextAd() {
        if (adQueue.isEmpty()) {
            return new Ad("Generic", "This is a fallback ad.");
        }
        Ad next = adQueue.poll();
        adQueue.add(next);
        return next;
    }
}

