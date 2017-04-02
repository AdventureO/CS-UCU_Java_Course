package com.pryhoda.order;

import com.pryhoda.flowers.Flower;

/**
 * Created by pryho on 14-Nov-16.
 */
public class PaperDecorator extends ItemDecorator{

    public PaperDecorator(Item item) {
        super(item);
    }

    public String getDescription() {
        return item.getDescription() + " + paper";
    }

    public double price() {
        return 15 + item.price();
    }

    @Override
    public Flower[] searchFlower(String type) {
        return new Flower[0];
    }

}
