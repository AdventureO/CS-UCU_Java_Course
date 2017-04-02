package com.pryhoda.flowers;

/**
 * Created by pryho on 18-Dec-16.
 */
public abstract class Spec {

    protected FlowerColor color = null;
    protected FlowerType type = null;
    protected double length = 0;
    protected int freshness;
    protected double price = 0;

    public Spec(FlowerType type, double length, int freshness, FlowerColor color){
        this.color = color;
        this.length = length;
        this.freshness = freshness;
        this.type = type;
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getFreshness() {
        return freshness;
    }

    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public boolean equals(Spec otherSpec) {
        return color != otherSpec.getColor() && length != otherSpec.getLength() && type != otherSpec.getType();
    }

    public int isFresh() {
        return this.freshness;
    }

    public String toString() {
        return "Type: " + getType() + ", price: " + String.valueOf(getPrice()) + ",freshness level: " +
                String.valueOf(isFresh()) + ", length: " + String.valueOf(getLength());
    }
}

