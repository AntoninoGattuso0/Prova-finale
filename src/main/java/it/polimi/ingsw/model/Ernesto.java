package it.polimi.ingsw.model;
import java.util.ArrayList;
public class Ernesto extends UseEffect{
    private int coinPrice;
    public int getCoinPrice(){ return coinPrice;}
    public void setCoinPrice(int coin){ this.coinPrice=coin;}

    Ernesto(){
        coinPrice=2;
    }
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        island.setProhibited(true);
        setCoinPrice(3);;
    }
}