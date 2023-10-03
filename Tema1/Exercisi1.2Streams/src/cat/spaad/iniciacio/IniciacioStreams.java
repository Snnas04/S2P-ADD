package cat.spaad.iniciacio;

import cat.spaad.tipusstreams.MetodesBufferedStreams;
import cat.spaad.tipusstreams.MetodesByteStreams;
import cat.spaad.tipusstreams.MetodesCharacterStreams;

import java.io.IOException;

public class IniciacioStreams {
    public static void main(String[] args) {
        IniciacioStreams iniciacioStreams = new IniciacioStreams();
        try {
            iniciacioStreams.provesBuffered();
        } catch (IOException e) {
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
}
