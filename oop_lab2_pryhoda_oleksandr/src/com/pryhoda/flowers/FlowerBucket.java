package com.pryhoda.flowers;

import com.pryhoda.order.Item;

public class FlowerBucket implements Item {

    private int defaultSize = 5;
    private Flower[] bouquet = new Flower[defaultSize];
    private int lastIndex = 0;

    @Override
    public String getDescription() {
        String description = "";
        for (Flower flower : bouquet) {
            if (flower != null) {
                description += flower.toString();
            } else {
                break;
            }
        }
        return description;
    }

    @Override
    public double price() {
        double sum = 0;
        for (Flower flower : bouquet) {
            if (flower != null) {
                sum += flower.getPrice();
            } else {
                break;
            }
        }
        return sum;
    }

    public void addFlower(Flower nw) {
        if (defaultSize - 1 < lastIndex) {
            Flower[] newFlowers = new Flower[defaultSize * 2];
            for (int i = 0; i < defaultSize; i++) {
                newFlowers[i] = bouquet[i];
            }

            bouquet = newFlowers;
            defaultSize *= 2;
        }

        bouquet[lastIndex] = nw;
        lastIndex++;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < lastIndex; i++) {
            s += bouquet[i].toString() + "\n";
        }
        return s;
    }

    @Override
    public Flower[] searchFlower(String type) {
        int count = 0;
        for (int i = 0; i < bouquet.length; i++) {
            if (bouquet[i] == null) {
                continue;
            } else if (type.equals(bouquet[i].getSpec())) {
                count++;
            }
        }

        Flower[] result = new Flower[count];
        count = 0;
        for (int i = 0; i < bouquet.length; i++) {
            if (bouquet[i] == null) {
                continue;
            } else if (type.equals(bouquet[i].getSpec())) {
                result[count] = bouquet[i];
            }
        }
        return result;
    }
}