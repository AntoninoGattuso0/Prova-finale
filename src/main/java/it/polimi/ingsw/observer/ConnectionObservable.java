package it.polimi.ingsw.observer;

import java.util.ArrayList;

public class ConnectionObservable {
    private final ArrayList<ConnectionObserver> observers= new ArrayList<>();
    public void addObserver(ConnectionObserver observer){
        synchronized (observer){
            observers.add(observer);
        }
    }
}
