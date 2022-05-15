package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.observer.ConnectionObserver;

public interface ClientHandlerIntefrace extends Runnable {//MODIFICA NOME IN VISTA DI ALTRI HANDLER, DA RIVEDERE
    void run();
    void sendObject(Object object);
    void setTurn(boolean myTurn);
    void setUserNickname(String userNickname);
    String getUserNickname();
    Message read();

    void addObserver(ConnectionObserver observer);
}
