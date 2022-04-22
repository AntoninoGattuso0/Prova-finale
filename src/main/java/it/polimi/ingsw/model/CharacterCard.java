package it.polimi.ingsw.model;
 abstract class CharacterCard {
    protected int coinPrice; //modificato in protected
    protected boolean On;
    public boolean isOn(){
        On=true;
        return On;
    }
    public int increasePrice(int coinPrice){
        coinPrice=coinPrice+1;
        return coinPrice;
    }
    public abstract void useeffect();
}
