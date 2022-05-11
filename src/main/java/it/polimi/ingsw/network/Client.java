package it.polimi.ingsw.network;

import java.io.*;
import java.net.*;

public class Client implements Runnable {

    Socket mySocket = null;
    ObjectInputStream in;
    ObjectOutputStream out;
    private final int port;

    public Client(int port){
        this.port = port;
    }

    public void run() {
        try {
            Socket mySocket = new Socket(InetAddress.getLocalHost(), port);
            in = new ObjectInputStream(mySocket.getInputStream());
            out = new ObjectOutputStream(mySocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}