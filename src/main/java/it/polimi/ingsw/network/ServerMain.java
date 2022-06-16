package it.polimi.ingsw.network;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;

public class ServerMain {
    /**
     * start the Server and print the Address
     * @see Server
     */
    public static void main(String[] args) throws IOException {
        Server server=new Server(4000);
        InetAddress address= InetAddress.getByAddress(Inet4Address.getLocalHost().getAddress());
        System.out.println("l'indirizzo ip del server è: " + address);
        server.start();
    }
}
