package it.polimi.ingsw.network;
import java.io.*;
import java.net.*;

public class Server {
    ServerSocket server = null;
    Socket socketclient = null;
    ObjectInputStream in;
    ObjectOutputStream out;
    int port = 6987;
    public void comunica(){

    }
    public Socket attendi() {
        try {
            server = new ServerSocket(port);
            socketclient = server.accept();
            in = new ObjectInputStream(socketclient.getInputStream());
            out = new ObjectOutputStream(socketclient.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socketclient;
    }
    }
