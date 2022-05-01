package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Antonio extends UseEffect{
    private int coinPrice;
    private int numPawnAntonio;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;
    public Antonio(StudentBag studentBag){ //COSTRUTTORE ANTONIO: manca l'inizializzazione del prezzo. Non so come fare visto che CharacterCard è una classe astratta -Nino
        coinPrice=1;
        numPawnAntonio=0;
        greenPawn=0;
        redPawn=0;
        yellowPawn=0;
        pinkPawn=0;
        bluePawn=0;
        while(numPawnAntonio<4){
            Random rnd = new Random();
            ArrayList<String> refillPawn = Game.createArrayPawn(studentBag);
            if (studentBag.getNum() > 0) {
                int random = rnd.nextInt(refillPawn.size());
                if (Objects.equals(refillPawn.get(random), "GREEN")) {
                    setGreenPawn(getGreenPawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setGreenNum(studentBag.getGreenNum()-1);
                    if(studentBag.getGreenNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "RED")) {
                    setRedPawn(getRedPawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setRedNum(studentBag.getRedNum()-1);
                    if(studentBag.getRedNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "YELLOW")) {
                    setYellowPawn(getYellowPawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setYellowNum(studentBag.getYellowNum()-1);
                    if(studentBag.getYellowNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "PINK")) {
                    setPinkPawn(getPinkPawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setPinkNum(studentBag.getPinkNum()-1);
                    if(studentBag.getPinkNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "BLUE")) {
                    setBluePawn(getBluePawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setBlueNum(getBluePawn()-1);
                    if(studentBag.getBlueNum()==0){
                        refillPawn.remove(random);
                    }
                }
            }
        }
    }

    public void useEffectAntonio(Game game, int i,Island island,Player player,ArrayList<ColorPawn> colorPawn) {
        if (Objects.equals(colorPawn.toString(), "GREEN") && getGreenPawn() > 0) {  //altrimenti cosa succede se la pedina verde non c'è?
            island.setGreenPawn(island.getGreenPawn() + 1);
            setGreenPawn(getGreenPawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else if (Objects.equals(colorPawn.toString(), "RED") && getRedPawn() > 0) {
            island.setRedPawn(island.getRedPawn() + 1);
            setRedPawn(getRedPawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else if (Objects.equals(colorPawn.toString(), "YELLOW") && getYellowPawn() > 0) {
            island.setYellowPawn(island.getYellowPawn()+1);
            setYellowPawn(getYellowPawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else if (Objects.equals(colorPawn.toString(), "PINK") && getPinkPawn() > 0) {
            island.setPinkPawn(island.getPinkPawn() + 1);
            setPinkPawn(getPinkPawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else if (Objects.equals(colorPawn.toString(), "BLUE") && getBluePawn() > 0) {
            island.setBluePawn(island.getBluePawn() + 1);
            setBluePawn(getBluePawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else {
            System.out.println("errore colore non presente in entrata");
        }
        Random rnd = new Random();
        ArrayList<String> refillPawn = Game.createArrayPawn(game.studentBag);
        if (game.studentBag.getNum() > 0) {
            int random = rnd.nextInt(refillPawn.size());
            if (Objects.equals(refillPawn.get(random), "GREEN")) {
                setGreenPawn(getGreenPawn() + 1);
                setNumPawnAntonio(getNumPawnAntonio() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setGreenNum(game.studentBag.getGreenNum() - 1);
                if (game.studentBag.getGreenNum() == 0) {
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "RED")) {
                setRedPawn(getRedPawn() + 1);
                setNumPawnAntonio(getNumPawnAntonio() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setRedNum(game.studentBag.getRedNum() - 1);
                if (game.studentBag.getRedNum() == 0) {
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "YELLOW")) {
                setYellowPawn(getYellowPawn() + 1);
                setNumPawnAntonio(getNumPawnAntonio() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setYellowNum(game.studentBag.getYellowNum() - 1);
                if (game.studentBag.getYellowNum() == 0) {
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "PINK")) {
                setPinkPawn(getPinkPawn() + 1);
                setNumPawnAntonio(getNumPawnAntonio() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setPinkNum(game.studentBag.getPinkNum() - 1);
                if (game.studentBag.getPinkNum() == 0) {
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "BLUE")) {
                setBluePawn(getBluePawn() + 1);
                setNumPawnAntonio(getNumPawnAntonio() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setBlueNum(game.studentBag.getBlueNum()- 1);
                if (game.studentBag.getBlueNum() == 0) {
                    refillPawn.remove(random);

                }
            }
        }
        coinPrice++;
    }

    public int getBluePawn() {
        return bluePawn;
    }

    public int getGreenPawn() {
        return greenPawn;
    }

    public int getNumPawnAntonio() {
        return numPawnAntonio;
    }

    public int getPinkPawn() {
        return pinkPawn;
    }

    public int getRedPawn() {
        return redPawn;
    }

    public int getYellowPawn() {
        return yellowPawn;
    }

    public void setBluePawn(int bluePawn) {
        this.bluePawn = bluePawn;
    }

    public void setGreenPawn(int greenPawn) {
        this.greenPawn = greenPawn;
    }

    public void setNumPawnAntonio(int numPawnAntonio) {
        this.numPawnAntonio = numPawnAntonio;
    }

    public void setPinkPawn(int pinkPawn) {
        this.pinkPawn = pinkPawn;
    }

    public void setRedPawn(int redPawn) {
        this.redPawn = redPawn;
    }

    public void setYellowPawn(int yellowPawn) {
        this.yellowPawn = yellowPawn;
    }
}