package it.polimi.ingsw.model;

import java.util.Objects;

public class DiningRoom {
    //modifiche all'UML: array di array invece che 5 int
    int[][] position = new int[5][10];
    int numGreen = 0;
    int numRed = 0;
    int numYellow = 0;
    int numPink = 0;
    int numBlue = 0;

    public void addPawn(ColorPawn colorPawn, int position[][], Player player) {
        int j; //variabile che serve a iterare dentro le righe della sala
        if(Objects.equals(colorPawn, Game.m.get(0)))
        for(j = 0; j < 10; j++){
                 if(position[0][j] != 1){
                   position[0][j]= 1;
                   numGreen = j;
                     if(position[0][2] == 1 || position[0][5] == 1 || position[0][9] == 1)
                         player.numCoin++;
                   break;
                 }
             }

        if(Objects.equals(colorPawn, Game.m.get(1)))
            for(j = 0; j < 10; j++){
                if(position[1][j] != 1){
                    position[1][j]= 1;
                    numRed = j;
                    if(position[1][2] == 1 || position[1][5] == 1 || position[1][9] == 1)
                        player.numCoin++;
                    break;
                }
            }

        if(Objects.equals(colorPawn, Game.m.get(2)))
            for(j = 0; j < 10; j++){
                if(position[2][j] != 1){
                    position[2][j]= 1;
                    numYellow = j;
                    if(position[2][2] == 1 || position[2][5] == 1 || position[2][9] == 1)
                        player.numCoin++;
                    break;
                }
            }

        if(Objects.equals(colorPawn, Game.m.get(3)))
            for(j = 0; j < 10; j++){
                if(position[3][j] != 1){
                    position[3][j]= 1;
                    numPink = j;
                    if(position[3][2] == 1 || position[3][5] == 1 || position[3][9] == 1)
                        player.numCoin++;
                    break;
                }
            }

        if(Objects.equals(colorPawn, Game.m.get(4)))
            for(j = 0; j < 10; j++){
                if(position[4][j] != 1){
                    position[4][j]= 1;
                    numBlue = j;
                    if(position[5][2] == 1 || position[5][5] == 1 || position[5][9] == 1)
                        player.numCoin++;
                    break;
                }
            }
    }

}