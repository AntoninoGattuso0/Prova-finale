package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Ciro extends UseEffect{
    private int coinPrice;
    Ciro(){
        coinPrice=3;
    }
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {//copia del metodo per calcolare la top influenza
        game.topInfluence(island,game);
         coinPrice++;
    }
}


