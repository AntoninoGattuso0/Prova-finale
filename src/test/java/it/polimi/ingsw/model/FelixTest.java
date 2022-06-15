package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FelixTest {

    @Test
    public void testFelix(){
        int contr=0;
        Game game = new Game(2, true);
        game.start(game);
        while (contr == 0) {
            if (game.getCharacterCards().get(0).getNumCard()==5) {
                contr = 1;
            }
            if (contr == 0) {
                game = new Game(2, true);
                game.start(game);
            }
        }
        game.newPlayer("Andre", game);
        game.newPlayer("John", game);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        game.getProfTable().setGreenProf(0);
        game.getProfTable().setRedProf(1);
        game.getProfTable().setYellowProf(0);
        game.getProfTable().setPinkProf(1);
        game.getProfTable().setBlueProf(1);
        game.islands.get(7).setGreenPawn(3);
        game.islands.get(7).setRedPawn(2);
        game.islands.get(7).setYellowPawn(4);
        game.islands.get(7).setPinkPawn(0);
        game.islands.get(7).setBluePawn(4);
        game.islands.get(7).setMotherNature(true);
        game.islands.get(7).setTower(true);
        game.islands.get(7).setColorTower(ColorTower.BLACK);
        game.getCharacterCards().get(0).getUseEffect().useEffect(game, 6, game.islands.get(7), game.players.get(1), colorPawn);
        game.topInfluence(game.getIslands().get(7), game);
        assertEquals(ColorTower.WHITE, game.islands.get(7).getColorTower());
    }
}