package Data;

import java.util.HashMap;
import java.util.Objects;

public class Aspirant {
    private String nif;
    private String name;
    private String surname;
    private String cp;

    public Aspirant(String nif, String name, String surname, String cp) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.cp = cp;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nif", nif);
        map.put("name", name);
        map.put("surname", surname);
        map.put("cp", cp);

        return map;
    }

    @Override
    public String toString() {
        return "Aspirant{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cp='" + cp + '\'' +
                '}';
    }
}
