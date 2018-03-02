package cor_lab.com;

/**
 * Calculate a number of 20$ bills
 */
public class Dollars20Dis extends Dispenser {
    @Override
    void getAmount(Currency currency) {
        int sum = currency.getMoney();
        next.getAmount(new Currency(sum % 20));
        if(sum/20 != 0) System.out.println(sum / 20 + " - 20 Dollars bill");
    }
}
