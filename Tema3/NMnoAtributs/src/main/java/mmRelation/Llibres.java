package mmRelation;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Llibres {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ISBN")
    private String isbn;
    @Basic
    @Column(name = "titol")
    private String titol;
    @Basic
    @Column(name = "copies")
    private Byte copies;
    @OneToMany(mappedBy = "llibresByLlibre")
    private Collection<Prestecs> prestecsByIsbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public Byte getCopies() {
        return copies;
    }

    public void setCopies(Byte copies) {
        this.copies = copies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Llibres llibres = (Llibres) o;

        if (isbn != null ? !isbn.equals(llibres.isbn) : llibres.isbn != null) return false;
        if (titol != null ? !titol.equals(llibres.titol) : llibres.titol != null) return false;
        if (copies != null ? !copies.equals(llibres.copies) : llibres.copies != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (titol != null ? titol.hashCode() : 0);
        result = 31 * result + (copies != null ? copies.hashCode() : 0);
        return result;
    }

    public Collection<Prestecs> getPrestecsByIsbn() {
        return prestecsByIsbn;
    }

    public void setPrestecsByIsbn(Collection<Prestecs> prestecsByIsbn) {
        this.prestecsByIsbn = prestecsByIsbn;
    }
}
