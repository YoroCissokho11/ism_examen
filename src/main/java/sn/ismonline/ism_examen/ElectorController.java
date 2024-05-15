
package sn.ismonline.ism_examen;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class ElectorController {
    @FXML
    private TableView<Elector> ElecTbv;
    @FXML
    private TableColumn<Elector, String> EnomCol;
    @FXML
    private TableColumn<Elector, String> Ecandcol;

    public ElectorController() {
    }

    @FXML
    private void initialize() {
        this.EnomCol.setCellValueFactory((cellData) -> {
            return ((Elector)cellData.getValue()).nameProperty();
        });
        this.Ecandcol.setCellValueFactory((cellData) -> {
            return ((Elector)cellData.getValue()).districtProperty();
        });
        this.loadElectors();
    }

    private void loadElectors() {
        Elector elector1 = new Elector("Électeur 1", "District A");
        Elector elector2 = new Elector("Électeur 2", "District B");
        this.ElecTbv.getItems().addAll(new Elector[]{elector1, elector2});
    }

    @FXML
    private void handleDeleteElector() {
        Elector selectedElector = (Elector)this.ElecTbv.getSelectionModel().getSelectedItem();
        if (selectedElector != null) {
            this.ElecTbv.getItems().remove(selectedElector);
            this.showInfoAlert("Électeur Supprimé", "L'électeur '" + selectedElector.getName() + "' a été supprimé.");
        } else {
            this.showErrorAlert("Aucun Électeur Sélectionné", "Veuillez sélectionner un électeur à supprimer.");
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

