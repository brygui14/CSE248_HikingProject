package Controller;

import java.io.IOException;

import Model.Trail;
import Model.TrailMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateTrailController {

    @FXML
    private Button exitButton;

    @FXML
    private Button createButton;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField difficulty;

    @FXML
    private TextField type;

    @FXML
    private TextField length;

    @FXML
    private TextField elevationGain;

    @FXML
    void create(ActionEvent event) throws IOException {
    	Trail temp = new Trail(name.getText(), address.getText(), difficulty.getText(), type.getText(), Double.valueOf(length.getText()), Double.valueOf(elevationGain.getText()));
    	TrailMap.addTree(temp);
    	
    	Stage stage1 = (Stage) exitButton.getScene().getWindow();
    	stage1.close();
    	
    	AdminChoiceController.setUser(AdminChoiceController.myUser);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/AdminTrailView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    	
    	
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
    	Stage stage1 = (Stage) exitButton.getScene().getWindow();
    	stage1.close();
    	
    	AdminChoiceController.setUser(AdminChoiceController.myUser);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/AdminTrailView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    }

}
