package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentBagTest {
    @Test
    public void test1(){
        StudentBag studentbag = new StudentBag();
        assertEquals(120, StudentBag.getNum());
    }

}