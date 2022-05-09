package it.polimi.ingsw.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ErnestoTest {
    @Test
    public void TestNotInfluence(){
        Game game = new Game(3, true);
        game.start(game);
        String nick1 = "Rebeca";
        String nick2 = "Paolo";
        String nick3 = "Antonino";
        Game.newPlayer(nick1, game);
        Game.newPlayer(nick2, game);
        Game.newPlayer(nick3, game);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        ProfTable.setGreenProf(0);
        ProfTable.setRedProf(0);
        ProfTable.setYellowProf(1);
        ProfTable.setPinkProf(1);
        ProfTable.setBlueProf(-1);
        game.islands.get(9).setGreenPawn(6);
        game.islands.get(9).setRedPawn(2);
        game.islands.get(9).setYellowPawn(3);
        game.islands.get(9).setPinkPawn(2);
        game.islands.get(9).setBluePawn(0);
        game.islands.get(9).setTower(true);
        game.islands.get(9).setColorTower(ColorTower.BLACK);
        Ernesto ernesto = new Ernesto();
        ernesto.useEffect(game, 5, game.islands.get(9), game.players.get(0), colorPawn);
        Game.topInfluence(game.islands.get(9), game);
        assertEquals(ColorTower.BLACK, game.islands.get(9).getColorTower());
    }
}