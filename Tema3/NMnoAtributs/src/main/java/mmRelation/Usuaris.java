package mmRelation;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Usuaris {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codi")
    private int codi;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "cognoms")
    private String cognoms;
    @OneToMany(mappedBy = "usuarisByUsuari")
    private Collection<Prestecs> prestecsByCodi;

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuaris usuaris = (Usuaris) o;

        if (codi != usuaris.codi) return false;
        if (nom != null ? !nom.equals(usuaris.nom) : usuaris.nom != null) return false;
        if (cognoms != null ? !cognoms.equals(usuaris.cognoms) : usuaris.cognoms != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codi;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (cognoms != null ? cognoms.hashCode() : 0);
        return result;
    }

    public Collection<Prestecs> getPrestecsByCodi() {
        return prestecsByCodi;
    }

    public void setPrestecsByCodi(Collection<Prestecs> prestecsByCodi) {
        this.prestecsByCodi = prestecsByCodi;
    }
}
