package IniciacioJDBC;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SentenciesPreparadesAutors {
    private final static String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private final static String user = "root";
    private final static String password = "Thespai422";

    public static void main(String[] args) {
        try (var con = DriverManager.getConnection(URL, user, password)) {
            var sentencia = con.createStatement();

            var sql = "UPDATE AUTORS SET NOM_AUT = ? WHERE ID_AUT = ?";
            var preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "Arnau Codina");
            preparedStatement.setString(1, "Olívia Riutort");
            preparedStatement.setInt(2, 1139);
            var result = preparedStatement.executeUpdate();

            sentencia.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
