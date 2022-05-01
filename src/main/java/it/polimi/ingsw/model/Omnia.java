package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Omnia extends UseEffect{
    private int coinPrice;
    Omnia(){
        coinPrice=3;
    }
    public void useEffect(Game game, int s, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        int i, j;
        for(i=0; i<3; i++){
            for(j=0; j < Game.totPlayer; j++){
                Game.players.get(j).diningRoom.removePawnFromDiningRoom(colorPawn.get(0), Game.players.get(j), game);
                if(Game.players.get(j).diningRoom.getNumGreen() < 0) Game.players.get(j).diningRoom.setNumGreen(0);
                if(Game.players.get(j).diningRoom.getNumRed() < 0) Game.players.get(j).diningRoom.setNumRed(0);
                if(Game.players.get(j).diningRoom.getNumYellow() < 0) Game.players.get(j).diningRoom.setNumYellow(0);
                if(Game.players.get(j).diningRoom.getNumPink() < 0) Game.players.get(j).diningRoom.setNumPink(0);
                if(Game.players.get(j).diningRoom.getNumBlue() < 0) Game.players.get(j).diningRoom.setNumBlue(0);
            }
        }
        coinPrice++;
    }
}

