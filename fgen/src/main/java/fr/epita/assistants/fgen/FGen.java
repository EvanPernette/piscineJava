package fr.epita.assistants.fgen;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import javax.lang.model.util.ElementScanner14;

public class FGen {
    
    private String currentPath;
    public FGen(final String inputPath) {
        parse(inputPath);
    }
    
    private void parse(String inputPath) {
        try {
            currentPath = System.getProperty("user.dir");
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(inputPath);
            if (inputStream == null) {
                throw new RuntimeException("Invalid input path");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("+")) {
                    String path = line.substring(2);
                    createDirectoryAndFile(path);
                } else if (line.startsWith(">")) {
                    String path = line.substring(2);
                    changeCurrentPath(path);
                } else if (line.startsWith("-")) {
                    String path = line.substring(2);
                    deleteFileOrDirectory(path);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Invalid input path");
        }
    }
    
    private void createDirectoryAndFile(String path) {
        Path currentPath2 = Paths.get(this.currentPath);
        Path path3 = currentPath2.resolve(path);
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                Path path2 = currentPath2.resolve(path.substring(0, i));
                try {
                    Files.createDirectories(path2);
                } catch (IOException e) {
                    return;
                }
            }
        }
        try {
            Files.createFile(path3);
        } catch (IOException e) {
            return;
        }
    }
    

    private void changeCurrentPath(String path) {
        File file = new File(currentPath, path);
        if (file.exists() && file.isDirectory()) {
            currentPath = file.getPath();
        } else {
            throw new RuntimeException("Invalid input path");
        }
    }

    private void deleteFileOrDirectory(String path) {
        Path currentPath2 = Paths.get(this.currentPath);
        Path path2 = currentPath2.resolve(path);
        try {
            Files.walkFileTree(path2, (FileVisitor<? super Path>) new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            return;
        }
    }

}