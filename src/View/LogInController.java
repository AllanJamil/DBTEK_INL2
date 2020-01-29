package View;

import Repository.AccountRepository;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LogInController {

    AccountRepository r = new AccountRepository();

    private static int customer_ID;
    @FXML
    private Label label_errorMessage;
    @FXML
    private TextField textField_username;
    @FXML
    private PasswordField textField_password;

    public void loadUI(String fxmlFile) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene tempScene = new Scene(root);
        ObservableList<Window> windows = Stage.getWindows();
        Stage window = (Stage) windows.get(0);
        window.setScene(tempScene);
        window.show();
    }

    public void logInButton() {
        if (textField_username.getText().equals("") && textField_password.getText().equals("") ||
                !textField_username.getText().equals("") && textField_password.getText().equals("") ||
                textField_username.getText().equals("") && !textField_password.getText().equals("")) {
            label_errorMessage.setText("Enter both username and password.");
        } else {
            this.customer_ID = r.logIn(textField_username.getText(), textField_password.getText());

            if (customer_ID == -1) {
                label_errorMessage.setText("The username or password is not correct.");
            } else {
                try {
                    loadUI("order.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCustomer_ID() {
        return customer_ID;
    }
}
