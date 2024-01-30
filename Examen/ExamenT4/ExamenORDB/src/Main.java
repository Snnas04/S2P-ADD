import Connection.DataBase;
import models.Address;
import models.Jugueta;
import models.Magatzem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();

        // 1
        Magatzem selectMagatzem = db.findMagatzemByCodi(1);
        System.out.println("1.\n" + selectMagatzem + "\n");

        // 2
        Magatzem insertMagatzem = new Magatzem(4, "activitat 2", 777333888, new Address("test", "alcudia", "07329",
                "espanya"));
        boolean resultInsertMagatzem = db.createMagatzem(insertMagatzem);
        System.out.println("2.\n" + resultInsertMagatzem + "\n");

        // 3
        List<Jugueta> allJuguetes = db.findAllJuguetes();
        System.out.println("3.");
        allJuguetes.forEach(System.out::println);
        System.out.println("");

        // 4
        boolean addEtiquetaJugueta = db.afegirEtiqueta("examen", 3, 3);
        System.out.println("9.\n" + addEtiquetaJugueta);
    }
}
