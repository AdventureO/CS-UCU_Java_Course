package pryhoda.com;

public class Main {

    public static void main(String[] args) {
	    Waiter waiter = new Waiter();
        Waiter waiter1 = new Waiter();

        BurgerBuilder mexicanBurger = new MexicanBurgerBuilder();
        BurgerBuilder veganBurger = new VeganBurgerBuilder();

        waiter.setBurgerBuilder(mexicanBurger);
        waiter1.setBurgerBuilder(veganBurger);
        waiter.makeOffer();
        waiter1.makeOffer();

        Burger burger = waiter.getBurger();
        Burger burger1 = waiter1.getBurger();

        System.out.println(burger);
        System.out.println(burger1);
    }
}
