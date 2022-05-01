package it.polimi.ingsw.model;
import java.util.*;
public class Cloud {
    private int numPawn;    //sono inizializzati da qualche parte?
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;
    public int getNumPawn() {
        return numPawn;
    }
    public int getYellowPawn() {
        return yellowPawn;
    }
    public int getRedPawn() {
        return redPawn;
    }
    public int getPinkPawn() {
        return pinkPawn;
    }
    public int getGreenPawn() {
        return greenPawn;
    }
    public int getBluePawn() {
        return bluePawn;
    }
    public void setYellowPawn(int yellowPawn) {
        this.yellowPawn = yellowPawn;
    }
    public void setRedPawn(int redPawn) {
        this.redPawn = redPawn;
    }
    public void setPinkPawn(int pinkPawn) {
        this.pinkPawn = pinkPawn;
    }
    public void setGreenPawn(int greenPawn) {
        this.greenPawn = greenPawn;
    }
    public void setBluePawn(int bluePawn) {
        this.bluePawn = bluePawn;
    }
    public void setNumPawn(int numPawn) {
        this.numPawn = numPawn;
    }
    public void refillCloud(StudentBag studentBag) {
        int i;
        Random rnd = new Random();
        ArrayList<String> refillPawn = Game.createArrayPawn(studentBag);
        for (i = 0; i < getNumPawn(); i++) {
            if (studentBag.getNum() > 0) {
                int random = rnd.nextInt(refillPawn.size());
                String color = Game.m.get(random);
                if (Objects.equals(refillPawn.get(random), "GREEN")) {
                        setGreenPawn(getGreenPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                    studentBag.setNum(studentBag.getNum() - 1);
                    studentBag.setGreenNum(studentBag.getGreenNum() - 1);
                        if (studentBag.getGreenNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "RED")) {
                        setRedPawn(getRedPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                    studentBag.setNum(studentBag.getNum() - 1);
                    studentBag.setRedNum(studentBag.getRedNum() - 1);
                        if (studentBag.getRedNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "YELLOW")) {
                        setYellowPawn(getYellowPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                    studentBag.setNum(studentBag.getNum() - 1);
                    studentBag.setYellowNum(studentBag.getYellowNum() - 1);
                        if (studentBag.getYellowNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "PINK")) {
                        setPinkPawn(getPinkPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        studentBag.setNum(studentBag.getNum() - 1);
                        studentBag.setPinkNum(studentBag.getPinkNum() - 1);
                        if (studentBag.getPinkNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "BLUE")) {
                        setBluePawn(getBluePawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        studentBag.setNum(studentBag.getNum() - 1);
                        studentBag.setBlueNum(studentBag.getBlueNum()- 1);
                        if (studentBag.getBlueNum() == 0) {
                            refillPawn.remove(random);
                    }
                }
            }
        }
    }
}
