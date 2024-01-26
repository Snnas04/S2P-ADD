import Controller.DataBase;
import Data.Student;
import Data.Subject;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();

        // 1.3 Insereix a la base de dades anterior tres alumnes i tres assignatures
//        db.createDB();

        // 2.1 Recupera l'objecte que representa un alumne a partir del seu nom i llinatges
        Student student = db.findStudentByFullName("Menganito", "Perez");
        System.out.println("\n2.1:\n" + student);

        // 2.2 Recupera tots els alumnes d'un curs
        List<Student> students = db.findAllStudents();
        System.out.println("\n2.2:");
        students.forEach(System.out::println);

        // 2.3 Mostra totes les assignatures d'un curs
        List<Subject> subjects = db.findAllSubjectsByCourse("S2P");
        System.out.println("\n2.3:");
        subjects.forEach(System.out::println);

        // 2.4 Mostra totes les assignatures
        List<Subject> allSubjects = db.findAllSubjects();
        System.out.println("\n2.4:");
        allSubjects.forEach(System.out::println);
    }
}
