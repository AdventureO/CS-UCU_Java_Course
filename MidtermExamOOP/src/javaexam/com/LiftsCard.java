package javaexam.com;

/**
 * Created by pryho on 28-Nov-16.
 */
public class LiftsCard extends SkiPassDecorator {
    /**
     * Initialize a crad with type - Lifts
     */

    private String type;
    int liftAmount;

    public LiftsCard(SkiPassCard skiPassCard) {
        super(skiPassCard);
    }

    @Override
    public String cardType() {
        this.type = "Lift card";
        return this.type;
    }

    @Override
    public int cardValidity() {
        return 0;
    }

    public int cardLiftAmount(){
        this.liftAmount = 10;
        return this.liftAmount;
    }
}
