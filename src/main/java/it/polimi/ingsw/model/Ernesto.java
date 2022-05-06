package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Ernesto extends UseEffect{
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

    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        if(numProhibitionCard != 0){
            island.setProhibited(true);
            setNumProhibitionCard(getNumProhibitionCard() - 1);
        }
        setCoinPrice(3);
    }
}