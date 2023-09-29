import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        System.out.println("Exercisi 1:");
        m.Exercisi1(args);
        System.out.println("\nExercisi 2:");
        m.Exercisi2(args);
        System.out.println("\nExercisi 3:");
        m.Exercisi3();
        System.out.println("\nExercisi 4:");
        m.Exercisi4();
        System.out.println("\nExercisi 5:");
        m.Exercisi5();
    }

    // 1. Construeix un path a partir d'un String i mostra tota la informació possible d'aquest path per consola.
    private void Exercisi1(String[] args) {
        if (args.length != 1) {
            System.out.println("Introdueix un path");
            System.exit(1);
        }

        Path pathEx1 = Paths.get(args[0]);

        System.out.println("String path: " + pathEx1.toString());
        System.out.println("File Name: " + pathEx1.getFileName());
        System.out.println("Element position name: " + pathEx1.getName(0));
        System.out.println("Count path: " + pathEx1.getNameCount());
    }

    // 2. Utilitza la classe Files per mostrar per consola tota la informació sobre un arxiu del vostre sistema.
    private void Exercisi2(String[] args) {
        if (args.length != 1) {
            System.out.println("Introdueix un path");
            System.exit(1);
        }

        Path file = Paths.get(args[0]);
        file.getFileName();

        System.out.println("Es un fitxer? " + Files.isRegularFile(file));
        System.out.println("Es pot llegir? " + Files.isReadable(file));
        System.out.println("Es pot editar/actualitzar? " + Files.isWritable(file));
        System.out.println("Es executable? " + Files.isExecutable(file));
    }

    // 3. Copia un fitxer entre dos directoris
    private void Exercisi3() {
        Path origen = Paths.get("./dir1/test.txt");
        Path desti = Paths.get("./dir2/test.txt");

        try {
            Files.copy(origen, desti);
            System.out.println("El fitxer: " + origen.getFileName() + " s'ha copiat correctament");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 4. Mou un fitxer a un altre directori
    private void Exercisi4() {
        Path origen = Paths.get("./dir1/test2.txt");
        Path desti = Paths.get("./dir2/test.txt");

        try {
            Files.move(origen, desti);
            System.out.println("El fitxer: " + origen.getFileName() + " s'ha mogut correctament");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 5. Copia un directori sencer.
    private void Exercisi5() {
        Path origen = Paths.get("dir1/test.txt");
        Path desti = Paths.get("copyDir");

        try {
            Files.move(origen, desti);
            System.out.println("El directori: " + origen.getName(0) + " s'ha mogut correctament");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 6. Mostra per consola el contingut d'un directori, inclosos els seus subdirectoris i els seus continguts.

    // 7. Crea un Form amb un component Jtree que mostri la mateixa informació que l'exercici anterior. Prova-ho amb un directori "petitet".

}
