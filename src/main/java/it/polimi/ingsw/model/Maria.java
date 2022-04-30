package it.polimi.ingsw.model;

import java.awt.*;
import java.util.ArrayList;

public class Maria extends UseEffect{
    private int coinPrice;
    Maria(){
        coinPrice=1;
    }
    public void scambiaStudenti(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        diningRoom.removePawnFromDiningRoom(colorPawn1, player, entrance);
        diningRoom.addPawnToDiningRoom(colorPawn2, player, entrance);
        coinPrice++;
    }

    public void scambiaStudenti(ColorPawn colorPawn1, ColorPawn colorPawn2, ColorPawn colorPawn3, ColorPawn colorPawn4, Player player, Entrance entrance, DiningRoom diningRoom){
        diningRoom.removePawnFromDiningRoom(colorPawn1, player, entrance);
        diningRoom.addPawnToDiningRoom(colorPawn2, player, entrance);
        diningRoom.removePawnFromDiningRoom(colorPawn3, player, entrance);
        diningRoom.addPawnToDiningRoom(colorPawn4, player, entrance);
    }
}
