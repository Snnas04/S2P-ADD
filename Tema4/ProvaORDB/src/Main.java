import controller.BaseDades;
import model.Alumne;
import model.Assignatura;
import model.Cicle;
import model.Matricula;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BaseDades db = new BaseDades();

        // 1. Recuperar un cicle a partir de l'identificador.
        Cicle cicle = db.findCicleByCodi(1);
        System.out.println("1.\n" + cicle);

        // 2. Recuperar una assignatura a partir de l'identificador.
        Assignatura assignatura = db.findAssignaturaByCodi(1);
        System.out.println("2.\n" + assignatura);

        // 3. Recuperar un alumne a partir de l'identificador (tota la informació excepte les dades de contacte).
        Alumne alumne = db.findAlumneByNIF("98765432B");
        System.out.println("3.\n" + alumne);

        // 4. Recuperar un alumne a partir de l'identificador (també les dades de contacte).
         Alumne contactAlumne = db.findAlumneByNIFwhitContact("98765432B");
         System.out.println("4.\n" + contactAlumne);

         // 5.Recuperar una matrícula a partir de l'identificador (format per dos camps).
        Matricula matricula = db.findMatriculaByCodi("12345678F", 1);
        System.out.println("5.\n" + matricula);

        // 6. Recuperar tots els alumnes de la base de dades.
        List<Alumne> allAlumnes = db.findAllAlumneByNIFwhitContact();
        System.out.println("6.");
        allAlumnes.forEach(System.out::println);
    }
}
