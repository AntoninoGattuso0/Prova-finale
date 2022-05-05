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
        game.moveProf();
        assertEquals(0,game.profTable.checkProf(0));
    }

}