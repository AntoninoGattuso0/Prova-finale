package it.polimi.ingsw.model;

public class StudentBag {
    private int num;
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
        num=blueNum+redNum+yellowNum+pinkNum+greenNum;
    }
    public void setGreenNum(int i){
       greenNum = i;
    }
    public int getGreenNum(){
        return greenNum;
    }
    public void setRedNumNum(int i){
        greenNum = i;
    }
    public int getRedNumNum(){
        return greenNum;
    }
    public void setYellowNum(int i){
        greenNum = i;
    }
    public int getYellowNum(){
        return greenNum;
    }
    public void setPinkNum(int i){
        greenNum = i;
    }
    public int getPinkNum(){
        return greenNum;
    }
    public void setBlueNum(int i){
        greenNum = i;
    }
    public int getBlueNum(){
        return greenNum;
    }
    public void modifyGreenNum(int i){
        greenNum += i;
    }
    public void modifyRedNum(int i){
        redNum += i;
    }
    public void modifyYellowNum(int i){
        yellowNum += i;
    }
    public void modifyPinkNum(int i){
        pinkNum += i;
    }
    public void modifyBlueNum(int i){
        blueNum += i;
    }
    public int getNum(){
        return num;
    }


}
