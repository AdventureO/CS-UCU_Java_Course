package javaexam.com;

/**
 * Created by pryho on 28-Nov-16.
 */
public class DaysCard extends SkiPassDecorator {
    /**
     * Initialize a crad with type - Days
     */

    private String type;
    int validity;

    public DaysCard(SkiPassCard skiPassCard) {
        super(skiPassCard);
    }

    @Override
    public String cardType(){
        this.type = "Days card";
        return this.type;
    }

    public int cardValidity(){
        this.validity = 1;
        return this.validity;
    }

    @Override
    public int cardLiftAmount() {
        return 0;
    }
}
