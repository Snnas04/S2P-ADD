package model;

import org.postgresql.util.PGobject;

public class Activitat extends PGobject {
    private String titol;
    private String enunciat;
    private String url;

    public Activitat(String titol, String enunciat, String url) {
        this.titol = titol;
        this.enunciat = enunciat;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Contacte {\n" +
                "telefon = " + titol + '\n' +
                "email = " + enunciat + '\n' +
                "twitter = " + url + '\n' +
                '}';
    }
}
