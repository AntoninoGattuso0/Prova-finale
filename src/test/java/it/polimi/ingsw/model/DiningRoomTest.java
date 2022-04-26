package it.polimi.ingsw.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiningRoomTest {
    @Test
    public void testMovePawnToIsland(){
        Game.totPlayer=3;
        StudentBag studentBag = new StudentBag();
        DiningRoom diningRoom= new DiningRoom();
        Entrance entrance= new Entrance();
        assertEquals(7,entrance.greenPawn+entrance.redPawn+ entrance.yellowPawn+ entrance.pinkPawn+ entrance.bluePawn);
    }

}