package Controller;

import java.io.IOException;

import Model.User;
import Model.UserBag;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameTextBox;

    @FXML
    private PasswordField passwordTextBox;

    @FXML
    private Button signUpButton;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) throws IOException {
    	String userName = usernameTextBox.getText();  	
    	String password = passwordTextBox.getText();
    	
    	if (UserBag.checkUserLogin(userName, password)) {
    		Stage closing = (Stage) usernameTextBox.getScene().getWindow();
	    	closing.close();
    		
    		User user = UserBag.setUser(userName);
    		
    		if(user.isAdminStatus()) {
    			
    			AdminChoiceController.setUser(user);
    			
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/AdminChoiceView.fxml"));
    	    	Parent root = fxmlLoader.load();
    	    	Stage stage = new Stage();
    	    	stage.setOpacity(1);
    	    	stage.setScene(new Scene(root));
    	    	stage.show();
    	    	
    		}
    		else {
    			UserChoiceController.setUser(user);
    			
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/UserChoiceView.fxml"));
    	    	Parent root = fxmlLoader.load();
    	    	Stage stage = new Stage();
    	    	stage.setOpacity(1);
    	    	stage.setScene(new Scene(root));
    	    	stage.show();
    		}
    	}
    	else {
    		Alert errorMesg = new Alert(AlertType.ERROR);
    		errorMesg.setContentText("Invalid Username or Password");
    		errorMesg.showAndWait();
    	}
    	
    	
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/SignUpView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.showAndWait();
    	
    	
    }

}
