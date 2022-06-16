package it.polimi.ingsw.View.GUI;

import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.model.Game;

import it.polimi.ingsw.view.GUI.Gui;
import it.polimi.ingsw.view.View;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TestGui{
    @Test
    public void TestGui(){
        Game game=new Game(2,false);
        game.start(game);
        game.newPlayer("a",game);
        game.newPlayer("b",game);




    }


}