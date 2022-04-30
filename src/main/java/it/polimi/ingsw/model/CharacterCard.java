package it.polimi.ingsw.model;

public class CharacterCard { //vorrei riportarla a public class. le 12 carte come sottoclassi (leggere gruppo) -Nino
    UseEffect useEffect;
    //va assolutamente riportata a classe sennò non posso dare in ingresso un tipo Charactercard e quindiint coinPrice;                // non posso sapere quale dei character il player ha sceltoprotected int coinPrice; //modificato in protected


    public void useEffect(UseEffect useEffect){
        this.useEffect=useEffect;
    }

    public UseEffect getUseEffect() {
        return useEffect;
    }
}