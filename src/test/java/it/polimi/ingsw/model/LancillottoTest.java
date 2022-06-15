package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LancillottoTest {
    @Test
    public void testLancillotto(){
        int contr=0;
        Game game = new Game(3, true);
        game.start(game);
        while (contr == 0) {
            if (game.getCharacterCards().get(0).getNumCard()==8) {
                contr = 1;
            }
            if (contr == 0) {
                game = new Game(3, true);
                game.start(game);
            }
        }
        String nick1 = "Franco";
        String nick2 = "Giovanni";
        String nick3 = "Raviolo";
        game.newPlayer(nick1, game);
        game.newPlayer(nick2, game);
        game.newPlayer(nick3, game);
        game.getProfTable().setGreenProf(0);
        game.getProfTable().setRedProf(0);
        game.getProfTable().setYellowProf(1);
        game.getProfTable().setPinkProf(2);
        game.getProfTable().setBlueProf(-1);
        game.islands.get(0).setGreenPawn(3);
        game.islands.get(0).setRedPawn(2);
        game.islands.get(0).setYellowPawn(4);
        game.islands.get(0).setPinkPawn(3);
        game.islands.get(0).setBluePawn(0);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        game.getCharacterCards().get(0).getUseEffect().useEffect(game, 2,game.islands.get(0),game.players.get(1),colorPawn);
        game.topInfluence(game.getIslands().get(0),game);
        assertEquals(ColorTower.BLACK, game.islands.get(0).getColorTower());
    }

}