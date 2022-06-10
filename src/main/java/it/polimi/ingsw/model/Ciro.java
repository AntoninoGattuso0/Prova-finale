package it.polimi.ingsw.model;
import java.io.Serializable;
import java.util.ArrayList;
public class Ciro extends UseEffect implements Serializable {
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
        game.topInfluence(island,game);
         setCoinPrice(4);
    }
}