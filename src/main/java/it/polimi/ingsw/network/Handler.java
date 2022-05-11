package it.polimi.ingsw.network;

public interface Handler extends Runnable {
    void run();
    void sendObject(Object object);
    void setTurn(boolean myTurn);
    void setUserNickname(String userNickname);
    String getUserNickname();
    Message read();
}
