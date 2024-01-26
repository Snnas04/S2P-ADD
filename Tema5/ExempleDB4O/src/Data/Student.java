package Data;

public class Student {
    private String dni;
    private String name;
    private String surname;
    private String course;

    public Student(String dni, String name, String surname, String course) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String name) {
        this.name = name;
    }

    public String getLlinatges() {
        return surname;
    }

    public void setLlinatges(String surname) {
        this.surname = surname;
    }

    public String getCurs() {
        return course;
    }

    public void setCurs(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
