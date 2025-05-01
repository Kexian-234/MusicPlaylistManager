package org.example;

import java.util.Objects;

public class Ad implements Playable {
    private String brand;
    private String message;

    /**
     * Constructs an Ad object
     * @param brand
     * @param message
     */
    public Ad(String brand, String message) {
        this.brand = brand;
        this.message = message;
    }

    /**
     * plays the ad selected
     */
    @Override
    public void play() {
        System.out.println("Ad from " + brand + ": " + message);
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(brand, ad.brand) && Objects.equals(message, ad.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, message);
    }

    // toString
    @Override
    public String toString() {
        return "Ad{" +
                "brand='" + brand + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
