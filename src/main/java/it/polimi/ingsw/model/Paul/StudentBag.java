package it.polimi.ingsw.model.Paul;

public class StudentBag {
    private int num;
    private int greenNum;
    private int redNum;
    private int yellowNum;
    private int pinkNum;
    private int blueNum;

    public boolean checkNum(int num){
        if (num=='0')
            return true;
        return false;
    }
}
