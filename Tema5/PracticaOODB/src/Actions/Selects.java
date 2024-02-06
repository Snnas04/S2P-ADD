package Actions;

import DB.Actor;
import DB.Film;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

import static Actions.NewDB.DBNAME;

public class Selects {
    // 2
    public List<Object> selectAll() {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Film> list = oc.queryByExample(Object.class);
        List<Object> objects = new ArrayList<>(list);

        oc.close();

        return objects;
    }

    // 3
    public Film selectFilmByTitle(String title) {
        Film film;

        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Film> list = oc.queryByExample(new Film(null, title, null, null, null, null, null, null));

        if (!list.isEmpty()) {
            film = list.next();
        } else {
            return null;
        }

        oc.close();

        return film;
    }

    // 4
    public List<Actor> selectCastByFilmId(String id) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Film> list = oc.queryByExample(new Film(id, null, null, null, null, null, null, null));

        if (!list.isEmpty()) {
            Film film = list.next();
            oc.close();
            return film.getActors();
        } else {
            oc.close();
            return null;
        }
    }

    // 5
    public List<Film> selectFilmsByGenre(String genre) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Film> list = oc.queryByExample(new Film(null, null, null, null, null, genre, null, null));
        List<Film> films = new ArrayList<>(list);

        oc.close();

        return films;
    }

    // extras
    public Actor selectActorById(int id) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Actor> list = oc.queryByExample(new Actor(id, null, null, null, null));

        if (!list.isEmpty()) {
            Actor actor = list.next();
            oc.close();
            return actor;
        } else {
            oc.close();
            return null;
        }
    }
}
