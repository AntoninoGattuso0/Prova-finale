package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class LightGame implements Serializable {
    @Serial
    private static final long serialVersionUID= 3353043693680634940L;
    private ProfTable profTable;
    private  ArrayList<LightCloud> clouds;
    private  ArrayList<LightPlayer> players;
    private  ArrayList<Island> islands;
    private int numPlayers;
    private boolean isExpert;
    private ArrayList<CharacterCard> characterCards;
    private Antonio antonio;
    private Barbara barbara;
    private Ciro ciro;
    private Dante dante;
    private Ernesto ernesto;
    private Felix felix;
    private Giuseppe giuseppe;
    private Ivan ivan;
    private Lancillotto lancillotto;
    private Maria maria;
    private Nicola nicola;
    private Omnia omnia;
    public LightGame(ArrayList<CharacterCard> characterCards,boolean isExpert, ArrayList<LightCloud> clouds, ArrayList<LightPlayer> players, ArrayList<Island> islands, int numPlayers, ProfTable profTable, Antonio antonio, Barbara barbara, Ciro ciro, Dante dante, Ernesto ernesto, Felix felix, Giuseppe giuseppe, Ivan ivan, Lancillotto lancillotto, Maria maria, Nicola nicola, Omnia omnia){
        this.characterCards = characterCards;
        this.clouds=clouds;
        this.players=players;
        this.islands=islands;
        this.isExpert=isExpert;
        this.numPlayers=numPlayers;
        this.profTable=profTable;
        this.antonio = antonio;
        this.barbara = barbara;
        this.ciro = ciro;
        this.dante = dante;
        this.ernesto = ernesto;
        this.felix = felix;
        this.giuseppe = giuseppe;
        this.ivan = ivan;
        this.lancillotto = lancillotto;
        this.maria = maria;
        this.nicola = nicola;
        this.omnia = omnia;
    }
    public boolean getIsExpert(){
        return isExpert;
    }
    public ProfTable getProfTable() {
        return profTable;
    }
    public int getNumPlayers() {
        return numPlayers;
    }
    public ArrayList<Island> getIslands() {
        return islands;
    }
    public ArrayList<LightCloud> getClouds() {
        return clouds;
    }
    public ArrayList<LightPlayer> getPlayers() {
        return players;
    }

    public ArrayList<CharacterCard> getCharacterCards() {
        return characterCards;
    }

    public Antonio getAntonio() {
        return antonio;
    }

    public Barbara getBarbara() {
        return barbara;
    }

    public Ciro getCiro() {
        return ciro;
    }

    public Dante getDante() {
        return dante;
    }

    public Ernesto getErnesto() {
        return ernesto;
    }

    public Felix getFelix() {
        return felix;
    }

    public Giuseppe getGiuseppe() {
        return giuseppe;
    }

    public Ivan getIvan() {
        return ivan;
    }

    public Lancillotto getLancillotto() {
        return lancillotto;
    }

    public Maria getMaria() {
        return maria;
    }

    public Nicola getNicola() {
        return nicola;
    }

    public Omnia getOmnia() {
        return omnia;
    }
}
