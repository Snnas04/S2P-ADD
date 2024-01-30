package models;

import java.util.Arrays;

public class Jugueta {
    private int ref;
    private String nom;
    private  int edad;
    private String marca;
    private String etiqueta;
    private Magatzem magatzem;

    public Jugueta(int ref, String nom, int edad, String marca, String[] etiqueta, Magatzem magatzem) {
        this.ref = ref;
        this.nom = nom;
        this.edad = edad;
        this.marca = marca;
        this.etiqueta = Arrays.toString(etiqueta);
        this.magatzem = magatzem;
    }

    @Override
    public String toString() {
        return "Jugueta{" +
                "ref=" + ref +
                ", nom='" + nom + '\'' +
                ", edad=" + edad +
                ", marca='" + marca + '\'' +
                ", etiqueta='" + etiqueta + '\'' +
                ", magatzem=" + magatzem +
                '}';
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Magatzem getMagatzem() {
        return magatzem;
    }

    public void setMagatzem(Magatzem magatzem) {
        this.magatzem = magatzem;
    }
}
