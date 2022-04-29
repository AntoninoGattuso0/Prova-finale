package it.polimi.ingsw.model;

public class ProfTable {

    private int greenProf;
    private int redProf;
    private int yellowProf;
    private int pinkProf;
    private int blueProf;

    ProfTable(){
        greenProf = -1;
        redProf = -1;
        yellowProf = -1;
        pinkProf = -1;
        blueProf = -1;
    }

    public int getGreenProf() {
        return greenProf;
    }

    public int getRedProf() {
        return redProf;
    }

    public int getYellowProf() {
        return yellowProf;
    }

    public int getPinkProf() {
        return pinkProf;
    }

    public int getBlueProf() {
        return blueProf;
    }

    public void setGreenProf(int greenProf) {
        this.greenProf = greenProf;
    }

    public void setRedProf(int redProf) {
        this.redProf = redProf;
    }

    public void setYellowProf(int yellowProf) {
        this.yellowProf = yellowProf;
    }

    public void setPinkProf(int pinkProf) {
        this.pinkProf = pinkProf;
    }

    public void setBlueProf(int pinkProf) {
        this.pinkProf = pinkProf;
    }



    //modifiche all'UML:metodo restituisce un int ovvero il numero del giocatore che possiede il professore
    public int checkProf(int color)  {
        if(color == 0) return greenProf;
        else if(color == 1) return redProf;
        else if(color == 2)  return yellowProf;
        else if(color == 3) return pinkProf;
        else if(color == 4) return blueProf;
        return -1;
        }
}
