package it.polimi.ingsw.model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class BarbaraTest {
    @Test
    public void TestUseEffectBarbara() {
        Game game = new Game(2, true);
        Barbara barbara = new Barbara(game);
        ArrayList<ColorPawn> colorPawn= new ArrayList<>();
        colorPawn.add(ColorPawn.GREEN);
        Game.newPlayer("a",game);//0
        Game.newPlayer("b",game);//1
        ProfTable.setGreenProf(0);
        ProfTable.setRedProf(0);
        ProfTable.setPinkProf(0);
        game.players.get(0).diningRoom.setNumGreen(3);
        game.players.get(1).diningRoom.setNumGreen(3);
        game.players.get(0).diningRoom.setNumRed(3);
        game.players.get(1).diningRoom.setNumRed(2);
        game.players.get(0).diningRoom.setNumYellow(3);
        game.players.get(1).diningRoom.setNumYellow(4);
        game.players.get(0).diningRoom.setNumBlue(8);
        game.players.get(1).diningRoom.setNumBlue(3);
        CharacterCard characterCard=new CharacterCard(barbara);
        characterCard.useEffect.useEffect(game,1,game.islands.get(0),game.players.get(0),colorPawn);
        assertEquals(1, ProfTable.getGreenProf());
        assertEquals(3,barbara.getCoinPrice());
        assertEquals(0, ProfTable.getRedProf());
        assertEquals(1, ProfTable.getPinkProf());
    }
}