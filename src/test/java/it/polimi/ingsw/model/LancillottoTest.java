package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LancillottoTest {
    @Test
    public void testLancillotto(){
        Game game = new Game(3, true);
        game.start(game);
        String nick1 = "Franco";
        String nick2 = "Giovanni";
        String nick3 = "Raviolo";
        game.newPlayer(nick1, game);
        game.newPlayer(nick2, game);
        game.newPlayer(nick3, game);
        game.players.get(0).towerSpace.colorTower = ColorTower.BLACK;
        game.players.get(1).towerSpace.colorTower = ColorTower.BLACK;
        game.players.get(2).towerSpace.colorTower = ColorTower.BLACK;
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
        Lancillotto lancillotto = new Lancillotto();
        CharacterCard card1 = new CharacterCard(lancillotto,8);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        card1.useEffect.useEffect(game, 2,game.islands.get(0),game.players.get(0),colorPawn);
        assertEquals(ColorTower.BLACK, game.islands.get(0).getColorTower());
    }

}