package it.polimi.ingsw.client.ModelLight;

public class LightDiningRoom {
    private int numGreen;
    private int numRed;
    private int numYellow;
    private int numPink;
    private int numBlue;

    public LightDiningRoom(){
        this.numGreen = 0;
        this.numRed = 0;
        this.numYellow = 0;
        this.numPink = 0;
        this.numBlue = 0;
    }

    public void setNumBlue(int numBlue) {
        this.numBlue = numBlue;
    }

    public void setNumGreen(int numGreen) {
        this.numGreen = numGreen;
    }

    public void setNumPink(int numPink) {
        this.numPink = numPink;
    }

    public void setNumRed(int numRed) {
        this.numRed = numRed;
    }

    public void setNumYellow(int numYellow) {
        this.numYellow = numYellow;
    }
}
