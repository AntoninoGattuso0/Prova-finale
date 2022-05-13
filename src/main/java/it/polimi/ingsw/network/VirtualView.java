package it.polimi.ingsw.network;

import it.polimi.ingsw.observer.ViewObservable;

import java.util.HashMap;
import java.util.Map;

public class VirtualView extends ViewObservable {//DA COMPLETARE
    private final Map<String, ClientHandlerIntefrace>  clients= new HashMap<>();
    private String actualPlayer;
    private final Object lock;
    public VirtualView(){
        this.lock=new Object();
    }
    public void addClientInVirtualView(ClientHandlerIntefrace client, String nick){
        synchronized (lock){
            clients.put(nick,client);
            lock.notifyAll();
        }
    }
    public void removeClientInVirtualView(ClientHandlerIntefrace client, String nick){
        synchronized (lock){
            clients.remove(nick,client);
            lock.notifyAll();
        }
    }
    public void setActualPlayer(String actualPlayer) {
        this.actualPlayer = actualPlayer;
        clients.get(actualPlayer).setTurn(true);
    }
    public String getActualPlayer() {
        return actualPlayer;
    }
}