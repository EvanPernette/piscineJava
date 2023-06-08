package fr.epita.assistants;

import java.io.IOException;

import fr.epita.assistants.mykitten.MyKitten;

public class Main {
    public static void main(String[] args) throws IOException {
        MyKitten myKitten = new MyKitten("src/main/java/fr/epita/assistants/a");
        myKitten.replaceByMiaou("abc");
        try {
            myKitten.toFile("src/main/java/fr/epita/assistants/b");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
