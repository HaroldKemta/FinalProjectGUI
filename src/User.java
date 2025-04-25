import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int userId;
    private List<BankAccount> accounts;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
        this.accounts = new ArrayList<>(); // creates empty list of bank accounts for user
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);  // stores in user's account list
    }

    public void viewAccounts() {
        System.out.println("Accounts for " + name + ":");
        for (BankAccount acc : accounts) {
            System.out.println(" - " + acc.getAccountNumber() + " | Balance: $" + acc.getBalance());
        }
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userId;
    }
}
