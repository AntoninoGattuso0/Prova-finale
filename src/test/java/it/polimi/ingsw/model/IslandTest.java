package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class IslandTest {

    @Test
    public void testIsland(){
        Island island = new Island();
        assertFalse(island.getMotherNature());
        assertEquals(0, island.getGreenPawn());
        assertEquals(0, island.getRedPawn());
        assertEquals(0, island.getYellowPawn());
        assertEquals(0, island.getPinkPawn());
        assertEquals(0, island.getBluePawn());
        assertFalse(island.getTower());
        assertNull(island.getColorTower());
        assertFalse(island.getProhibited());
        assertEquals(1, island.getTotIsland());
    }

}