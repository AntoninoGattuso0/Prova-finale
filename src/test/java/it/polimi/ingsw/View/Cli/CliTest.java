package it.polimi.ingsw.View.Cli;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.view.Cli.Cli;
import org.junit.jupiter.api.Test;

class CliTest {

    @Test
    public void testTitle(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("EZECHIEL",game);
        Game.newPlayer("EZRA",game);
        Cli cli = new Cli();

        cli.init();
    }

    @Test
    public void testIsland(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("EZECHIEL",game);
        Game.newPlayer("EZRA",game);
        Cli cli = new Cli();
        cli.displayIslands();

    }

    @Test
    public void testCloud(){
        Game game = new Game(3, true);
        game.start(game);
        Game.newPlayer("EZECHIEL",game);
        Game.newPlayer("EZRA",game);
        Game.newPlayer("CANDACE",game);
        Cli cli = new Cli();
        cli.displayCloud();
    }

    @Test
    public void testSchoolBoard(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("EZECHIEL",game);
        Game.newPlayer("EZRA",game);
        Cli cli = new Cli();
        //setter DiningRoom
        game.getPlayers().get(0).getDiningRoom().setNumGreen(7);
        game.getPlayers().get(0).getDiningRoom().setNumRed(4);
        game.getPlayers().get(0).getDiningRoom().setNumYellow(9);
        game.getPlayers().get(0).getDiningRoom().setNumPink(2);
        game.getPlayers().get(0).getDiningRoom().setNumBlue(0);

        game.getPlayers().get(1).getDiningRoom().setNumGreen(4);
        game.getPlayers().get(1).getDiningRoom().setNumRed(5);
        game.getPlayers().get(1).getDiningRoom().setNumYellow(3);
        game.getPlayers().get(1).getDiningRoom().setNumPink(2);
        game.getPlayers().get(1).getDiningRoom().setNumBlue(3);

        //setter TowerSpace
        game.getPlayers().get(0).getTowerSpace().setNumTower(7);
        game.getPlayers().get(1).getTowerSpace().setNumTower(-1);

        //setter ProfTable
        game.getProfTable().setGreenProf(1);
        game.getProfTable().setRedProf(0);
        game.getProfTable().setYellowProf(1);
        game.getProfTable().setPinkProf(0);
        game.getProfTable().setBlueProf(-1);

        cli.displaySchoolBoard();
    }

    @Test
    public void testAssistantCard(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("EZECHIEL",game);
        Game.newPlayer("EZRA",game);
        Cli cli = new Cli();

        cli.displayAssistantCard();
    }
}