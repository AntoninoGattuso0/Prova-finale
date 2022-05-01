package it.polimi.ingsw.model;
public class StudentBag {
    private int num;
    private int greenNum;
    private int redNum;
    private int yellowNum;
    private int pinkNum;
    private int blueNum;
    public StudentBag(){
        setNum(120);
        setYellowNum(24);
        setRedNum(24);
        setGreenNum(24);
        setPinkNum(24);
        setBlueNum(24);
    }
    public void setGreenNum(int i){
       greenNum = i;
    }
    public int getGreenNum(){
        return greenNum;
    }
    public void setRedNum(int i){
        redNum = i;
    }
    public int getRedNum(){
        return redNum;
    }
    public void setYellowNum(int i){
        yellowNum = i;
    }
    public int getYellowNum(){
        return yellowNum;
    }
    public void setPinkNum(int i){
        pinkNum = i;
    }
    public int getPinkNum(){
        return pinkNum;
    }
    public void setBlueNum(int i){
        blueNum = i;
    }
    public int getBlueNum() {
        return blueNum;
    }
    public  int getNum(){
        return num;
    }
    public void setNum(int i){
        num = i;
    }

}
