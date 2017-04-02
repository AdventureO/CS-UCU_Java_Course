package com.pryhoda.suppliers;

import com.pryhoda.flowers.FlowerBucket;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by pryho on 20-Dec-16.
 */
public class TulipSuplier implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        FlowerBucket bouquet = (FlowerBucket) arg;
        int x = bouquet.searchFlower("Tulip").length;
        System.out.println("You'll have " + x + "tulips");
    }
}
