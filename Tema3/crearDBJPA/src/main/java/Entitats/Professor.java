package Entitats;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @ManyToMany
    @JoinTable(
            name = "professor_curs",
            joinColumns = @JoinColumn(name = "id_professor"),
            inverseJoinColumns = @JoinColumn(name = "id_curs")
    )
    private List<Curs> cursos;

    // Altres atributs i mètodes getters/setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Curs> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curs> cursos) {
        this.cursos = cursos;
    }
}
