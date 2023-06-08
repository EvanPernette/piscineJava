package fr.epita.assistants.observer;

import fr.epita.assistants.observer.Observable.Observer;

public class Lifeguard implements Observer<Swimmer> {
    private String name;
    
    public Lifeguard(String name) {
        this.name = name;
        
        System.out.println(name + " begins to keep an eye on the swimmers.");
    }
    
    @Override
    public void onEvent(Swimmer swimmer) {
        SwimmerStatus status = swimmer.getStatus();
        String swimmerName = swimmer.getName();
        
        if (status == SwimmerStatus.DROWNING) {
            System.out.println(name + ": I will save you " + swimmerName + "!");
        } else if (status == SwimmerStatus.TOO_FAR) {
            System.out.println(name + ": " + swimmerName + "! You are too far, come back!");
        }
    }
}