package mmRelation;

import javax.persistence.*;

@Entity
@IdClass(PrestecsPK.class)
public class Prestecs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "llibre")
    private String llibre;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuari")
    private int usuari;
    @ManyToOne
    @JoinColumn(name = "llibre", referencedColumnName = "ISBN", nullable = false)
    private Llibres llibresByLlibre;
    @ManyToOne
    @JoinColumn(name = "usuari", referencedColumnName = "codi", nullable = false)
    private Usuaris usuarisByUsuari;

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

        Prestecs prestecs = (Prestecs) o;

        if (usuari != prestecs.usuari) return false;
        if (llibre != null ? !llibre.equals(prestecs.llibre) : prestecs.llibre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = llibre != null ? llibre.hashCode() : 0;
        result = 31 * result + usuari;
        return result;
    }

    public Llibres getLlibresByLlibre() {
        return llibresByLlibre;
    }

    public void setLlibresByLlibre(Llibres llibresByLlibre) {
        this.llibresByLlibre = llibresByLlibre;
    }

    public Usuaris getUsuarisByUsuari() {
        return usuarisByUsuari;
    }

    public void setUsuarisByUsuari(Usuaris usuarisByUsuari) {
        this.usuarisByUsuari = usuarisByUsuari;
    }
}
