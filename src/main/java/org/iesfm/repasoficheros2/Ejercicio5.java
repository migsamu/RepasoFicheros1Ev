package org.iesfm.repasoficheros2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {

    private static final Logger log = LoggerFactory.getLogger(Ejercicio5.class);
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Ejercicio5 ejercicio5 = new Ejercicio5();
        String pathOrigen = ejercicio5.pideRuta();
        String texto = ejercicio5.pideTextoABuscar();
        String pathDestino = ejercicio5.pideRuta();

        int veces = ejercicio5.contarTexto(texto, pathOrigen);

        ejercicio5.escribirVeces(veces, pathDestino);


    }

    public String pideRuta() {
        log.info("Introduce la ruta del archivo");
        return scan.nextLine();
    }

    public String pideTextoABuscar() {
        log.info("Introduce el texto a buscar");
        return scan.nextLine();
    }

    public int contarTexto(String texto, String path) {
        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(texto)) {
                    contador++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }

    public void escribirVeces(int veces, String path) {
        try (FileWriter writer = new FileWriter(new File(path),true)) {
            writer.write("se ha encontrado el texto " + veces + " veces" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
