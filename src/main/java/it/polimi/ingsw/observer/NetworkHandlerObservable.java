package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.Message.Message;

import java.io.IOException;
import java.util.ArrayList;

public class NetworkHandlerObservable {
    private final ArrayList<NetworkHandler> observers = new ArrayList<>();

    public void addObserver(NetworkHandler observer) {
        synchronized (observer) {
            observers.add(observer);
        }
    }

    public void notifyMessage(Message message) {
        synchronized (observers) {
            for (NetworkHandler observer : observers) {
                try {
                    observer.updateMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void notifyConnection(String ip,String port){
        synchronized (observers){
            for(NetworkHandler observer:observers){
                observer.updateConnection(ip,port);
            }
        }
    }
}
