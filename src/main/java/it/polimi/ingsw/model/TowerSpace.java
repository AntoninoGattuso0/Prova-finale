package it.polimi.ingsw.model;

public class TowerSpace {

    protected ColorTower colorTower;
    private int numTower;

    public int getNumTower() {
        return numTower;
    }  // esiste qualche metodo che sposta le torri decrementandole da qui?

    public void setNumTower(int numTower){
        this.numTower = numTower;
    }

    public ColorTower getColorTower() {
        return colorTower;
    }

    /**
     * set the number of tower
     */
    public void setStartNumTower(Game game){
        if(game.totPlayer == 2 || game.totPlayer == 4) setNumTower(8);
        else if(game.totPlayer == 3) setNumTower(6);
    }

    /**
     * set the colorTower
     */
    public TowerSpace(Game game){
        int i = game.players.size();
        setNumTower(0);
        if(game.totPlayer == 2||game.totPlayer == 3) {
            if (i == 0) {
                colorTower = ColorTower.WHITE;
                setStartNumTower(game);
            } else if (i == 1) {
                colorTower = ColorTower.BLACK;
                setStartNumTower(game);
            } else if (i == 2) {
                colorTower = ColorTower.GREY;
                setStartNumTower(game);
            }
        }else{
                if (i == 0||i == 2) {
                    colorTower = ColorTower.WHITE;
                    if(i == 0) setStartNumTower(game);
                } else if (i == 1||i == 3) {
                    colorTower = ColorTower.BLACK;
                    if(i == 1) setStartNumTower(game);
                }
            }
        }
}