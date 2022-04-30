package it.polimi.ingsw.model;

import java.util.*;

public class Giuseppe extends CharacterCard{
    protected int nPawn;
    protected int numGreenPawn;
    protected int numRedPawn;
    protected int numYellowPawn;
    protected int numPinkPawn;
    protected int numBluePawn;
    Giuseppe(StudentBag studentBag){
        coinPrice=1;
        nPawn = 0;
        numGreenPawn = 0;
        numRedPawn = 0;
        numYellowPawn = 0;
        numPinkPawn=0;
        numBluePawn=0;
        Random rdm = new Random();
        ArrayList<String> refillCharacterCard = Game.createArrayPawn(studentBag);
        int random = rdm.nextInt(5);
        for(int i = 0; i < 6; i++){
            if(Objects.equals(refillCharacterCard.get(random),Game.m.get(0))) {
                numGreenPawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setGreenNum(studentBag.getGreenNum() - 1);
            }else if(Objects.equals(refillCharacterCard.get(random),Game.m.get(1))) {
                numRedPawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setRedNum(studentBag.getRedNum() - 1);
            }else if(Objects.equals(refillCharacterCard.get(random),Game.m.get(2))) {
                numYellowPawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setYellowNum(studentBag.getYellowNum() - 1);
            }else if(Objects.equals(refillCharacterCard.get(random),Game.m.get(3))) {
                numPinkPawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setPinkNum(studentBag.getPinkNum() - 1);
            }else if(Objects.equals(refillCharacterCard.get(random),Game.m.get(4))) {
                numBluePawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setBlueNum(studentBag.getBlueNum() - 1);
            }
        }
        nPawn = 6;
    }

    public void swapPawn(ColorPawn colorPawnCard, ColorPawn colorPawnEntrance, Entrance entrance){
        if(!Objects.equals(colorPawnCard, colorPawnEntrance) && this.nPawn > 3){
            if(Objects.equals(colorPawnCard.toString(), "GREEN")){
                this.numGreenPawn--;
                entrance.setGreenPawn(entrance.getGreenPawn() + 1);
            }else if(Objects.equals(colorPawnCard.toString(), "RED")){
                this.numRedPawn--;
                entrance.setRedPawn(entrance.getRedPawn() + 1);
            }else if(Objects.equals(colorPawnCard.toString(), "YELLOW")){
                this.numYellowPawn--;
                entrance.setYellowPawn(entrance.getYellowPawn() + 1);
            }else if(Objects.equals(colorPawnCard.toString(), "PINK")){
                this.numPinkPawn--;
                entrance.setPinkPawn(entrance.getPinkPawn() + 1);
            }else if(Objects.equals(colorPawnCard.toString(), "BLUE")){
                this.numBluePawn--;
                entrance.setBluePawn(entrance.getBluePawn() + 1);
            }
            if(Objects.equals(colorPawnEntrance.toString(), "GREEN")){
                this.numGreenPawn++;
                entrance.setGreenPawn(entrance.getGreenPawn() - 1);
            }else if(Objects.equals(colorPawnEntrance.toString(), "RED")){
                this.numRedPawn++;
                entrance.setRedPawn(entrance.getRedPawn() - 1);
            }else if(Objects.equals(colorPawnEntrance.toString(), "YELLOW")){
                this.numYellowPawn++;
                entrance.setYellowPawn(entrance.getYellowPawn() - 1);
            }else if(Objects.equals(colorPawnEntrance.toString(), "PINK")){
                this.numPinkPawn++;
                entrance.setPinkPawn(entrance.getPinkPawn() - 1);
            }else if(Objects.equals(colorPawnEntrance.toString(), "BLUE")){
                this.numBluePawn++;
                entrance.setBluePawn(entrance.getBluePawn() - 1);
            }

        }
    }
    //LEGGIMI :( non va bene il fatto che anche se la funzione viene chiamata n volte viene richiamata sempre su stessa isola e pedina
    public void useEffect(int numPawnSwap, ColorPawn colorPawnCard, ColorPawn colorPawnEntrance, Entrance entrance){
        boolean swap = false;
        if(numPawnSwap > 0 && numPawnSwap < 4)
            swap = true;
        if(swap){
            while(numPawnSwap != 0){
                swapPawn(colorPawnCard, colorPawnEntrance, entrance);
                numPawnSwap--;
            }
        }
    }

}