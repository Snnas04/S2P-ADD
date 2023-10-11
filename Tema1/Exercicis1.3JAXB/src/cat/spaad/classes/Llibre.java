package cat.spaad.classes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Llibre {
    private String autor;
    private String titol;
    private String genere;
    private String data_publicacio;
    private String descripcio;

    public Llibre() {}

    public Llibre(String autor, String titol, String genere, String data_publicacio, String descripcio) {
        this.autor = autor;
        this.titol = titol;
        this.genere = genere;
        this.data_publicacio = data_publicacio;
        this.descripcio = descripcio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getData_publicacio() {
        return data_publicacio;
    }

    public void setData_publicacio(String data_publicacio) {
        this.data_publicacio = data_publicacio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "autor='" + autor + '\'' +
                ", titol='" + titol + '\'' +
                ", genere='" + genere + '\'' +
                ", data_publicacio='" + data_publicacio + '\'' +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }
}
