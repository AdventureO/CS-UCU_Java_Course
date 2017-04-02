package com.pryhoda.git;

import java.util.Arrays;

/**
 * Created by pryho on 04-Oct-16.
 */
public class Bouquet {

    private int max = 3;
    private Flower[] flwrs = new Flower[max];
    private int lastIndex = 0;
    public double price = 0;

    public void addFlower(Flower nw) {
        if (max - 1 < lastIndex) {
            Flower[] newFlwr = new Flower[max * 2];
            for(int i = 0; i < max; i++){
                newFlwr[i]  = flwrs[i];
            }
            max *= 2;
            flwrs = newFlwr;
        }
        price += nw.getPrice();
        flwrs[lastIndex] = nw;
        lastIndex++;
    }

    public void sortFlowersByNumbersOfDays(){
        int i, j;
        double newValue;
        for (i = 1; i < flwrs.length; i++) {
            if(flwrs[i] == null){
                break;
            }
            newValue = flwrs[i].getNumberOfDays();
            Flower temp = flwrs[i];
            j = i;
            while (j > 0 && flwrs[j - 1].getNumberOfDays() > newValue) {
                flwrs[j] = flwrs[j - 1];
                j--;
            }
            flwrs[j] = temp;
        }
        System.out.println(Arrays.toString(flwrs));
    }



    public String findFlowerWithSTeamSize(int low, int high){
        int count = 0;
        Flower[] tempArray = new Flower[flwrs.length];
        for(int i = 0; i < flwrs.length; i++) {
            if(flwrs[i] == null){
                continue;
            }
            if (flwrs[i].getSteamSize() >= low && flwrs[i].getSteamSize() <= high) {
                count++;
                tempArray[count - 1] = flwrs[i];
            }
        }
        Flower[] result = new Flower[count];
        for(int i = 0; i < result.length; i++){
            result[i] = tempArray[i];
        }
        return Arrays.toString(result);
    }


    public void showFlowers() {
        for (int l = 0; l < flwrs.length; l++) {
            if (flwrs[l] != null) {
                System.out.println(flwrs[l]);
            }
        }
    }
}