package cor_lab.com;

/**
 * Make all operations with money giving
 */
public class ATM {
    int money;

    public ATM(int money){
        this.money = money;
    }

    public void moneyGiving(){
        Dollars10Dis d10 = new Dollars10Dis();
        Dollars20Dis d20 = new Dollars20Dis();
        Dollars50Dis d50 = new Dollars50Dis();

        d50.setNext(d20);
        d20.setNext(d10);

        d50.getAmount(new Currency(money));
    }
}
