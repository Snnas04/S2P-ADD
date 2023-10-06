package cat.spaad.tipusstreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.System.in;

public class MetodesByteStreams {
    public void llegeixBytes(String origen) throws IOException {
        FileInputStream in = new FileInputStream(origen);

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

    public void escriuBytes(String desti, byte[] dades) throws IOException {
        FileOutputStream out = new FileOutputStream(desti);

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
}
