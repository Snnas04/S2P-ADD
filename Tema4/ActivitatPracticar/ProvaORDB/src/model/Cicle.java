package model;

public class Cicle {
    private int id_cicle;
    private String nom;

    public Cicle(int id_cicle, String nom) {
        this.id_cicle = id_cicle;
        this.nom = nom;
    }

    public int getId_cicle() {
        return id_cicle;
    }

    public void setId_cicle(int id_cicle) {
        this.id_cicle = id_cicle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Cicle {\n" +
                "id_cicle = " + id_cicle + "\n" +
                "nom = " + nom + "\n" +
                '}';
    }
}
