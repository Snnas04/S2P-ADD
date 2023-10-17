import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"dni", "nom", "llinatges", "adreca", "cp", "ciutat", "telefon"})
public class Soci {
    private String dni;
    private String nom;
    private String llinatges;
    private String adreca;
    private int cp;
    private String ciutat;
    private String telefon;

    public Soci() {}

    public Soci(String dni, String nom, String llinatges, String adreca, int cp, String ciutat, String telefon) {
        this.dni = dni;
        this.nom = nom;
        this.llinatges = llinatges;
        this.adreca = adreca;
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

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Soci{" +
                "dni=" + dni +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", adreca='" + adreca + '\'' +
                ", cp=" + cp +
                ", ciutat='" + ciutat + '\'' +
                ", telefon=" + telefon +
                '}';
    }
}
