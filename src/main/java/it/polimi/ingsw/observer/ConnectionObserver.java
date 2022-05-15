package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.ClientHandler;

public interface ConnectionObserver {
    void updateDisconnection(ClientHandler client);
}
