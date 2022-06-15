package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IvanTest {

    @Test
    public void TestIvanUseEffect(){
        int contr=0;
        Game game = new Game(2, true);
        game.start(game);
        while (contr == 0) {
            if (game.getCharacterCards().get(0).getNumCard()==7) {
                contr = 1;
            }
            if (contr == 0) {
                game = new Game(2, true);
                game.start(game);
            }
        }
        game.newPlayer("Nicky", game);
        game.newPlayer("Gabi", game);
        game.getProfTable().setGreenProf(0);
        game.getProfTable().setRedProf(0);
        game.getProfTable().setYellowProf(1);
        game.getProfTable().setPinkProf(1);
        game.getProfTable().setBlueProf(-1);
        game.islands.get(3).setGreenPawn(3);
        game.islands.get(3).setRedPawn(2);
        game.islands.get(3).setYellowPawn(3);
        game.islands.get(3).setPinkPawn(2);
        game.islands.get(3).setBluePawn(0);
        game.islands.get(3).setTower(false);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        game.getCharacterCards().get(0).getUseEffect().useEffect(game, 8, game.islands.get(3), game.players.get(1), colorPawn);
        game.topInfluence(game.islands.get(3), game);
        assertEquals(ColorTower.BLACK, game.islands.get(3).getColorTower());
    }
}