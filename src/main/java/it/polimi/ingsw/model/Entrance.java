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
    public int getNumPawn(){   this.greenPawn;   }              //utile? questo metodo sarebbe utile se da qualche parte qualcuno lo usasse,
                                                                // ma essendo protected e non private ci possono accedere tutte le calssi del model

    //modifiche all'UML: il ritorno di check è boolean
    //metodo che controlla in base al numero di Players se ci sono ancora 4 o 5 pedine all'ingresso
    public boolean checkNum(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4 && numPawn > 4)
            return true;
        else if(Game.totPlayer == 3 && numPawn > 5)
            return true;
        else return false;
    }


    public void moveToIsland(ColorPawn colorPawn, Island island){
        if(Objects.equals(colorPawn.toString(), "GREEN"))
            island.greenPawn++;
        if(Objects.equals(colorPawn.toString(), "RED"))
            island.redPawn++;
        if(Objects.equals(colorPawn.toString(), "YELLOW"))
            island.yellowPawn++;
        if(Objects.equals(colorPawn.toString(), "PINK"))
            island.pinkPawn++;
        if(Objects.equals(colorPawn.toString(), "BLUE"))
            island.bluePawn++;
    }

    public void chooseCloud(ColorPawn colorPawn, Cloud cloud){
       while(cloud.numPawn!=0){
            if(Objects.equals(colorPawn.toString(), "GREEN")) {
                cloud.greenPawn--;
                cloud.numPawn--;
                this.greenPawn++;
            }
            if(Objects.equals(colorPawn.toString(), "RED")) {
                cloud.redPawn--;
                cloud.numPawn--;
                this.redPawn++;
            }
            if(Objects.equals(colorPawn.toString(), "YELLOW")) {
                cloud.yellowPawn--;
                cloud.numPawn--;
                this.yellowPawn++;
            }
            if(Objects.equals(colorPawn.toString(), "PINK")) {
                cloud.pinkPawn--;
                cloud.numPawn--;
                this.pinkPawn++;
            }
            if(Objects.equals(colorPawn.toString(), "BLUE")) {
                cloud.bluePawn--;
                cloud.numPawn--;
                this.bluePawn++;
        }
    }
}