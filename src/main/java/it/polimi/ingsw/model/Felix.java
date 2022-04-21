package it.polimi.ingsw.model;

public class Felix extends CharacterCard{

    //UML: Cambio nome del metodo
    public int noTowerInflunence(Island island){
        int influence;
        if(island.isTower)
        influence = Game.topInfluence() - island.totIsland;  //totIsland sarebbe il numro di isole che sono unite?
                                 //dovrebbe esserci un metodo che restituisce l'influenza del giocatore sull'isola
        return influence;
    }
}
