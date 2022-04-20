package it.polimi.ingsw.model;

public class CharacterCard {
    protected int coinPrice; //modificato in protected
    protected boolean On;
    public boolean isOn();{

    }
    public int increasePrice(int coinPrice){
        coinPrice=coinPrice+1;
        return coinPrice;
    }
}
