package it.polimi.ingsw.model;

import java.util.*;

public class Cloud {
    protected int numPawn;    //sono inizializzati da qualche parte?
    protected int greenPawn;
    protected int redPawn;
    protected int yellowPawn;
    protected int pinkPawn;
    protected int bluePawn;

    public void getNumPlayer() {
        int numPawn;
    }      //che fa? mi sa che devi mettere return

    public void refillCloud() {
        int i;
        Random rnd = new Random();
        ArrayList<String> refillPawn = Game.createArrayPawn();
        for (i = 0; i < numPawn; i++) {
            if (StudentBag.num > 0) {
                int random = rnd.nextInt(refillPawn.size());
                String color = Game.m.get(random);
                if (Objects.equals(refillPawn.get(random), "GREEN")) {
                    greenPawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.greenNum--;
                    if(StudentBag.greenNum==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "RED")) {
                    redPawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.redNum--;
                    if(StudentBag.redNum==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "YELLOW")) {
                    yellowPawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.yellowNum--;
                    if(StudentBag.yellowNum==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "PINK")) {
                    pinkPawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.pinkNum--;
                    if(StudentBag.pinkNum==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "BLUE")) {
                    bluePawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.blueNum--;
                    if(StudentBag.blueNum==0){
                        refillPawn.remove(random);
                    }
                }
            }
        }
    }
}
