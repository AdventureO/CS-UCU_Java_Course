package cor_lab.com;

/**
 * Make changes between bill giving. Depend on how much money does user need
 */
public abstract class Dispenser {

    Dispenser next;
    abstract void getAmount(Currency currency);
    void setNext(Dispenser next){
        this.next = next;
    }

}
