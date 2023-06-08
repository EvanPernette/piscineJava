package fr.epita.assistants.throwback;

public class ShortStringException extends Exception{
    public ShortStringException(String s) throws Exception {
        super("StringException: ShortStringException: " + s + " (length: " + s.length() + ")");
    }
}
