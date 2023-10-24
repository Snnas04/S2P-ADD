import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/BIBLIOTECA";
    private static final String usuari = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(url, usuari, password)) {
            var statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            var sql = "SELECT * FROM AUTORS ORDER BY NOM_AUT";
            var resultat = statement.executeQuery(sql);

            var rs = resultat;
            rs.absolute(5851);
            while (rs.relative(2)) {
                int ID_AUT = rs.getInt("ID_AUT");
                String NOM_AUT = rs.getString("NOM_AUT");

                System.out.println(ID_AUT + " " + NOM_AUT);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
