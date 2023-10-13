import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"id", "ciutat", "districte", "poblacio"})
public class Ciutat {
    private int id;
    private String ciutat;
    private String districte;
    private int poblacio;

    public Ciutat() {}

    public Ciutat(int id, String ciutat, String districte, int poblacio) {
        this.id = id;
        this.ciutat = ciutat;
        this.districte = districte;
        this.poblacio = poblacio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getDistricte() {
        return districte;
    }

    public void setDistricte(String districte) {
        this.districte = districte;
    }

    public int getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(int poblacio) {
        this.poblacio = poblacio;
    }

    @Override
    public String toString() {
        return "Ciutat{" +
                "id=" + id +
                ", ciutat='" + ciutat + '\'' +
                ", districte='" + districte + '\'' +
                ", poblacio=" + poblacio +
                '}';
    }
}
