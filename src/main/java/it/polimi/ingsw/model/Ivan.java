package it.polimi.ingsw.model;

public class Ivan{
    public void topInfl(Island island){
        int infl = metodoCheCalcolaInfluenza();
        if(island.isTower)
            infl = metodoCheCalcolaInfluenza() + 2;
        return infl;
    }
}
