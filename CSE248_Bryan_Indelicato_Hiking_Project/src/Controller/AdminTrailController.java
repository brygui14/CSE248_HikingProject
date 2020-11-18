package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Trail;
import Model.TrailMap;
import Model.User;
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

public class AdminTrailController {
	
	private final ObservableList<Trail> trailList = FXCollections.observableArrayList();

	@FXML
	private TextField searchBox;
	
    @FXML
    private TableView<Trail> trailTable;

    @FXML
    private TableColumn<Trail, String> name;

    @FXML
    private TableColumn<Trail, String> address;

    @FXML
    private TableColumn<Trail, String> difficulty;

    @FXML
    private Button exitButton;

    @FXML
    private Button addButton;

    @FXML
    void addTrail(ActionEvent event) throws IOException {
    	Stage stage1 = (Stage) exitButton.getScene().getWindow();
    	stage1.close();
    	
    	AdminChoiceController.setUser(AdminChoiceController.myUser);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/CreateTrailView.fxml"));
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
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/AdminChoiceView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    }
    
    @FXML
    void initialize() {
    	List<Trail> list = new ArrayList<Trail>(TrailMap.getTrailMap().values());
    	
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));
    	address.setCellValueFactory(new PropertyValueFactory<>("address"));
    	difficulty.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
    	
    	trailList.addAll(list);
    	
    	FilteredList<Trail> filteredData = new FilteredList<>(trailList, b ->  true);
    	
    	searchBox.textProperty().addListener((observable, oldval, newval) -> {
    		filteredData.setPredicate(trail -> {
    			if(trail.getName().toLowerCase().contains(newval.toLowerCase())) {
    				return true;
    			}
    			else if(trail.getAddress().toLowerCase().contains(newval.toLowerCase())) {
    				return true;
    			}
    			else if(trail.getDifficulty().toLowerCase().contains(newval.toLowerCase())) {
    				return true;
    			}
    			else {
    				return false;
    			}
    		});
    	});
    	
    	SortedList<Trail> sortedData = new SortedList<>(filteredData);
    	
    	sortedData.comparatorProperty().bind(trailTable.comparatorProperty());
    	
    	trailTable.setItems(sortedData);
    	
    	trailTable.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
		            Trail selected = trailTable.getSelectionModel().getSelectedItem();		            
		         
		            try {
		            	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/DetailedTrailView.fxml"));
			            Stage window = new Stage();
			            window.initModality(Modality.APPLICATION_MODAL);
			            window.initOwner(Stage.getWindows().get(0));
			            Parent root = fxmlLoader.load();
						Scene scene = new Scene(root);
						window.setScene(scene);
						DetailedTrailController controller = fxmlLoader.getController();
						controller.loadTrail(selected);
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
