package org.iesfm.repasoficheros2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Ejercicio2 {

    private static final Logger log = LoggerFactory.getLogger(Ejercicio2.class);

    public static void main(String[] args) {
        readFolder("/home/miguel/files");
    }

    public static String readFiles(File file) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public static void readFolder(String path) {
        File file = new File(path);

        for (File f : file.listFiles()) {
           log.info(readFiles(f));
        }

    }
}
/*
Crea un programa que lea todos los ficheros de texto en el directorio /home/<usuario>/files/. Imprime en pantalla el contenido de cada fichero en una línea
 */