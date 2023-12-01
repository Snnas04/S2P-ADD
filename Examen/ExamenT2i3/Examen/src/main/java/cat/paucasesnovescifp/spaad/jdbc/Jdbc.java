package cat.paucasesnovescifp.spaad.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
    private static final String url = "jdbc:mysql://localhost:3306/interins";
    private static final String user = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        localitatsIlla(71); // exercici 1
        eliminarCentre(7000029); // exercici 2
        // exercici 3
        System.out.println("Hi ha " + contarCentresIlla(71) + " centres a l'illa");
        executarProcedure(071);
    }

    public static void localitatsIlla(int illa) {
        try (var con = DriverManager.getConnection(url, user, password)) {
            var sentencia = con.createStatement();

            var sql = "SELECT * FROM Localitats as l WHERE l.idIlla = " + illa;
            var resultat = sentencia.executeQuery(sql);

            ResultSet rs = resultat;

            while (rs.next()) {
                int idLocalitat = rs.getInt("idLocalitat");
                String nomLocalitat = rs.getString("nomLocalitat");
                int idIlla = rs.getInt("idIlla");

                System.out.println(idLocalitat + " " + nomLocalitat + " " + idIlla);
            }

            sentencia.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminarCentre(int centre) {
        try (var con = DriverManager.getConnection(url, user, password)) {
            con.setAutoCommit(false);
            var sentencia = con.createStatement();

            var sql = "DELETE FROM Centres WHERE idCentre = " + centre;
            var resultat = sentencia.executeUpdate(sql);

            if (resultat == 0) {
                System.out.println("No s'ha eliminat cap registre");
                con.rollback();
            } else {
                System.out.println("S'ha eliminat " + resultat + " registre");
            }

            sentencia.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int contarCentresIlla(int illa) {
        try (var con = DriverManager.getConnection(url, user, password)) {
            var sentencia = con.createStatement();

            var sql = "SELECT count(*) FROM Centres C\n" +
                    "Join Localitats L on C.idLocalitat = L.idLocalitat\n" +
                    "join Illes I on L.idIlla = I.idIlla\n" +
                    "where I.idIlla =" + illa;
            var resultat = sentencia.executeQuery(sql);

            ResultSet rs = resultat;

            while (rs.next()) {
                int count = rs.getInt("COUNT(*)");
                return count;
            }

            sentencia.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void executarProcedure(int illa) {
        // executam la procedure crada a l'axiu procedure.sql dins el package jdbc
        try(var con = DriverManager.getConnection(url, user, password)) {
            var sentencia = con.prepareCall("CALL countCentresIlla(?, ?)");

            sentencia.setInt(1, illa);
            sentencia.registerOutParameter(2, java.sql.Types.INTEGER);
            sentencia.execute();

            System.out.println("Hi ha " + sentencia.getInt(2) + " centres a l'illa " + illa);

            sentencia.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
