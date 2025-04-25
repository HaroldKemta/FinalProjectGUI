public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, User owner, double interestRate) {
        super(accountNumber, owner);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest of $" + interest + " added to savings account " + accountNumber);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from savings account " + accountNumber);
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }
}

