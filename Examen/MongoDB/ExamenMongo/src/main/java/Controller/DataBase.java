package Controller;

import Data.Llibre;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;

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

    // 2
    public ArrayList<Llibre> activitat2() {
        ArrayList<Llibre> LlibreList = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Llibre llibre = new Llibre(doc.getString("isbn"), doc.getString("departament"), doc.getString("titol"), doc.getString("autors"));

                LlibreList.add(llibre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return LlibreList;
    }

    // 3
    public ArrayList<Document> activitat3(String camp) {
//        db.llibres.aggregate([
//            {$match: {departament: null}},
//            {$group: {_id: "$departament", num: {$sum: 1}}},
//        ])
        Document doc = new Document(camp, camp);
        return collection.find().projection(include(camp)).into(new ArrayList<>());
    }
}
