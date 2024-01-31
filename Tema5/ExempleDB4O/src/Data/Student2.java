package Data;

public class Student2 {
    private String dni;
    private String name;
    private String surname;
    private Course course;

    public Student2(String dni, String name, String surname, Course course) {
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

    public Course getCurs() {
        return course;
    }

    public void setCurs(Course course) {
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
