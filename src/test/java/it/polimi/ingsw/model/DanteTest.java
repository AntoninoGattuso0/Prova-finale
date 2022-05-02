package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DanteTest {
@Test
    public void TestUseEffectDante(){
    Game game= new Game(3,true);
    Dante dante=new Dante();
    int i=0;
    ArrayList<ColorPawn> colorPawns= new ArrayList<>();
    Game.newPlayer("a",game);
    Game.newPlayer("b",game);
    Game.newPlayer("c",game);
    game.players.get(0).useAssistant(game.players.get(0),game.players.get(0).deckAssistant.get(2));
    CharacterCard characterCard=new CharacterCard(dante);
    characterCard.useEffect.useEffect(game,i,game.islands.get(0),game.players.get(0),colorPawns);
    assertEquals(3,game.players.get(0).deckAssistant.get(2).getStep());
}

}