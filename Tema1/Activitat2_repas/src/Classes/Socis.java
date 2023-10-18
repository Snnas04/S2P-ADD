package Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Socis {
    private int recompte;
    private List<Soci> socis = new ArrayList<>();

    public Socis(){}

    public Socis(int recompte, List<Soci> socis){
        this.recompte = recompte;
        this.socis = socis;
    }

    public int getRecompte() {
        return recompte;
    }

    public void setRecompte(int recompte) {
        this.recompte = recompte;
    }

    @XmlElement(name = "soci")
    public List<Soci> getSocis() {
        return socis;
    }

    public void setSocis(List<Soci> socis) {
        this.socis = socis;
    }
}
