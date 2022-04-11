package it.polimi.ingsw.model;

public class  StudentBag {
    static protected int num;
    static protected int greenNum;
    static protected int redNum;
    static protected int yellowNum;
    static protected int pinkNum;
    static protected int blueNum;

    static public boolean checkNum(){
        if (StudentBag.num=='0')
            return true;
        return false;
    }
}
