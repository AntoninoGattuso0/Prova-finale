package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class IslandTest {

    @Test
    public void testIsland(){
        Island island = new Island();
        assertFalse(island.isMotherNature);
        assertEquals(0, island.greenPawn);
        assertEquals(0, island.redPawn);
        assertEquals(0, island.yellowPawn);
        assertEquals(0, island.pinkPawn);
        assertEquals(0, island.bluePawn);
        assertFalse(island.isTower);
        assertNull(island.colorTower);
        assertFalse(island.isProhibited);
        assertEquals(1, island.totIsland);
    }

}