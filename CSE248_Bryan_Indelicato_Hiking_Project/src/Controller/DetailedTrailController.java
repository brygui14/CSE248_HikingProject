package Controller;

import Model.Trail;
import Model.TrailMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DetailedTrailController {

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
    private Button deleteButton;

    @FXML
    void delete(ActionEvent event) {
    	TrailMap.delete(trail);
    	Stage closing = (Stage) exitButton.getScene().getWindow();
    	closing.close();
    	
    }

    @FXML
    void exit(ActionEvent event) {
    	Stage closing = (Stage) exitButton.getScene().getWindow();
    	closing.close();
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
