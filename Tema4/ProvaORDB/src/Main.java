import controller.BaseDades;
import model.*;

import java.math.BigDecimal;
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

        // 7. Recuperar totes les matrícules d'un alumne.
        List<Matricula> matricules = db.findAllMatriculaByNIF("12345678F");
        System.out.println("7.");
        matricules.forEach(System.out::println);

        // 8. Recuperar totes les matrícules d'una assignatura.
        List<Matricula> matriculesAssig = db.findAllMatriculaByCodiAssig(1);
        System.out.println("8.");
        matriculesAssig.forEach(System.out::println);

        // 9. Modificar una de les notes d'una assignatura d'un alumne.
        boolean resultModificarNotes = db.modificarNota("98765432B", 2, BigDecimal.valueOf(4.0), 2);
        System.out.println("9.\n" + resultModificarNotes);

        // 10. Afegir un alumne nou a la base de dades.
        // vercio 1
//        Alumne newAlumne = new Alumne("12345678Z", "Marc", "Sans", new Contacte("888555222", "marcsans@cpnoves", "@marc"));
//        boolean resultNouAlumne = db.crearAlumne(newAlumne);
//        System.out.println("10.\n" + resultNouAlumne);

        // vercio 2
//        Alumne newAlumneObject = new Alumne("84395683F", "Adrian", "Aguilo", new Contacte("649372057", "adrianaguilo" +
//                "@cpnoves", "@adri"));
//        boolean resultNouAlumneObject = db.createAlumneObject(newAlumneObject);
//        System.out.println("10.\n" + resultNouAlumneObject);

        // 11. Matricular un alumne a una assignatura.
//        boolean resultatNovaMatricula = db.matricularNouAlumne("12345678F", 2);
//        System.out.println("11.\n" + resultatNovaMatricula);

        // 12. Afegir les notes d'una matrícula.
        BigDecimal[] notes = new BigDecimal[]{BigDecimal.valueOf(5.7), BigDecimal.valueOf(6.1), BigDecimal.valueOf(4.3)};
        boolean resultatAfegirNotes = db.afegirNotes("12345678F", 2, notes);
        System.out.println("12.\n" + resultatAfegirNotes);
    }
}
