package sn.ismonline.ism_examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dbconnexion {

    private Connection cnx;
    private PreparedStatement pstm;
    private ResultSet rs;

    public void connect() {
        String url = "jdbc:mysql://localhost:3306/votre_base_de_donnees";
        String user = "votre_utilisateur";
        String password = "votre_mot_de_passe";

        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion à la base de données établie !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User newUser) {
        String sql = "INSERT INTO utilisateur (nom, prenom, login, password, actif, profil) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            connect();
            pstm = cnx.prepareStatement(sql);
            pstm.setString(1, newUser.getNom());
            pstm.setString(2, newUser.getPrenom());
            pstm.setString(3, newUser.getLogin());
            pstm.setString(4, newUser.getPassword());
            pstm.setInt(5, newUser.getActif());
            pstm.setInt(6, newUser.getProfil());
            pstm.executeUpdate(); // Exécution de la requête d'insertion
            System.out.println("Utilisateur inséré avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur";
        try {
            connect(); // Connexion à la base de données
            pstm = cnx.prepareStatement(sql);
            rs = pstm.executeQuery(); // Exécution de la requête de sélection
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setActif(rs.getInt("actif"));
                user.setProfil(rs.getInt("profil"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return userList;
    }

    private void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (cnx != null) cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
