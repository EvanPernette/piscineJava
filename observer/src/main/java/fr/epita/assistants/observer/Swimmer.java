package fr.epita.assistants.observer;



import java.util.HashSet;
import java.util.Set;

public class Swimmer implements Observable<Swimmer> {
    private Set<Observer<Swimmer>> observers;
    private String name;
    private SwimmerStatus status;
    
    public Swimmer(String name) {
        this.name = name;
        this.status = SwimmerStatus.OK;
        this.observers = new HashSet<>();
        System.out.println(name + " goes into the sea.");
    }
    
    public String getName() {
        return this.name;
    }
    
    public SwimmerStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(SwimmerStatus status) {
        this.status = status;
        if (status == SwimmerStatus.DROWNING) {
            System.out.println(name + ": I'm drowning, help!!");
        }
        this.fire(this);
    }
    
    @Override
    public Set<Observer<Swimmer>> getObservers() {
        return this.observers;
    }
    
    @Override
    public void register(Observer<Swimmer>... observers) {
        for (Observer<Swimmer> observer : observers) {
            this.observers.add(observer);
        }
    }
    
    @Override
    public void unregister(Observer<Swimmer> observer) {
        this.observers.remove(observer);
    }
    
    @Override
    public void fire(Swimmer swimmer) {
        for (Observer<Swimmer> observer : this.observers) {
            observer.onEvent(swimmer);
        }
    }
}