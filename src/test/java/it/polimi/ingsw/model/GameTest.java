package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testStart(){
        Game.totPlayer = 3;
        Game.start();
        assertEquals(Game.players.size(), 2);
    }
}