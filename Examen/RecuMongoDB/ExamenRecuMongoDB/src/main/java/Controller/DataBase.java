package Controller;

import Data.Film;
import Utils.DBExeptions;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Objects;

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

    // 1
    public void insert(Document doc) throws DBExeptions {
        if (doc == null)
            throw new DBExeptions("Document is null");
        collection.insertOne(doc);
    }

    // 2
    public ArrayList<Film> getMovieByKeyWord(String keyWord) {
        ArrayList<Film> aspirantsList = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                if (Objects.equals(doc.getString("title"), keyWord)) {
                    Film film = new Film(doc.getString("title"));

                    aspirantsList.add(film);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aspirantsList;
    }

    // 3
    public ArrayList<Document> findMoviesByYears(ArrayList<Integer> years) {
        Document filter = new Document("year", new Document("$in", years));
        return collection.find(filter).projection(fields(include("title", "year"), exclude("_id"))).sort(new Document("any", 1).append("title", -1)).into(new ArrayList<>());
    }

    // 4
    // supos que tambe he d'excloure l'id
    public ArrayList<Document> findCastByMovieTitle(String title) {
        Document filter = new Document("title", title);
        return collection.find(filter).projection(fields(include("cast"), exclude("_id"))).into(new ArrayList<>());
    }
}
