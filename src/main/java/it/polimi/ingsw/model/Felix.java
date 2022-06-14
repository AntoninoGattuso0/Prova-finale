package it.polimi.ingsw.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Felix extends UseEffect implements Serializable {
    @Serial
    private static final long serialVersionUID= -1214930636709409876L;
    private int coinPrice;
    private boolean effectActive;
    public int getCoinPrice(){
        return coinPrice;
    }

    public void setCoinPrice(int coin){
        this.coinPrice=coin;
    }
    public void setEffectActive(boolean c){
        effectActive=c;
    }
    public boolean getEffectActive(){
        return effectActive;
    }
    Felix(){
        coinPrice = 3;
        effectActive=false;
    }

    public void useEffect(Game game, int num, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        effectActive=true;
        setCoinPrice(4);
    }
}