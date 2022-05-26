package it.polimi.ingsw.client;

import it.polimi.ingsw.view.Cli.Cli;

public class ClientMain {
    public static void main(String[] args) {
        Cli cli=new Cli();
        SocketNetworkHandler socketNetworkHandler=new SocketNetworkHandler(cli);
        socketNetworkHandler.updateConnection("localhost", String.valueOf(4000));
        socketNetworkHandler.run();
    }
}
