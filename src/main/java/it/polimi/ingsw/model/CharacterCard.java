package it.polimi.ingsw.model;

public class CharacterCard {
    private int coinPrice;
    private boolean On;
    public boolean isOn(){

    }
    public int increasePrice(int coinPrice){
        coinPrice=coinPrice+1;
        return coinPrice;
    }
}
