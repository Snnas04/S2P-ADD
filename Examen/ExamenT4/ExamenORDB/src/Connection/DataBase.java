package Connection;

import models.Address;
import models.Jugueta;
import models.Magatzem;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String URL = "jdbc:postgresql://localhost/distribuidora";
    private static final String usuari = "examen";
    private static final String contrasenya = "examen";

    public Magatzem findMagatzemByCodi(int magCodi) {
        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre =con.prepareStatement("select nom, tel, adresa from magatzem where codi = ?");
            pre.setInt(1, magCodi);

            try (var rs = pre.executeQuery()) {
                if (rs.next()) {
                    return new Magatzem(magCodi, rs.getString("nom"), rs.getInt("tel"),
                            (PGobject) rs.getObject("adresa"));
                } else {
                    return null;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean createMagatzem(Magatzem magatzem) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("insert into magatzem values (?, ?, ?, row(?, ?, ?, ?))");

            pre.setInt(1, magatzem.getCodi());
            pre.setString(2, magatzem.getNom());
            pre.setInt(3, magatzem.getTel());

            Address address = (Address) magatzem.getAdresa();
            pre.setString(4, address.getCarrer());
            pre.setString(5, address.getLocalitat());
            pre.setString(6, address.getCp());
            pre.setString(7, address.getPais());

            nfiles = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1);
    }

    public List<Jugueta> findAllJuguetes() {
        List<Jugueta> listJuguetes = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("select * from jugueta");

            var rs = pre.executeQuery();

            while (rs.next()) {
                int magatzem = rs.getInt("codi_magatzem");
                Array ref = rs.getArray("etiqueta");
                String[] etiquetes = (String[]) ref.getArray();


                Jugueta jugueta = new Jugueta(rs.getInt("ref"), rs.getString("nom"), rs.getInt("edad"),
                        rs.getString("marca"), etiquetes, findMagatzemByCodi(magatzem));
                listJuguetes.add(jugueta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listJuguetes;
    }

    public boolean afegirEtiqueta(String etiqueta, int refJugueta, int posicio) {
        int nfiles = 0;

        try (Connection con = DriverManager.getConnection(URL, usuari, contrasenya)) {
            PreparedStatement pre = con.prepareStatement("update jugueta set etiqueta[?] = ? where ref = ?");

            pre.setInt(1, posicio);
            pre.setString(2, etiqueta);
            pre.setInt(3, refJugueta);

            nfiles = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (nfiles == 1);
    }
}
