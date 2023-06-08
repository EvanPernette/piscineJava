package fr.epita.assistants.war;

public class Soldier extends Combatant{
    int health;
    int damage;
    String scream;
    public Soldier() {
        this.health = 15;
        this.damage = 3;
        this.scream = "No pity for losers!";
    }
    public void kill() {
        this.health = 0;
    }
    public void printState() {
        System.out.println("I have " + this.health + " health points.");
    }
    public void attack(Soldier target) {
        target.health -= damage;
    }
    public void attack(Vehicle v) {
        System.out.println("I can't fight this.");
    }
    public void scream() {
        System.out.println(scream);
    }
}