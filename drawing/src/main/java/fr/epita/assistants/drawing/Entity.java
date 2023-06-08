package fr.epita.assistants.drawing;


public abstract class Entity implements IDrawable{
    private static long SEQUENCE = 0;
    protected long id;

    public Entity(){
        this.id = SEQUENCE;
        SEQUENCE++;
    }

    public long getId(){
        return this.id;
    }

    public abstract void draw();
}
