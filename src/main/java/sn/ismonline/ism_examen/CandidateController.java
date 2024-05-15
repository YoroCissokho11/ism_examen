package sn.ismonline.ism_examen;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class CandidateController {
    public TableView CandidateTbv;
    @FXML
    private TableView<Candidate> candidateTable;
    @FXML
    private TableColumn<Candidate, String> Cnomcol;
    @FXML
    private TableColumn<Candidate, String> Cparticol;

    public CandidateController() {
    }

    @FXML
    private void initialize() {
        this.Cnomcol.setCellValueFactory((cellData) -> {
            return ((Candidate)cellData.getValue()).nameProperty();
        });
        this.Cparticol.setCellValueFactory((cellData) -> {
            return ((Candidate)cellData.getValue()).partyProperty();
        });
        this.loadCandidates();
    }

    private void loadCandidates() {
        Candidate candidate1 = new Candidate("Candidat 1", "Parti A");
        Candidate candidate2 = new Candidate("Candidat 2", "Parti B");
        this.candidateTable.getItems().addAll(new Candidate[]{candidate1, candidate2});
    }

    @FXML
    private void handleDeleteCandidate() {
        Candidate selectedCandidate = (Candidate)this.candidateTable.getSelectionModel().getSelectedItem();
        if (selectedCandidate != null) {
            this.candidateTable.getItems().remove(selectedCandidate);
            this.showInfoAlert("Candidat Supprimé", "Le candidat '" + selectedCandidate.getName() + "' a été supprimé.");
        } else {
            this.showErrorAlert("Aucun Candidat Sélectionné", "Veuillez sélectionner un candidat à supprimer.");
        }

    }

    private void showInfoAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText((String)null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText((String)null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

