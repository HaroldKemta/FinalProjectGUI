import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Bank bank = new Bank();

        // Create users
        User user1 = new User("Harold", 104);
        bank.addUser(user1);

        // Create accounts
        CheckingAccount acc1 = new CheckingAccount(101, user1, 500);
        SavingsAccount acc2 = new SavingsAccount(102, user1, 2.5);
        bank.addAccount(acc1);
        bank.addAccount(acc2);

        // Transactions
        bank.processTransaction(new DepositTransaction(8000, acc1));
        bank.processTransaction(new DepositTransaction(7000, acc2));
        bank.processTransaction(new WithdrawTransaction(2300, acc1));
        bank.processTransaction(new WithdrawTransaction(2300, acc2));

        // View accounts in a TextArea instead of printing
        TextArea output = new TextArea();
        output.setEditable(false);
        output.setText(user1.getAccountsInfo());  // You’ll need to implement this method

        VBox root = new VBox(output);
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Banking App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Required to launch JavaFX
    }
}
