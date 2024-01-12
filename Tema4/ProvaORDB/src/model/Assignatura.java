package model;

public class Assignatura {
    private int id_assignatura;
    private String nom;
    private Cicle cicle;

    public Assignatura(int id_assignatura, String nom, Cicle cicle) {
        this.id_assignatura = id_assignatura;
        this.nom = nom;
        this.cicle = cicle;
    }

    public int getId_assignatura() {
        return id_assignatura;
    }

    public void setId_assignatura(int id_assignatura) {
        this.id_assignatura = id_assignatura;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Cicle getCicle() {
        return cicle;
    }

    public void setCicle(Cicle cicle) {
        this.cicle = cicle;
    }

    @Override
    public String toString() {
        return "Assignatura {" + '\n' +
                "id_assignatura=" + id_assignatura + '\n' +
                "nom = " + nom + '\n' +
                "cicle = " + cicle + '\n' +
                '}';
    }
}
