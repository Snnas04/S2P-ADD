import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.Metodo1();
        main.Metodo2();
    }

    private void Metodo1() throws IOException {
        FileOutputStream out = null;

        try {
            FileInputStream in = new FileInputStream("imgTag.png");

            out = new FileOutputStream("imgTagCopy.png");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
            out.close();
        }
    }

    private void Metodo2() {
        try (FileInputStream in = new FileInputStream("imgTag.png");
             FileOutputStream out = new FileOutputStream("imgTagCopy.png")) {

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
