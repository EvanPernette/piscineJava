package fr.epita.assistants.observer;

import fr.epita.assistants.observer.Observable.Observer;

public class Person implements Observer<Swimmer> {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    @Override
    public void onEvent(Swimmer swimmer) {
        SwimmerStatus status = swimmer.getStatus();
        String swimmerName = swimmer.getName();
        
        if (status == SwimmerStatus.WAVING) {
            System.out.println(name + ": Waves at " + swimmerName + ".");
        }
    }
}