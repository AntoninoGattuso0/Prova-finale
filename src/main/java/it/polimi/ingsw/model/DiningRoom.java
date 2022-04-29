package it.polimi.ingsw.model;

import java.util.Objects;

public class DiningRoom {
    //modifiche all'UML: array di array: in cui gli elementi sono 0 o 1;
    //5 int che tengono conto di quante pedine di ogni colore sono presenti nella sala
    int[][] position = new int[5][10];
    private int numGreen;
    private int numRed;
    private int numYellow;
    private int numPink;
    private int numBlue;

    DiningRoom(){
        numGreen = 0;
        numRed = 0;
        numYellow = 0;
        numPink = 0;
        numBlue = 0;
    }

    public int getNumGreen() {
        return numGreen;
    }

    public int getNumRed() {
        return numRed;
    }

    public int getNumYellow() {
        return numYellow;
    }

    public int getNumPink() {
        return numPink;
    }

    public int getNumBlue() {
        return numBlue;
    }

    public void setNumGreen(int numGreen) {
        this.numGreen = numGreen;
    }

    public void setNumRed(int numRed) {
        this.numRed = numRed;
    }

    public void setNumYellow(int numYellow) {
        this.numYellow = numYellow;
    }

    public void setNumPink(int numPink) {
        this.numPink = numPink;
    }

    public void setNumBlue(int numBlue) {
        this.numBlue = numBlue;
    }

    public void addPawnToEntrance(ColorPawn colorPawn, Player player, Entrance entrance){

        int j; //variabile che serve a iterare dentro le righe della sala
        if(Objects.equals(colorPawn.toString(), Game.m.get(0))) {
        for(j = 0; j < 10; j++){
                 if(position[0][j] != 1){
                   position[0][j]= 1;
                   setNumGreen(j);
                   entrance.setGreenPawn(entrance.getGreenPawn() - 1);
                     if(Game.isExpert && (position[0][2] == 1 || position[0][5] == 1 || position[0][8] == 1))
                         player.setNumCoin(player.getNumCoin() + 1);
                   break;
                 }
            }
        }

        if(Objects.equals(colorPawn.toString(), Game.m.get(1))){
            for(j = 0; j < 10; j++){
                if(position[1][j] != 1){
                    position[1][j]= 1;
                    setNumRed(j);
                    entrance.setRedPawn(entrance.getRedPawn() - 1);
                    if(Game.isExpert && (position[1][2] == 1 || position[1][5] == 1 || position[1][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }

        if(Objects.equals(colorPawn.toString(), Game.m.get(2))){
            for(j = 0; j < 10; j++){
                if(position[2][j] != 1){
                    position[2][j]= 1;
                    setNumYellow(j);
                    entrance.setYellowPawn(entrance.getYellowPawn() - 1);
                    if(Game.isExpert && (position[2][2] == 1 || position[2][5] == 1 || position[2][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }

        if(Objects.equals(colorPawn.toString(), Game.m.get(3))){
            for(j = 0; j < 10; j++){
                if(position[3][j] != 1){
                    position[3][j]= 1;
                    setNumPink(j);
                    entrance.setPinkPawn(entrance.getPinkPawn() - 1);
                    if(Game.isExpert && (position[3][2] == 1 || position[3][5] == 1 || position[3][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }

        if(Objects.equals(colorPawn.toString(), Game.m.get(4))) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for(j = 0; j < 10; j++){
                if(position[4][j] != 1){
                    position[4][j]= 1;
                    setNumBlue(j);
                    entrance.setBluePawn(entrance.getBluePawn() - 1);
                    if(Game.isExpert && (position[4][2] == 1 || position[4][5] == 1 || position[4][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
    }

    public void addPawn(int m, ColorPawn colorPawn, Player player, Entrance entrance){
        if((Game.totPlayer == 2 || Game.totPlayer == 4) && (m > 0 &&  m < 4 )){
            while(m != 0){
                addPawnToEntrance(colorPawn, player, entrance);
                m--;
            }
        }

        if(Game.totPlayer == 3 && (m > 0 &&  m < 5 )){
            while(m != 0){
                addPawnToEntrance(colorPawn, player, entrance);
                m--;
            }
        }
    }
}