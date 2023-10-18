import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"titol", "duracio", "generes", "valoracio", "argument", "directors", "repartiment"})
public class Film {
    private String titol;
    private int duracio;
    private String generes;
    private float valoracio;
    private String argument;
    private String directors;
    private String repartiment;

    public Film() {}

    public Film(String titol, int duracio, String generes, float valoracio, String argument, String directors, String repartiment) {
        this.titol = titol;
        this.duracio = duracio;
        this.generes = generes;
        this.valoracio = valoracio;
        this.argument = argument;
        this.directors = directors;
        this.repartiment = repartiment;
    }

    @XmlElement(name = "titol")
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getDuracio() {
        return duracio;
    }

    @XmlElement(name = "duracio")
    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    @XmlElement(name = "generes")
    public String getGeneres() {
        return generes;
    }

    public void setGeneres(String generes) {
        this.generes = generes;
    }

    @XmlElement(name = "valoracio")
    public float getValoracio() {
        return valoracio;
    }

    public void setValoracio(float valoracio) {
        this.valoracio = valoracio;
    }

    @XmlElement(name = "argument")
    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    @XmlElement(name = "directors")
    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    @XmlElement(name = "repartiment")
    public String getRepartiment() {
        return repartiment;
    }

    public void setRepartiment(String repartiment) {
        this.repartiment = repartiment;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titol='" + titol + '\'' +
                ", duracio=" + duracio +
                ", generes='" + generes + '\'' +
                ", valoracio=" + valoracio +
                ", argument='" + argument + '\'' +
                ", directors='" + directors + '\'' +
                ", repartiment='" + repartiment + '\'' +
                '}';
    }
}
