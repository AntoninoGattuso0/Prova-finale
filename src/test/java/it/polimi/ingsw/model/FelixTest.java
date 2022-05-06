package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FelixTest {

    @Test
    public void testFelix(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Andre", game);
        Game.newPlayer("John", game);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        ProfTable.setGreenProf(0);
        ProfTable.setRedProf(1);
        ProfTable.setYellowProf(0);
        ProfTable.setPinkProf(1);
        ProfTable.setBlueProf(1);
        game.islands.get(7).setGreenPawn(3);
        game.islands.get(7).setRedPawn(2);
        game.islands.get(7).setYellowPawn(4);
        game.islands.get(7).setPinkPawn(0);
        game.islands.get(7).setBluePawn(4);
        game.islands.get(7).setTower(true);
        game.islands.get(7).setColorTower(ColorTower.BLACK);
        Felix felix = new Felix();
        felix.useEffect(game, 6, game.islands.get(7), game.players.get(1), colorPawn);
        assertEquals(ColorTower.WHITE, game.islands.get(7).getColorTower());
        System.out.println("Costo attuale carta Felix: " + felix.getCoinPrice());
    }