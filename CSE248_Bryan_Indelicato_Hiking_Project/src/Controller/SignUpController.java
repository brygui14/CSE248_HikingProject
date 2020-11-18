package Controller;

import Model.User;
import Model.UserBag;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private TextField usernameTextBox;

    @FXML
    private PasswordField passwordTextBox;

    @FXML
    private Button cancelButton;

    @FXML
    private Button signUpButton;

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) usernameTextBox.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void signUp(ActionEvent event) {
    	User newUser = new User(usernameTextBox.getText(), passwordTextBox.getText());
    	UserBag.addUser(newUser);
    	Alert congrats = new Alert(AlertType.INFORMATION);
    	congrats.setHeaderText("Signed Up");
    	congrats.setContentText("Congratulations on signing up!");
    	congrats.show();
    	
    	Stage stage = (Stage) usernameTextBox.getScene().getWindow();
    	stage.close();
    	
    	System.out.println(UserBag.searchUser(newUser.getUsername()).toString());
    	
    }

}