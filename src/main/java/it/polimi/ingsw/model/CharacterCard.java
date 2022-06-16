package it.polimi.ingsw.model;

import java.io.Serializable;

/**
 * all 12 Effects are attributes of CharacterCard
 */
public class CharacterCard implements Serializable {
    UseEffect useEffect;
    public int numCard;
    public CharacterCard(UseEffect useEffect, int numCard){
        this.useEffect=useEffect;
        this.numCard = numCard;
    }

    /**
     * is used to take the real effect of CharacterCard
     * @return the Effect
     */
    public UseEffect getUseEffect() {
        return useEffect;
    }

    public int getNumCard() {
        return numCard;
    }
}