package Controller;

import java.io.IOException;

import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserChoiceController {

    public static User user;
	
	@FXML
    private Text textField;

    @FXML
    private Button viewHistoryButton;

    @FXML
    private Button trailButton;

    @FXML
    private Button exitButton;

    @FXML
    void exit(ActionEvent event) throws IOException {
    	Stage closing = (Stage) exitButton.getScene().getWindow();
    	closing.close();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/LoginView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    }

    @FXML
    void viewHistory(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/HikingHistoryView.fxml"));
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initOwner(Stage.getWindows().get(0));
        Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setScene(scene);
		window.show();
    }

    @FXML
    void viewTrails(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/TrailMapView.fxml"));
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initOwner(Stage.getWindows().get(0));
        Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setScene(scene);
		window.show();
    }
    
    public static void setUser(User user1) {
    	user = user1;
    	
    	
    }

}
