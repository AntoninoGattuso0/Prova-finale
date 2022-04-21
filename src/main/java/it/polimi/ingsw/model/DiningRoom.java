package it.polimi.ingsw.model;

import java.util.Objects;

public class DiningRoom {
    //modifiche all'UML: array di array: in cui gli elementi sono 0 o 1;
    //5 int che tengono conto di quante pedine di ogni colore sono presenti nella sala
    int[][] position = new int[5][10];
    protected int numGreen = 0;
    protected int numRed = 0;
    protected int numYellow = 0;
    protected int numPink = 0;
    protected int numBlue = 0;

    public void addPawn(ColorPawn colorPawn, Player player) {

        int j; //variabile che serve a iterare dentro le righe della sala
        if(Objects.equals(colorPawn.toString(), Game.m.get(0)))
        for(j = 0; j < 10; j++){
                 if(position[0][j] != 1){
                   position[0][j]= 1;
                   numGreen = j;
                   Entrance.greenPawn--;
                     if(position[0][2] == 1 || position[0][5] == 1 || position[0][9] == 1)
                         player.numCoin++;
                   break;
                 }
             }

        if(Objects.equals(colorPawn.toString(), Game.m.get(1)))
            for(j = 0; j < 10; j++){
                if(position[1][j] != 1){
                    position[1][j]= 1;
                    numRed = j;
                    Entrance.redPawn--;
                    if(position[1][2] == 1 || position[1][5] == 1 || position[1][9] == 1)
                        player.numCoin++;
                    break;
                }
            }

        if(Objects.equals(colorPawn.toString(), Game.m.get(2)))
            for(j = 0; j < 10; j++){
                if(position[2][j] != 1){
                    position[2][j]= 1;
                    numYellow = j;
                    Entrance.yellowPawn--;
                    if(position[2][2] == 1 || position[2][5] == 1 || position[2][9] == 1)
                        player.numCoin++;
                    break;
                }
            }

        if(Objects.equals(colorPawn.toString(), Game.m.get(3)))
            for(j = 0; j < 10; j++){
                if(position[3][j] != 1){
                    position[3][j]= 1;
                    numPink = j;
                    Entrance.pinkPawn--;
                    if(position[3][2] == 1 || position[3][5] == 1 || position[3][9] == 1)
                        player.numCoin++;
                    break;
                }
            }

        if(Objects.equals(colorPawn.toString(), Game.m.get(4)))  //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for(j = 0; j < 10; j++){
                if(position[4][j] != 1){
                    position[4][j]= 1;
                    numBlue = j;
                    Entrance.bluePawn--;
                    if(position[5][2] == 1 || position[5][5] == 1 || position[5][9] == 1)
                        player.numCoin++;
                    break;
                }
            }
    }

}