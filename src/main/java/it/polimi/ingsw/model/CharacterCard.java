package it.polimi.ingsw.model;

import java.io.Serializable;

public class CharacterCard implements Serializable {
    UseEffect useEffect;
    public int numCard;
    public CharacterCard(UseEffect useEffect, int numCard){
        this.useEffect=useEffect;
        this.numCard = numCard;
    }

    public UseEffect getUseEffect() {
        return useEffect;
    }

    public int getNumCard() {
        return numCard;
    }
}