package fr.epita.assistants.embedfiles;

import java.util.Optional;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DisplayEmbedFile {
    private String filename;
    
    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }
    
    public Optional<String> display() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            return Optional.empty();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            reader.close();
            return Optional.of(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}