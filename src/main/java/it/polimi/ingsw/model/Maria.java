package it.polimi.ingsw.model;

import java.awt.*;
//ce la faremo
public class Maria extends CharacterCard{
    Maria(){
        coinPrice=1;
    }
    public void scambiaStudenti(ColorPawn colorPawn1, ColorPawn colorPawn2, Player player, Entrance entrance, DiningRoom diningRoom){
        diningRoom.removePawnFromDiningRoom(colorPawn1, player, entrance);
        diningRoom.addPawnToDiningRoom(colorPawn2, player, entrance);
    }

    public void scambiaStudenti(ColorPawn colorPawn1, ColorPawn colorPawn2, ColorPawn colorPawn3, ColorPawn colorPawn4, Player player, Entrance entrance, DiningRoom diningRoom){
        diningRoom.removePawnFromDiningRoom(colorPawn1, player, entrance);
        diningRoom.addPawnToDiningRoom(colorPawn2, player, entrance);
        diningRoom.removePawnFromDiningRoom(colorPawn3, player, entrance);
        diningRoom.addPawnToDiningRoom(colorPawn4, player, entrance);
    }
}
