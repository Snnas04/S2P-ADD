package IniciacioJDBC;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class BatchAutors {
    private static final String url = "jdbc:mysql://localhost:3306/BIBLIOTECA";
    private static final String usuari = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(url, usuari, password)) {
            var statement = conn.createStatement();

            // INSERTS
            var sql = "INSERT INTO AUTORS VALUES (1000, 'Jaume Ximenes', '1997-11-21', 'Irlandesa', NULL)";
            statement.addBatch(sql);

            sql = "INSERT INTO AUTORS VALUES (1001, 'Antoni Villalonga', '1980-06-30', 'Catalana', NULL)";
            statement.addBatch(sql);

            sql = "INSERT INTO AUTORS VALUES (1002, 'Mary Smith', '1989-02-05', 'Anglesa', NULL)";
            statement.addBatch(sql);

            var resultat = statement.executeBatch();

            System.out.println("S'han afegit " + Arrays.toString(resultat) + " registres");

            // DELETE
            sql = "DELETE FROM AUTORS WHERE ID_AUT = 1000";
            statement.addBatch(sql);

            sql = "DELETE FROM AUTORS WHERE ID_AUT = 1001";
            statement.addBatch(sql);

            sql = "DELETE FROM AUTORS WHERE ID_AUT = 1002";
            statement.addBatch(sql);

            resultat = statement.executeBatch();

            System.out.println("S'han eliminat " + Arrays.toString(resultat) + " registres");

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
