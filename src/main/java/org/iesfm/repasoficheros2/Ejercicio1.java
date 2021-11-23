package org.iesfm.repasoficheros2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Ejercicio1 {

    private static final Logger log = LoggerFactory.getLogger(Ejercicio1.class);

    public static void read(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            StringBuilder str = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line).append("\n");
            }
            log.info(str.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read("/tmp/hola.txt");
    }
}
