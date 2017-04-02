package com.pryhoda.order;

import com.pryhoda.flowers.Flower;

/**
 * Created by pryho on 23-Nov-16.
 */
public interface Item {

    String description = "No name";

    public String getDescription();
    public abstract double price();
    public Flower[] searchFlower(String type);

}
