package cat.spaad.llegirescriure;

import cat.spaad.classes.Llibre;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Llibre llibre = new Llibre("Marc Sans", "Llibre de Multiplataforma", "Educatiu", 20, 2020, "Llibre de DAM");

        JAXBContext context = JAXBContext.newInstance(Llibre.class);

        var unmarshaller = context.createUnmarshaller();
        var llibre2 = (Llibre) unmarshaller.unmarshal(new File("books.xml"));
        System.out.println(llibre2);
    }
}
