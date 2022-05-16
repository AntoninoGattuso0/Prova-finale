package it.polimi.ingsw.View.Cli;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.view.Cli.Cli;
import org.junit.jupiter.api.Test;

class CliTest {

    @Test
    public void testInterfaccia(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Player0",game);
        Game.newPlayer("Player1",game);
        Cli cli = new Cli();
        cli.displayIslands(game);
        cli.displayEntrance(game);
        cli.displayCloud(game);
    }

}