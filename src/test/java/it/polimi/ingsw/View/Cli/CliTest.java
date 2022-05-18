package it.polimi.ingsw.View.Cli;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.view.Cli.Cli;
import org.junit.jupiter.api.Test;

class CliTest {

    @Test
    public void testInterfaccia(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("EZECHIEL",game);
        Game.newPlayer("EZRA",game);
        Cli cli = new Cli();
        cli.displayIslands(game);
        cli.displayEntrance(game, game.getPlayers().get(0));


        game.getPlayers().get(0).getDiningRoom().setNumGreen(7);
        game.getPlayers().get(0).getDiningRoom().setNumRed(4);
        game.getPlayers().get(0).getDiningRoom().setNumYellow(9);
        game.getPlayers().get(0).getDiningRoom().setNumPink(2);
        game.getPlayers().get(0).getDiningRoom().setNumBlue(0);

        game.getPlayers().get(1).getDiningRoom().setNumGreen(4);
        game.getPlayers().get(1).getDiningRoom().setNumRed(5);
        game.getPlayers().get(1).getDiningRoom().setNumYellow(3);
        game.getPlayers().get(1).getDiningRoom().setNumPink(2);
        game.getPlayers().get(1).getDiningRoom().setNumBlue(1);
        cli.displayDiningRoom(game, game.getPlayers().get(0));

        cli.displayCloud(game);

        game.getPlayers().get(0).getTowerSpace().setNumTower(3);
        game.getPlayers().get(1).getTowerSpace().setNumTower(5);
        cli.displayTowerSpace(game, 0);


        game.getProfTable().setGreenProf(1);
        game.getProfTable().setRedProf(0);
        game.getProfTable().setYellowProf(1);
        game.getProfTable().setPinkProf(0);
        game.getProfTable().setBlueProf(1);


        game.getPlayers().get(1).getDiningRoom().setNumRed(5);
        game.getPlayers().get(1).getDiningRoom().setNumYellow(3);
        game.getPlayers().get(1).getDiningRoom().setNumPink(2);
        game.getPlayers().get(1).getDiningRoom().setNumBlue(1);
        cli.displayProfTable(game);

        cli.displaySchoolBoard(game);
    }

}