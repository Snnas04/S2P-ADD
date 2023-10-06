package cat.spaad.tipusstreams;

import java.io.*;

public class MetodesDataStreams {
    public  double[] llegeixArray(String origen) throws IOException {
        // Llegeix les dades que s'han escrit al fitxer origen i torna un array amb les dades que ha llegit. Ho pots provar
        // amb el fitxer generat a (b). (DataInputStream)
        DataInputStream in = new DataInputStream(new FileInputStream(origen));

        double[] dades;

        try(in) {
            System.out.println("\n====================\n");

            dades = new double[(int) in.readDouble()];
            while (in.available() > 0) {
                for (int i = 0; i < dades.length; i++) {
                    dades[i] = in.readDouble();
                    System.out.println(dades[i]);
                }
            }

            System.out.println("\n====================\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
        }

        return dades;
    }

    public void escriuArray(String desti, double[] dades) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(desti));

        try(out) {
            out.writeDouble(dades.length);
            for (double dada : dades) {
                out.writeDouble(dada);
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
