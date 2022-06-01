package it.polimi.ingsw.client;

import it.polimi.ingsw.view.Cli.Cli;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Cli cli=new Cli();
        SocketNetworkHandler socketNetworkHandler=new SocketNetworkHandler(cli);
        socketNetworkHandler.updateConnection("localhost", String.valueOf(4000));
        cli.run();
        socketNetworkHandler.run();
    }
}
