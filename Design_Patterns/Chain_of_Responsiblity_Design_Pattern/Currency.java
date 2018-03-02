package cor_lab.com;

/**
 * Deliver currency to the biggest bill - 50$
 */
public class Currency {
    private int amount;

    public Currency(int amount){
        this.amount = amount;
    }

    public int getMoney(){
        return this.amount;
    }
}
