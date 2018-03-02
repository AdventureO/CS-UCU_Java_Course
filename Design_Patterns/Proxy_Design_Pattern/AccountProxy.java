package pryhoda.com;

/**
 * Check if username and password is valid and then create an object of type Account
 */
public class AccountProxy implements IAccount {

    User user;

    public AccountProxy(User user){
        this.user = user;
    }

    @Override
    public void doOperations() {
        if(user.getUserName().equals("admin") && user.getUserPassword().equals("admin123")){
            Account account = new Account();
            account.doOperations();
        }
        else{
            System.out.println("Invalid username or password");
        }
    }
}
