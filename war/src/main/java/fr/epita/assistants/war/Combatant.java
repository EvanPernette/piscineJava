package fr.epita.assistants.war;


public abstract class Combatant{
    public void printState() {
        System.err.println("Error 404. Class not found.");
    }
    public abstract void attack(Soldier target);
    public abstract void scream();
    public abstract void attack(Vehicle v);
}