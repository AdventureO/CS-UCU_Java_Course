package javaexam.com;

/**
 * Created by pryho on 28-Nov-16.
 */
public class Card implements SkiPassCard{
    /**
     * create a card an initialize with id
     */
    private int id;
    String type = "";
    int validity = 0;
    int liftAmount = 0;

    Card(int id){
        this.id = id;
    }

    @Override
    public String cardType() {
        this.type = "Card is not set";
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

