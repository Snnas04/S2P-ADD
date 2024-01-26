package model;

import org.postgresql.util.PGobject;

public class Alumne {
    private String nif;
    private String nom;
    private String cognoms;
    private PGobject contacte;

    public Alumne(String nif, String nom, String cognoms, PGobject contacte) {
        this.nif = nif;
        this.nom = nom;
        this.cognoms = cognoms;
        this.contacte = contacte;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public PGobject getContacte() {
        return contacte;
    }

    public void setContacte(PGobject contacte) {
        this.contacte = contacte;
    }

    @Override
    public String toString() {
        return "Alumne {\n" +
                "nif = " + nif + '\n' +
                "nom = " + nom + '\n' +
                "cognoms = " + cognoms + '\n' +
                "contacte = " + contacte + '\n' +
                '}';
    }
}
