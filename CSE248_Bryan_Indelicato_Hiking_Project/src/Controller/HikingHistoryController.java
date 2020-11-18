package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.HikingHistory;
import Model.HikingHistoryBag;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HikingHistoryController {
	
	
	
	private final ObservableList<HikingHistory> hikinglist = FXCollections.observableArrayList();

    @FXML
    private TableView<HikingHistory> hikingTable;

    @FXML
    private TableColumn<HikingHistory, String> name;

    @FXML
    private TableColumn<HikingHistory, String> date;

    @FXML
    private TableColumn<HikingHistory, String> duration;

    @FXML
    private Button exitButton;

    @FXML
    void exit(ActionEvent event) throws IOException {
    	Stage stage1 = (Stage) exitButton.getScene().getWindow();
    	stage1.close();
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/UserChoiceView.fxml"));
    	Parent root = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setOpacity(1);
    	stage.setScene(new Scene(root));
    	stage.show();
    }
    
    @FXML
    void initialize() {
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));
    	date.setCellValueFactory(new PropertyValueFactory<>("date"));
    	duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
    	
    	
    	hikinglist.addAll(UserChoiceController.user.getHikingHistoryBag().values());
    	
    	FilteredList<HikingHistory> filteredData = new FilteredList<>(hikinglist, b -> true);
    	
    	SortedList<HikingHistory> sortedData = new SortedList<>(filteredData);
    	
    	hikingTable.setItems(sortedData);
    	
    	hikingTable.setOnMousePressed(new EventHandler<MouseEvent>() {
		    @Override 
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
		            HikingHistory selected =hikingTable.getSelectionModel().getSelectedItem();
		            
		         
		            try {
		            	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/DetailedHikeView.fxml"));
			            Stage window = new Stage();
			            window.initModality(Modality.APPLICATION_MODAL);
			            window.initOwner(Stage.getWindows().get(0));
			            Parent root = fxmlLoader.load();
						Scene scene = new Scene(root);
						window.setScene(scene);
						DetailedHikeController controller = fxmlLoader.getController();
						controller.loadHistory(selected);
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
