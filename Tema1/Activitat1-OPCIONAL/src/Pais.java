import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement
@XmlType(propOrder = {"nom", "ciutats"})
public class Pais {
    private String nom;
    private ArrayList<Ciutat> ciutats = new ArrayList<Ciutat>();

    public Pais() {}

    public Pais(String nom, ArrayList<Ciutat> ciutats) {
        this.nom = nom;
        this.ciutats = ciutats;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Ciutat> getCiutats() {
        return ciutats;
    }

    public void setCiutats(ArrayList<Ciutat> ciutats) {
        this.ciutats = ciutats;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nom='" + nom + '\'' +
                ", ciutats=" + ciutats +
                '}';
    }
}
