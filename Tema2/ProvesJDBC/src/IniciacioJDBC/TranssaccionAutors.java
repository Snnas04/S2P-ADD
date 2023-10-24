package IniciacioJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TranssaccionAutors {
    private static final String url = "jdbc:mysql://localhost:3306/BIBLIOTECA";
    private static final String usuari = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(url, usuari, password)) {
            // a
            conn.setAutoCommit(false);
            var statement = conn.createStatement();

            // b
            var sql = "UPDATE AUTORS SET NOM_AUT = ? WHERE ID_AUT = ?";
            var preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "Arnau Codina");
            preparedStatement.setString(1, "Olívia Riutort");
            preparedStatement.setInt(2, 1139);
            var result = preparedStatement.executeUpdate();

            // c
            sql = "SELECT COUNT(*) FROM AUTORS";
            var resultC = statement.executeQuery(sql);

            System.out.println("Hi ha " + resultC + " autors");

            // d
            sql = "INSERT INTO AUTORS VALUES (9283, 'Andreu Garcia', '2004-04-04', 'Espanyol', NULL)";
            var resultD = statement.executeUpdate(sql);

            System.out.println("S'ha afegit " + resultD + " als autors");

            // e
            conn.rollback();

            // f
            sql = "SELECT COUNT(*) FROM AUTORS";
            var resultF = statement.executeQuery(sql);

            System.out.println("Hi ha " + resultF + " autors");

            // g
            sql = "INSERT INTO AUTORS VALUES (9283, 'Andreu Garcia', '2004-04-04', 'Espanyol', NULL)";
            var resultG = statement.executeUpdate(sql);

            System.out.println("S'ha afegit " + resultG + " als autors");

            conn.commit();

            sql = "SELECT COUNT(*) FROM AUTORS";
            var resultGCount = statement.executeQuery(sql);

            System.out.println("Hi ha " + resultGCount + " autors");

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
