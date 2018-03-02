package pryhoda.com;

/**
 * Consider methods for making burgers with different ingridients
 */
abstract class BurgerBuilder {

    Burger burger;

    public Burger getBurger(){
        return burger;
    }

    public void createBurger(){
        burger = new Burger();
    }

    public abstract void addCheese();
    public abstract void addBread();
    public abstract void addSauce();
}
