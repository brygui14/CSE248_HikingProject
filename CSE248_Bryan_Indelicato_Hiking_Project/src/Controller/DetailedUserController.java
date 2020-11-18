package Controller;

import Model.User;
import Model.UserBag;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailedUserController {
	
	private User user;

    @FXML
    private Text username;

    @FXML
    private Text password;

    @FXML
    private Text admin;

    @FXML
    private Button exit;

    @FXML
    private Button adminButton;

    @FXML
    private Button deleteButton;

    @FXML
    void delete(ActionEvent event) {
    	UserBag.remove(user);
    	Stage closing = (Stage) exit.getScene().getWindow();
    	closing.close();
    	
    }

    @FXML
    void exitButton(ActionEvent event) {
    	Stage closing = (Stage) exit.getScene().getWindow();
    	closing.close();
    }

    @FXML
    void makeAdmin(ActionEvent event) {
    	user.setAdminStatus(true);
    	loadUser(user);
    }
    
    
    public void loadUser(User user) {
    	this.user = user;
    	username.setText(user.getUsername());
    	password.setText(user.getPassword());
    	admin.setText(String.valueOf(user.isAdminStatus()));
    }

}

