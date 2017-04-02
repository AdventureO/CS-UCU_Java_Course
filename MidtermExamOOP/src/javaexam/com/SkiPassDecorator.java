package javaexam.com;

/**
 * Created by pryho on 28-Nov-16.
 */
public abstract class SkiPassDecorator implements SkiPassCard {

    protected SkiPassCard skiPassCard;

    public SkiPassDecorator(SkiPassCard skiPassCard) {
        this.skiPassCard= skiPassCard;
    }
}
