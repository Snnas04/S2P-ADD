package Actions;

import DB.Film;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import static Actions.NewDB.DBNAME;

public class Delete {
    Selects selects = new Selects();

    // 8
    public void deleteActorFromFilm(int actorId, String filmId) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Film> list = oc.queryByExample(new Film(filmId, null, null, null, null, null, null, null));

        if (!list.isEmpty()) {
            Film film = list.next();
            film.getActors().removeIf(actor -> actor.getId() == actorId);

            oc.store(film);

            oc.close();

            System.out.println("Actor deleted from film");
        } else {
            oc.close();
            System.out.println("Film not found");
        }
    }

    // 9
    public void deleteActor(int actorId) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Film> films = oc.queryByExample(new Film(null, null, null, null, null, null, null, null));

        if (!films.isEmpty()) {
            while (films.hasNext()) {
                Film film = films.next();
                film.getActors().removeIf(actor -> actor.getId() == actorId);
                oc.store(film);
            }

            oc.close();

            System.out.println("Actor deleted from all films");
        } else {
            oc.close();
            System.out.println("Actor not found");
        }
    }
}
