package sn.ismonline.ism_examen;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController {
    @FXML
    private TextField LidField;
    @FXML
    private PasswordField LpassField;
    private sn.ismonline.ism_examen.App appInstance;

    public LoginController() {
    }

    public void setAppInstance(sn.ismonline.ism_examen.App appInstance) {
        this.appInstance = appInstance;
    }

    @FXML
    private void handleLogin() {
        String username = this.LidField.getText();
        String password = this.LpassField.getText();
        if (this.isValid(username, password)) {
            this.appInstance.showUserPage();
        } else {
            this.showErrorAlert("Identifiants invalides", "Vérifiez vos indentifiants.");
        }

    }

    private boolean isValid(String username, String password) {
        return username.equals("identifiant") && password.equals("password");
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText((String)null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showSuccessMessage(String s) {
    }
}
