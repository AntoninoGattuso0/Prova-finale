package it.polimi.ingsw.model;
public class ProfTable {
    private static int greenProf;
    private static int redProf;
    private static int yellowProf;
    private static int pinkProf;
    private static int blueProf;
    public ProfTable(){
        greenProf = -1;
        redProf = -1;
        yellowProf = -1;
        pinkProf = -1;
        blueProf = -1;
    }
    public static int getGreenProf() {
        return greenProf;
    }
    public static int getRedProf() {
        return redProf;
    }
    public static int getYellowProf() {
        return yellowProf;
    }
    public static int getPinkProf() {
        return pinkProf;
    }
    public static int getBlueProf() {
        return blueProf;
    }
    public static void setGreenProf(int i) {
        greenProf = i;
    }
    public static void setRedProf(int i) {
        redProf = i;
    }
    public static void setYellowProf(int i) {
        yellowProf = i;
    }
    public static void setPinkProf(int i) {
        pinkProf = i;
    }
    public static void setBlueProf(int i) {
        blueProf = i;
    }
    //modifiche all'UML:metodo restituisce un int ovvero il numero del giocatore che possiede il professore
    public int checkProf(int color)  {
        if(color == 0) return greenProf;
        else if(color == 1) return redProf;
        else if(color == 2)  return yellowProf;
        else if(color == 3) return pinkProf;
        else if(color == 4) return blueProf;
        else return -1;
        }
}
