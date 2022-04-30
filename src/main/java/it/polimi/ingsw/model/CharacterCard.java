package it.polimi.ingsw.model;

public abstract class CharacterCard { //vorrei riportarla a public class. le 12 carte come sottoclassi (leggere gruppo) -Nino

    protected int coinPrice;           //va assolutamente riportata a classe sennò non posso dare in ingresso un tipo Charactercard e quindiint coinPrice;                // non posso sapere quale dei character il player ha sceltoprotected int coinPrice; //modificato in protected

    public int increasePrice() {
        return coinPrice++;
    }

    public void useEffect(int i,Game game) {
    }
}