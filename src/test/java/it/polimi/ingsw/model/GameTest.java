package it.polimi.ingsw.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class GameTest extends TestCase {
    @Test
    public void testStart(){
        Game.totPlayer = 2;
        Game.start();
        assertEquals(2, Game.totPlayer);
    }
}