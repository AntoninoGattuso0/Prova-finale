package it.polimi.ingsw.model;

public class Ivan extends CharacterCard{
    public void topInfl(Island island){
        int infl;
        if(island.isTower)
           return infl = Game.topInfluence() + 2;
    }
}
