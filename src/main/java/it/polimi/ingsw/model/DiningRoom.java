package it.polimi.ingsw.model;

import java.util.Objects;

public class DiningRoom {
    //modifiche all'UML: array di array invece che 5 int
    int[][] position = new int[5][10];

    public void addPawn(ColorPawn colorPawn, int position[][]){
        if(Objects.equals(colorPawn, Game.m.get(0)))
        for(int j = 0; j < 10; j++){
                 if(position[0][j] != 1){
                   position[0][j]= 1;
                   break;
                 }
             }
    }




    public void coinPosition(Player player){
        for(int i = 0; i < 5; i++){
            if(position[i][2] == 1 || position[i][5] == 1 || position[i][9] == 1)
                player.numCoin++;
        }
    }
}

