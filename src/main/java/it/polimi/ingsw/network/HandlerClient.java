package it.polimi.ingsw.network;

public interface HandlerClient extends Runnable {//MODIFICA NOME IN VISTA DI ALTRI HANDLER, DA RIVEDERE
    void run();
    void sendObject(Object object);
    void setTurn(boolean myTurn);
    void setUserNickname(String userNickname);
    String getUserNickname();
    Message read();
}
