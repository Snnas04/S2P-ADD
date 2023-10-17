import java.io.*;

public class Parse {
    public LlistaSocis parse(String arxiu) {
        var socis = new LlistaSocis();

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(arxiu)))) {
            while (true) {
                String dni = in.readUTF();
                String nom = in.readUTF();
                String llinatges = in.readUTF();
                String adreca = in.readUTF();
                int cp = in.readInt();
                String ciutat = in.readUTF();
                String telefon = in.readUTF();

                socis.getSocis().add(new Soci(dni, nom, llinatges, adreca, cp, ciutat, telefon));
            }
        } catch (IOException e) {
            return socis;
        }
    }
}
