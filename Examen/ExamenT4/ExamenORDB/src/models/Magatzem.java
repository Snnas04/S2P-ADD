package models;

import org.postgresql.util.PGobject;

public class Magatzem {
    private int codi;
    private String nom;
    private int tel;
    private PGobject adresa;

    public Magatzem(int codi, String nom, int tel, PGobject adresa) {
        this.codi = codi;
        this.nom = nom;
        this.tel = tel;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Magatzem{" +
                "codi=" + codi +
                ", nom='" + nom + '\'' +
                ", tel=" + tel +
                ", adresa=" + adresa +
                '}';
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public PGobject getAdresa() {
        return adresa;
    }

    public void setAdresa(PGobject adresa) {
        this.adresa = adresa;
    }
}
