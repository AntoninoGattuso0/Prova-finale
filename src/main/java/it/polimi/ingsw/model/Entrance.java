package it.polimi.ingsw.model;

public class Entrance {

    protected static int numPawn;
    protected int greenPawn = 0;   //static o no?                         penso di no -Paul
    protected int bluePawn = 0;
    protected int pinkPawn = 0;
    protected int yellowPawn = 0;
    protected int redPawn = 0;

    //in Game-start bisogna aggiungere un metodo che mette in Entrance le pedine studenti in base al numero di Player

    // modifiche all'UML:ho aggiunto setter per definire quante sono le torri iniziali, final o no?
    public static void setNumPawn(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) numPawn = 9;
        else if(Game.totPlayer == 3) numPawn = 7;
    }

//metodo che ritorna quante pedine sono presenti all'ingresso
    public static int getNumPawn(){
        return numPawn;
    }

    //modifiche all'UML: il ritorno di check è boolean
    //metodo che controlla in base al numero di Players se ci sono ancora 4 o 5 pedine all'ingresso
    public boolean checkNum(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4 && numPawn > 4)
            return true;
        else if(Game.totPlayer == 3 && numPawn > 5)
            return true;
        return false;
    }

    public void moveToDining(){
        if()







        }
    }

    public void moveToIsland(){

    }

    public void chooseCloud(){

    }
}
