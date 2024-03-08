import Controller.DataBase;
import Data.Film;
import Data.IMDB;
import org.bson.Document;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase("localhost", 27017, "AAD", "movie");

        // te deix tot descomentat perque sino s'envan els imports

        // 1 -
        System.out.println("\n1.\n");
        Film filmAct1 = new Film("Recuperacio de MongoDB", "bla bla bla bla", 2024, 120, "[Ricardo, Marc, Miquel, Oscar, Andreu]", new IMDB(1200, 10), "short movie");
        Document docAct1 = new Document("title", filmAct1.getTitle())
                .append("plot", filmAct1.getPlot())
                .append("year", filmAct1.getType())
                .append("runtime", filmAct1.getRuntime())
                .append("cast", filmAct1.getCast())
                .append("imbd", filmAct1.getImdb())
                .append("type", filmAct1.getType());

        try {
            db.insert(docAct1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2 -
        System.out.println("\n2.\n");
        db.getMovieByKeyWord("Superman").forEach(System.out::println);

        // 3
        System.out.println("\n3.\n");
        ArrayList<Integer> years = new ArrayList<>();
        years.add(2000);
        years.add(1990);
        db.findMoviesByYears(years).forEach(System.out::println);

        // 4
        System.out.println("\n4.\n");
        db.findCastByMovieTitle("Battlefield Earth").forEach(System.out::println);
    }
}
