package it.polimi.ingsw.model;
import java.util.ArrayList;
public class Ernesto extends UseEffect{
    protected int coinPrice;

    Ernesto(){
        coinPrice=2;
    }
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        island.setProhibited(true);
        coinPrice++;
    }
}