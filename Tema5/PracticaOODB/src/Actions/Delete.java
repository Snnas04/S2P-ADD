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
            film.getActors().removeIf(a -> a.getId() == actorId);

            oc.store(film); // This line updates the film in the database

            oc.close();

            System.out.println("Actor deleted from film");

            var castByFilmId = selects.selectCastByFilmId(filmId);
            System.out.println("New film casting:\n" + castByFilmId);
        } else {
            oc.close();
            System.out.println("Film not found");
        }
    }
}
