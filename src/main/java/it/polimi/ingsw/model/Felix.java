package it.polimi.ingsw.model;

public class Felix{

    //UML: Cambio nome del metodo
    public void useEffect(Island island, Player player){
        int influence;
        if(island.isTower)
            influence = Game.topInflunce() - island.totIsland;
    }
}
