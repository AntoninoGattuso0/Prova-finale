package it.polimi.ingsw.model;

import java.util.*;

public class Giuseppe{
    protected int nPawn = 0;
    protected int numGreenPawn = 0;
    protected int numRedPawn = 0;
    protected int numYellowPawn = 0;
    protected int numPinkPawn = 0;
    protected int numBluePawn = 0;

    //UML: nuovo metodo che aggiunge 6 pedine a caso alla carta
    private void refillGiuseppeCard(){
        Random rdm = new Random();
        ArrayList<String> refillCharacterCard = Game.createArrayPawn();
        int random = rdm.nextInt(5);
        for(int i = 0; i < 6; i++){
            if(Objects.equals(refillCharacterCard.get(random),Game.m.get(0))) {
                this.numGreenPawn++;
                StudentBag.num--;
                StudentBag.greenNum--;
            }else if(Objects.equals(refillCharacterCard.get(random),Game.m.get(1))) {
                this.numRedPawn++;
                StudentBag.num--;
                StudentBag.redNum--;
            }else if(Objects.equals(refillCharacterCard.get(random),Game.m.get(2))) {
                this.numYellowPawn++;
                StudentBag.num--;
                StudentBag.yellowNum--;
            }else if(Objects.equals(refillCharacterCard.get(random),Game.m.get(3))) {
                this.numPinkPawn++;
                StudentBag.num--;
                StudentBag.pinkNum--;
            }else if(Objects.equals(refillCharacterCard.get(random),Game.m.get(4))) {
                this.numBluePawn++;
                StudentBag.num--;
                StudentBag.blueNum--;
            }
        }
        this.nPawn = 6;
    }

    public void swapPawn(ColorPawn colorPawnCard, ColorPawn colorPawnEntrance, Entrance entrance){
        if(!Objects.equals(colorPawnCard, colorPawnEntrance) && this.nPawn > 3){
            if(Objects.equals(colorPawnCard.toString(), "GREEN")){
                this.numGreenPawn--;
                entrance.greenPawn++;
            }else if(Objects.equals(colorPawnCard.toString(), "RED")){
                this.numRedPawn--;
                entrance.redPawn++;
            }else if(Objects.equals(colorPawnCard.toString(), "YELLOW")){
                this.numYellowPawn--;
                entrance.redPawn++;
            }else if(Objects.equals(colorPawnCard.toString(), "PINK")){
                this.numPinkPawn--;
                entrance.redPawn++;
            }else if(Objects.equals(colorPawnCard.toString(), "BLUE")){
                this.numBluePawn--;
                entrance.bluePawn++;
            }
            if(Objects.equals(colorPawnEntrance.toString(), "GREEN")){
                this.numGreenPawn++;
                entrance.greenPawn--;
            }else if(Objects.equals(colorPawnEntrance.toString(), "RED")){
                this.numRedPawn++;
                entrance.redPawn--;
            }else if(Objects.equals(colorPawnEntrance.toString(), "YELLOW")){
                this.numYellowPawn++;
                entrance.redPawn--;
            }else if(Objects.equals(colorPawnEntrance.toString(), "PINK")){
                this.numPinkPawn++;
                entrance.redPawn--;
            }else if(Objects.equals(colorPawnEntrance.toString(), "BLUE")){
                this.numBluePawn++;
                entrance.bluePawn--;
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