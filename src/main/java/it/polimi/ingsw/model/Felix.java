package it.polimi.ingsw.model;

public class Felix{

    //UML: Cambio nome del metodo
    public void useEffect(Island island, Player player){
        int influence = metodoCheRestituisceInfluenza();
        if(island.isTower)
            influence = metodoCheRestituisceInfluenza() - island.totIsland;   //mi serve un metodo che restituisca l'influenza sull'isola
        return influence;
    }
}