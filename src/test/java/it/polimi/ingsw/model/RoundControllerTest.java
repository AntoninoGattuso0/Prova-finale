package it.polimi.ingsw.model;

import it.polimi.ingsw.controller.RoundController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RoundControllerTest {
    @Test
    public void RoundControllerTest(){
        Game game=new Game(3,true);
        game.start(game);
        ArrayList<Player> players;
        game.newPlayer("A",game);
        game.newPlayer("B",game);
        game.newPlayer("C",game);
        game.getPlayers().get(0).setCurrentAssistant(game.getPlayers().get(0).deckAssistant.get(8));
        game.getPlayers().get(1).setCurrentAssistant(game.getPlayers().get(1).deckAssistant.get(2));
        game.getPlayers().get(2).setCurrentAssistant(game.getPlayers().get(2).deckAssistant.get(5));
        RoundController roundController=new RoundController(game.getPlayers());
        players=roundController.newRoundOrder(game);
        System.out.println(players.get(0).getNickname() +" " +players.get(1).getNickname()+" "+players.get(2).getNickname() );
    }
}
