package IniciacioJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModificaAutors {
    private static final String url = "jdbc:mysql://localhost:3306/BIBLIOTECA";
    private static final String usuari = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(url, usuari, password)) {
            var statement = conn.createStatement();
            // INSERT
            var sql = "INSERT INTO AUTORS VALUES (1139, 'Olívia Riutort', '2007-10-01', 'Polaca', NULL)";
            var resultat = statement.executeUpdate(sql);

            System.out.println("S'ha afegit " + resultat + " registre");

            // UPDATE
            sql = "UPDATE AUTORS SET NOM_AUT = 'Arnau Codina' WHERE ID_AUT = 1139";
            resultat = statement.executeUpdate(sql);

            System.out.println("S'ha actualitzat " + resultat + " registre");

            // DELETE
            sql = "DELETE FROM AUTORS WHERE ID_AUT = 1139";
            resultat = statement.executeUpdate(sql);

            System.out.println("S'ha eliminat " + resultat + " registre");

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
