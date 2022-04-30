package it.polimi.ingsw.model;

public class Ernesto extends CharacterCard{

    Ernesto(){
        coinPrice=2;
    }

    public void notInfluence(Island island){
        island.setProhibited(true);
    }


}