package Controller;

import Model.HikingHistory;
import Model.Trail;
import Model.TrailMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserHikeTrailController{

	private Trail trail;
	
    @FXML
    private Text name;

    @FXML
    private Text address;

    @FXML
    private Text difficulty;

    @FXML
    private Text type;

    @FXML
    private Text length;

    @FXML
    private Text elevationGain;

    @FXML
    private Button exitButton;

    @FXML
    private Button hikeButton;

    @FXML
    void exit(ActionEvent event) {
    	Stage closing = (Stage) exitButton.getScene().getWindow();
    	closing.close();
    	
    }

    @FXML
    void hikeTrail(ActionEvent event) {
    	Stage closing = (Stage) exitButton.getScene().getWindow();
    	closing.close();
    	
    	UserChoiceController.user.addHike(new HikingHistory(this.trail));
    	
    	
    }

    public void loadTrail(Trail trail) {
    	this.trail = trail;
    	name.setText(trail.getName());
    	address.setText(trail.getAddress());
    	difficulty.setText(trail.getDifficulty());
    	type.setText(trail.getType());
    	length.setText(String.valueOf(trail.getLength()));
    	elevationGain.setText(String.valueOf(trail.getElevationGain()));
    }
}
