package fr.epita.assistants.grades.model;

public record Activity(String name1 , Subject subject1, float coefficient) {
    public Subject subject() {
        return subject1;
    }

    public String name() {
        return name1;
    }

    public float weight() {
        return coefficient;
    }

}
