package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import Model.UserBag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminUserController {
	
	private final ObservableList<User> userList = FXCollections.observableArrayList();

	@FXML
	private TextField searchBox;
	
    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> username;

    @FXML
    private TableColumn<User, Boolean> adminStatus;

    @FXML
    private Button exitButton;

    @FXML
    private Button createButton;

    @FXML
    void create(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/SignUpView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.showAndWait();
    	
    	
    	
    	
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
    	Stage stage1 = (Stage) exitButton.getScene().getWindow();
    	stage1.close();
    	
    	AdminChoiceController.setUser(AdminChoiceController.myUser);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/AdminChoiceView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    	
    }
    
    @FXML
    void initialize() {
    	
    	List<User> list = new ArrayList<User>(UserBag.getUserBag().values());
    	
    	username.setCellValueFactory(new PropertyValueFactory<>("username"));
    	adminStatus.setCellValueFactory(new PropertyValueFactory<>("adminStatus"));
    	
    	userList.addAll(list);
    	
    	FilteredList<User> filteredData = new FilteredList<>(userList, b ->  true);
    	
    	searchBox.textProperty().addListener((observable, oldval, newval) -> {
    		filteredData.setPredicate(user -> {
    			if(user.getUsername().toLowerCase().contains(newval.toLowerCase())) {
    				return true;
    			}
    			else {
    				
    				return false;
    			}
    		});
    		
    		
    	});
    	
    	SortedList<User> sortedData = new SortedList<>(filteredData);
    	
    	sortedData.comparatorProperty().bind(userTable.comparatorProperty());
    	
    	userTable.setItems(sortedData);
    	
    	userTable.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
		            User selected = userTable.getSelectionModel().getSelectedItem();
		            
		         
		            try {
		            	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/DetailedUserView.fxml"));
			            Stage window = new Stage();
			            window.initModality(Modality.APPLICATION_MODAL);
			            window.initOwner(Stage.getWindows().get(0));
			            Parent root = fxmlLoader.load();
						Scene scene = new Scene(root);
						window.setScene(scene);
						DetailedUserController controller = fxmlLoader.getController();
						controller.loadUser(selected);
						window.setScene(scene);
						window.show();
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            
		        }
		    }
		});
	}
    	
    }
    
    

