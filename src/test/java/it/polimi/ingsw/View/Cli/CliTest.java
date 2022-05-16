package it.polimi.ingsw.View.Cli;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.view.Cli.Cli;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CliTest {

    @Test
    public void testInterfaccia(){
        Game game = new Game(3, true);
        game.start(game);
        Cli cli = new Cli();
        cli.displayIslands(game);
    }

}