package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssistantCardTest {
    @Test
    public void TestAssistantCard() {
        int i,j;
        Game game = new Game(3, true);
        game.start(game);
        Game.newPlayer("a", game);
        Game.newPlayer("b", game);
        Game.newPlayer("c", game);
        for (j = 0; j < game.totPlayer; j++) {
            for (i = 0; i < 10; i++)
                assertEquals(game.players.get(j).deckAssistant.get(i).getCardValue(), game.players.get(0).deckAssistant.get(i).getCardValue());
            for (i = 0; i < 10; i++)
                assertEquals(game.players.get(j).deckAssistant.get(i).getStep(), game.players.get(0).deckAssistant.get(i).getStep());
        }
    }
}