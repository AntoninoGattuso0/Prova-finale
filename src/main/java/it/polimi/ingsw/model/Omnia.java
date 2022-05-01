package it.polimi.ingsw.model;
public class Omnia extends UseEffect{
    private int coinPrice;
    Omnia(){
        coinPrice=3;
    }
    public void removePawn(ColorPawn colorPawn,Game game){
        int i, j;
        for(i=0; i<3; i++){
            for(j=0; j < Game.totPlayer; j++){
                Game.players.get(j).diningRoom.removePawnFromDiningRoom(colorPawn, Game.players.get(j),game);
                coinPrice++;
            }
        }
    }
}

