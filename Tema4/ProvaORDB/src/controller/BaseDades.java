package controller;

import model.Alumne;
import model.Assignatura;
import model.Cicle;
import model.Matricula;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDades {
    private static final String URL = "jdbc:postgresql://localhost/institut";
    private static final String usuari = "examen";
    private static final String contrasenya = "examen";

    public static void main(String[] args) {

    }

    public Cicle findCicleByCodi(int codi) {
        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select nom from cicles where id_cicle = ?");
            pre.setInt(1, codi);

            try (var rs = pre.executeQuery()) {
                if (rs.next()) {
                    return new Cicle(codi, rs.getString("nom"));
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Assignatura findAssignaturaByCodi(int codi) {
        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select nom, cicle from assignatures where cicle = ?");
            pre.setInt(1, codi);

            try (var rs = pre.executeQuery()) {
                if (rs.next()) {
                    var cicle = findCicleByCodi(rs.getInt("cicle"));
                    return new Assignatura(codi, rs.getString("nom"), cicle);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Alumne findAlumneByNIF(String nif) {
        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
           PreparedStatement pre = con.prepareStatement("select nom, cognoms from alumnes where nif = ?");
          pre.setString(1, nif);

          try (var rs = pre.executeQuery()) {
              if (rs.next()) {
                  return new Alumne(nif, rs.getString("nom"), rs.getString("cognoms"), null); // posam null perquè no ens interessa recuperar les dades de contacte
              } else {
                  return null;
              }
          }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Alumne findAlumneByNIFwhitContact(String nif) {
        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select nom, cognoms, dades_alumne from alumnes where nif = " +
                    "?");
            pre.setString(1, nif);

            try (var rs = pre.executeQuery()) {
                if (rs.next()) {
                    return new Alumne(nif, rs.getString("nom"), rs.getString("cognoms"), (PGobject) rs.getObject("dades_alumne")); // posam null perquè no ens interessa recuperar les dades de contacte
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Matricula findMatriculaByCodi(String nif, int codiAssig) {
        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select nota from matricula where alumne = ? and assignatura" +
                    " = ?");
            pre.setString(1, nif);
            pre.setInt(2, codiAssig);

            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    Array ref = rs.getArray("nota");
                    BigDecimal[] notes = (BigDecimal[]) ref.getArray();
                    return new Matricula(findAlumneByNIFwhitContact(nif), findAssignaturaByCodi(codiAssig), notes);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Alumne> findAllAlumneByNIFwhitContact() {
        List<Alumne> listAlumnes = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select * from alumnes");

            var rs = pre.executeQuery();

            while (rs.next()) {
                Alumne alumne = new Alumne(rs.getString("nif"), rs.getString("nom"), rs.getString("cognoms"), (PGobject) rs.getObject("dades_alumne"));
                listAlumnes.add(alumne);
            }
            return listAlumnes;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
