package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.Message.Message;

import java.util.ArrayList;

public class ViewObservable {
    private final ArrayList<ViewObserver> observers=new ArrayList<>();

    public void addObserver(ViewObserver observer){
        synchronized (observer){
            observers.add(observer);
        }
    }
    public void sendNumPlayers(int num){
        synchronized (observers){
            for(ViewObserver observers:observers){
                observers.updatePlayersNum(num);
            }
        }
    }
    public void sendNewMessage(Message message){
        synchronized (observers){
            for(ViewObserver observer: observers){
                observer.updateMessage(message);
            }
        }
    }
}
//virtualView observable dal controller
//networkHandler Obserevable di eventi del model