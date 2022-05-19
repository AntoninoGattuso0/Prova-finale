package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.StartTurnMessage;
import it.polimi.ingsw.network.Message.WinnerMessage;
import it.polimi.ingsw.observer.ViewObservable;

import java.util.HashMap;
import java.util.Map;

public class VirtualView extends ViewObservable /*implements*/ {//DA COMPLETARE
    private final Map<String, ClientHandlerInterface>  clients= new HashMap<>();
    private String actualPlayer;
    private final Object lock;
    public VirtualView(){
        this.lock=new Object();
    }
    public void addClientInVirtualView(ClientHandlerInterface client, String nick){
        synchronized (lock){
            clients.put(nick,client);
            lock.notifyAll();
        }
    }
    public void removeClientInVirtualView(ClientHandlerInterface client, String nick){
        synchronized (lock){
            clients.remove(nick,client);
            lock.notifyAll();
        }
    }
    public void startTurn(){
        for(ClientHandlerInterface clientHandler: clients.values()){
            clientHandler.sendObject(new StartTurnMessage(actualPlayer));
        }
    }
    public void setActualPlayer(String actualPlayer) {
        this.actualPlayer = actualPlayer;
        clients.get(actualPlayer).setTurn(true);
    }
    public String getActualPlayer() {
        return actualPlayer;
    }

    public void playerWinForQuitting(String nick) {
        System.out.println(nick + " is the last Player in lobby. ");
        updateWin(nick);
    }
    public void updateWin(String nick){
        System.out.println("The winner is "+ nick+", GameOver");
        sendBroadcast(new WinnerMessage(nick));
    }
    public void sendBroadcast(Message message){
        synchronized (lock){
            for(ClientHandlerInterface clientHandler: clients.values()){
                clientHandler.sendObject(message);
            }
        }
    }

    public void sendAllQuitPlayer(String userNickname) {
    }

    public void sendDisconectionInSet(String userNickname) {

    }

    public void endTurn() {
        clients.get(actualPlayer).setTurn(false);
    }
}