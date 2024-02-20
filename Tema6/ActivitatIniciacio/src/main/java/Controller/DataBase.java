package Controller;

import Data.Aspirant;
import Utils.DBExeptions;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;

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
}
