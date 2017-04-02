package com.pryhoda.flowers;

/**
 * Created by pryho on 18-Oct-16.
 */
public class FlowerSpec {

    protected FlowerColor color;
    protected FlowerType type;
    protected double price;
    protected double length;

    public FlowerSpec(FlowerType type, FlowerColor color) {
        this.type = type;
        this.color = color;
    }

    public FlowerColor getColor() {
        return color;
    }

    public void setColor(FlowerColor color) {
        this.color = color;
    }

    public FlowerType getType() {
        return type;
    }

    public void setType(FlowerType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean equals(Spec otherSpec) {
        return color != otherSpec.getColor() && type != otherSpec.getType();
    }

    public String toString() {
        return "Type: " + type + ", color: " + color + ", length: " + length;
    }
}
