package it.polimi.ingsw.network;
import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private final Lobby lobby;
    int port;
    private ServerMessageMenager serverMessageMenager;
    public Server(int port) {
        this.port = port;
        lobby= new Lobby();
        serverMessageMenager= new ServerMessageMenager(lobby);

    }

    public Lobby getLobby() {
        return lobby;
    }

    public void start() throws IOException {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("SERVER SOCKET CLOSED!");
        }
    while(true){
            try {
                    System.out.println("SERVER: Waiting client connection.");
                    if (!lobby.isLobbyOk()) {
                        Socket socket = serverSocket.accept();
                        System.out.println("SERVER: Client connected.");
                        ClientHandlerInterface client = (ClientHandlerInterface) new ClientHandler(socket, getLobby());
                        client.run();
                    } else if (getLobby().getClients().size() != getLobby().getPlayers().size()) {
                        serverSocket.close();
                        System.out.println("Server closed");
                        break;
                    }
            } catch (IOException e) {
                System.out.println("SERVER: restarting server.");
            }
    }
}

    public void close() throws IOException {
        serverSocket.close();
    }
}
