package it.polimi.ingsw.model;

import java.util.*;

import static it.polimi.ingsw.model.StudentBag.getGreenNum;
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

    public void refillCloud() {
        int i;
        Random rnd = new Random();
        ArrayList<String> refillPawn = Game.createArrayPawn();
        for (i = 0; i < getNumPawn(); i++) {
            if (StudentBag.getNum() > 0) {
                int random = rnd.nextInt(refillPawn.size());
                String color = Game.m.get(random);
                if (Objects.equals(refillPawn.get(random), "GREEN")) {
                        setGreenPawn(getGreenNum() + 1);
                        setNumPawn(getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setGreenNum(StudentBag.getGreenNum() - 1);
                        if (StudentBag.getGreenNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "RED")) {
                        setRedPawn(getRedPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setRedNum(StudentBag.getRedNum() - 1);
                        if (StudentBag.getRedNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "YELLOW")) {
                        setYellowPawn(getYellowPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setYellowNum(StudentBag.getYellowNum() - 1);
                        if (StudentBag.getYellowNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "PINK")) {
                        setPinkPawn(getPinkPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setPinkNum(StudentBag.getPinkNum() - 1);
                        if (StudentBag.getPinkNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "BLUE")) {
                        setBluePawn(getBluePawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setBlueNum(StudentBag.getBlueNum()- 1);
                        if (StudentBag.getBlueNum() == 0) {
                            refillPawn.remove(random);
                    }
                }
            }
        }
    }
}
