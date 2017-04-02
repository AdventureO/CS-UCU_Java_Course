package com.pryhoda.git;

/**
 * Created by pryho on 04-Oct-16.
 */
public class Rose extends Flower{
    public Rose(double steamSize, double numberOfDays, double price, String color){
        this.setColor(color);
        this.setNumberOfDays(numberOfDays);
        this.steamSize = steamSize;
        this.setPrice(price);
    }
}