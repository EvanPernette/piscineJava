package fr.epita.assistants.war;

public class Vehicle extends Combatant{
    String name;
    int defense;
    public Vehicle(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }
    public void printState() {
        System.out.println("I have " + this.defense + " defense points.");
    }
    public void attack(Soldier target) {
        target.health = 0;
    }
    public void attack(Vehicle v) {
        v.defense /= 2;
    }
    public void scream() {
        System.out.println("I'm " + name + "!");
    }

}