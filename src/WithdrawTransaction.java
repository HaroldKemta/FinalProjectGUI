public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(double amount, BankAccount account) {
        super("Withdraw", amount, account);
    }

    @Override
    public void execute() {
        if (!account.withdraw(amount)) {
            System.out.println("Transaction failed.");
        }
    }
}
