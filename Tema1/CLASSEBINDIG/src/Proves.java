import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Proves {
    public static void main(String[] args) throws JAXBException {
        Modul modul = new Modul("Accés a dades", "ADD", 200);

        JAXBContext context = JAXBContext.newInstance(Modul.class);

        Marshaller marshaller = context.createMarshaller();

        // escriure a fitxer
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(modul, new File("modul.xml"));

        // llegir de fitxer
        var unmarshaller = context.createUnmarshaller();
        var modul2 = (Modul) unmarshaller.unmarshal(new File("modul.xml"));
        System.out.println(modul2);
    }
}
