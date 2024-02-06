import Controller.DataBase;
import Data.Student;
import Data.Subject;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();

        // 1
        // 1.3 Insereix a la base de dades anterior tres alumnes i tres assignatures
        db.createDB();

        // 2 Consultes per exemple
        // 2.1 Recupera l'objecte que representa un alumne a partir del seu nom i llinatges
//        Student student = db.findStudentByFullName("Menganito", "Perez");
//        System.out.println("\n2.1:\n" + student);

        // 2.2 Recupera tots els alumnes d'un curs
//        List<Student> students = db.findAllStudents();
//        System.out.println("\n2.2:");
//        students.forEach(System.out::println);

        // 2.3 Mostra totes les assignatures d'un curs
//        List<Subject> subjects = db.findAllSubjectsByCourse("S2P");
//        System.out.println("\n2.3:");
//        subjects.forEach(System.out::println);

        // 2.4 Mostra totes les assignatures
//        List<Subject> allSubjects = db.findAllSubjects();
//        System.out.println("\n2.4:");
//        allSubjects.forEach(System.out::println);

        // 3 Consultes natives
        // 3.1 Recupera l'objecte que representa un alumne a partir del seu nom i llinatges
//        Student studentCN = db.findStudentByFullNameCN("Menganito", "Perez");
//        System.out.println("\n3.1:\n" + studentCN);

        // 3.2 Recupera tots els alumnes d'un curs
//        List<Student> studentsCN = db.findStudentByCourseCN("S1P");
//        System.out.println("\n3.2:");
//        studentsCN.forEach(System.out::println);

        // 3.3 Mostra totes les assignatures d'un curs
//        List<Subject> subjectsCN = db.findSubjectByCourseCN("S2P");
//        System.out.println("\n3.3:");
//        subjectsCN.forEach(System.out::println);

        // 3.4 Mostra totes les assignatures
//        List<Subject> allSubjectsCN = db.findAllSubjectsCN();
//        System.out.println("\n3.4:");
//        allSubjectsCN.forEach(System.out::println);

        // 4 Referències
        // 4.1 Crea una classe Course amb un codi i un nom
        // [done]

        // 4.2 Copia les classes Alumne i Assignatura a Alumne2 i Assignatura2 i modifica-les de manera que en lloc de tenir el codi del curs tenguin l'objecte Course
        // [done]

        // 4.3 Insereix a la base de dades un Curs i tres Alumnes2 i tres Assignatures2 que pertanyin a aquest curs
        db.createDB2();

        // 4.4 A partir d'un Alumne2 recupera el curs i modifica el seu nom. Guarda l'alumne. Que passa amb el curs?
//        System.out.println("\n4.4:");
//        db.modifyCourseByStudent("11111111C");

        getDBContent(db);
    }

    private static void getDBContent(DataBase db) {
        // Recuperar tot el contingut de la base de dades
        List<Object> dbContent = db.findAllDB();
        System.out.println("\nAll DB content:");
        dbContent.forEach(System.out::println);
    }
}
