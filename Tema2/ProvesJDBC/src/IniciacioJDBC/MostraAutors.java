package IniciacioJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostraAutors {
    private static final String url = "jdbc:mysql://localhost:3306/BIBLIOTECA";
    private static final String usuari = "root";
    private static final String password = "1234";


    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, usuari, password)) {
            System.out.println("Connectat a la base de dades BIBLIOTECA");

            var statement = conn.createStatement();
            var sql = "SELECT * FROM AUTORS";
            var resultat = statement.executeQuery(sql);

            ResultSet rs = resultat;

            while (rs.next()) {
                int ID_AUT = rs.getInt("ID_AUT");
                String NOM_AUT = rs.getString("NOM_AUT");

                System.out.println(ID_AUT + " " + NOM_AUT);
            }

            rs.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
