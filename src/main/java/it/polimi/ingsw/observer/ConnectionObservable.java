package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.ClientHandlerInterface;

import java.util.ArrayList;

public class ConnectionObservable {
    private final ArrayList<ConnectionObserver> observers= new ArrayList<>();
    public void addObserver(ConnectionObserver observer) {
        synchronized (observer) {
            observers.add(observer);
        }
    }
        public void notifyDisconnection(ClientHandlerInterface client){
                   synchronized (observers){
                       for(ConnectionObserver observer: observers){
                           observer.updateDisconnection(client);
                       }
                   }
        }

}
