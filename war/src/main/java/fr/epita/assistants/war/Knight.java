package fr.epita.assistants.war;

public class Knight extends Soldier {
    public Knight() {
        this.health = 20;
        this.damage = 5;
        this.scream = "Be quick or be dead!";
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

