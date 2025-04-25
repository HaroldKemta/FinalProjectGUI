public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(int accountNumber, User owner, double overdraftLimit) {
        super(accountNumber, owner);
        this.overdraftLimit = overdraftLimit;
    }

    @Override // overrides Speer classes withdraw method

    public boolean withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from checking account " + accountNumber);
            return true;
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
            return false;
        }
    }
}