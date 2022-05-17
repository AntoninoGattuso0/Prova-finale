package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.ClientHandlerInterface;

public interface ConnectionObserver {
    void updateDisconnection(ClientHandlerInterface client);
}
