package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Collections;

public class Lancillotto{

    public int removeColor(int island, int removedColor){
        int i, j, k, n, color, max;
        boolean notunique = false;
        ArrayList<Integer> influence = new ArrayList<>();
        for(i=0; i<Game.totPlayer; i++) influence.add(0);
        for(color=0; color<5; color++) {
            if(color==removedColor)color++;
            n = ProfTable.checkProf(color);
            if(color==0 && n!=-1) influence.set(n, influence.get(n) + Game.islands.get(island).greenPawn);

            else if(color==1 && n!=-1) influence.set(n, influence.get(n) + Game.islands.get(island).redPawn);

            else if(color==2 && n!=-1)influence.set(n, influence.get(n) + Game.islands.get(island).yellowPawn);

            else if(color==3 && n!=-1)influence.set(n, influence.get(n) + Game.islands.get(island).pinkPawn);

            else if(color==4 && n!=-1)influence.set(n, influence.get(n) + Game.islands.get(island).bluePawn);
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
            if(Game.islands.get(island).isTower && Game.islands.get(island).colorTower == Game.players.get(i).towerSpace.colorTower)
                influence.set(i, influence.get(i) + Game.islands.get(island).totIsland);
        }

        max = Collections.max(influence);

        for(i=0; i<influence.size() && !notunique;i++){
            for(j=i+1; j<influence.size() && !notunique; j++){
                if((influence.get(i).equals(influence.get(j))) && influence.get(i).equals(max) && i!=j) notunique = true;
            }
        }
        if(!notunique) return influence.indexOf(max);
        return -1;
    }
}
