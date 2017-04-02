package com.pryhoda.flowers;

/**
 * Created by pryho on 18-Dec-16.
 */
public enum FlowerType {
    CHAMOMILE, TULIP, ROSE, CACTUS;

    public String toString(){
        switch (this) {
            case CHAMOMILE:
                return "Chamomile";
            case TULIP:
                return "Tulip";
            case ROSE:
                return "Rose";
            case CACTUS:
                return "Cactus";
            default:
                return "No type";
        }
    }
}
