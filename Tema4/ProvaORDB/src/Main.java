import controller.BaseDades;
import model.Alumne;
import model.Assignatura;
import model.Cicle;

public class Main {
    public static void main(String[] args) {
        BaseDades bd = new BaseDades();

        // 1. Recuperar un cicle a partir de l'identificador.
        Cicle cicle = bd.findCicleByCodi(1);
        System.out.println(cicle);

        // 2. Recuperar una assignatura a partir de l'identificador.
        Assignatura assignatura = bd.findAssignaturaByCodi(1);
        System.out.println(assignatura);

        // 3. Recuperar un alumne a partir de l'identificador (tota la informació excepte les dades de contacte).
        Alumne alumne = bd.findAlumneByNIF("98765432B");
        System.out.println(alumne);
    }
}
