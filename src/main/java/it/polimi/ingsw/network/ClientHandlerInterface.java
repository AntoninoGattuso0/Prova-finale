package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.observer.ConnectionObserver;

public interface ClientHandlerInterface extends Runnable, ConnectionObserver {
    void sendObject(Message object);
    void setTurn(boolean myTurn);
    void setUserNickname(String userNickname);
    String getUserNickname();
    void readFromClient();
    Message read();
    void run();
    void closeConnect(String nickname);
}
