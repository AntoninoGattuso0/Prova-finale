package it.polimi.ingsw.model;
public class TowerSpace {
    protected ColorTower colorTower;
    private int numTower;
    public TowerSpace(Game game){
        int i=Game.players.size();
        if(Game.totPlayer==2||Game.totPlayer==3) {
            if (i == 0) {
                colorTower = ColorTower.WHITE;
                setNumTowerIniziale();
            } else if (i == 1) {
                colorTower = ColorTower.BLACK;
                setNumTowerIniziale();
            } else if (i == 2) {
                colorTower = ColorTower.GREY;
                setNumTowerIniziale();
            }
        }else{
                if (i == 0||i==2) {
                    colorTower = ColorTower.WHITE;
                    setNumTowerIniziale();
                } else if (i == 1||i==3) {
                    colorTower = ColorTower.BLACK;
                    setNumTowerIniziale();
                }
            }
        }
    public void setNumTowerIniziale(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) setNumTower(8);
        else if(Game.totPlayer == 3) setNumTower(6);
    }
    public int getNumTower() {
        return numTower;
    }  // esiste qualche metodo che sposta le torri decrementandole da qui?
    public void setNumTower(int numTower){
        this.numTower = numTower;
    }
}