package cat.spaad.tipusstreams;

import cat.spaad.auxiliar.Cronometre;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MetodesCharacterStreams {
    public void llegeixCharacters(String origen) throws IOException {
        FileReader in = new FileReader(origen);

        try(in) {
            System.out.println("\n====================\n");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println("\n====================\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
        }
    }

    public void escriuCharacters(String desti, String dades) throws IOException {
        FileWriter out = new FileWriter(desti);
        
        try(out) {
            out.write(dades);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    public void inutil(String origen) throws IOException {
        FileReader in = new FileReader(origen);

        try(in) {
            System.out.println("\nCaracter Streams");
            Cronometre cronometre = new Cronometre();
            cronometre.inicia();

            int c;
            while ((c = in.read()) != -1) {}

            cronometre.atura();

            System.out.println("Temps de lectura: " + cronometre.mostra() + " milisegons");

            System.out.println("\n====================");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
        }
    }
}
