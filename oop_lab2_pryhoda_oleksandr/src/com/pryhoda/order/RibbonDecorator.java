package com.pryhoda.order;

import com.pryhoda.flowers.Flower;

/**
 * Created by pryho on 14-Nov-16.
 */
public class RibbonDecorator extends ItemDecorator {

    public RibbonDecorator(Item item) {
        super(item);
    }

    public String getDescription() {
        return item.getDescription() + "+ ribbon";
    }

    public double price() {
        return 10 + item.price();
    }

    @Override
    public Flower[] searchFlower(String type) {
        return new Flower[0];
    }
}