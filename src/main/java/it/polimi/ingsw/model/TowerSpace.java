package it.polimi.ingsw.model;
public class TowerSpace {
    protected ColorTower colorTower;
    private int numTower;
    public TowerSpace(Game game){
        int i = game.players.size();
        setNumTower(0);
        if(game.totPlayer==2||game.totPlayer==3) {
            if (i == 0) {
                colorTower = ColorTower.WHITE;
                setNumTowerIniziale(game);
            } else if (i == 1) {
                colorTower = ColorTower.BLACK;
                setNumTowerIniziale(game);
            } else if (i == 2) {
                colorTower = ColorTower.GREY;
                setNumTowerIniziale(game);
            }
        }else{
                if (i == 0||i==2) {
                    colorTower = ColorTower.WHITE;
                    if(i == 0) setNumTowerIniziale(game);
                } else if (i == 1||i==3) {
                    colorTower = ColorTower.BLACK;
                    if(i == 1) setNumTowerIniziale(game);
                    cioa
                }
            }
        }
    public void setNumTowerIniziale(Game game){
        if(game.totPlayer == 2 || game.totPlayer == 4) setNumTower(8);
        else if(game.totPlayer == 3) setNumTower(6);
    }
    public int getNumTower() {
        return numTower;
    }  // esiste qualche metodo che sposta le torri decrementandole da qui?
    public void setNumTower(int numTower){
        this.numTower = numTower;
    }
}