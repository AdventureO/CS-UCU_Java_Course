package com.pryhoda.flowers;

/**
 * Created by pryho on 18-Dec-16.
 */
public enum FlowerColor {
    RED, GREEN, BLUE, YELLOW, WHITE, PURPLE;

    public String toString(){
        switch(this) {
            case RED:
                return "Red";
            case GREEN:
                return "Green";
            case BLUE:
                return "Blue";
            case YELLOW:
                return "Yellow";
            case WHITE:
                return "White";
            case PURPLE:
                return "Purple";
            default:
                return "No color";
        }
    }
}
