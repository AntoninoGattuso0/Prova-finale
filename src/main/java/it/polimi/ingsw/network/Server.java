package it.polimi.ingsw.network;
import java.io.*;
import java.net.*;

public class Server implements Runnable {
    private ServerSocket serverSocket;
    private final Lobby lobby;
    int port;

    public Server(int port) {
        this.port = port;
        lobby= new Lobby();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("SERVER SOCKET CLOSED!");
        }
    while(true){
        try{
        System.out.println("SERVER: Waiting client connection.");
            Socket socket= serverSocket.accept();
            System.out.println("SERVER: Client connected.");
            Handler client= new Client(socket);
            client.run();
            lobby.addClient(client);
        } catch (IOException e) {
            System.out.println("SERVER: restarting server.");
        }
    }
}
}
