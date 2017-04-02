package com.pryhoda.flowers;

/**
 * Created by pryho on 04-Oct-16.
 */
public abstract class Flower {

    protected FlowerSpec spec;

    public Flower(FlowerSpec flowerSpec, int length, int freshness) {
        this.spec = flowerSpec;
    }

    public FlowerSpec getSpec() {
        return spec;
    }

    @Override
    public String toString() {
        return "Type: " + getSpec();
    }

}
