package Actions;

import DB.Actor;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import static Actions.NewDB.DBNAME;

public class Inserts {
    Selects selects = new Selects();

    // 6
    public void updateActorDeathDate(int actor, String deathdate) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Actor> list = oc.queryByExample(new Actor(actor, null, null, null, null));

        if (!list.isEmpty()) {
            Actor modifiedActor = list.next();
            modifiedActor.setDeathdate(deathdate);
            oc.store(modifiedActor);
        }

        oc.close();

        System.out.println("Actor death date updated");
        var updatedActor = selects.selectActorById(actor);
        System.out.println(updatedActor);
    }

    // 7
    public void insertActor(Actor actor) {
        ObjectContainer oc = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DBNAME);
        ObjectSet<Actor> list = oc.queryByExample(new Actor(actor.getId(), null, null, null, null));

        if (list.isEmpty()) {
            oc.store(actor);
            System.out.println("Actor inserted");
        } else {
            System.out.println("Actor already exists");
        }

        oc.close();

        var newActor = selects.selectActorById(actor.getId());
        System.out.println(newActor);
    }
}
