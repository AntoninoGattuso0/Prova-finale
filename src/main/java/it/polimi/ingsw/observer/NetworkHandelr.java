package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.Message.Message;

import java.io.IOException;

public interface NetworkHandelr extends Runnable {
    void updateMessage(Message message) throws IOException;
    void updateConnection(String ip,String port);
    void closeConnection();
}
