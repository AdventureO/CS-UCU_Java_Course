package pryhoda.com;

public class Main {

    public static void main(String[] args) {
        User lol1 = new User("admin", "admi123");
        AccountProxy lol = new AccountProxy(lol1);
        lol.doOperations();
    }
}
