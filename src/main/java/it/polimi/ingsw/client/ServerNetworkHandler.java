package it.polimi.ingsw.client;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.Message.ClientAcceptedMessage;
import it.polimi.ingsw.network.Message.Ping;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.NetworkChannel;

public class ServerNetworkHandler implements Runnable, SocketNetworkHandler {
    private final  View view;
    public ServerMessagesManager(View view){
        this.view=view;
    }
    public void manageInputFromServer(Object in){
        if(in instanceof Ping){
            return;
        }
        if(in instanceof ClientAcceptedMessage){
            
        }
    }
}
