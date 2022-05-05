package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Omnia extends UseEffect{
    private int coinPrice;
    Omnia(){
        coinPrice=3;
    }
    
    public void setCoinPrice(int coinPrice){this.coinPrice = coinPrice;}
    public int getCoinPrice(){return coinPrice;}

    public void useEffect(Game game, int s, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        int i, j;
        for(i=0; i<3; i++){
            for(j=0; j < game.totPlayer; j++){
                game.players.get(j).diningRoom.removePawnFromDiningRoom(colorPawn.get(0), game.players.get(j), game);
                if(game.players.get(j).diningRoom.getNumGreen() < 0) game.players.get(j).diningRoom.setNumGreen(0);
                if(game.players.get(j).diningRoom.getNumRed() < 0) game.players.get(j).diningRoom.setNumRed(0);
                if(game.players.get(j).diningRoom.getNumYellow() < 0) game.players.get(j).diningRoom.setNumYellow(0);
                if(game.players.get(j).diningRoom.getNumPink() < 0) game.players.get(j).diningRoom.setNumPink(0);
                if(game.players.get(j).diningRoom.getNumBlue() < 0) game.players.get(j).diningRoom.setNumBlue(0);
            }
        }
        setCoinPrice(4);
    }
}

