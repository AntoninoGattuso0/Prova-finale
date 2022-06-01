package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DanteTest {
    @Test
    public void TestUseEffectDante(){
    Game game= new Game(3,true);
    game.start(game);
    Dante dante=new Dante();
    int i=0;
    ArrayList<ColorPawn> colorPawns= new ArrayList<>();
    game.newPlayer("a",game);
    game.newPlayer("b",game);
    game.newPlayer("c",game);
    game.players.get(0).useAssistant(game,game.players.get(0),game.players.get(0).deckAssistant.get(2));
    System.out.println(game.players.get(0).getCurrentAssistant().getStep());
    CharacterCard characterCard=new CharacterCard(dante,3);
    characterCard.useEffect.useEffect(game,i,game.islands.get(0),game.players.get(0),colorPawns);
    assertEquals(4,game.players.get(0).getCurrentAssistant().getStep());
    }

}