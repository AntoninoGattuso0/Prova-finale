package it.polimi.ingsw.model;

import java.util.Objects;

public class DiningRoom {
    //modifiche all'UML: array di array invece che 5 int
    int[][] position = new int[5][10];

    public void addPawn(ColorPawn colorPawn, int position[][]){
        for(int m; m < 5; m++)
            for(int n; n < 10; n++){
                if(Objects.equals(colorPawn, Game.m.get(0))){
                 if(position[m][n] != 0)
                   position[m][n]= 1;
              continue;
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
