package Controller;

import Data.Aspirant;
import Utils.DBExeptions;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Projections.include;

public class DataBase {
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public DataBase(String host, int port, String dbName, String collectionName) {
        client = MongoClients.create("mongodb://snnas04:1234@" + host + ":" + port);
        db = client.getDatabase(dbName);
        collection = db.getCollection(collectionName);
    }

    public void insert(Document doc) throws DBExeptions {
        if (doc == null)
            throw new DBExeptions("Document is null");
        collection.insertOne(doc);
    }

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

    public ArrayList<Document> findSkipLimit(int from, int quantity) {
        return collection.find().skip(from - 1).limit(quantity).into(new ArrayList<>());
    }

    public ArrayList<Document> findByCP(String cp) {
        Document filter = new Document("codiPostal", cp);
        return collection.find(filter).into(new ArrayList<>());
    }

    public ArrayList<Document> findByCPName(String cp, String name) {
        Document filter = new Document("codiPostal", cp).append("nom", name);

        return collection.find(filter).into(new ArrayList<>());
    }

    public ArrayList<Document> findAllProjection(ArrayList<String> names) {
        return collection.find().projection(include(names)).into(new ArrayList<>());
    }

    public ArrayList<Document> findAllSort(String field, boolean asc) {
        return collection.find().sort(new Document(field, asc ? 1 : -1)).into(new ArrayList<>());
    }

    
}
