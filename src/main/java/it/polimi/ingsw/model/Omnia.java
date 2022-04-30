package it.polimi.ingsw.model;

public class Omnia extends UseEffect{
    Omnia(){
        coinPrice=3;
    }

    public void removePawn(ColorPawn colorPawn,Game game){
        int i, j;
        for(i=0; i<3; i++){
            for(j=0; j<game.totPlayer; j++){
                game.players.get(j).diningRoom.removePawnFromDiningRoom(colorPawn, game.players.get(j),game);
            }
        }
    }
}

