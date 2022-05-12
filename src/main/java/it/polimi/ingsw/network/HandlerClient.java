package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;

public interface HandlerClient extends Runnable {//MODIFICA NOME IN VISTA DI ALTRI HANDLER, DA RIVEDERE
    void run();
    void sendObject(Object object);
    void setTurn(boolean myTurn);
    void setUserNickname(String userNickname);
    String getUserNickname();
    Message read();
}
