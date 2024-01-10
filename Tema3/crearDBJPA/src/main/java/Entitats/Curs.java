package Entitats;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curs")
    private Long id;

    @Column(name = "nom_curs")
    private String nomCurs;

    @OneToMany(mappedBy = "curs")
    private List<Estudiant> estudiants;

    // Altres atributs i mètodes getters/setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCurs() {
        return nomCurs;
    }

    public void setNomCurs(String nomCurs) {
        this.nomCurs = nomCurs;
    }

    public List<Estudiant> getEstudiants() {
        return estudiants;
    }

    public void setEstudiants(List<Estudiant> estudiants) {
        this.estudiants = estudiants;
    }
}

