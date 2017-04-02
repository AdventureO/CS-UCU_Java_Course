package com.pryhoda.git;

public class Main {

    public static void main(String[] args) {
        makeBouquet();
        makeGift();
    }

    public static void makeBouquet(){
        Flower a = new Tulpis(3, 3, 12, "blue");
        Flower b = new Tulpis(2, 1, 89, "yellow");
        Flower c = new Rose(5, 144, 5, "green");
        Flower d = new Rose(8, 2, 4, "red");

        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(a);
        bouquet.addFlower(b);
        bouquet.addFlower(c);
        bouquet.addFlower(d);

        System.out.println("Bouquet price: " + bouquet.price + "$");
        bouquet.sortFlowersByNumbersOfDays();
        System.out.println(bouquet.findFlowerWithSTeamSize(4, 8));
        bouquet.showFlowers();
    }

    public static void makeGift(){
        Candys a = new Bonbon(5, 5, 5, "Dusches");
        Candys b = new Bonbon(3, 1, 1, "Korivka");
        Candys c = new Goody(2, 120, 6, "Spartak");
        Candys d = new Goody(1, 8, 0.4, "Romashka");

        Gift gift = new Gift();
        gift.addCandy(a);
        gift.addCandy(b);
        gift.addCandy(c);
        gift.addCandy(d);

        System.out.println("Gift weight: " + gift.giftWeight);
        gift.sortCandysByWeight();
        System.out.println(gift.findCandyByAmountOfSugar(4, 8));
        gift.showCandys();
    }

}
