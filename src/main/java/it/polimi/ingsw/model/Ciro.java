package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Ciro {
    public int useEffect(int numIsola){//copia del metodo per calcolare la top influenza
        int j, n, color;
        n = -1;
        ArrayList<Integer> influence = new ArrayList<>(3);
        for(j=0; j<Game.totPlayer; j++) influence.add(0);
        for(color=0; color<5; color++) {
            n = ProfTable.checkProf(color); //boh, sei arrivato qui ma manca il metodo
            influence.get(n).equals(Game.islands.get(numIsola).greenPawn);
        }
        Game.islands.get(numIsola).isTower = true;
        Game.islands.get(numIsola).colorTower = Game.players.get(n).towerSpace.colorTower;
        Game.unifyIsland(numIsola);

        return 0;
    }
}
