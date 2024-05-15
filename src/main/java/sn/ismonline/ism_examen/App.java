package sn.ismonline.ism_examen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;
    private static App instance;

    public static App getInstance() {

        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showUserPage();
    }

    public void showLoginPage() {
        loadAndShowPage("/pages/Login.fxml", "Connexion");
    }

    public void showUserPage() {
        loadAndShowPage("/pages/User.fxml", "Gestion des utilisateurs");
    }

    public void showCandidatePage() {
        loadAndShowPage("/pages/Candidate.fxml", "Gestion des candidats");
    }

    public void showElectorPage() {
        loadAndShowPage("/pages/Elector.fxml", "Gestion des électeurs");
    }

    public void showStatisticsPage() {
        loadAndShowPage("/pages/Statistics.fxml", "Statistiques");
    }

    private FXMLLoader loadAndShowPage(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle(title);
            primaryStage.show();
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

