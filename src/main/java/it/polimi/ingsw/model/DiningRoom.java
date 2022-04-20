package it.polimi.ingsw.model;

import java.util.Objects;

public class DiningRoom {


    //modifiche all'UML: array di array invece che 5 int
    boolean [][] position = new boolean[5][10];


    public int coinPosition(Player player){   //ho aggiunto che prende in ingresso un player, se no come facciamo a dare un coin a un determinato player? --Paul
        if(position[][3]||position[][6]||position[][9])
            player.numCoin++;
    }
}
