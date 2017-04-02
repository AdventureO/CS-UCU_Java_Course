package javaexam.com;

/**
 * Created by pryho on 28-Nov-16.
 */
public class SeasonCard extends SkiPassDecorator {
    /**
     * Initialize a crad with type - Season
     */
    String type;

    public SeasonCard(SkiPassCard skiPassCard) {
        super(skiPassCard);
    }

    @Override
    public String cardType() {
        this.type = "Season card";
        return this.type;
    }

    @Override
    public int cardValidity() {
        return 0;
    }

    @Override
    public int cardLiftAmount() {
        return 0;
    }


}
