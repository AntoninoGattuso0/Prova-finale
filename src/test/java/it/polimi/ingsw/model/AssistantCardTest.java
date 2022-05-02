package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssistantCardTest {
    @Test
    public void TestAssistantCard() {
        int i,j;
        Game game = new Game(3, true);
        Game.newPlayer("a", game);
        Game.newPlayer("b", game);
        Game.newPlayer("c", game);
        for (j = 0; j < Game.totPlayer; j++) {
            for (i = 0; i < 10; i++)
                assertEquals(Game.players.get(j).deckAssistant.get(i).getCardValue(), Game.players.get(0).deckAssistant.get(i).getCardValue());
            for (i = 0; i < 10; i++)
                assertEquals(Game.players.get(j).deckAssistant.get(i).getStep(), Game.players.get(0).deckAssistant.get(i).getStep());
        }
    }
}