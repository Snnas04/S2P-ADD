import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create("mongodb://snnas04:1234@localhost:27017");
        MongoDatabase db = client.getDatabase("TestDB");

        MongoCollection<Document> collection = db.getCollection("test");
        Document document = new Document("name", "Marc")
                .append("surname", "Sans")
                .append("City", "Sencelles");

        collection.insertOne(document);

        client.close();
    }
}
