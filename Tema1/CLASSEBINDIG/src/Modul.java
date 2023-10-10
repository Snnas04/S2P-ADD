import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Modul {
    private String nom;
    private String codi;
    private int hores;

    public Modul() {}

    public Modul(String nom, String codi, int hores) {
        this.nom = nom;
        this.codi = codi;
        this.hores = hores;
    }

    public String getNom() {
        return nom;
    }

    public String getCodi() {
        return codi;
    }

    public int getHores() {
        return hores;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public String toString() {
        return "Nom: " + nom + "\nCodi: " + codi + "\nHores: " + hores;
    }
}