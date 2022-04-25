package it.polimi.ingsw.model;

public class StudentBag {
    static protected int num;
    static protected int greenNum;
    static protected int redNum;
    static protected int yellowNum;
    static protected int pinkNum;
    static protected int blueNum;
    StudentBag(){ //COSTRUTTORE STUDENTBAG: non ricordo il numero di pedine, modificatelo se il numero è sbagliato. -Nino
        greenNum=26;
        redNum=26;
        yellowNum=26;
        pinkNum=26;
        blueNum=26;
        num=blueNum+redNum+yellowNum+pinkNum+greenNum;
    }
}
