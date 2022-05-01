package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MariaTest {
    @Test
    public void testUseEffectMaria(){
        Game game = new Game(4, true);
        Game.newPlayer("Johnny", game);
        Game.newPlayer("Frank", game);
        Game.newPlayer("Sibilla", game);
        Game.newPlayer("Ruperta", game);
        Game.players.get(0).diningRoom.setNumGreen(3);
        Game.players.get(0).diningRoom.setNumYellow(2);
        Game.players.get(1).diningRoom.setNumGreen(2);
        Game.players.get(1).diningRoom.setNumBlue(2);
        Game.players.get(2).diningRoom.setNumPink(1);
        ArrayList<ColorPawn> colorPawns = new ArrayList<>();
        colorPawns.add(ColorPawn.GREEN);
        colorPawns.add(ColorPawn.RED);
        colorPawns.add(ColorPawn.BLUE);
        colorPawns.add(ColorPawn.PINK);
        Maria maria = new Maria();
        CharacterCard card1 = new CharacterCard(maria);
        card1.useEffect.useEffect(game, 1, Game.islands.get(0), Game.players.get(0), colorPawns);
        System.out.println(Game.players.get(0).diningRoom.getNumGreen());
        System.out.println(Game.players.get(0).diningRoom.getNumRed());
        System.out.println(Game.players.get(0).diningRoom.getNumYellow());
        System.out.println(Game.players.get(0).diningRoom.getNumPink());
        System.out.println(Game.players.get(0).diningRoom.getNumBlue());

    }
}