import Classes.Soci;
import Classes.Socis;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Socis s = llegir();
        escriureXML(s);
        escriureObjectes(s);
        mostrarObjectes();
    }

    private static Socis llegir(){
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("socis.dat")))) {
            int quantitat = 0;
            List<Soci> socis = new ArrayList<>();
            while (true){
                try {
                    socis.add(new Soci(in.readUTF(), in.readUTF(), in.readUTF(), in.readUTF(), in.readInt(), in.readUTF(), in.readUTF()));
                    quantitat++;
                } catch (EOFException e){
                    return new Socis(quantitat, socis);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    private static void escriureXML(Socis socis) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Socis.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(socis, new File("test.xml"));
    }
    private static void mostrarObjectes() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.dat"))) {
            try {
                while (true) {
                    System.out.println(in.readObject().toString());
                }
            } catch (EOFException e) {
                System.out.println("S'ha llegit el fitxer.");
            } catch (ClassNotFoundException e) {
                e.getMessage();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void escriureObjectes(Socis socis) throws JAXBException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.dat"))) {
            for (Soci s : socis.getSocis()) {
                s.setNom(s.getNom().toLowerCase());
                s.setLlinatges(s.getLlinatges().toLowerCase());
                out.writeObject(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
