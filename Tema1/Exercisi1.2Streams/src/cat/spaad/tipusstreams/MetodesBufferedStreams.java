package cat.spaad.tipusstreams;

import cat.spaad.auxiliar.Cronometre;

import java.io.*;

public class MetodesBufferedStreams {
    public void llegeixLinia(String origen) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(origen));

        try(in) {
            System.out.println("\n====================\n");
            String c;
            while ((c = in.readLine()) != null) {
                System.out.println(c);
            }
            System.out.println("\n====================\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
        }
    }

    public void escriuLinia(String desti, String[] dades) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(desti));

        try(out) {
            for (String dada : dades) {
                out.write(dada);
                out.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    public void inutil(String origen) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(origen));

        try(in) {
            System.out.println("\nBuffered Streams");

            Cronometre cronometre = new Cronometre();
            cronometre.inicia();

            String c;
            while ((c = in.readLine()) != null) {}
            cronometre.atura();

            System.out.println("Temps de lectura: " + cronometre.mostra() + " milisegons");

            System.out.println("\n====================");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
        }
    }
}
