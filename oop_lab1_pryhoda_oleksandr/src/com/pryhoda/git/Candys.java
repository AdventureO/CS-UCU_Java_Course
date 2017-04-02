package com.pryhoda.git;

/**
 * Created by pryho on 09-Oct-16.
 */
public class Candys {
    private double price = 0;

    private double amountOfSugar = 0;

    private double weight = 0;

    private String name = "Unknown";

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(double amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     public String toString(){
         return "(Name: " + name + " , " + "Price: " + price + " , " + "Amount of sugar: " +  amountOfSugar + " , " + "Weight: " + weight + ")";
     }
}
