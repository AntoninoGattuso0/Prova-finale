package it.polimi.ingsw.model;
import java.util.ArrayList;
import java.util.Collections;
public class Ivan extends UseEffect{
    private int coinPrice;
    public int getCoinPrice(){
        return coinPrice;
    }

    public void setCoinPrice(int coin){
        this.coinPrice=coin;
    }
    Ivan(){
        coinPrice=2;
    }
    public void useEffect(Game game, int i,Island island,Player player,ArrayList<ColorPawn> colorPawn){//   public void useEffect(Game game, int i,Island island,Player player,ArrayList<ColorPawn> colorPawn){
        int j, k, n, color, max;
        boolean notunique = false;
        ArrayList<Integer> influence = new ArrayList<>();
        for(i=0; i<game.totPlayer; i++) influence.add(0);
        for(color=0; color<5; color++) {
            n = game.profTable.checkProf(color);
            if(color==0 && n!=-1) influence.set(n, influence.get(n) + island.getGreenPawn());
            else if(color==1 && n!=-1) influence.set(n, influence.get(n) + island.getRedPawn());
            else if(color==2 && n!=-1)influence.set(n, influence.get(n) + island.getYellowPawn());
            else if(color==3 && n!=-1)influence.set(n, influence.get(n) + island.getPinkPawn());
            else if(color==4 && n!=-1)influence.set(n, influence.get(n) + island.getBluePawn());
        }
        if(game.totPlayer==4){
            for(i=1; game.players.get(i).towerSpace.colorTower == game.players.get(0).towerSpace.colorTower; i++);
            influence.set(0, influence.get(0) + influence.get(i));//ho tutte le pedine di una squadra sommate al player 0
            for(j=1; j<game.totPlayer && j==i; j++);
            for(k=2; k<game.totPlayer && (k==i || k==j); k++);
            influence.set(j, influence.get(j) + influence.get(k));//sommo tutte le pedine dell'altra squadra all'indirizzo j
            influence.set(i, 0);
            influence.set(k, 0);
        }
        for(i=0; i<game.totPlayer; i++){
            if(island.getTower() && island.getColorTower() == game.players.get(i).towerSpace.colorTower)
                influence.set(i, influence.get(i) + island.getTotIsland());
        }
        influence.set(game.players.indexOf(player), influence.get(game.players.indexOf(player)) + 2);
        max = Collections.max(influence);
        for(i=0; i<influence.size() && !notunique;i++){
            for(j=i+1; j<influence.size() && !notunique; j++){
                if((influence.get(i).equals(influence.get(j))) && influence.get(i).equals(max) && game.players.get(i).towerSpace.colorTower != game.players.get(j).towerSpace.colorTower) notunique = true;
            }
        }
        if(!notunique) island.setColorTower(game.players.get(influence.indexOf(max)).towerSpace.colorTower);
        Game.unifyIsland(game.islands.indexOf(island), game);
        setCoinPrice(3);
    }
}