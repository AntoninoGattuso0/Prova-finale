package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Collections;

public class Ivan extends CharacterCard{
    Ivan(){
        coinPrice=2;
    }
    public void useEffect(Island island, Player player){
        int i, j, k, n, color, max;
        boolean notunique = false;
        ArrayList<Integer> influence = new ArrayList<>();
        for(i=0; i<Game.totPlayer; i++) influence.add(0);
        for(color=0; color<5; color++) {
            n = ProfTable.checkProf(color);
            if(color==0 && n!=-1) influence.set(n, influence.get(n) + island.greenPawn);

            else if(color==1 && n!=-1) influence.set(n, influence.get(n) + island.redPawn);

            else if(color==2 && n!=-1)influence.set(n, influence.get(n) + island.yellowPawn);

            else if(color==3 && n!=-1)influence.set(n, influence.get(n) + island.pinkPawn);

            else if(color==4 && n!=-1)influence.set(n, influence.get(n) + island.bluePawn);
        }
        if(Game.totPlayer==4){
            for(i=1; Game.players.get(i).towerSpace.colorTower == Game.players.get(0).towerSpace.colorTower; i++);
            influence.set(0, influence.get(0) + influence.get(i));//ho tutte le pedine di una squadra sommate al player 0
            for(j=1; j<Game.totPlayer && j==i; j++);
            for(k=2; k<Game.totPlayer && (k==i || k==j); k++);
            influence.set(j, influence.get(j) + influence.get(k));//sommo tutte le pedine dell'altra squadra all'indirizzo j
            influence.set(i, 0);
            influence.set(k, 0);
        }

        for(i=0; i<Game.totPlayer; i++){
            if(island.isTower && island.colorTower == Game.players.get(i).towerSpace.colorTower)
                influence.set(i, influence.get(i) + island.totIsland);
        }

        influence.set(Game.players.indexOf(player), influence.get(Game.players.indexOf(player)) + 2);

        max = Collections.max(influence);

        for(i=0; i<influence.size() && !notunique;i++){
            for(j=i+1; j<influence.size() && !notunique; j++){
                if((influence.get(i).equals(influence.get(j))) && influence.get(i).equals(max) && Game.players.get(i).towerSpace.colorTower != Game.players.get(j).towerSpace.colorTower) notunique = true;
            }
        }
        if(!notunique) island.colorTower = Game.players.get(influence.indexOf(max)).towerSpace.colorTower;
        Game.unifyIsland(Game.islands.indexOf(island));
    }
}