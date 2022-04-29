package it.polimi.ingsw.model;

public class StudentBag {
    private static int num;
    private int greenNum;
    private int redNum;
    private int yellowNum;
    private int pinkNum;
    private int blueNum;
    StudentBag(){ //COSTRUTTORE STUDENTBAG: non ricordo il numero di pedine, modificatelo se il numero è sbagliato. -Nino
        greenNum=24;
        redNum=24;
        yellowNum=24;
        pinkNum=24;
        blueNum=24;
        num=greenNum+redNum+yellowNum+pinkNum+blueNum;
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
    public void setYellow(int i){
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

    public static int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num = num;
    }

}
