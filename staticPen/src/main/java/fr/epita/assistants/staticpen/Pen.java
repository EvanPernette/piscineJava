package fr.epita.assistants.staticpen;


public class Pen {

    public enum Color {
        RED,
        BLUE,
    }

    Color color;
    private static int penCounter = 0;
    private static int redPenCounter = 0;
    private static int bluePenCounter = 0;
    public Pen(final Color color) {
        this.color = color;
        penCounter++;
        if (color == Color.RED) {
            redPenCounter++;
        } else if (color == Color.BLUE) {
            bluePenCounter++;
        }
    }

    public static int getRedPenCounter() {
        return redPenCounter;
    }

    public static int getPenCounter() {
        return penCounter;
    }

    public static int getBluePenCounter() {
        return bluePenCounter;
    }

    public void changeColor(final Color color) {
        if (this.color == Color.RED) {
            redPenCounter--;
        } else if (this.color == Color.BLUE) {
            bluePenCounter--;
        }
        this.color = color;
        if (color == Color.RED) {
            redPenCounter++;
        } else if (color == Color.BLUE) {
            bluePenCounter++;
        }
    }

    public static void resetCounts() {
        penCounter = 0;
        redPenCounter = 0;
        bluePenCounter = 0;
    }

    public void print() {
        System.out.println("I'm a " + color + " pen.");
    }
}
