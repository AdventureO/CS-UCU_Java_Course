package pryhoda.com;

/**
 * Extends BurgerBuilder, override methods
 */
public class MexicanBurgerBuilder extends BurgerBuilder {

    @Override
    public void addCheese() {
        burger.setCheese("Cheddar");
    }

    @Override
    public void addBread() {
        burger.setBread("Grey bread");
    }

    @Override
    public void addSauce() {
        burger.setSauce("Spicy sauce");
    }
}
