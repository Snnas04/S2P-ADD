import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement
@XmlType(propOrder = {"nom", "familia", "moduls"})
public class Cicle {
    private String nom;
    private String familia;
    private ArrayList<Modul> moduls = new ArrayList<Modul>();

    public Cicle() {}

    public Cicle(String nom, String familia, ArrayList<Modul> moduls) {
        this.nom = nom;
        this.familia = familia;
        this.moduls = moduls;
    }

    public String getNom() {
        return nom;
    }

    public String getFamilia() {
        return familia;
    }

    @XmlElementWrapper(name = "llistaModuls")
    public ArrayList<Modul> getModuls() {
        return moduls;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement(name = "familiaCicle")
    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public void setModuls(ArrayList<Modul> moduls) {
        this.moduls = moduls;
    }

    public String toString() {
        return "Nom: " + nom + "\nfamilia: " + familia + "\nModuls: " + moduls;
    }
}
