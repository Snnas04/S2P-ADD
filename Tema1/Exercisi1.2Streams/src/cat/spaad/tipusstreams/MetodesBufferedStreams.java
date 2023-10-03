package cat.spaad.tipusstreams;

import java.io.*;

public class MetodesBufferedStreams {
    public static void main(String[] args) {

    }

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
        //Guarda al fitxer destí el text contingut dins l'array de cadenes dades. Al fitxer s'ha de veure cada string
        // en una línia (out.newLine()). (BufferedWriter)
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
}
