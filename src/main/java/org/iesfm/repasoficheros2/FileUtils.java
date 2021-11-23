package org.iesfm.repasoficheros2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;

public class FileUtils {
    private static Logger log = LoggerFactory.getLogger(FileUtils.class);

    public File createEmptyFile(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
        return file;
    }


    public File classpathFile(String path) {
        File file = null;
        try {
            file = new File(getClass().getResource(path).toURI());
        } catch (URISyntaxException e) {
            log.error("", e);
        }
        return file;
    }

    public File[] listFiles(File folder) {
        return folder.listFiles();
    }

    public int countTextOccurrences(File file, String text) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(text)) {
                    count++;
                }
            }
        } catch (IOException e) {
            log.error("Error leyendo el archivo " + file.getName(), e);
        }

        return count;
    }

    public String readFile(File file) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error("Error leyendo el archivo " + file.getName(), e);
        }

        return builder.toString();
    }

    public void writeToFile(File file, String content) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            log.error("Error escribiendo en el archivo " + file.getName(), e);
        }
    }
}
