package Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement
@XmlType(propOrder = {"dni", "nom", "llinatges", "direccio", "cp", "ciutat", "telefon"})
public class Soci implements Serializable {
    private String dni, nom, llinatges, direccio, ciutat, telefon;
    private int cp;

    public Soci(){}

    public Soci(String dni, String nom, String llinatges, String direccio, int cp, String ciutat, String telefon){
        this.dni = dni;
        this.nom = nom;
        this.llinatges = llinatges;
        this.direccio = direccio;
        this.cp = cp;
        this.ciutat = ciutat;
        this.telefon = telefon;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    @XmlElement(name = "adreça")
    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Soci{ " +
                "\n    dni='" + dni + '\'' +
                ", \n    nom='" + nom + '\'' +
                ", \n    llinatges='" + llinatges + '\'' +
                ", \n    direccio='" + direccio + '\'' +
                ", \n    ciutat='" + ciutat + '\'' +
                ", \n    telefon='" + telefon + '\'' +
                ", \n    cp=" + cp +
                "\n}";
    }
}
