package it.polimi.ingsw.model;

import java.util.*;

public class Giuseppe{
    private int nPawn = 0;
    protected int numGreenPawn = 0;
    protected int numRedPawn = 0;
    protected int numYellowPawn = 0;
    protected int numPinkPawn = 0;
    protected int numBluePawn = 0;

    public int getnPawn(){ return nPawn; }
    public void setnPawn() { this.nPawn++; }

    //UML: nuovo metodo che aggiunge 6 pedine a caso alla carta
    private void refillGiuseppeCard(){
        Random rdm = new Random();
        ArrayList<String> refillCharacterCard = Game.createArrayPawn();
        int random = rdm.nextInt(5);
        for(int i = 0; i < 6; i++){
            if(Objects.equals(refillCharacterCard.get(random),Game.m.get(0))) {
                this.numGreenPawn++;
                setnPawn();
                StudentBag.num--;
                StudentBag.greenNum--;
            }
            if(Objects.equals(refillCharacterCard.get(random),Game.m.get(1))) {
                this.numRedPawn++;
                this.nPawn++;
                StudentBag.num--;
                StudentBag.redNum--;
            }
            if(Objects.equals(refillCharacterCard.get(random),Game.m.get(2))) {
                this.numYellowPawn++;
                this.nPawn++;
                StudentBag.num--;
                StudentBag.yellowNum--;
            }
            if(Objects.equals(refillCharacterCard.get(random),Game.m.get(3))) {
                this.numPinkPawn++;
                this.nPawn++;
                StudentBag.num--;
                StudentBag.pinkNum--;
            }
            if(Objects.equals(refillCharacterCard.get(random),Game.m.get(4))) {
                this.numBluePawn++;
                this.nPawn++;
                StudentBag.num--;
                StudentBag.blueNum--;
            }
        }
    }

    public void swapPawn(ColorPawn colorPawnCard, ColorPawn colorPawnEntrance, Entrance entrance){
        if(!Objects.equals(colorPawnCard, colorPawnEntrance))

            entrance.greenPawn++;



    }
}
