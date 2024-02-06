package Actions;

import java.util.ArrayList;
import java.util.List;

import DB.Actor;
import DB.Film;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class NewDB {
    public static final String DBNAME = "cinema.db4o";

    // 1
    public static void CreateDB() {
        Actor actor1 = new Actor(1, "Tom Hanks", "09/07/1956", null, "American");
        Actor actor2 = new Actor(2, "Meryl Streep", "22/06/1949", null, "American");
        Actor actor3 = new Actor(3, "Brad Pitt", "18/12/1963", null, "American");
        Actor actor4 = new Actor(4, "Leonardo DiCaprio", "11/11/1974", null, "American");
        Actor actor5 = new Actor(5, "Heath Ledger", "04/04/1979", "22/01/2008", "Australian");
        Actor actor6 = new Actor(6, "Tom Cruise", "03/07/1962", null, "American");
        Actor actor7 = new Actor(7, "Cate Blanchett", "14/05/1969", null, "Australian");
        Actor actor8 = new Actor(8, "Will Smith", "25/09/1968", null, "American");
        Actor actor9 = new Actor(9, "Jennifer Lawrence", "15/08/1990", null, "American");
        Actor actor10 = new Actor(10, "Johnny Depp", "09/06/1963", null, "American");
        Actor actor11 = new Actor(11, "Penélope Cruz", "28/04/1974", null, "Spanish");
        Actor actor12 = new Actor(12, "Gong Li", "31/12/1965", null, "Chinese");
        Actor actor13 = new Actor(13, "Aishwarya Rai", "01/11/1973", null, "Indian");

        List<Actor> cast1 = new ArrayList<>();
        cast1.add(actor1);
        cast1.add(actor2);
        cast1.add(actor3);
        cast1.add(actor4);

        List<Actor> cast2 = new ArrayList<>();
        cast2.add(actor1);
        cast2.add(actor5);

        List<Actor> cast3 = new ArrayList<>();
        cast3.add(actor6);
        cast3.add(actor7);

        List<Actor> cast4 = new ArrayList<>();
        cast4.add(actor8);
        cast4.add(actor9);

        List<Actor> cast5 = new ArrayList<>();
        cast5.add(actor10);
        cast5.add(actor11);
        cast5.add(actor12);
        cast5.add(actor13);

        Film film1 = new Film("1", "Forrest Gump", "142 min", "Robert Zemeckis", "Un hombre con discapacidad intelectual lucha por superar los obstáculos de la vida.", "Drama", "PG-13", cast1);
        Film film2 = new Film("2", "The Dark Knight", "152 min", "Christopher Nolan", "Cuando el Joker desata el caos en Gotham City, Batman debe aceptar uno de los mayores desafíos de su vida.", "Acción", "PG-13", cast2);
        Film film3 = new Film("3", "Mission: Impossible - Fallout", "147 min", "Christopher McQuarrie", "Ethan Hunt y su equipo deben competir contra el tiempo después de que una misión sale mal.", "Acción", "PG-13", cast3);
        Film film4 = new Film("4", "Men in Black", "98 min", "Barry Sonnenfeld", "Dos agentes secretos enfrentan una nueva amenaza: una criatura intergaláctica que puede cambiar de forma.", "Ciencia ficción", "PG-13", cast4);
        Film film5 = new Film("5", "Pirates of the Caribbean: The Curse of the Black Pearl", "143 min", "Gore Verbinski", "El capitán Jack Sparrow busca recuperar su barco, el Black Pearl, y rescatar a la hija del gobernador secuestrada por un malvado capitán pirata.", "Aventura", "PG-13", cast5);

        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);

        // insert actors
        oc.store(actor1);
        oc.store(actor2);
        oc.store(actor3);
        oc.store(actor4);
        oc.store(actor5);
        oc.store(actor6);
        oc.store(actor7);
        oc.store(actor8);
        oc.store(actor9);
        oc.store(actor10);
        oc.store(actor11);
        oc.store(actor12);
        oc.store(actor13);

        // insert films
        oc.store(film1);
        oc.store(film2);
        oc.store(film3);
        oc.store(film4);
        oc.store(film5);

        oc.close();
        System.out.println("DB created");
    }
}
