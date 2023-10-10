package cat.spaad.ajudes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MetodesObjectStreams {

    public void escriuObjecte(String fitxerDesti, Object objecte) throws Exception {
        //Obre un objecte FileOutputStream per escriure al fitxer
        FileOutputStream fos = new FileOutputStream(fitxerDesti);

        //Obre un objecte ObjectOutputStream per escriure l'objecte
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //Escriu l'objecte al fitxer
        oos.writeObject(objecte);

        //Tanca els objectes
        oos.close();
        fos.close();
    }

    public void llegeixObjecte(String fitxerOrigen) throws Exception {
        //Obre un objecte FileInputStream per llegir del fitxer
        FileInputStream fis = new FileInputStream(fitxerOrigen);

        //Obre un objecte ObjectInputStream per llegir l'objecte
        ObjectInputStream ois = new ObjectInputStream(fis);

        //Llegeix l'objecte del fitxer
        Object objecteLlegit = ois.readObject();

        //Tanca els objectes
        ois.close();
        fis.close();

        //Retorna l'objecte llegit
        System.out.println(objecteLlegit);
    }
}
