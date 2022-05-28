package it.polimi.ingsw.model;
public class CharacterCard {
    UseEffect useEffect;
    public CharacterCard(UseEffect useeffect){
        useEffect=useeffect;
    }

    public UseEffect getUseEffect() {
        return useEffect;
    }
}