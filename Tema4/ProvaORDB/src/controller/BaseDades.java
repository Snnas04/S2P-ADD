package controller;

import model.Alumne;
import model.Assignatura;
import model.Cicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}
