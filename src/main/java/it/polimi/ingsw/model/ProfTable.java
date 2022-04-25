package it.polimi.ingsw.model;

public class ProfTable {

    protected static int greenProf;
    protected static int redProf;
    protected static int yellowProf;
    protected static int pinkProf;
    protected static int blueProf;

    ProfTable(){
        greenProf = -1;
        redProf = -1;
        yellowProf = -1;
        pinkProf = -1;
        blueProf = -1;
    }

    //modifiche all'UML:metodo restituisce un int ovvero il numero del giocatore che possiede il professore
    public static int checkProf(int color)  {
        if(color == 0) return greenProf;
        else if(color == 1) return redProf;
        else if(color == 2) return yellowProf;
        else if(color == 3) return pinkProf;
        else if(color == 4) return blueProf;
        return -1;
        }
}
