public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount, BankAccount account) {
        super("Deposit", amount, account);
    }

    @Override
    public void execute() {
        account.deposit(amount); // the subclass  deposits using abstaract super class
    }
}
