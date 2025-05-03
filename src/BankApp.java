import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankApp extends Application {
    private Bank bank = new Bank();
    private User currentUser;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banking System");

        // Create User Section
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        Button createUserBtn = new Button("Create User");
        createUserBtn.setOnAction(e -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                currentUser = new User(name, bank.getUsers().size() + 1);
                bank.addUser(currentUser);

                // Create initial accounts for the user
                CheckingAccount checkingAccount = new CheckingAccount(1001, currentUser, 500);  // Example overdraft limit
                SavingsAccount savingsAccount = new SavingsAccount(1002, currentUser, 3.5);   // Example interest rate
                currentUser.addAccount(checkingAccount);
                currentUser.addAccount(savingsAccount);

                showAlert("User created: " + name);
                updateAccountUI(primaryStage);
            } else {
                showAlert("Please enter a valid name.");
            }
        });

        // Layout for creating users
        VBox layout = new VBox(10, nameField, createUserBtn);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateAccountUI(Stage primaryStage) {
        // Check if both accounts exist
        CheckingAccount checkingAccount = currentUser.getCheckingAccount();
        SavingsAccount savingsAccount = currentUser.getSavingsAccount();

        if (checkingAccount == null || savingsAccount == null) {
            showAlert("Please ensure that both checking and savings accounts are created.");
            return;
        }

        // Deposit and withdraw options for checking account
        TextField checkingDepositField = new TextField();
        checkingDepositField.setPromptText("Enter amount to deposit into checking");

        Button depositCheckingBtn = new Button("Deposit to Checking");
        depositCheckingBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(checkingDepositField.getText());
                if (amount > 0) {
                    checkingAccount.deposit(amount);
                    showAlert("Deposited $" + amount + " to Checking Account");
                    updateBalanceUI(primaryStage);
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid input. Please enter a valid amount.");
            }
        });

        // Withdraw option for checking account
        TextField checkingWithdrawField = new TextField();
        checkingWithdrawField.setPromptText("Enter amount to withdraw from checking");

        Button withdrawCheckingBtn = new Button("Withdraw from Checking");
        withdrawCheckingBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(checkingWithdrawField.getText());
                if (amount > 0) {
                    boolean success = checkingAccount.withdraw(amount);
                    if (success) {
                        showAlert("Withdrew $" + amount + " from Checking Account");
                        updateBalanceUI(primaryStage);
                    } else {
                        showAlert("Insufficient funds in Checking Account");
                    }
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid input. Please enter a valid amount.");
            }
        });

        // Deposit and withdraw options for savings account
        TextField savingsDepositField = new TextField();
        savingsDepositField.setPromptText("Enter amount to deposit into savings");

        Button depositSavingsBtn = new Button("Deposit to Savings");
        depositSavingsBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(savingsDepositField.getText());
                if (amount > 0) {
                    savingsAccount.deposit(amount);
                    showAlert("Deposited $" + amount + " to Savings Account");
                    updateBalanceUI(primaryStage);
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid input. Please enter a valid amount.");
            }
        });

        // Withdraw option for savings account
        TextField savingsWithdrawField = new TextField();
        savingsWithdrawField.setPromptText("Enter amount to withdraw from savings");

        Button withdrawSavingsBtn = new Button("Withdraw from Savings");
        withdrawSavingsBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(savingsWithdrawField.getText());
                if (amount > 0) {
                    boolean success = savingsAccount.withdraw(amount);
                    if (success) {
                        showAlert("Withdrew $" + amount + " from Savings Account");
                        updateBalanceUI(primaryStage);
                    } else {
                        showAlert("Insufficient funds in Savings Account");
                    }
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid input. Please enter a valid amount.");
            }
        });

        // Show current balance button
        Button showBalanceBtn = new Button("Show Balances");
        showBalanceBtn.setOnAction(e -> updateBalanceUI(primaryStage));

        // Add UI elements for user interaction
        VBox layout = new VBox(10, checkingDepositField, depositCheckingBtn, checkingWithdrawField, withdrawCheckingBtn,
                savingsDepositField, depositSavingsBtn, savingsWithdrawField, withdrawSavingsBtn, showBalanceBtn);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setScene(scene);
    }

    private void updateBalanceUI(Stage primaryStage) {
        CheckingAccount checkingAccount = currentUser.getCheckingAccount();
        SavingsAccount savingsAccount = currentUser.getSavingsAccount();

        if (checkingAccount == null || savingsAccount == null) {
            showAlert("Please ensure that both checking and savings accounts are created.");
            return;
        }

        // Show current balance for both accounts
        String balanceMessage = "Checking Balance: $" + checkingAccount.getBalance() + "\n" +
                "Savings Balance: $" + savingsAccount.getBalance();
        showAlert(balanceMessage);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
