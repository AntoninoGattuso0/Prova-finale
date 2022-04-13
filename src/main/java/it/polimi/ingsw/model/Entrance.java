package it.polimi.ingsw.model;

import it.polimi.ingsw.model.ColorPawn;

public class Entrance {

    protected static int numPawn;
    private int greenPawn = 0;
    private int bluePawn = 0;
    private int pinkPawn = 0;
    private int yellowPawn = 0;
    private int redPawn = 0;

    //in Game-start bisogna aggiungere un metodo che mette in Entrance le pedine studenti in base al numero di Player

    //modifiche all'UML:ho aggiunto setter per definire quante sono le torri iniziali, final perché si setta all'inizio
    public final void setNumPawn(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) numPawn = 9;
        else if(Game.totPlayer == 3) numPawn = 7;
    }

    public


    //modifiche all'UML: il ritorno di check è boolean
    public boolean checkNum(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4 && numPawn > 4)
            return true;
        else if(Game.totPlayer = 3 && numPawn > 5)
            return true;
        else return false;
    }

    public void moveToDining(){
        int nPawn;  //variabile che tiene conto di quante pedine spostare in base al nr di player
        if(Game.totPlayer == 2 || Game.totPlayer == 4) nPawn = 3;
        else if(Game.totPlayer == 3) nPawn = 4;

        for(int i = 0; i < nPawn; i++){





        }
    }

    public void moveToIsland(){

    }

    public void chooseCloud(){

    }
}
