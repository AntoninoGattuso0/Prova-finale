package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfTableTest {
    @Test
    public void testCheckProf(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Davide", game);
        Game.newPlayer("Isaac", game);
        game.players.get(0).diningRoom.setNumGreen(3);
        game.players.get(1).diningRoom.setNumGreen(1);
        game.players.get(0).diningRoom.setNumRed(4);
        game.players.get(1).diningRoom.setNumRed(2);
        game.players.get(0).diningRoom.setNumYellow(0);
        game.players.get(1).diningRoom.setNumYellow(2);
        game.players.get(0).diningRoom.setNumPink(5);
        game.players.get(1).diningRoom.setNumPink(7);
        game.players.get(0).diningRoom.setNumBlue(2);
        game.players.get(1).diningRoom.setNumBlue(9);
        game.moveProf();
        assertEquals(0,game.profTable.checkProf(0));
        assertEquals(0,game.profTable.checkProf(1));
        assertEquals(1,game.profTable.checkProf(2));
        assertEquals(1,game.profTable.checkProf(3));
        assertEquals(1,game.profTable.checkProf(4));
    }

    @Test
    public void testCheckProf2(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Davide", game);
        Game.newPlayer("Isaac", game);
        ProfTable.setGreenProf(0);
        ProfTable.setRedProf(0);
        ProfTable.setYellowProf(1);
        ProfTable.setPinkProf(1);
        ProfTable.setBlueProf(1);

        assertEquals(0, game.profTable.checkProf(0));
        assertEquals(0, game.profTable.checkProf(1));
        assertEquals(1, game.profTable.checkProf(2));
        assertEquals(1, game.profTable.checkProf(3));
        assertEquals(1, game.profTable.checkProf(4));
    }

}