package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Antonio extends CharacterCard{
    protected int numPawnAntonio;
    protected int greenPawn;
    protected int redPawn;
    protected int yellowPawn;
    protected int pinkPawn;
    protected int bluePawn;
    public void checkStudent(int numPawnAntonio){
        Random rnd = new Random();
        ArrayList<String> refillPawn = Game.createArrayPawn();
        if (StudentBag.num > 0) {
            int random = rnd.nextInt(refillPawn.size());
            String color = Game.m.get(random);
            if (Objects.equals(refillPawn.get(random), "GREEN")) {
                greenPawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.greenNum--;
                if(StudentBag.greenNum==0){
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "RED")) {
                redPawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.redNum--;
                if(StudentBag.redNum==0){
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "YELLOW")) {
                yellowPawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.yellowNum--;
                if(StudentBag.yellowNum==0){
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "PINK")) {
                pinkPawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.pinkNum--;
                if(StudentBag.pinkNum==0){
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "BLUE")) {
                bluePawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.blueNum--;
                if(StudentBag.blueNum==0){
                    refillPawn.remove(random);
                }
            }
        }
    }
    public void moveStudent(){
        //copiare metodo dello spostamento di studente sull'isola
    }
}
