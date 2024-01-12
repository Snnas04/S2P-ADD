package model;

import org.postgresql.util.PGobject;

public class Contacte extends PGobject {
    private String telefon;
    private String email;
    private String twitter;

    public Contacte(String telefon, String email, String twitter) {
        this.telefon = telefon;
        this.email = email;
        this.twitter = twitter;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "Contacte {\n" +
                "telefon = " + telefon + '\n' +
                "email = " + email + '\n' +
                "twitter = " + twitter + '\n' +
                '}';
    }
}
