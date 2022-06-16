package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * represents the Cloud and hos the number of Pawn
 */
public class Cloud {
    private int numPawn;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;
    public Cloud(){
        numPawn=0;
        greenPawn=0;
        redPawn=0;
        yellowPawn=0;
        pinkPawn=0;
        bluePawn=0;
    }
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

    /**
     * if the players are 2 or 4, the NumPawn on the cloud are 3, else are 4
     * @return the numPawn
     */
    public int requiredNumPawn(Game game) {
        if(game.totPlayer == 2 || game.totPlayer == 4)
            setNumPawn(3);
        else if (game.totPlayer == 3)
            setNumPawn(4);
         return getNumPawn();
    }
    public void refillCloud(StudentBag studentBag, Game game) {
        int i;
        Random rnd = new Random();
        ArrayList<ColorPawn> refillPawn = Game.createArrayPawn(studentBag);
        for (i = 0; i < requiredNumPawn(game); i++) {
            if (studentBag.getNum() > 0) {
                int random = rnd.nextInt(refillPawn.size());
                if (Objects.equals(refillPawn.get(random), ColorPawn.GREEN)) {
                        setGreenPawn(getGreenPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        studentBag.setNum(studentBag.getNum() - 1);
                        studentBag.setGreenNum(studentBag.getGreenNum() - 1);
                        if (studentBag.getGreenNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.RED)) {
                        setRedPawn(getRedPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        studentBag.setNum(studentBag.getNum() - 1);
                        studentBag.setRedNum(studentBag.getRedNum() - 1);
                        if (studentBag.getRedNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.YELLOW)) {
                        setYellowPawn(getYellowPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        studentBag.setNum(studentBag.getNum() - 1);
                        studentBag.setYellowNum(studentBag.getYellowNum() - 1);
                        if (studentBag.getYellowNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.PINK)) {
                        setPinkPawn(getPinkPawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        studentBag.setNum(studentBag.getNum() - 1);
                        studentBag.setPinkNum(studentBag.getPinkNum() - 1);
                        if (studentBag.getPinkNum() == 0) {
                            refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.BLUE)) {
                        setBluePawn(getBluePawn() + 1);
                        setNumPawn(getNumPawn() + 1);
                        studentBag.setNum(studentBag.getNum() - 1);
                        studentBag.setBlueNum(studentBag.getBlueNum()- 1);
                        if (studentBag.getBlueNum() == 0) {
                            refillPawn.remove(random);
                    }
                }
            }else{
                return;
            }
        }
    }
}
