package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AntonioTest {
    @Test
    public void test1(){
        StudentBag studentBag= new StudentBag();
    Antonio antonio = new Antonio();

    assertEquals(4,antonio.numPawnAntonio);
    assertEquals(4,antonio.greenPawn+antonio.bluePawn+antonio.pinkPawn+antonio.redPawn+antonio.yellowPawn);
    assertEquals(116,studentBag.num);
    }
    }


