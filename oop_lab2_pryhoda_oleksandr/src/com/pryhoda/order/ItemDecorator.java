package com.pryhoda.order;

/**
 * Created by pryho on 14-Nov-16.
 */
public abstract class ItemDecorator implements Item {

    public Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }
    public abstract String getDescription();

}
