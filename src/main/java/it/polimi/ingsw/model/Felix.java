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
    public boolean isEffectActive(){
        return effectActive;
    }
    Felix(){
        coinPrice = 3;
        effectActive=false;
    }

    /**CharacterCard 6: during this turn the towers don't count in the Influence
     *
     * @param game
     * @param num
     * @param island
     * @param player
     * @param colorPawn
     */
    public void useEffect(Game game, int num, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        effectActive=true;
        setCoinPrice(4);
    }
}