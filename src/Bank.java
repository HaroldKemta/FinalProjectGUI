import java.util.ArrayList;
import java.util.List;


public class Bank {

    private List<User> users;
    private List<BankAccount> accounts;  // list of users and accounts

    public Bank() {
        users = new ArrayList<>();
        accounts = new ArrayList<>();
    }       // constructor , empty list of users and accounts


    public void addUser(User user) {
        users.add(user);
    }          // adds user to bank’s users list


    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccount(int accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }     // looking for account number if found return it’s reference ( the account)


    public void processTransaction(Transaction transaction) {
        transaction.execute();
        // runs transaction logic ( deposit or withdrawal)
    }

    public List<User> getUsers() {
        return users;
    }

}
