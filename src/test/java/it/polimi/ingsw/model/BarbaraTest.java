package it.polimi.ingsw.model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class BarbaraTest {
    @Test
    public void test1() {

        Game game = new Game(2, true);
        Barbara barbara = new Barbara();
        ArrayList<ColorPawn> colorPawn= new ArrayList<>();
        colorPawn.add(ColorPawn.GREEN);
        Game.newPlayer("a",game);//0
        Game.newPlayer("b",game);//1
        ProfTable.setGreenProf(0);
        ProfTable.setRedProf(1);
        ProfTable.setYellowProf(0);
        ProfTable.setPinkProf(0);
        ProfTable.setBlueProf(0);
        CharacterCard characterCard=new CharacterCard(barbara);
        characterCard.useEffect.useEffect(game,1,Game.islands.get(0),Game.players.get(0),colorPawn);
        assertEquals(1, ProfTable.getGreenProf());
    }
}