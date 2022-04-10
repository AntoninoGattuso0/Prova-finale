package it.polimi.ingsw.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class GameTest extends TestCase {
    @Test
    Island island = null;
    ArrayList<Island>islands = new ArrayList<>(12);
    int n;
    public void testMotherNature(){
        island = new Island();
        assertEquals(true, islands.get(n).isMotherNature());
    }
}