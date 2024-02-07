import Actions.Delete;
import Actions.Inserts;
import Actions.NewDB;
import Actions.Selects;
import DB.Actor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NewDB newDB = new NewDB();
        Selects selects = new Selects();
        Inserts inserts = new Inserts();
        Delete delete = new Delete();

        // 1. Create DB
        System.out.println("1:");
        newDB.CreateDB();

        // 2. Recuperar totes les dades de la base de dades
        System.out.println("\n2:");
        getDBContent(selects);

        // 3. Recuperar una pel·lícula per títol
        var filmByTitle = selects.selectFilmByTitle("The Dark Knight");
        System.out.println("\n3:\n" + filmByTitle);

        // 4. Recuperar el repartiment d’un film a partir de la seva referència
        var castByFilmId = selects.selectCastByFilmId("1");
        System.out.println("\n4:\n" + castByFilmId);

        // 5. Recuperar els films a partir d’un gènere donat
        var filmsByGenre = selects.selectFilmsByGenre("Acción");
        System.out.println("\n5:\n" + filmsByGenre);

        // 6. Afegir la data de defunció d’un actor a partir del seu identificador
        System.out.println("\n6:");
        inserts.updateActorDeathDate(1, "2024-04-02");

        // 7. Afegir un nou actor a la base de dades
        System.out.println("\n7:");
        inserts.insertActor(new Actor(14, "Christian Bale", "1974-01-30", null, "Britànic"));

        // 8. Eliminar un actor d'una pel·lícula
        System.out.println("\n8:");
        delete.deleteActorFromFilm(5, "2");

        // 9. Eliminar un actor a partir del seu identificador. Eliminar tambe les seves participacions en pel·lícules
        System.out.println("\n9:");
        delete.deleteActor(2);
    }

    private static void getDBContent(Selects db) {
        List<Object> dbContent = db.selectAll();
        System.out.println("\nAll DB content:");
        dbContent.forEach(System.out::println);
    }
}
