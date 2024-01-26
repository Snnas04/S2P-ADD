package controller;

import model.*;
import org.postgresql.PGConnection;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDades {
    private static final String URL = "jdbc:postgresql://localhost/institut";
    private static final String usuari = "examen";
    private static final String contrasenya = "examen";

    // 1
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

    // 2
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

    // 3
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

    // 4
    public Alumne findAlumneByNIFwhitContact(String nif) {
        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select nom, cognoms, dades_alumne from alumnes where nif = " +
                    "?");
            pre.setString(1, nif);

            try (var rs = pre.executeQuery()) {
                if (rs.next()) {
                    return new Alumne(nif, rs.getString("nom"), rs.getString("cognoms"), (PGobject) rs.getObject("dades_alumne"));
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 5
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

    // 6
    public List<Alumne> findAllAlumneByNIFwhitContact() {
        List<Alumne> listAlumnes = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select * from alumnes");

            var rs = pre.executeQuery();

            while (rs.next()) {
                Alumne alumne = new Alumne(rs.getString("nif"), rs.getString("nom"), rs.getString("cognoms"), (PGobject) rs.getObject("dades_alumne"));
                listAlumnes.add(alumne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAlumnes;
    }

    // 7
    public List<Matricula> findAllMatriculaByNIF(String nif) {
        List<Matricula> listMatricules = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select assignatura, nota from matricula where alumne = ?");
            pre.setString(1, nif);

            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    Array ref = rs.getArray("nota");
                    BigDecimal[] notes = (BigDecimal[]) ref.getArray();

                    Matricula matricula = new Matricula(findAlumneByNIFwhitContact(nif), findAssignaturaByCodi(rs.getInt("assignatura")), notes);

                    listMatricules.add(matricula);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listMatricules;
    }

    // 8
    public List<Matricula> findAllMatriculaByCodiAssig(int codiAssig) {
        List<Matricula> listMatricules = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select alumne, nota from matricula where assignatura = ?");
            pre.setInt(1, codiAssig);

            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    Array ref = rs.getArray("nota");
                    BigDecimal[] notes = (BigDecimal[]) ref.getArray();

                    Matricula matricula = new Matricula(findAlumneByNIFwhitContact(rs.getString("alumne")), findAssignaturaByCodi(codiAssig), notes);

                    listMatricules.add(matricula);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listMatricules;
    }

    // 9
    public boolean modificarNota(String nif, int codiAssig, BigDecimal nota, int posicio) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("update matricula set nota[?] = ? where alumne = ? and assignatura = ?");

            pre.setInt(1, posicio);
            pre.setBigDecimal(2, nota);
            pre.setString(3, nif);
            pre.setInt(4, codiAssig);

            nfiles = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1); // si nfiles == 1, retorna true, si no, retorna false
    }

    // 10
    // fora Objecte, ancara que passam un objecta si en lloc de passar un objecte passasim els diferents atributs funcionaria igual
    public boolean crearAlumne(Alumne alumne) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("insert into alumnes values (?, ?, ?, row(?, ?, ?))");

            pre.setString(1, alumne.getNif());
            pre.setString(2, alumne.getNom());
            pre.setString(3, alumne.getCognoms());

            Contacte contacte = (Contacte) alumne.getContacte();
            pre.setString(4, contacte.getTelefon());
            pre.setString(5, contacte.getEmail());
            pre.setString(6, contacte.getTwitter());

            nfiles =pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1);
    }

    // passant un Objecte
    public boolean createAlumneObject(Alumne alumne) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("insert into alumnes values (?, ?, ?, ?)");

            pre.setString(1, alumne.getNif());
            pre.setString(2, alumne.getNom());
            pre.setString(3, alumne.getCognoms());
            pre.setObject(4, alumne.getContacte());

            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1);
    }

    // 11
    public boolean matricularNouAlumne(String nif, int codiAssig) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("insert into matricula values (?, ?, null)");
            pre.setString(1, nif);
            pre.setInt(2, codiAssig);

            nfiles = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1);
    }

    // 12
    public boolean afegirNotes(String nif, int codiAsssig, BigDecimal[] notes) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("update matricula set nota = ? where alumne = ? and assignatura = ?");

            Array notesArray = con.createArrayOf("DECIMAL", notes);
            pre.setArray(1, notesArray);
            pre.setString(2, nif);
            pre.setInt(3, codiAsssig);

            nfiles = pre.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1);
    }

    /* ****************************
    *   ACTIVITAT PER PRACTICAR   *
    * ************************** */
    public boolean addActivitySubject(Activitat activitat, int codiAssig) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("update assignatures set activitat = ? where id_assignatura = ?");

            PGConnection pgConn = (PGConnection) con;
            pgConn.addDataType("activitats", Activitat.class);

            pre.setObject(1, activitat);
            pre.setInt(2, codiAssig);

            nfiles = pre.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1);
    }

    public boolean deleteActivity(int codiAssig) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("update assignatures set activitat = null where " +
                    "id_assignatura = ?");


            pre.setInt(1, codiAssig);

            nfiles = pre.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1);
    }
}
