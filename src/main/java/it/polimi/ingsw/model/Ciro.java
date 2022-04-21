package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Ciro extends CharacterCard{
    public int calculateInfluence(int numisola){
        int i, j, n, color;
        n = -1;
        for(i=0; !Game.islands.get(numisola); i++);
        ArrayList<Integer> influence = new ArrayList<>(3);
        for(j=0; j<Game.totPlayer; j++) influence.add(0);
        for(color=0; color<5; color++) {
            n = ProfTable.checkProf(color); //boh, sei arrivato qui ma manca il metodo
            influence.get(n).equals(Game.islands.get(i).greenPawn);3
        }
        Game.islands.get(i).isTower = true;
        Game.islands.get(i).colorTower = Game.players.get(n).towerSpace.colorTower;
        Game.unifyIsland(i);
    }
}
