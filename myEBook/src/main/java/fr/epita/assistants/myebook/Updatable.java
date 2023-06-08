package fr.epita.assistants.myebook;

public interface Updatable {
    double getVersion();
    void update(double version);
}
