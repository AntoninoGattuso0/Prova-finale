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


        game.getPlayers().get(0).getDiningRoom().setNumGreen(10);
        game.getPlayers().get(0).getDiningRoom().setNumRed(1);
        game.getPlayers().get(0).getDiningRoom().setNumYellow(4);
        game.getPlayers().get(0).getDiningRoom().setNumPink(5);
        game.getPlayers().get(0).getDiningRoom().setNumBlue(3);

        game.getPlayers().get(1).getDiningRoom().setNumGreen(4);
        game.getPlayers().get(1).getDiningRoom().setNumRed(5);
        game.getPlayers().get(1).getDiningRoom().setNumYellow(3);
        game.getPlayers().get(1).getDiningRoom().setNumPink(2);
        game.getPlayers().get(1).getDiningRoom().setNumBlue(1);
        cli.displayDiningRoom(game);

        cli.displayCloud(game);

        game.getPlayers().get(0).getTowerSpace().setNumTower(6);
        game.getPlayers().get(1).getTowerSpace().setNumTower(5);
        cli.displayTowerSpace(game);
    }

}