package sn.ismonline.ism_examen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private TableView<User> userTbv;

    @FXML
    private TextField UidTfd;

    @FXML
    private TextField UnomTfd;

    @FXML
    private TextField UprenomTfd;

    @FXML
    private TextField UloginTfd;

    @FXML
    private TextField UpasswordTfd;

    @FXML
    private TextField UactivedTfd;

    @FXML
    private TextField UprofilTfd;

    private Dbconnexion db = new Dbconnexion();

    @FXML
    private void clearFields() {
        UidTfd.clear();
        UnomTfd.clear();
        UprenomTfd.clear();
        UloginTfd.clear();
        UpasswordTfd.clear();
        UactivedTfd.clear();
        UprofilTfd.clear();
    }

    @FXML
    private void saveUser(ActionEvent event) {
        try {
            int id = Integer.parseInt(UidTfd.getText());
            String nom = UnomTfd.getText();
            String prenom = UprenomTfd.getText();
            String login = UloginTfd.getText();
            String password = UpasswordTfd.getText();
            int actived = Integer.parseInt(UactivedTfd.getText());
            String profil = UprofilTfd.getText();

            // Insérer le nouvel utilisateur dans la base de données
            User newUser = new User();
            newUser.setId(id);
            newUser.setNom(nom);
            newUser.setPrenom(prenom);
            newUser.setLogin(login);
            newUser.setPassword(password);
            newUser.setActived(actived);
            newUser.setProfil(Integer.parseInt(profil));
            db.equals(newUser);

            // Actualiser le TableView
            loadUsers();

            // Effacer les champs après l'ajout
            clearFields();
        } catch (NumberFormatException e) {
            showErrorAlert("Erreur de saisie", "Veuillez saisir une valeur numérique valide pour l'ID et l'actived.");
        } catch (Exception e) {
            showErrorAlert("Erreur", "Une erreur est survenue lors de l'ajout de l'utilisateur.");
            e.printStackTrace();
        }
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private TableColumn<User, Integer> idCol;

    @FXML
    private TableColumn<User, String> nomCol;

    @FXML
    private TableColumn<User, String> prenomCol;

    @FXML
    private TableColumn<User, String> loginCol;

    @FXML
    private TableColumn<User, String> passwordCol;

    @FXML
    private TableColumn<User, Integer> activedCol;

    @FXML
    private TableColumn<User, Integer> profilCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        loginCol.setCellValueFactory(new PropertyValueFactory<>("login"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        activedCol.setCellValueFactory(new PropertyValueFactory<>("actived"));
        profilCol.setCellValueFactory(new PropertyValueFactory<>("profil"));

        loadUsers();
    }

    private void loadUsers() {
        ObservableList<User> users = FXCollections.observableArrayList(db.getAllUsers());
        userTbv.setItems(users);
    }
}
