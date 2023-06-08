package fr.epita.assistants;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import fr.epita.assistants.fgen.FGen;


public class Main {
    public static void main(String[] args) {
        String inputPath = "example.txt";
        FGen fgen = new FGen(inputPath);
    }
}
