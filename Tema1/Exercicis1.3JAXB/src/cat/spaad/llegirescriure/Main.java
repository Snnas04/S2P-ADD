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
        ArrayList<Llibre> list = new ArrayList<Llibre>();
        list.add(new Llibre("J.K. Rowling", "Harry Potter i la pedra filosofal", "Fantasia", "26/06/1997", "Una " +
                "historia de màgia"));
        list.add(new Llibre("J.K. Rowling", "Harry Potter i la cambra secreta", "Fantasia", "02/07/1998", "Una " +
                "historia de màgia"));

        Catalog catalog = new Catalog("Llibres de Harry Potter", list);

        JAXBContext context = JAXBContext.newInstance(Catalog.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(list, new File("books2.xml"));

//        var unmarshaller = context.createUnmarshaller();
//        var llibre2 = (Catalog) unmarshaller.unmarshal(new File("books2.xml"));
//        System.out.println(llibre2);
    }
}
