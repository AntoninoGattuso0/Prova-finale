package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.ClientHandler;

public interface EndGameObserver {
    void administrEndGame();
    void administrDisconnectionInLobby(ClientHandler clientHandler);
}
