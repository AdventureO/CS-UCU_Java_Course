package pryhoda.com;

/**
 * Extends BurgerBuilder, override methods
 */
public class VeganBurgerBuilder extends BurgerBuilder {

    @Override
    public void addCheese() {
        burger.setCheese("Cheddar, Mozzarella");
    }

    @Override
    public void addBread() {
        burger.setBread("White bread");
    }

    @Override
    public void addSauce() {
        burger.setSauce("Tartar sauce");
    }
}
