package org.iesfm.repasoficheros2;

import java.io.*;
import java.net.URISyntaxException;

public class Ejercicio4 {
    public static void main(String[] args) {

    Ejercicio4 ejercicio4 = new Ejercicio4();
                ejercicio4.writeFile("/el_quijote.txt", "/tmp/a.txt");
    }

    public String readClassPath(String path) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(getClass().getResource(path).toURI())))) {
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public void writeFile(String originPath, String destinationPath) {

        try (FileWriter writer = new FileWriter(destinationPath)) {
            writer.write(readClassPath(originPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
