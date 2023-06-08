package fr.epita.assistants.throwback;


public class StringException extends Exception{
    public StringException(String s) throws Exception{
        if (s.length() < 100) {
            throw new ShortStringException(s);
        } else{
            throw new LongStringException(s);
        }
    }
}
