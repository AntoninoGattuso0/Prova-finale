package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AntonioTest {
    @Test
    public void test1(){
        StudentBag studentBag= new StudentBag();
    Antonio antonio = new Antonio();
    assertEquals(4,antonio.getNumPawnAntonio());
    assertEquals(4,antonio.getBluePawn()+antonio.getGreenPawn()+antonio.getPinkPawn()+antonio.getRedPawn()+antonio.getYellowPawn());
    assertEquals(116,studentBag.getNum());
    }
    }


