package cat.spaad.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement
@XmlType(propOrder = {"nom", "llibres"})
public class Catalog {
    private String nom;
    private ArrayList<Llibre> llibres = new ArrayList<Llibre>();

    public Catalog() {}

    public Catalog(String nom, ArrayList<Llibre> llibres) {
        this.nom = nom;
        this.llibres = llibres;
    }

    @XmlElement (name = "name")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElementWrapper (name = "books")
    @XmlElement (name = "book")
    public ArrayList<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(ArrayList<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "nom='" + nom + '\'' +
                ", llibres=" + llibres +
                "\n" +
                '}';
    }
}
