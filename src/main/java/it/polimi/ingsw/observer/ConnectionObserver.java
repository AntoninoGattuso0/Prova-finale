package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.ClientHandlerIntefrace;

public interface ConnectionObserver {
    void updateDisconnection(ClientHandlerIntefrace client);
}
