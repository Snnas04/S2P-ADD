package cat.spaad.iniciacio;

import cat.spaad.ajudes.Inicis;
import cat.spaad.ajudes.MetodesObjectStreams;
import cat.spaad.tipusstreams.*;

import java.io.DataOutputStream;
import java.io.IOException;

public class IniciacioStreams {
    public static void main(String[] args) {
        IniciacioStreams iniciacioStreams = new IniciacioStreams();
        try {
            iniciacioStreams.provesObjecte();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void provesByte() throws IOException {
        new MetodesByteStreams().llegeixBytes("src/petit.txt");
        new MetodesByteStreams().escriuBytes("src/petitCopy.txt", "Test Byte Streams".getBytes());
    }

    public void provesCharacter() throws IOException {
        new MetodesCharacterStreams().llegeixCharacters("src/petit.txt");
        new MetodesCharacterStreams().escriuCharacters("src/petitCopy.txt", "Test Charecter Streams");
    }

    public void provesBuffered() throws IOException {
        new MetodesBufferedStreams().llegeixLinia("src/petit.txt");
        new MetodesBufferedStreams().escriuLinia("src/petitCopy.txt", new String[]{"Test Buffered Streams", "Test Buffered Streams"});
    }

    public void provesData() throws IOException {
        double[] dades = {4.0, 12.0, 3.5, 44.0332, 15.2304};
        new MetodesDataStreams().escriuArray("src/petitCopy.txt", dades);
        new MetodesDataStreams().llegeixArray("src/petitCopy.txt");
    }

    public void provesObjecte() throws Exception {
        Inicis inicis = new Inicis(12, "Test Object Streams");
        new MetodesObjectStreams().escriuObjecte("src/petitObject.dat", inicis);
        new MetodesObjectStreams().llegeixObjecte("src/petitObject.dat");
    }

    public void provesComparacions() throws IOException {
        new MetodesCharacterStreams().inutil("src/Shakespeare.txt");
        new MetodesBufferedStreams().inutil("src/Shakespeare.txt");
    }
}
