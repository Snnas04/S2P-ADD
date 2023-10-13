import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        LlegirPaisosDelMon();
    }

    public static void LlegirPaisosDelMon() throws IOException, JAXBException {
        var arxiu = new File("cities.txt");
        var in = new BufferedReader(new FileReader(arxiu));

        int count = 0;
        ArrayList<Pais> paisos = new ArrayList<Pais>();
        String liena;

        while ((liena = in.readLine()) != null) {
            var dades = liena.split(";");
            var id = dades[0];
            var pais = dades[1];
            var ciutat = dades[2];
            var districte = dades[3];
            var poblacio = dades[4];

            paisos.add(new Pais(pais, new ArrayList<Ciutat>()));
            paisos.get(count).getCiutats().add(new Ciutat(Integer.parseInt(id), ciutat, districte, Integer.parseInt(poblacio)));

            count++;
        }

        in.close();

        EscriurePaisosDelMon(count, paisos);
    }


    private static void EscriurePaisosDelMon(int count, ArrayList<Pais> paisos) throws JAXBException {
        var paisosDelMon = new PaisosDelMon(String.valueOf(count), paisos);

        JAXBContext context = JAXBContext.newInstance(PaisosDelMon.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(paisosDelMon, new File("cities.xml"));
    }
}
