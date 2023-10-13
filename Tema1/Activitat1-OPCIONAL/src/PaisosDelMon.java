import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement
@XmlType(propOrder = {"recompte", "paisos"})
public class PaisosDelMon {
    private String recompte;
    private ArrayList<Pais> paisos = new ArrayList<Pais>();

    public PaisosDelMon() {}

    public PaisosDelMon(String recompte, ArrayList<Pais> paisos) {
        this.recompte = recompte;
        this.paisos = paisos;
    }


    public String getRecompte() {
        return recompte;
    }

    public void setRecompte(String recompte) {
        this.recompte = recompte;
    }

    public ArrayList<Pais> getPaisos() {
        return paisos;
    }

    public void setPaisos(ArrayList<Pais> paisos) {
        this.paisos = paisos;
    }

    @Override
    public String toString() {
        return "PaisosDelMon{" +
                "recompte='" + recompte + '\'' +
                ", paisos=" + paisos +
                '}';
    }
}
