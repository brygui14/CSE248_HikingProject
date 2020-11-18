package Controller;

import Model.HikingHistory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailedHikeController {
	
	HikingHistory hh;

    @FXML
    private Text name;

    @FXML
    private Text date;

    @FXML
    private Text duration;

    @FXML
    private Text pace;

    @FXML
    private Text distance;

    @FXML
    private Button exitButton;

    @FXML
    void exit(ActionEvent event) {
    	Stage stage1 = (Stage) exitButton.getScene().getWindow();
    	stage1.close();
    }
    
    public void loadHistory(HikingHistory hh) {
    	this.hh = hh;
    	name.setText(hh.getName());
    	date.setText(hh.getDate());
    	duration.setText(hh.getDuration());
    	pace.setText(hh.getPace());
    	distance.setText(String.valueOf(hh.getDistance()));
    	
    	
    }

}