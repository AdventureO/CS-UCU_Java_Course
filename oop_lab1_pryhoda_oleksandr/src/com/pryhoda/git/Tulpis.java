package com.pryhoda.git;

import com.pryhoda.git.Flower;

/**
 * Created by pryho on 04-Oct-16.
 */
public class Tulpis extends Flower {
    public Tulpis(double steamSize, double numberOfDays, double price, String color){
        this.setColor(color);
        this.setNumberOfDays(numberOfDays);
        this.steamSize = steamSize;
        this.setPrice(price);
    }
}
