package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IvanTest {

    @Test
    public void TestIvanUseEffect(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Nicky", game);
        Game.newPlayer("Gabi", game);
        ProfTable.setGreenProf(0);
        ProfTable.setRedProf(0);
        ProfTable.setYellowProf(1);
        ProfTable.setPinkProf(1);
        ProfTable.setBlueProf(-1);
        game.islands.get(3).setGreenPawn(3);
        game.islands.get(3).setRedPawn(2);
        game.islands.get(3).setYellowPawn(3);
        game.islands.get(3).setPinkPawn(2);
        game.islands.get(3).setBluePawn(0);
        game.islands.get(3).setTower(false);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        Ivan ivan = new Ivan();
        CharacterCard card = new CharacterCard(ivan);
        card.useEffect.useEffect(game, 8, game.islands.get(3), game.players.get(1), colorPawn);
        Game.topInfluence(game.islands.get(3), game);
        assertEquals(ColorTower.BLACK, game.islands.get(3).getColorTower());
        System.out.println("Costo attuale carta Ivan: " + ivan.getCoinPrice());
    }
}