package it.polimi.ingsw.model;

public class Felix{

    //UML: Cambio nome del metodo
    public int noTowerInflunence(Island island){
        int influence;
        if(island.isTower)
        influence = Game.moveProf() - island.totIsland;

        return influence;
    }
}
