//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main { public static void main(String[] args) {
    Bank bank = new Bank();

    // Create users
    User user1 = new User("Harold", 104);
    bank.addUser(user1);

    // Create accounts
    CheckingAccount acc1 = new CheckingAccount(1001, user1, 500);
    SavingsAccount acc2 = new SavingsAccount(1002, user1, 2.5);
    bank.addAccount(acc1);
    bank.addAccount(acc2);

    // Transactions
    bank.processTransaction(new DepositTransaction(1000, acc1));
    bank.processTransaction(new WithdrawTransaction(200, acc1));

    // View accounts
    user1.viewAccounts();
}
}