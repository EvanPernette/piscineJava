package fr.epita.assistants.throwback;

public class UnknownException extends Exception{
    public UnknownException(String z) throws Exception {
        super("UnknownException: " + z);
    }
}
