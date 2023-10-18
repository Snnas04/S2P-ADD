import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        var socis = new Parse().parse("socis.dat");
        var context = JAXBContext.newInstance(LlistaSocis.class);
        var marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(socis, new File("socis.xml"));
    }
}
