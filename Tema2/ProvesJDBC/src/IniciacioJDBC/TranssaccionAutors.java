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
            conn.setAutoCommit(false);
            var statement = conn.createStatement();

            var sql = "SELECT COUNT(*) FROM AUTORS";
            var resultCOUNT1 = statement.executeQuery(sql);

            System.out.println("Hi ha " + resultCOUNT1 + " autors");


            sql = "INSERT INTO AUTORS VALUES (9283, 'Andreu Garcia', '2004-04-04', 'Espanyol', NULL)";
            var resultINSERT = statement.executeUpdate(sql);

            System.out.println("S'ha afegit " + resultINSERT + " als autors");
            sql = "SELECT COUNT(*) FROM AUTORS";
            var resultCOUNT2 = statement.executeQuery(sql);

            System.out.println("Hi ha " + resultCOUNT2 + " autors");

            conn.rollback();


            sql = "SELECT COUNT(*) FROM AUTORS";
            var resultCOUNT3 = statement.executeQuery(sql);

            System.out.println("Hi ha " + resultCOUNT3 + " autors");

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
