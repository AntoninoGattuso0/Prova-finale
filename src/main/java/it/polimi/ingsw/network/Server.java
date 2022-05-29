package it.polimi.ingsw.network;
import java.io.*;
import java.net.*;

public class Server {//DA RIVEDERE
    private ServerSocket serverSocket;
    private final Lobby lobby;
    int port;
    private final ServerMessageMenager serverMessageMenager;
    public Server(int port) {
        this.port = port;
        lobby= new Lobby();
        this.serverMessageMenager = new ServerMessageMenager(lobby);

    }

    public Lobby getLobby() {
        return lobby;
    }

    public void start() {
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
            ClientHandlerInterface client= (ClientHandlerInterface) new ClientHandler(socket,getLobby());
            client.run();
        } catch (IOException e) {
            System.out.println("SERVER: restarting server.");
        }
    }
}
}
