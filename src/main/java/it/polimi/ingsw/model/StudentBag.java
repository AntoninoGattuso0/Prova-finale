package it.polimi.ingsw.model;

public class StudentBag {
    private static int num;
    private static int greenNum;
    private static int redNum;
    private static int yellowNum;
    private static int pinkNum;
    private static int blueNum;
    StudentBag(){ //COSTRUTTORE STUDENTBAG: non ricordo il numero di pedine, modificatelo se il numero è sbagliato. -Nino
        greenNum=24;
        redNum=24;
        yellowNum=24;
        pinkNum=24;
        blueNum=24;
        num=greenNum+redNum+yellowNum+pinkNum+blueNum;
    }
    public static void setGreenNum(int i){
       greenNum = i;
    }
    public static int getGreenNum(){
        return greenNum;
    }
    public static void setRedNum(int i){
        redNum = i;
    }
    public static int getRedNum(){
        return redNum;
    }
    public static void setYellowNum(int i){
        yellowNum = i;
    }
    public static int getYellowNum(){
        return yellowNum;
    }
    public static void setPinkNum(int i){
        pinkNum = i;
    }
    public static int getPinkNum(){
        return pinkNum;
    }
    public static void setBlueNum(int i){
        blueNum = i;
    }
    public static int getBlueNum() {
        return blueNum;
    }

    public static int getNum(){
        return num;
    }
    public static void setNum(int i){
        num = i;
    }

}
