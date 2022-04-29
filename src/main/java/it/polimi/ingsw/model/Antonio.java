package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static it.polimi.ingsw.model.StudentBag.*;

public class Antonio extends CharacterCard{
    private int numPawnAntonio;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;
    Antonio(){ //COSTRUTTORE ANTONIO: manca l'inizializzazione del prezzo. Non so come fare visto che CharacterCard è una classe astratta -Nino
        coinPrice=1;
        numPawnAntonio=0;
        greenPawn=0;
        redPawn=0;
        yellowPawn=0;
        pinkPawn=0;
        bluePawn=0;
        while(numPawnAntonio<4){
            Random rnd = new Random();
            ArrayList<String> refillPawn = Game.createArrayPawn();
            if (StudentBag.getNum() > 0) {
                int random = rnd.nextInt(refillPawn.size());
                if (Objects.equals(refillPawn.get(random), "GREEN")) {
                    greenPawn++;
                    numPawnAntonio++;
                    StudentBag.setNum(StudentBag.getNum()-1);
                    StudentBag.setGreenNum(StudentBag.getGreenNum()-1);
                    if(StudentBag.getGreenNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "RED")) {
                    setRedPawn(getRedPawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    StudentBag.setNum(StudentBag.getNum()-1);
                    StudentBag.setRedNum(StudentBag.getRedNum()-1);
                    if(StudentBag.getRedNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "YELLOW")) {
                    setYellowPawn(getYellowPawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    StudentBag.setNum(StudentBag.getNum()-1);
                    StudentBag.setYellowNum(StudentBag.getYellowNum()-1);
                    if(StudentBag.getYellowNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "PINK")) {
                    setPinkPawn(getPinkPawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    StudentBag.setNum(StudentBag.getNum()-1);
                    StudentBag.setPinkNum(StudentBag.getPinkNum()-1);
                    if(StudentBag.getPinkNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), "BLUE")) {
                    setBluePawn(getBluePawn()+1);
                    setNumPawnAntonio(getNumPawnAntonio()+1);
                    StudentBag.setNum(StudentBag.getNum()-1);
                    StudentBag.setBlueNum(getBluePawn()-1);
                    if(StudentBag.getBlueNum()==0){
                        refillPawn.remove(random);
                    }
                }
            }
        }
    }

    public void useEffect(ColorPawn colorPawn, Island island){
            if(Objects.equals(colorPawn.toString(), "GREEN") && this.greenPawn > 0){  //altrimenti cosa succede se la pedina verde non c'è?
                island.greenPawn++;
                this.greenPawn--;
                this.numPawnAntonio--;
            }else if(Objects.equals(colorPawn.toString(), "RED") && this.redPawn > 0){
                island.redPawn++;
                this.redPawn--;
                this.numPawnAntonio--;
            }else  if(Objects.equals(colorPawn.toString(), "YELLOW") && this.yellowPawn > 0){
                island.yellowPawn++;
                this.yellowPawn--;
                this.numPawnAntonio--;
            }else if(Objects.equals(colorPawn.toString(), "PINK") && this.pinkPawn > 0){
                island.pinkPawn++;
                this.pinkPawn--;
                this.numPawnAntonio--;
            }else if(Objects.equals(colorPawn.toString(), "BLUE") && this.bluePawn > 0){
                island.bluePawn++;
                this.bluePawn--;
                this.numPawnAntonio--;
            }else {
                System.out.println("errore colore non presente in entrata");
            }
        Random rnd = new Random();
        ArrayList<String> refillPawn = Game.createArrayPawn();
        if (StudentBag.num > 0) {
            int random = rnd.nextInt(refillPawn.size());
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