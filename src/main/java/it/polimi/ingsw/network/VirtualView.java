package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.ServerToClient.StartTurnMessage;
import it.polimi.ingsw.network.Message.ServerToClient.WinnerMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VirtualView {
    private final ArrayList<ClientHandlerInterface> clients = new ArrayList<>();
    private String actualPlayer;
    private final Object lock;

    public VirtualView() {
        this.lock = new Object();
    }

    public void addClientInVirtualView(ClientHandlerInterface client, String nick) {
        synchronized (lock) {
            clients.add(client);
            lock.notifyAll();
        }
    }
    public void removeClientInVirtualView(ClientHandlerInterface client, String nick) {
        synchronized (lock) {
            clients.remove(client);
            lock.notifyAll();
        }
    }
    public void startTurn() {
        for (ClientHandlerInterface clientHandler :clients) {
            clientHandler.sendObject(new StartTurnMessage());
        }
    }

    public void setActualPlayer(String actualPlayer) {
        this.actualPlayer = actualPlayer;
        int i;
        for(i=0;i<clients.size();i++){
            if(clients.get(i).getUserNickname().equals(actualPlayer)){
                clients.get(i).setTurn(true);
            }
        }
    }

    public String getActualPlayer() {
        return actualPlayer;
    }

    public void playerWinForQuitting(String nick) {
        System.out.println(nick + " is the last Player in lobby. ");
        updateWin(nick);
    }

    public void updateWin(String nick) {
        System.out.println("The winner is " + nick + ", GameOver");
        sendBroadcast(new WinnerMessage(nick));
    }

    public void sendBroadcast(Message message) {
        synchronized (lock) {
            for (ClientHandlerInterface clientHandler : clients.values()) {
                clientHandler.sendObject(message);
            }
            lock.notifyAll();
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