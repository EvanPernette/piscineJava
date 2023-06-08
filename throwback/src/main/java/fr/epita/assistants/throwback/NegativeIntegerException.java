package fr.epita.assistants.throwback;

public class NegativeIntegerException extends Exception{
    public NegativeIntegerException(String value) throws Exception{
        super("IntegerException: NegativeIntegerException: " + value);
    }
}
