import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement
@XmlType(propOrder = {"recompte", "socis"})
public class LlistaSocis {
    private int recompte;
    private ArrayList<Soci> socis = new ArrayList<Soci>();

    public LlistaSocis() {}

    public LlistaSocis(int recompte, ArrayList<Soci> socis) {
        this.recompte = recompte;
        this.socis = socis;
    }

    public int getRecompte() {
        return recompte;
    }

    public void setRecompte(int recompte) {
        this.recompte = recompte;
    }

    public ArrayList<Soci> getSocis() {
        return socis;
    }

    public void setSocis(ArrayList<Soci> socis) {
        this.socis = socis;
    }

    @Override
    public String toString() {
        return "LlistaSocis{" +
                "recompte=" + recompte +
                ", socis=" + socis +
                '}';
    }
}
