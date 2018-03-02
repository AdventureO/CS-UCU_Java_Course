package cor_lab.com;

/**
 * Calculate a number of 10$ bills
 */
public class Dollars10Dis extends Dispenser {
    @Override
    void getAmount(Currency currency) {
        int sum = currency.getMoney();
        if(sum/10 != 0) System.out.println(sum / 10 + " - 10 Dollars bill");
    }
}
