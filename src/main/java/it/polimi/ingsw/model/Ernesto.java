package it.polimi.ingsw.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * the fifth effect (Ernesto because "E" is the fifth alphabet letter)
 * @see UseEffect
 */
public class Ernesto extends UseEffect implements Serializable {
    @Serial
    private static final long serialVersionUID= -2535390467065107362L;
    private int coinPrice;
    public int getCoinPrice(){ return coinPrice;}
    public void setCoinPrice(int coin){ this.coinPrice=coin;}
    private int numProhibitionCard = 4;

    public int getNumProhibitionCard(){
        return numProhibitionCard;
    }

    public void setNumProhibitionCard(int numProhibitionCard){
        this.numProhibitionCard = numProhibitionCard;
    }

    Ernesto(){
        coinPrice=2;
    }

    /**CharacterCard 5: you have 4 No Entry card. You can put one on the Island to make it Prohibited
     */
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        if(numProhibitionCard != 0){
            island.setProhibited(true);
            setNumProhibitionCard(getNumProhibitionCard() - 1);
        }
        setCoinPrice(3);
    }
}