package fr.epita.assistants.mykitten;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.stream.Stream;

public class MyKitten {
	public Stream<String> streamContent;
	
	public MyKitten(String srcPath) throws IOException {
            this.streamContent = Files.lines(Paths.get(srcPath));

	}
	public int count = 1;
	public void replaceByMiaou(String wordToReplace) {
		this.streamContent = streamContent.map(line -> {
            return count++ + " " + line.replaceAll(wordToReplace, "miaou");
		});
	}
	
	public void toFile(String destPath) throws IOException {
		Files.write(Paths.get(destPath), 
				(Iterable<String>)streamContent::iterator);
	}
	
	public static void miaou(String srcPath, String destPath, String wordToReplace) throws IOException {
		MyKitten myKitten = new MyKitten(srcPath);
		myKitten.replaceByMiaou(wordToReplace);
		myKitten.toFile(destPath);
	}
    
}