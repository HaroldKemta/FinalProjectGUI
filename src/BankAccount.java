public class BankAccount {

    protected int accountNumber;
    protected double balance;
    protected User owner; // Association with User

    public BankAccount(int accountNumber, User owner) {
        this.accountNumber = accountNumber;
        this.owner = owner; // links user object(name) as owner

        this.balance = 0;
        owner.addAccount(this); // Link this account to user
    }

    public void deposit(double amount) {  // modifier adds $$
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}




