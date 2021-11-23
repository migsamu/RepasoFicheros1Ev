package org.iesfm.repasoficheros2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class Ejercicio3 {

    private static final Logger log = LoggerFactory.getLogger(Ejercicio3.class);

    public void readFileClasspath() {

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(this.getClass().getResource("/el_quijote.txt").toURI())))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            log.info(builder.toString());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Ejercicio3 ejercicio3 = new Ejercicio3();
        ejercicio3.readFileClasspath();
    }

}
/*
Crea un programa que lea del classpath el fichero el_quijote.txt y lo reconstruya en una variable StringBuilder. Al final imprime El Quijote en pantalla.
 */