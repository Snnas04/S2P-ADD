package model;

import org.postgresql.util.PGobject;

import java.sql.SQLException;

import static Utile.EinesCadenes.*;

public class Activitat extends PGobject {
    private String titol;
    private String enunciat;
    private String url;

    public Activitat() {
    }

    public Activitat(String titol, String enunciat, String url) {
        this.titol = titol;
        this.enunciat = enunciat;
        this.url = url;
        setType("activitats");
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getEnunciat() {
        return enunciat;
    }

    public void setEnunciat(String enunciat) {
        this.enunciat = enunciat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getValue() {
        String result = "(";
        result += tanca(titol) + ",";
        result += tanca(enunciat) + ",";
        result += tanca(url) + ")";

        return result;
    }

    @Override
    public void setValue(String value) throws SQLException {
        super.setValue(value);

        String[] atrubuts = parseValue(value);

        titol = atrubuts[0];
        enunciat = atrubuts[1];
        url = atrubuts[2];
    }

    @Override
    public String toString() {
        return "Activitat{" +
                "titol='" + titol + '\'' +
                ", enunciat='" + enunciat + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
