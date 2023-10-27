import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        llegitEmpleats();
    }

    private static void llegitEmpleats() throws Exception {
        FileInputStream fis = new FileInputStream("empleats.dat");

        ObjectInputStream ois = new ObjectInputStream(fis);

        Object objecteLlegit = ois.readObject();

        ois.close();
        fis.close();
    }
}
