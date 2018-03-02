package cor_lab.com;

/**
 * Calculate a number of 50$ bills
 */
public class Dollars50Dis extends Dispenser {
    @Override
    void getAmount(Currency currency) {
        int sum = currency.getMoney();
        next.getAmount(new Currency(sum % 50));
        if(sum/50 != 0) System.out.println(sum / 50 + " - 50 Dollars bill");
    }
}
