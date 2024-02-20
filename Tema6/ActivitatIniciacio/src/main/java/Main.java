import Controller.DataBase;
import Data.Aspirant;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase("localhost", 27017, "mydb:", "aspirants");

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

        // 7
        db.getAspirants().forEach(System.out::println);
    }
}
