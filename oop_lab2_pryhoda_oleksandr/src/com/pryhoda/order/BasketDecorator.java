package com.pryhoda.order;

import com.pryhoda.flowers.Flower;

/**
 * Created by pryho on 14-Nov-16.
 */
public class BasketDecorator extends ItemDecorator {

    public BasketDecorator(Item item) {
        super(item);
    }

    public String getDescription() {
        return item.getDescription() + " + basket";
    }

    public double price() {
        return 20 + item.price();
    }

    @Override
    public Flower[] searchFlower(String type) {
        return new Flower[0];
    }
}
