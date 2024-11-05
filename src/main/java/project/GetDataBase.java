package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetDataBase {
    private static final String URL = "jdbc:mariadb://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
             
            // Lister les tables
            ResultSet tables = statement.executeQuery("SHOW TABLES;");
            System.out.println("Tables in the database:");
            while (tables.next()) {
                System.out.println(tables.getString(1));
            }

            // Vérifier le contenu de la table CLIENT (si elle existe)
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CLIENT;");
            System.out.println("\nContents of the CLIENT table:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                                   ", Nom: " + resultSet.getString("nom") +
                                   ", Email: " + resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
