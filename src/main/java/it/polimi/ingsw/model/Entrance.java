package it.polimi.ingsw.model;

import java.util.*;

public class Entrance {

    protected int numPawn;
    protected int greenPawn = 0;
    protected int bluePawn = 0;
    protected int pinkPawn = 0;
    protected int yellowPawn = 0;
    protected int redPawn = 0;

    // modifiche all'UML:ho aggiunto setter per definire quante sono le torri iniziali
    public void setNumPawn(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) numPawn = 9;
        else if(Game.totPlayer == 3) numPawn = 7;
    }

//metodo che ritorna quante pedine sono presenti all'ingresso
    public int getNumPawn(){
        return numPawn;
    }

    //modifiche all'UML: il ritorno di check è boolean
    //metodo che controlla in base al numero di Players se ci sono ancora 4 o 5 pedine all'ingresso
    public boolean checkNum(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4 && numPawn > 4)
            return true;
        else if(Game.totPlayer == 3 && numPawn > 5)
            return true;
        else return false;
    }


    public void moveToIsland(){

    }

    public void chooseCloud(){

    }
}
