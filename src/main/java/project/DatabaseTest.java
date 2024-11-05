package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseTest {

    private static final String URL = "jdbc:mariadb://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection to the database was successful!");

            // Création de la table CLIENT
            String createTableSQL = "CREATE TABLE IF NOT EXISTS CLIENT ("
                    + "id BIGINT PRIMARY KEY AUTO_INCREMENT, "
                    + "nom VARCHAR(50), "
                    + "email VARCHAR(50)"
                    + ");";

            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableSQL);
                System.out.println("Table CLIENT created successfully.");

                // Insertion d'un enregistrement dans la table CLIENT
                String insertClientSQL = "INSERT INTO CLIENT (nom, email) VALUES ('Test', 'test@example.com');";
                statement.executeUpdate(insertClientSQL);
                System.out.println("Client added successfully.");
            }

        } catch (SQLException e) {
            System.err.println("Error connecting to the database or executing SQL statements.");
            e.printStackTrace();
        }
    }
}
