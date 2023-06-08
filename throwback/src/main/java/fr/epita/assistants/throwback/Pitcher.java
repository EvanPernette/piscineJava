package fr.epita.assistants.throwback;


public class Pitcher {
    public static void throwException(String name) throws Exception{
        if (name.charAt(0) == '-' || (name.charAt(0) >= '0' && name.charAt(0) <= '9'))
        {
            for (int i = 1; i < name.length(); i++) {
                if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
                }
                else
                {
                    throw new UnknownException(name);
                }
            }
            if (name.length() == 1 && name.charAt(0) == '-')
            {
                throw new UnknownException(name);
            }
            throw new IntegerException(name);
        }
        for (int i = 0; i < name.length(); i++) {
            if ((Character.toLowerCase(name.charAt(i)) >= 'a' && Character.toLowerCase(name.charAt(i)) <= 'z') || name.charAt(i) == ',' || name.charAt(i) == '.' || name.charAt(i) == ' ' || name.charAt(i) == '\'') {
            }
            else
            {
                throw new UnknownException(name);
            }
        }
        throw new StringException(name);
    }
}
