package Controller;

import Data.Aspirant;
import Utils.DBExeptions;
import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Projections.*;

public class DataBase {
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public DataBase(String host, int port, String dbName, String collectionName) {
        client = MongoClients.create("mongodb://snnas04:1234@" + host + ":" + port);
        db = client.getDatabase(dbName);
        collection = db.getCollection(collectionName);
    }
    // A la classe BaseDades crea un mètode que rebi un document i l’inserti a la base de dades. Si el document és null, llença una excepció de tipus DBExeptions amb el missatge “Document is null”.
    public void insert(Document doc) throws DBExeptions {
        if (doc == null)
            throw new DBExeptions("Document is null");
        collection.insertOne(doc);
    }

/* **************
*   CONSULTES   *
************** */
    // 7. Crea un mètode que utilitzi MongoCursor per recuperar tots els documents i torni un ArrayList<Aspirant>. Mostra’ls per pantalla al main.
    public ArrayList<Aspirant> getAspirants() {
        ArrayList<Aspirant> aspirantsList = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Aspirant aspirant = new Aspirant(doc.getString("nif"), doc.getString("nom"), doc.getString("llinatges"), doc.getString("codiPostal"));

                aspirantsList.add(aspirant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aspirantsList;
    }

    // 10. Crea un mètode que posi dins un ArrayList els documents de la col·lecció.
    public ArrayList<Document> getAllDocuments() {
        return collection.find().into(new ArrayList<>());
    }

    // 11. Crea un mètode amb dos paràmetres, la posició inicial del primer document que volem recuperar i la quantitat de documents que volem recuperar. Ha de posar aquests documents dins d’un ArrayList.
    public ArrayList<Document> findSkipLimit(int from, int quantity) {
        return collection.find().skip(from - 1).limit(quantity).into(new ArrayList<>());
    }

    // 12. Crea un altre mètode que filtri els documents per codiPostal. Ha de rebre el codi postal per paràmetre i tornar els documents dins d’un ArrayList.
    public ArrayList<Document> findByCP(String cp) {
        Document filter = new Document("codiPostal", cp);
        return collection.find(filter).into(new ArrayList<>());
    }

    // 13. Crea un altre mètode que rebi com a paràmetres el codiPostal i el nom i torni tots els documents que compleixin els dos requisits.
    public ArrayList<Document> findByCPName(String cp, String name) {
        Document filter = new Document("codiPostal", cp).append("nom", name);

        return collection.find(filter).into(new ArrayList<>());
    }

    // 14. Crea un altre mètode que rebi com a paràmetre una llista amb els noms dels camps que vol incloure al resultat. El mètode ha de crear un document amb aquests camps i utilitzar-lo amb .projection(). Ha de tornar la llista amb els documents.
    public ArrayList<Document> findAllProjection(ArrayList<String> names) {
        return collection.find().projection(include(names)).into(new ArrayList<>());
    }

    // 15. Crea un altre mètode que torni tots els documents de la col·lecció ordenats per un camp. Ha de tenir un paràmetre per el nom del camp i un altre per si volem l’ordre ascendent o descendent.
    public ArrayList<Document> findAllSort(String field, boolean asc) {
        return collection.find().sort(new Document(field, asc ? 1 : -1)).into(new ArrayList<>());
    }

/* ************
*   FULTRES   *
************ */
    // 16. Crea un altre mètode que filtri els documents per codiPostal. Ha de rebre el codi postal per paràmetre i tornar els documents dins d’un ArrayList.
    public ArrayList<Document> findByCP2(String cp) {
        return collection.find(new Document("codiPostal", cp)).into(new ArrayList<>());
    }

    // 17. Crea un altre mètode que rebi com a paràmetres el codiPostal i el nom i torni tots els documents que compleixin els dos requisits.
    public ArrayList<Document> findByCPandName(String cp, String name) {
        return collection.find(new Document("codiPostal", cp).append("nom", name)).into(new ArrayList<>());
    }

    // 18. Crea un mètode que rebi com a paràmetres dos noms i torni tots els documents que contenguin un dels dos noms.
    public ArrayList<Document> findByName(String name1, String name2) {
        // db.aspirants.find({
        //    $or: [
        //        { nom: "Joan" },
        //        { nom: "Maria" }
        //    ]
        //})
        Document filter = new Document("$or", new ArrayList<Document>() {{
            add(new Document("nom", name1));
            add(new Document("nom", name2));
        }});
        return collection.find(filter).into(new ArrayList<>());
    }

    // 19. Crea un altre mètode que rebi com a paràmetres una llista de noms i torni tots els documents que no contenguin cap dels noms de la llista.
    public ArrayList<Document> findNotInListNames(ArrayList<String> names) {
        Document filter = new Document("nom", new Document("$nin", names));
        return collection.find(filter).into(new ArrayList<>());
    }

/* **********
*   SORTS   *
********** */
    // 20. Crea un altre mètode que ordeni els aspirants per nom amb ascending.
    public ArrayList<Document> sortByNameDesc() {
        return collection.find().sort(new Document("nom", 1)).into(new ArrayList<>());
    }

    // 21. Crea un altre mètode que ordeni els aspirants primer per un ascending dels llinatges i després per un altre ascending del nom.
    public ArrayList<Document> sortBySurnamesAndNamesAsc() {
        return collection.find().sort(new Document("llinatges", -1).append("nom", -1)).into(new ArrayList<>());
    }

    // 22. Repeteix l’exercici anterior a un nou mètode utilitzant aquesta vegada orderBy.
    // No se on es fa servir OrderBy
    public ArrayList<Document> sortBySurnamesAndNamesAscWhitOrderBy() {
        return collection.find().sort(new Document("llinatges", -1).append("nom", -1)).into(new ArrayList<>());
    }

/* ****************
*   PROJECCIONS   *
**************** */
    // 23. Crea un mètode que torni un ArrayList<Document> i que utilitzi include per mostrar el nom i els llinatges dels aspirants.
    public ArrayList<Document> showNameAndSurname() {
        return collection.find().projection(include("nom", "llinatges")).into(new ArrayList<>());
    }

    // 24. Crea un mètode que torni un ArrayList<Document> i que utilitzi fields per mostrar el nom i els llinatges i no l’_id.
    public ArrayList<Document> showNameAndSurnameNoID() {
        return collection.find().projection(fields(include("nom", "llinatges"), exclude("_id"))).into(new ArrayList<>());
    }

/* ****************
*   AGREGATIONS   *
**************** */
    // 25. Crea un mètode que utilitzi aggregate per tornar el nif, nom i llinatges de cada aspirant amb la quantitat de preferències que té cada un d'ells, ordenats per llinatges.
    public ArrayList<Document> showNumPreferencePerAspirant() {
        Bson project = new Document("$project", new Document("_id", 0)
                .append("nif", 1)
                .append("nom", 1)
                .append("llinatges", 1)
                .append("totalPreferencies", new Document("$size", "$preferencies")));

        Bson sort = new Document("$sort", new Document("llinatges", 1));

        return collection.aggregate(Arrays.asList(project, sort)).into(new ArrayList<>());
    }

    //26. Crea un mètode que torni una llista amb els centres de la col·lecció, de manera que siguin únics, utilitzant $unwind i $group.
    public ArrayList<Document> showCentresUnwindAndGroup() {
        Bson unwind = new Document("$unwind", "$preferencies");
        Bson group = new Document("$group", new Document("_id", "$preferencies.centre"));

        return collection.aggregate(Arrays.asList(unwind, group)).into(new ArrayList<>());
    }

    // 27. Crea un mètode que afegeixi a la base de dades una nova col·lecció amb els centres únics.
    public void addCentersToNewCollection(String collectionName) {
        MongoCollection<Document> newCollection = db.getCollection(collectionName);

        Bson unwind = new Document("$unwind", "$preferencies");
        Bson group = new Document("$group", new Document("_id", "$preferencies.centre"));

        List<Document> centres = collection.aggregate(Arrays.asList(unwind, group)).into(new ArrayList<>());

        newCollection.insertMany(centres);
    }

/* ******************
*   MODIFICACIONS   *
****************** */
    // 28. Crea un mètode que rebi el nom d'un camp i el valor pel qual filtrar els documents i el nom d'un camp a modificar i el nou valor d'aquest camp. Utilitza'l des del main per canviar el nom de l’aspirant amb nif 14140460F, de Virgínia a Catalina.
    public void updateField(String field, String value, String fieldToModify, String newValue) {
        Document filter = new Document(field, value);
        Document update = new Document("$set", new Document(fieldToModify, newValue));

        collection.updateOne(filter, update);
    }

    // 29. Tots els aspirants amb codi postal 07300 ara han de tenir el codi postal 07301. Utilitza el mètode de l'exercici anterior.
    public void updateFieldByCP(String cp, String fieldToModify, String newValue) {
        Document filter = new Document("codiPostal", cp);
        Document update = new Document("$set", new Document(fieldToModify, newValue));

        collection.updateMany(filter, update);
    }

/* *************
*   ESBORRAT   *
************* */
    // 30. Crea un mètode que elimini un document. Ha de rebre l'_id de paràmetre. Utilitza'l per eliminar l’aspirant que has introduït anteriorment a l'exercici 6.
    public void deleteDocument(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }
}
