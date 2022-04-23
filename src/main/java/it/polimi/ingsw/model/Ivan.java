package it.polimi.ingsw.model;

public class Ivan{
    public void useEffect(Island island){
        int infl = metodoCheCalcolaInfluenza();
        if(island.isTower)
            infl = metodoCheCalcolaInfluenza() + 2;
        return infl;
    }
}