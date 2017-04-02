package javaexam.com;

/**
 * Created by pryho on 28-Nov-16.
 */
public class Passer {
    private Card card;

    public Passer(Card card){
        this.card = card;
    }

    public String check() {
        /**
         * A function which check if card is valid
         */
        if (card.cardType() == "Season card") {
            return "Correct passing. Enjoy a ski";
        } else if (card.cardType() == "Days card") {
            if (card.cardValidity() <= 0) {
                return "Passing Failed. Please renew your card";
            } else {
                return "Correct passing. Enjoy a ski";
            }
        } else if (card.cardType() == "Lift card") {
            if (card.cardLiftAmount() <= 0) {
                return "Passing Failed. Please renew your card";
            } else {
                card.validity -= 1;
                return "Correct passing. Enjoy a ski";
            }
        }
        return "Your card is not activated";
    }
}

