package it.polimi.ingsw.network;
import java.io.*;
import java.net.*;

public class Server implements Runnable {
    ServerSocket serverSocket;
    private final WaitingRoom waitingRoom;
    int port;

    public Server(int port) {
        this.port = port;
        this.waitingRoom = new WaitingRoom(DEFAUL_SIZE);
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
            ClientHandler client= new Client(socket);
            socket.run();
            waitingRoom.addClient(client);
        } catch (IOException e) {
            System.out.println("SERVER: restarting server.");
        }
    }
}
}
