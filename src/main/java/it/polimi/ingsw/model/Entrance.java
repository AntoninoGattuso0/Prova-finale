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
        if(Game.totPlayer == 2 || Game.totPlayer == 4) this.numPawn = 9;
        else if(Game.totPlayer == 3) this.numPawn = 7;
    }

//metodo che ritorna quante pedine sono presenti all'ingresso
    public int getNumPawn(){   return this.numPawn;   }              //utile? questo metodo sarebbe utile se da qualche parte qualcuno lo usasse,
                                                                // ma essendo protected e non private ci possono accedere tutte le calssi del model

    //modifiche all'UML: il ritorno di check è boolean
    //metodo che controlla in base al numero di Players se ci sono ancora 4 o 5 pedine all'ingresso
    public boolean checkNum(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4 && numPawn > 3)
            return true;
        else if(Game.totPlayer == 3 && numPawn > 4)
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

    public void chooseCloud (Cloud cloud){

        if(cloud.numPawn!=0 && !checkNum()){      //utile o no il controllo di numPawn? (controller)
            this.greenPawn += cloud.greenPawn;
            this.redPawn += cloud.redPawn;
            this.yellowPawn += cloud.yellowPawn;
            this.pinkPawn += cloud.pinkPawn;
            this.bluePawn += cloud.bluePawn;
            setNumPawn();

            cloud.numPawn = 0;
            cloud.greenPawn = 0;
            cloud.redPawn = 0;
            cloud.yellowPawn = 0;
            cloud.pinkPawn = 0;
            cloud.bluePawn = 0;

        }
    }
}