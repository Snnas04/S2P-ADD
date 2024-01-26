package Controller;

import Data.Student;
import Data.Subject;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String DBNAME = "shcool.db4o";

    public void createDB() {
        Student s1 = new Student("12345678A", "Pepito", "Grillo", "S2P");
        Student s2 = new Student("87654321B", "Menganito", "Perez", "S1P");
        Student s3 = new Student("11111111C", "Fulanito", "Garcia", "S2P");
        Student s4 = new Student("22222222D", "Miguel", "Perez", "S1P");

        Subject sb1 = new Subject("AAD", "Acces a Dades", "S2P");
        Subject sb2 = new Subject("PSP", "Programacio de Serveis i Processos", "S2P");
        Subject sb3 = new Subject("BDD", "Base de Dades", "S1P");

        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);

        // insert students
        oc.store(s1);
        oc.store(s2);
        oc.store(s3);
        oc.store(s4);

        // insert subjects
        oc.store(sb1);
        oc.store(sb2);
        oc.store(sb3);

        oc.close();
        System.out.println("DB created");
    }

    // 2.1
    public Student findStudentByFullName(String name, String surname) {
        Student student;

        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        // Cercar a studets a travers de nom i llinatges
        ObjectSet<Student> list = oc.queryByExample(new Student(null, name, surname, null));

        if (!list.isEmpty()) {
            student = list.next();
        } else {
            return null;
        }

        oc.close();

        return student;
    }

    // 2.2
    public List<Student> findAllStudents() {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        // tambe es podria retornar tots els alumnres si posam null a tots els parametres
        ObjectSet<Student> studentsList = oc.queryByExample(Student.class);
        ArrayList<Student> students = new ArrayList<>(studentsList);

        oc.close();

        return students;
    }

    // 2.3
    public List<Subject> findAllSubjectsByCourse(String course) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Subject> subjectsList = oc.queryByExample(new Subject(null, null, course));
        ArrayList<Subject> subjects = new ArrayList<>(subjectsList);

        oc.close();

        return subjects;
    }

    // 2.4
    public List<Subject> findAllSubjects() {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Subject> subjectsList = oc.queryByExample(Subject.class);
        ArrayList<Subject> subjects = new ArrayList<>(subjectsList);

        oc.close();

        return subjects;
    }
}
