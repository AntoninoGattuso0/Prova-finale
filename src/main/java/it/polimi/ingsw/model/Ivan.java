package it.polimi.ingsw.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Ivan extends UseEffect implements Serializable {
    private int coinPrice;
    private boolean effectActive;
    private int numPlayer;

    public int getCoinPrice(){
        return coinPrice;
    }
    public void setCoinPrice(int coin){
        this.coinPrice = coin;
    }
    public int getNumPlayer(){
        return numPlayer;
    }
    public boolean isEffectActive(){
        return effectActive;
    }
    public void setEffectActive(boolean c){
        effectActive=c;
    }
    Ivan(){
        coinPrice = 2;
        effectActive=false;
        numPlayer=-1;
    }

    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){//   public void useEffect(Game game, int i,Island island,Player player,ArrayList<ColorPawn> colorPawn){
        effectActive=true;
        numPlayer=i;
        setCoinPrice(3);
    }
}