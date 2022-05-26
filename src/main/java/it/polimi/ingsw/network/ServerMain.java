package it.polimi.ingsw.network;

public class ServerMain {
    public static void main(String[] args) {
        Server server=new Server(4000);
        server.start();
    }
}
