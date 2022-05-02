package it.polimi.ingsw.model;
import java.util.ArrayList;
public class Ciro extends UseEffect{
    private int coinPrice;
    Ciro(){
        coinPrice=3;
    }

    public void setCoinPrice(int coinPrice) {
        this.coinPrice = coinPrice;
    }
    public int getCoinPrice() {
        return coinPrice;
    }
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {//copia del metodo per calcolare la top influenza
        Game.topInfluence(island,game);
         setCoinPrice(getCoinPrice()+1);
    }
}