package Entitats;

import javax.persistence.*;

@Entity
@Table(name = "estudiants")
public class Estudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiant")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_curs")
    private Curs curs;

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

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }
}
