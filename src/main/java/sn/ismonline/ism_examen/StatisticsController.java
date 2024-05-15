package sn.ismonline.ism_examen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StatisticsController {
    @FXML
    private Label numberOfVotersLabel;

    public StatisticsController() {
    }

    @FXML
    private void initialize() {
        this.updateStatistics();
    }

    private void updateStatistics() {
        int numberOfVoters = 100;
        this.numberOfVotersLabel.setText(String.valueOf(numberOfVoters));
    }
}

