package com.pryhoda.git;

/**
 * Created by pryho on 04-Oct-16.
 */
public class Flower {

    private double price = 0;

    double steamSize = 0;

    private String color = "";

    private double numberOfDays = 0;

    public double getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(double numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getSteamSize() {
        return steamSize;
    }

    public void setSteamSize(double steamSIze) {
        this.steamSize = steamSIze;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "(Price: " + price + " , " + "Freshness: " + numberOfDays + " , " + "Steam size :" + steamSize +  " , " + "Colour :" + color + ")";
    }
}
