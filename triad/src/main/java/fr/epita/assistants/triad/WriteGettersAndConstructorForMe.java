package fr.epita.assistants.triad;

public class WriteGettersAndConstructorForMe {
    private final String name;
    private final String firstName;
    private final String lastName;

    private final String random;

    private final String anotherOne;

    private final String anotherOne2;

    private final String anotherOne3;

    private final String xyz;

    private final int x;

    private final double y;

    private final float z;

    private final Boolean b;

    private final boolean c;

    public WriteGettersAndConstructorForMe(String name1, String firstName1, String lastName1, String random1 , String anotherOne1,
                                           String anotherOne21, String anotherOne31, String xyz1,  int x1, double y1,float z1, Boolean b1, boolean c1 ){
        name = name1;
        firstName = firstName1;
        lastName = lastName1;
        random = random1;
        anotherOne = anotherOne1;
        anotherOne2 = anotherOne21;
        anotherOne3 = anotherOne31;
        xyz = xyz1;
        x = x1;
        y = y1;
        z = z1;
        b = b1;
        c = c1;
    }

    public String getName() {
        return this.name;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getRandom() {
        return this.random;
    }
    public String getAnotherOne() {
        return this.anotherOne;
    }
    public String getAnotherOne2(){
        return this.anotherOne2;
    }
    public String getAnotherOne3(){
        return this.anotherOne3;
    }
    public String getXyz() {
        return this.xyz;
    }
    public int getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public float getZ() {
        return this.z;
    }
    public Boolean getB() {
        return this.b;
    }
    public Boolean getC() {
        return this.c;
    }
}
