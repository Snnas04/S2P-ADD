package cat.spaad.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class Llibre {
    private String autor;
    private String titol;
    private String genere;
    private int preu;
    private int dataPublicacio;
    private String descripcio;

    public Llibre() {
    }

    public Llibre(String autor, String titol, String genere, int preu, int dataPublicacio, String descripcio) {
        this.autor = autor;
        this.titol = titol;
        this.genere = genere;
        this.preu = preu;
        this.dataPublicacio = dataPublicacio;
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

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public int getDataPublicacio() {
        return dataPublicacio;
    }

    public void setDataPublicacio(int dataPublicacio) {
        this.dataPublicacio = dataPublicacio;
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
                ", preu=" + preu +
                ", dataPublicacio=" + dataPublicacio +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }
}
