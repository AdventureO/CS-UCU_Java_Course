package pryhoda.com;

/**
 * Main class, which creates an object of type Burger
 */
public class Burger {

    private String cheese = "";
    private String bread = "";
    private String sauce = "";

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String toString(){
        return "Burger with " + cheese + ", " + bread + " and " + sauce;
    }
}
