package Controller;

import java.io.IOException;
import java.net.URI;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import Init.Testing;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminChoiceController {
	
	public static User myUser;
	
	
	 @FXML
	private Text textField;

    @FXML
    private Button userButton;

    @FXML
    private Button trailButton;

    @FXML
    private Button exitButton;

    @FXML
    void exit(ActionEvent event) throws IOException {
    	Stage stage1 = (Stage) exitButton.getScene().getWindow();
    	stage1.close();
    	
    	AdminChoiceController.setUser(AdminChoiceController.myUser);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/LoginView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    }

    @FXML
    void viewTrails(ActionEvent event) throws IOException {
    	Stage closing = (Stage) exitButton.getScene().getWindow();
    	closing.close();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/AdminTrailView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    }

    @FXML
    void viewUsers(ActionEvent event) throws IOException {
    	Stage closing = (Stage) exitButton.getScene().getWindow();
    	closing.close();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/AdminUserView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    }
    
    @FXML
    public void initialize() {
        textField.setText("Welcome " + myUser.getUsername());
    }
    
    public static void setUser(User user) {
    	myUser = user;
    }
    
    @FXML
    void JunitTest(ActionEvent event) {
    	Testing.JunitTestResults();
    	JUnitCore junit = new JUnitCore();
    	Result result = junit.run(Test.TestTrailMapJunit.class);
    	System.out.println("Junit Test for TrailMap methods: " + result.wasSuccessful());
    	result = junit.run(Test.TestUserBagJunit.class);
    	System.out.println("Junit Test for the UserBag methods: " + result.wasSuccessful());
		result = junit.run(Test.TestHikingHistoryJunit.class);
		System.out.println("Junit Test for Hiking History Bag methods: " + result.wasSuccessful());
    }
    
    @FXML
    void showDoc(ActionEvent event) {
    	try {
    		   
    		   URI uri= new URI("https://brygui14.github.io/cv/");
    		   
    		   	java.awt.Desktop.getDesktop().browse(uri);
    		    System.out.println("Web page opened in browser");
    		 
    		  } catch (Exception e) {
    		   
    		   e.printStackTrace();
    		  }
    		 }
    }
    
    

