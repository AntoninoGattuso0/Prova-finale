/* package it.polimi.ingsw.Networking;

import it.polimi.ingsw.network.ClientHandler;
import it.polimi.ingsw.network.ClientHandlerInterface;
import it.polimi.ingsw.network.Server;
import org.junit.jupiter.api.Test;

import java.net.Socket;

public class ClientServerTest {
    @Test
    public void serverTest(){
        Server server=new Server(4000);
        server.run();
        ClientHandlerInterface clientHandler=new ClientHandler(new Socket());
        clientHandler.run();
        server.getLobby().loginUser(clientHandler);
    }
}
*/