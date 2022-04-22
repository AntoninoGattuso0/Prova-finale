package it.polimi.ingsw.model;

public class ProfTable {

    protected static int greenProf = -1;
    protected static int redProf = -1;
    protected static int yellowProf = -1;
    protected static int pinkProf = -1;
    protected static int blueProf = -1;

    //modifiche all'UML:metodo restituisce un int ovvero il numero del giocatore che possiede il professore
    public int checkProf(int color)  {
        if(color==0) return greenProf;
        else if(color==1) return redProf;
        else if(color==2) return yellowProf;
        else if(color==3) return pinkProf;
        else if(color==4) return blueProf;
        return -1;
        //allora dovrebbe ricevere in ingresso un int che indica il colore --Paul
//aspetto che sia implementato il metodo moveProf
        }
}
