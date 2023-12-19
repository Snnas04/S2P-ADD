package mmRelation;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class PrestecsPK implements Serializable {
    @Column(name = "llibre")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String llibre;
    @Column(name = "usuari")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuari;

    public String getLlibre() {
        return llibre;
    }

    public void setLlibre(String llibre) {
        this.llibre = llibre;
    }

    public int getUsuari() {
        return usuari;
    }

    public void setUsuari(int usuari) {
        this.usuari = usuari;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrestecsPK that = (PrestecsPK) o;

        if (usuari != that.usuari) return false;
        if (llibre != null ? !llibre.equals(that.llibre) : that.llibre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = llibre != null ? llibre.hashCode() : 0;
        result = 31 * result + usuari;
        return result;
    }
}
