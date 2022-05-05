package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TowerSpaceTest{
    @Test
    public void setStartNumTower(){
        Game game = new Game(2, true);
        game.start(game);
        game.newPlayer("Asael", game);
        game.newPlayer("Erika", game);
        game.players.get(0).towerSpace.setStartNumTower(game);
        assertEquals(8, game.players.get(0).towerSpace.getNumTower());
    }

}