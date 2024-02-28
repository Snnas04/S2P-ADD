package Data;

import java.util.HashMap;
import java.util.List;

public class Llibre {
    private String isbn;
    private String departament;
    private String titol;
    private String autors;

    public Llibre(String isbn, String departament, String titol, String autors) {
        this.isbn = isbn;
        this.departament = departament;
        this.titol = titol;
        this.autors = autors;
    }

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("isbn", isbn);
        map.put("departament", departament);
        map.put("titol", titol);
        map.put("autors", autors);

        return map;
    }


    @Override
    public String toString() {
        return "Llibre{" +
                "isbn='" + isbn + '\'' +
                ", departament='" + departament + '\'' +
                ", titol='" + titol + '\'' +
                ", autors='" + autors + '\'' +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutors() {
        return autors;
    }

    public void setAutors(String autors) {
        this.autors = autors;
    }
}
