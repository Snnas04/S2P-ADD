package cat.spaad.classes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Llibre {
    private String id;
    private String autor;
    private String titol;
    private String genere;
    private String preu;
    private String data_publicacio;
    private String descripcio;

    public Llibre() {}

    public Llibre(String id, String autor, String titol, String genere, String preu, String data_publicacio, String descripcio) {
        this.id = id;
        this.autor = autor;
        this.titol = titol;
        this.genere = genere;
        this.preu = preu;
        this.data_publicacio = data_publicacio;
        this.descripcio = descripcio;
    }

    @XmlAttribute (name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement (name = "author")
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlElement (name = "title")
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    @XmlElement (name = "genre")
    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @XmlElement (name = "price")
    public String getPreu() {
        return preu;
    }

    public void setPreu(String preu) {
        this.preu = preu;
    }

    @XmlElement (name = "publish_date")
    public String getData_publicacio() {
        return data_publicacio;
    }

    public void setData_publicacio(String data_publicacio) {
        this.data_publicacio = data_publicacio;
    }

    @XmlElement (name = "description")
    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "\n" + "Llibre{" +
                "id='" + id + '\'' +
                ", autor='" + autor + '\'' +
                ", titol='" + titol + '\'' +
                ", genere='" + genere + '\'' +
                ", preu='" + preu + '\'' +
                ", data_publicacio='" + data_publicacio + '\'' +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }
}
