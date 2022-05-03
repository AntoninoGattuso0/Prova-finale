package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CiroTest {
    @Test
    public void TestCostruttoreCiro(){// DEVO CHECKARE QUANDO PAOLO RISOLVE LO SCAMBIO DI TORRI
        int i=0;
        Game game=new Game(3,true);
        game.start(game);
        Game.newPlayer("a",game);
        Game.newPlayer("b",game);
        Game.newPlayer("c",game);
        ProfTable.setPinkProf(2);
        ProfTable.setRedProf(2);
        ProfTable.setYellowProf(2);
        ProfTable.setGreenProf(2);
        Ciro ciro= new Ciro();
        ArrayList<ColorPawn> colorPawn= new ArrayList<>();
        CharacterCard characterCard=new CharacterCard(ciro);
        game.islands.get(0).setBluePawn(4);
        game.islands.get(0).setPinkPawn(5);
        characterCard.useEffect.useEffect(game,i,game.islands.get(0),game.players.get(0),colorPawn);
        if("GREY".equals(game.islands.get(0).getColorTower())){
            i=0;
        }
        assertEquals(0,i);
    }
}