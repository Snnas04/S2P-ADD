package IniciacioJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SentenciesPreparadesAutors {
    private static final String url = "jdbc:mysql://localhost:3306/BIBLIOTECA";
    private static final String usuari = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(url, usuari, password)) {
            var sentencia = conn.prepareStatement("INSERT INTO AUTORS VALUES (?, ?, ?)");
               
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
