package fr.epita.assistants.throwback;

public class LongStringException extends Exception{
    public LongStringException(String s) throws Exception {
        super("StringException: LongStringException: " + s + " (length: " + s.length() + ")");
    }
}
