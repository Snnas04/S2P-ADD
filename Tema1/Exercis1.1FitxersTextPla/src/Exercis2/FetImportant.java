package Exercis2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FetImportant {
    public static void main(String[] args) {
        new FetImportant();
    }

    private FetImportant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdueix un dels seguets valors:\n 1. 2001\n 2. 2008\n 3. 2016");
        System.out.println("=============");
        int opcio = scanner.nextInt();
        scanner.nextLine();

        Path file = null;

        if (opcio == 2001) {
            file = Paths.get("src/Exercis2/2001.txt");
        } else if (opcio == 2008) {
            file = Paths.get("src/Exercis2/2008.txt");
        } else if (opcio == 2016) {
            file = Paths.get("src/Exercis2/2016.txt");
        }

        llegir(String.valueOf(file));
    }

    private void llegir(String nomFitxer) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomFitxer));
            String linia;
            while ((linia = br.readLine()) != null) {
                System.out.println(linia);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error llegint el fitxer: " + e.getMessage());
        }
    }
}
