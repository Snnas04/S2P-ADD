import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        escriureFilmsXML();
        llegirFilms();
        escriureConfiguracioFilms();
    }

    public static void escriureConfiguracioFilms() {
        int recompte = 4;
        int bones = 4;
        int llargues = 3;

        try {
            FileWriter fileWriter = new FileWriter("films.conf");

            fileWriter.write("Usuari: " + System.getProperty("user.name") + ",\n");
            fileWriter.write("Recompte: " + recompte + " " + ",\n");
            fileWriter.write("Bones: " + bones + ",\n");
            fileWriter.write("Llargues: " + llargues + "\n");

            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error en crear el archivo: " + e.getMessage());
        }
    }

    private static void escriureFilmsTXT() throws Exception {
        ArrayList<Film> list = new ArrayList<Film>();
        list.add(new Film("U2: Experience + Innocente, Live in Berlin", 75, "Music", 7.1F, "U2 live in Berlin. A " +
                "must " +
                "for all U2 fans", "Matt Askem", "Bono,Adam Clayton, The Edge, Larry MullerJr."));

        list.add(new Film("Harry Potter i la cambra secreta", 130, "Fantasia", 8.2F, "argumant", "director",
                "repartiment"));

        list.add(new Film("Star Wars Capitulo IV", 140, "Fantasia", 9.1F, "argumant", "director",
                "repartiment"));

        list.add(new Film("Spiderman", 120, "Fantasia", 8.2F, "argumant", "director",
                "repartiment"));

        Films films = new Films(list);

        ArrayList arrayFilm = films.getFilms();

        var desti = new File("films.txt");


        FileWriter out = new FileWriter(desti);

        try(out) {
            out.write(String.valueOf(films));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    private static void escriureFilmsXML() throws JAXBException {
        ArrayList<Film> list = new ArrayList<Film>();
        list.add(new Film("U2: Experience + Innocente, Live in Berlin", 75, "Music", 7.1F, "U2 live in Berlin. A " +
                "must " +
                "for all U2 fans", "Matt Askem", "Bono,Adam Clayton, The Edge, Larry MullerJr."));

        list.add(new Film("Harry Potter i la cambra secreta", 130, "Fantasia", 8.2F, "argumant", "director",
                "repartiment"));

        list.add(new Film("Star Wars Capitulo IV", 140, "Fantasia", 9.1F, "argumant", "director",
                "repartiment"));

        list.add(new Film("Spiderman", 120, "Fantasia", 8.2F, "argumant", "director",
                "repartiment"));

        Films films = new Films(list);

        JAXBContext context = JAXBContext.newInstance(Films.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(films, new File("films.xml"));
    }

    private static void llegirFilms() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Films.class);

        var unmarshaller = context.createUnmarshaller();
        var films2 = (Films) unmarshaller.unmarshal(new File("films.xml"));
        System.out.println(films2);
    }

}
