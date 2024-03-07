import Controller.DataBase;
import Data.Aspirant;
import org.bson.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase("localhost", 27017, "TestDB", "aspirants");

        // Create an Aspirant object
//        Aspirant aspirant = new Aspirant("12345678A", "Marc", "Sans", "07140");
//        Document doc = new Document("nif", aspirant.getNif())
//                .append("nom", aspirant.getName())
//                .append("llinatges", aspirant.getSurname())
//                .append("codiPostal", aspirant.getCp());
//
//        try {
//            db.insert(doc);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Create another Aspirant object with toMap() method
//        Aspirant aspirant2 = new Aspirant("87654321B", "Pau", "Sans", "07140");
//        Document doc2 = new Document(aspirant2.toMap());
//
//        try {
//            db.insert(doc2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

/* **************
*   CONSULTES   *
************** */
        // 7. Crea un mètode que utilitzi MongoCursor per recuperar tots els documents i torni un ArrayList<Aspirant>. Mostra’ls per pantalla al main.
//        db.getAspirants().forEach(System.out::println);

        // 10. Crea un mètode que posi dins un ArrayList els documents de la col·lecció.
//        db.getAllDocuments().forEach(System.out::println);

        // 11. Crea un mètode amb dos paràmetres, la posició inicial del primer document que volem recuperar i la quantitat de documents que volem recuperar. Ha de posar aquests documents dins d’un ArrayList.
//        db.findSkipLimit(10, 5).forEach(System.out::println);

        // 12. Crea un altre mètode que filtri els documents per codiPostal. Ha de rebre el codi postal per paràmetre i tornar els documents dins d’un ArrayList.
//        db.findByCP("07300").forEach(System.out::println);

        // 13. Crea un altre mètode que rebi com a paràmetres el codiPostal i el nom i torni tots els documents que compleixin els dos requisits.
//        db.findByCPName("07421", "Margalida").forEach(System.out::println);

        // 14. Crea un altre mètode que rebi com a paràmetre una llista amb els noms dels camps que vol incloure al resultat. El mètode ha de crear un document amb aquests camps i utilitzar-lo amb .projection(). Ha de tornar la llista amb els documents.
//        ArrayList<String> camps = new ArrayList<>();
//        camps.add("nif");
//        camps.add("nom");
//        camps.add("llinatges");
//        camps.add("codiPostal");
//
//        db.findAllProjection(camps).forEach(System.out::println);

        // 15. Crea un altre mètode que torni tots els documents de la col·lecció ordenats per un camp. Ha de tenir un paràmetre per el nom del camp i un altre per si volem l’ordre ascendent o descendent.
//        db.findAllSort("nom", true).forEach(System.out::println);

/* ************
*   FULTRES   *
************ */
        // 16. Crea un altre mètode que filtri els documents per codiPostal. Ha de rebre el codi postal per paràmetre i tornar els documents dins d’un ArrayList.
//        db.findByCP2("07300").forEach(System.out::println);

        // 17. Crea un altre mètode que rebi com a paràmetres el codiPostal i el nom i torni tots els documents que compleixin els dos requisits.
//        db.findByCPandName("07300", "Maria").forEach(System.out::println);

        // 18. Crea un altre mètode que rebi com a paràmetres dos noms i torni tots els documents que contenguin un dels dos noms.
//        db.findByName("Maria", "Joan").forEach(System.out::println);

        // 19. Crea un altre mètode que rebi com a paràmetres una llista de noms i torni tots els documents que no contenguin cap dels noms de la llista.
        ArrayList<String> names = new ArrayList<>();
        names.add("Maria");
        names.add("Joan");
        names.add("Bartomeu");
//        db.findNotInListNames(names).forEach(System.out::println);

/* **********
*   SORTS   *
********** */
        // 20. Crea un altre mètode que ordeni els aspirants per nom amb ascending.
//        db.sortByNameDesc().forEach(System.out::println);

        // 21. Crea un altre mètode que ordeni els aspirants primer per un ascending dels llinatges i després per un altre ascending del nom.
//        db.sortBySurnamesAndNamesAsc().forEach(System.out::println);

        // 22. Repeteix l’exercici anterior a un nou mètode utilitzant aquesta vegada orderBy.
//        db.sortBySurnamesAndNamesAscWhitOrderBy().forEach(System.out::println);

/* ****************
*   PROJECCIONS   *
**************** */
        // 23. Crea un mètode que torni un ArrayList<Document> i que utilitzi include per mostrar el nom i els llinatges dels aspirants.
//        db.showNameAndSurname().forEach(System.out::println);

        // 24. Crea un mètode que torni un ArrayList<Document> i que utilitzi fields per mostrar el nom i els llinatges i no l’_id.
//        db.showNameAndSurnameNoID().forEach(System.out::println);

/* ****************
*   AGREGATIONS   *
**************** */
        // 25. Crea un mètode que utilitzi aggregate per tornar el nif, nom i llinatges de cada aspirant amb la quantitat de preferències que té cada un d'ells, ordenats per llinatges.
//        db.showNumPreferencePerAspirant().forEach(System.out::println);

        // 26. Crea un mètode que torni una llista amb els centres de la col·lecció, de manera que siguin únics, utilitzant $unwind i $group.
//        db.showCentresUnwindAndGroup().forEach(System.out::println);

        // 27. Crea un mètode que afegeixi a la base de dades una nova col·lecció amb els centres únics.
//        db.addCentersToNewCollection("centresPracticaRecu");

/* ******************
*   MODIFICACIONS   *
****************** */
        // 28. Crea un mètode que rebi el nom d'un camp i el valor pel qual filtrar els documents i el nom d'un camp a modificar i el nou valor d'aquest camp. Utilitza'l des del main per canviar el nom de l’aspirant amb nif 14140460F, de Virgínia a Catalina.
//        db.updateField("nif", "14140460F", "nom", "Catalina");
//        db.findByName("Catalina", "").forEach(System.out::println);

        // 29. Tots els aspirants amb codi postal 07300 ara han de tenir el codi postal 07301. Utilitza el mètode de l'exercici anterior.
//        db.updateFieldByCP("07300", "codiPostal", "07301");
//        db.findByCP("07301").forEach(System.out::println);

/* *************
*   ESBORRAT   *
************* */
        // 30. Crea un mètode que elimini un document. Ha de rebre l'_id de paràmetre. Utilitza'l per eliminar l’aspirant que has introduït anteriorment a l'exercici 6.
//        db.deleteDocument("65e9ee9f46ce4043a74c2744");
//        db.findByName("Marc", "").forEach(System.out::println);
    }
}
