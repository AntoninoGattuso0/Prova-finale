package it.polimi.ingsw.network;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class ServerMain {
    /**
     * start the Server and print the Address
     *
     * @see Server
     */
    public static void main(String[] args) throws IOException {
        Server server = new Server(4000);
        InetAddress address = InetAddress.getByAddress(Inet4Address.getLocalHost().getAddress());
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();
            // drop inactive
            if (!networkInterface.isUp())
                continue;
            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                System.out.println(String.format("NetInterface: name '%s', ip: %s",
                        networkInterface.getDisplayName(), addr.getHostAddress()));
            }
        }
        //System.out.println("l'indirizzo ip del server è: " + address);
        server.start();
    }
}
