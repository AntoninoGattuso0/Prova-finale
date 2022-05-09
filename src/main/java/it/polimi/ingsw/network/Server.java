package it.polimi.ingsw.network;
import java.io.*;
import java.net.*;

public class Server {
    ServerSocket server = null;
    Socket socketclient = null;
    DataInputStream in;
    DataOutputStream out;
    int port = 6987;
    public void comunica(){

    }
    public Socket attendi() {
        try {
            server = new ServerSocket(port);
            socketclient = server.accept();
            in = new DataInputStream(socketclient.getInputStream());
            out = new DataOutputStream(socketclient.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socketclient;
    }
    }
