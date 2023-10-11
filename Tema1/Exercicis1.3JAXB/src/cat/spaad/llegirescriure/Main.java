package cat.spaad.llegirescriure;

import cat.spaad.classes.Catalog;
import cat.spaad.classes.Llibre;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JAXBException {
        escriureCataleg();
        llegirCataleg();
    }

    private static void llegirCataleg() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);

        var unmarshaller = context.createUnmarshaller();
        var catalog2 = (Catalog) unmarshaller.unmarshal(new File("books.xml"));
        System.out.println(catalog2);
    }

    private static void escriureCataleg() throws JAXBException {
        ArrayList<Llibre> list = new ArrayList<Llibre>();
        list.add(new Llibre("jk123", "J.K. Rowling", "Harry Potter i la pedra filosofal", "Fantasia", "24.99", "02/07" +
                "/1997",
                "Una" +
                        " " +
                        "historia de màgia"));
        list.add(new Llibre("jk321", "J.K. Rowling", "Harry Potter i la cambra secreta", "Fantasia", "24.99", "02/07/1998",
                "Una" +
                        " " +
                        "historia de màgia"));

        Catalog catalog = new Catalog("Llibres de Harry Potter", list);

        JAXBContext context = JAXBContext.newInstance(Catalog.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(catalog, new File("books_prova.xml"));
    }
}
