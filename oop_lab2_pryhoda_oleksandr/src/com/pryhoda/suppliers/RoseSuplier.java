package com.pryhoda.suppliers;

import com.pryhoda.flowers.FlowerBucket;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by pryho on 20-Dec-16.
 */
public class RoseSuplier implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        FlowerBucket bouquet = (FlowerBucket) arg;
        int x = bouquet.searchFlower("Rose").length;
        System.out.println("You'll have " + x + "roses");
    }
}
