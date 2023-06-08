package fr.epita.assistants.throwback;

public class IntegerException extends Exception{
    public IntegerException(String value) throws Exception {
        if (value.charAt(0) == '-') {
            throw new NegativeIntegerException(value);
        } else {
            throw new PositiveIntegerException(value);
        }
    }
}
