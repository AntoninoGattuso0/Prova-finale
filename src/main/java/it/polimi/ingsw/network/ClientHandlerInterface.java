package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.observer.ConnectionObserver;

public interface ClientHandlerInterface extends Runnable, ConnectionObserver {//MODIFICA NOME IN VISTA DI ALTRI HANDLER, DA RIVEDERE
    void sendObject(Message object);
    void setTurn(boolean myTurn);
    void setUserNickname(String userNickname);
    String getUserNickname();
    void readFromClient();
    Message read();
    void addObserver(ConnectionObserver observer);
    void run();
}
