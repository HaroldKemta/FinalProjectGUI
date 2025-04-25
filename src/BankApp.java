import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankApp extends Application {
    private Bank bank = new Bank();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banking System");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        Button createUserBtn = new Button("Create User");
        createUserBtn.setOnAction(e -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                User user = new User(name, bank.getUsers().size() + 1);
                bank.addUser(user);
                showAlert("User created: " + name);
            }
        });

        VBox layout = new VBox(10, nameField, createUserBtn);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
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
