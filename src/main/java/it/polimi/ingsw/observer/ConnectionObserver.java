package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.ClientHandlerInterface;

/**
 * This interface is used to implement the updateDisconnection() for ClientHandler and Lobby
 */
public interface ConnectionObserver {
    void updateDisconnection(ClientHandlerInterface client);
}
