package fr.epita.assistants.war;


public class Assassin extends Soldier {
    public Assassin() {
        this.health = 10;
        this.damage = 9;
        this.scream = "Out of the shadows!";
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