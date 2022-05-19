package it.polimi.ingsw.observer;

import java.util.ArrayList;

public class IslandObservable {
    private final ArrayList<IslandObserver> observers= new ArrayList<>();

    public void addObserver(IslandObserver observer){
        synchronized (observer){
            observers.add(observer);
        }
    }
}
