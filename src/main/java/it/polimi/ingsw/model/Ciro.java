package it.polimi.ingsw.model;

//ce la faremo
public class Ciro extends CharacterCard{
    Ciro(){
        coinPrice=3;
    }
    public void useEffect(Island island) {//copia del metodo per calcolare la top influenza
        Game.topInfluence(island);
    }
}


