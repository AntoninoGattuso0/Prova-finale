package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.ServerToClient.DisconnectionMessage;
import it.polimi.ingsw.network.Message.ServerToClient.WinnerMessage;

import java.util.ArrayList;

/**
 * This class is used to send broadcast messages to all clients.
 */
public class VirtualView {
    private final ArrayList<ClientHandlerInterface> clients = new ArrayList<>();
    private String actualPlayer;
    private final Object lock;

    public VirtualView() {
        this.lock = new Object();
    }

    public void addClientInVirtualView(ClientHandlerInterface client) {
            clients.add(client);
    }

    public ArrayList<ClientHandlerInterface> getClients() {
        return clients;
    }
    public void removeClientInVirtualView(ClientHandlerInterface client) {
        synchronized (lock) {
            clients.remove(client);
            lock.notifyAll();
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

    /**
     * When the game ends, send to everyone the messages with the winner-nickname and after close the server.
     * @param nick of the winning player.
     * @see #sendBroadcast(Message)
     * @see WinnerMessage#WinnerMessage(String)
     */
    public void updateWin(String nick) {
        System.out.println("The winner is " + nick + ", GameOver");
        sendBroadcast(new WinnerMessage(nick));
        System.exit(1);
    }
/**
 * Is used to send a message to everyone.
 */
    public synchronized void sendBroadcast(Message message) {
        synchronized (lock) {
            for (ClientHandlerInterface clientHandler : clients) {
                clientHandler.sendObject(message);
            }
            lock.notifyAll();
        }
    }

    public void sendAllQuitPlayer(String userNickname) {
        sendBroadcast(new DisconnectionMessage(userNickname));
    }

}