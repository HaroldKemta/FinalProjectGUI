import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int userId;
    private List<BankAccount> accounts;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void viewAccounts() {
        System.out.println("Accounts for " + name + ":");
        for (BankAccount acc : accounts) {
            System.out.println(" - " + acc.getAccountNumber() + " | Balance: $" + acc.getBalance());
        }
    }

    public String getAccountsInfo() {
        StringBuilder sb = new StringBuilder();
        for (BankAccount acc : accounts) {
            sb.append(acc.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userId;
    }
}
