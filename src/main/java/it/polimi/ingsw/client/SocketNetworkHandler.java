package it.polimi.ingsw.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketNetworkHandler implements Runnable,NetworkHandler {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private final View view;
    private volatile boolean connected;
    private volatile boolean ready;
    private final MessageManager messageManager;
}
