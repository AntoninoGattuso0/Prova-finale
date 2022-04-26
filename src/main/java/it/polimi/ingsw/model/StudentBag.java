package it.polimi.ingsw.model;

public class StudentBag {
    static protected int num;
    static protected int greenNum;
    static protected int redNum;
    static protected int yellowNum;
    static protected int pinkNum;
    static protected int blueNum;
    StudentBag(){ //COSTRUTTORE STUDENTBAG: non ricordo il numero di pedine, modificatelo se il numero è sbagliato. -Nino
        greenNum=24;
        redNum=24;
        yellowNum=24;
        pinkNum=24;
        blueNum=24;
        num=blueNum+redNum+yellowNum+pinkNum+greenNum;
    }
}
