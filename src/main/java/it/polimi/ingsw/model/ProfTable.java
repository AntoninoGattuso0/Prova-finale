package it.polimi.ingsw.model;

import java.io.Serializable;

public class ProfTable implements Serializable {
    private int greenProf;
    private int redProf;
    private int yellowProf;
    private int pinkProf;
    private int blueProf;

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

    public void setGreenProf(int i) {
        greenProf = i;
    }

    public void setRedProf(int i) {
        redProf = i;
    }

    public void setYellowProf(int i) {
        yellowProf = i;
    }

    public void setPinkProf(int i) {
        pinkProf = i;
    }

    public void setBlueProf(int i) {
        this.blueProf = i;
    }

    /**
     * ProfTable is initialized all to -1 (-1 because no ine has the professor )
     */
    public ProfTable() {
        setGreenProf(-1);
        setRedProf(-1);
        setYellowProf(-1);
        setPinkProf(-1);
        setBlueProf(-1);
    }
    public int checkProf(int color) {
        if (color == 0) return greenProf;
        else if (color == 1) return redProf;
        else if (color == 2) return yellowProf;
        else if (color == 3) return pinkProf;
        else if (color == 4) return blueProf;
        else return -1;
    }
}