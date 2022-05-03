package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NicolaTest {
    @Test
    public void testUseEffectNicola() {
        Game game = new Game(4, true);
        game.start(game);
        Game.newPlayer("Johnny", game);
        Game.newPlayer("Frank", game);
        Game.newPlayer("Sibilla", game);
        Game.newPlayer("Ruperta", game);
        game.players.get(0).diningRoom.position[0][0] = 1;
        game.players.get(0).diningRoom.position[0][1] = 1;
        game.players.get(0).diningRoom.position[0][2] = 1;
        game.players.get(0).diningRoom.setNumGreen(3);
        game.players.get(0).diningRoom.position[2][0] = 1;
        game.players.get(0).diningRoom.position[2][1] = 1;
        game.players.get(0).diningRoom.setNumYellow(3);
        Nicola nicola = new Nicola(game.studentBag, game);
        CharacterCard card = new CharacterCard(nicola);
        ArrayList<ColorPawn> colorPawns = new ArrayList<>();
        colorPawns.add(ColorPawn.GREEN);
        System.out.println(game.players.get(0).diningRoom.getNumGreen());
        System.out.println(Nicola.getGreenPawn());
        System.out.println(nicola.coinPrice);
        card.useEffect.useEffect(game, 1, game.islands.get(0), game.players.get(0), colorPawns);
        System.out.println(game.players.get(0).diningRoom.getNumGreen());
        System.out.println(Nicola.getGreenPawn());
        System.out.println(nicola.coinPrice);


    }
}