package fr.epita.assistants.grades.model;

public record Grade(Activity activity1, int value1) {
    public Activity activity() {
        return activity1;
    }

    public int value() {
        return value1;
    }
}


