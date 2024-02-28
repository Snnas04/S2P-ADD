import Controller.DataBase;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase("localhost", 27017, "AAD", "llibres");

        // 1
//        Llibre llibre = new Llibre("00000000", "ExamenJava", "Primera Pregunta", "Marc");
//        Document doc = new Document(llibre.toMap());
//
//        try {
//            db.insert(doc);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 2
//        db.activitat2().forEach(System.out::println);

        // 3
        String camp = "departament";
        db.activitat3("departament").forEach(System.out::println);
    }
}
