package it.polimi.ingsw.network;

import java.io.*;
import java.net.*;

public class Client {
    Socket mySocket = null;
    DataInputStream in;
    DataOutputStream out;
    int port = 6987;
    public void comunica(){

    }
    public Socket connection() {
        try {
            Socket mySocket = new Socket(InetAddress.getLocalHost(), port);
            in = new DataInputStream(mySocket.getInputStream());
            out = new DataOutputStream(mySocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mySocket;
    }
}
