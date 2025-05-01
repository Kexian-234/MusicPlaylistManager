package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        PopSong test = new PopSong("Test", "TestArtist", 2025, 0);
        test.play();
        System.out.println(test.toString());
        test.play();
        System.out.println(test.toString());
    }
}