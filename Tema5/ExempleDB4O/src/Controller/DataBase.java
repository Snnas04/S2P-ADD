package Controller;

import Data.*;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    // 3.1
    public Student findStudentByFullNameCN(String name, String surname) {
        Student student;

        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Student> list = oc.query(new Predicate<Student>() {
            @Override
            public boolean match(Student student) {
                return student.getNom().equals(name) && student.getLlinatges().equals(surname);
            }
        });

        if (!list.isEmpty()) {
            student = list.next();
        } else {
            return null;
        }

        oc.close();

        return student;
    }

    // 3.2
    public List<Student> findStudentByCourseCN(String course) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Student> list = oc.query(new Predicate<Student>() {
            @Override
            public boolean match(Student student) {
                return student.getCurs().equalsIgnoreCase(course);
            }
        });

        List<Student> students = new ArrayList<>(list);

        oc.close();

        return students;
    }

    // 3.3
    public List<Subject> findSubjectByCourseCN(String course) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Subject> list = oc.query(new Predicate<Subject>() {
            @Override
            public boolean match(Subject subject) {
                return subject.getCurs().equalsIgnoreCase(course);
            }
        });

        List<Subject> subjects = new ArrayList<>(list);

        oc.close();

        return subjects;
    }

    // 3.4
    public List<Subject> findAllSubjectsCN() {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Subject> list = oc.query(new Predicate<Subject>() {
            @Override
            public boolean match(Subject subject) {
                return true; // retornam true perque volem tots els subjects, si no fesim una consulta nativa podriem fer un queryByExample(Subject.class)
            }
        });

        List<Subject> subjects = new ArrayList<>(list);

        oc.close();

        return subjects;
    }

    // 4.3
    public void createDB2() {
        Course c1 = new Course("S2P", "2n DAM");

        Student2 s1 = new Student2("12345678A", "Pepito", "Grillo", c1);
        Student2 s2 = new Student2("87654321B", "Menganito", "Perez", c1);
        Student2 s3 = new Student2("11111111C", "Fulanito", "Garcia", c1);

        Subject2 sb1 = new Subject2("AAD", "Acces a Dades", c1);
        Subject2 sb2 = new Subject2("PSP", "Programacio de Serveis i Processos", c1);
        Subject2 sb3 = new Subject2("BDD", "Base de Dades", c1);

        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);

        // insert course
        oc.store(c1);

        // insert students
        oc.store(s1);
        oc.store(s2);
        oc.store(s3);

        // insert subjects
        oc.store(sb1);
        oc.store(sb2);
        oc.store(sb3);

        oc.close();
        System.out.println("DB created");
    }

    // 4.4
    public void modifyCourseByStudent(String dni) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Student2> list = oc.queryByExample(new Student2(dni, null, null, null));

        if (!list.isEmpty()) {
            Student2 student = list.next();
            student.getCurs().setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            oc.store(student);
        }

        oc.close();

        System.out.println("Course modified");
    }

    // retornam tots els objectes de la base de dades
    public List<Object> findAllDB() {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Course> list = oc.queryByExample(Object.class);
        List<Object> objects = new ArrayList<>(list);

        oc.close();

        return objects;
    }
}
