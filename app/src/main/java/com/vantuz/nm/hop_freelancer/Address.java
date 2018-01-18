package com.vantuz.nm.hop_freelancer;

/**
 * Created by NM on 09.12.2017.
 */

public class Address {

    private String City;
    private String Street;
    private double latitude;
    private double longiture;

    public Address(String city, String street, double latitude, double longiture) {
        City = city;
        Street = street;
        this.latitude = latitude;
        this.longiture = longiture;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongiture() {
        return longiture;
    }

    public void setLongiture(double longiture) {
        this.longiture = longiture;
    }
}
