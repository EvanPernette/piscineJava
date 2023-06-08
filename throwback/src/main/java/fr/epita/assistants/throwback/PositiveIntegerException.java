package fr.epita.assistants.throwback;

public class PositiveIntegerException extends Exception{
    public PositiveIntegerException(String value) throws Exception{
        super("IntegerException: PositiveIntegerException: " + value);
    }
}
