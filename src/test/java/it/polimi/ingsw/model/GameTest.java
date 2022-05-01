package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testStart(){
        Game game = new Game(4, true);
        assertEquals(4, game.getTotPlayer());
    }
}