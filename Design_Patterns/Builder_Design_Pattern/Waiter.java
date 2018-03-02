package pryhoda.com;

/**
 * Make an offer, calls methods to make burger
 */
public class Waiter {
    BurgerBuilder burgerBuilder;

    public void setBurgerBuilder(BurgerBuilder bB){
        burgerBuilder = bB;
    }

    public Burger getBurger(){
        return burgerBuilder.getBurger();
    }

    public void makeOffer(){
        burgerBuilder.createBurger();
        burgerBuilder.addCheese();
        burgerBuilder.addBread();
        burgerBuilder.addSauce();
    }
}
