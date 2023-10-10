import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class Proves2 {
    public static void main(String[] args) throws JAXBException {
        ArrayList<Modul> llista = new ArrayList<Modul>();
        llista.add(new Modul("Accés a dades", "ADD", 200));
        llista.add(new Modul("Programació de Serveis i Processos", "PSP", 300));
        llista.add(new Modul("Sistemes de Gestio Empresaarial", "SGE", 100));
        llista.add(new Modul("Programació Multimedia i Dispositius Movils", "PMM", 400));

        Cicle cicle = new Cicle("Desenvolupament d'Aplicacions Multiplataforma", "Informàtica i Comunicacions", llista);

        JAXBContext context = JAXBContext.newInstance(Cicle.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(cicle, new File("cicle.xml"));
    }
}
