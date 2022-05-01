package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentBagTest {
    @Test
    public void testStudentBag(){
        StudentBag studentBag = new StudentBag();
        assertEquals(120, studentBag.getNum());
        assertEquals(24, studentBag.getGreenNum());
        assertEquals(24, studentBag.getRedNum());
        assertEquals(24, studentBag.getYellowNum());
        assertEquals(24, studentBag.getPinkNum());
        assertEquals(24, studentBag.getBlueNum());
    }

}