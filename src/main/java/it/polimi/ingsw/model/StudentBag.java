package it.polimi.ingsw.model;

public class StudentBag {
    private int num;
    private int greenNum;
    private int redNum;
    private int yellowNum;
    private int pinkNum;
    private int blueNum;

    public StudentBag(){ //COSTRUTTORE STUDENTBAG: non ricordo il numero di pedine, modificatelo se il numero è sbagliato. -Nino
        this.greenNum=24;
        this.redNum=24;
        this.yellowNum=24;
        this.pinkNum=24;
        this.blueNum=24;
        this.num=greenNum+redNum+yellowNum+pinkNum+blueNum;
    }
    public void setGreenNum(int i){
       this.greenNum = i;
    }
    public int getGreenNum(){
        return this.greenNum;
    }
    public void setRedNum(int i){
        this.redNum = i;
    }
    public int getRedNum(){
        return this.redNum;
    }
    public void setYellowNum(int i){
        this.yellowNum = i;
    }
    public int getYellowNum(){
        return this.yellowNum;
    }
    public void setPinkNum(int i){
        this.pinkNum = i;
    }
    public int getPinkNum(){
        return this.pinkNum;
    }
    public void setBlueNum(int i){
        this.blueNum = i;
    }
    public int getBlueNum() {
        return this.blueNum;
    }

    public  int getNum(){
        return this.num;
    }
    public void setNum(int i){
        this.num = i;
    }

}
