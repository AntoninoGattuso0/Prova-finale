package it.polimi.ingsw.model;

public class CharacterCard { //vorrei riportarla a public class. le 12 carte come sottoclassi (leggere gruppo) -Nino
                                //va assolutamente riportata a classe sennò non posso dare in ingresso un tipo Charactercard e quindi
                                // non posso sapere quale dei character il player ha scelto
    protected int coinPrice; //modificato in protected
    protected boolean On;

    public boolean isOn(){  //secondo me isOn non serve. -nino
        On=true;
        return On;
    }

    public int increasePrice(){
        return coinPrice++;
    }
}