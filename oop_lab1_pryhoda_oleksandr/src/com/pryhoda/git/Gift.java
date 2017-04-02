package com.pryhoda.git;

import java.util.Arrays;

/**
 * Created by pryho on 09-Oct-16.
 */
public class Gift {
    private int max = 3;
    private Candys[] candys = new Candys[max];
    private int lastIndex = 0;
    public double giftWeight = 0;

    public void addCandy(Candys nw) {
        if (max - 1 < lastIndex) {
            Candys[] newCandy = new Candys[max * 2];
            for(int i = 0; i < max; i++){
                newCandy[i]  = candys[i];
            }
            max *= 2;
            candys = newCandy;
        }
        giftWeight += nw.getWeight();
        candys[lastIndex] = nw;
        lastIndex++;
    }

    public void sortCandysByWeight(){
        int i, j;
        double newValue;
        for (i = 1; i < candys.length; i++) {
            if(candys[i] == null){
                break;
            }
            newValue = candys[i].getWeight();
            Candys temp = candys[i];
            j = i;
            while (j > 0 && candys[j - 1].getWeight() > newValue) {
                candys[j] = candys[j - 1];
                j--;
            }
            candys[j] = temp;
        }
        System.out.println(Arrays.toString(candys));
    }



    public String findCandyByAmountOfSugar(int low, int high){
        int count = 0;
        Candys[] tempArray = new Candys[candys.length];
        for(int i = 0; i < candys.length; i++) {
            if(candys[i] == null){
                continue;
            }
            if (candys[i].getAmountOfSugar() >= low && candys[i].getAmountOfSugar() <= high) {
                count++;
                tempArray[count - 1] = candys[i];
            }
        }
        Candys[] result = new Candys[count];
        for(int i = 0; i < result.length; i++){
            result[i] = tempArray[i];
        }
        return Arrays.toString(result);
    }


    public void showCandys() {
        for (int l = 0; l < candys.length; l++) {
            if (candys[l] != null) {
                System.out.println(candys[l]);
            }
        }
    }
}
