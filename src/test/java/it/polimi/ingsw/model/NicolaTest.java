package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class NicolaTest {//
    @Test
    public void testUseEffectNicola() {
        Game game = new Game(4, true);
        game.start(game);
        game.newPlayer("Johnny", game);
        game.newPlayer("Frank", game);
        game.newPlayer("Sibilla", game);
        game.newPlayer("Ruperta", game);
        game.players.get(0).diningRoom.position[0][0] = 1;
        game.players.get(0).diningRoom.position[0][1] = 1;
        game.players.get(0).diningRoom.position[0][2] = 1;
        game.players.get(0).diningRoom.setNumGreen(3);
        game.players.get(0).diningRoom.position[2][0] = 1;
        game.players.get(0).diningRoom.position[2][1] = 1;
        game.players.get(0).diningRoom.setNumYellow(3);
        Nicola nicola = new Nicola(game.studentBag, game);
        CharacterCard card = new CharacterCard(nicola,10);
        ArrayList<ColorPawn> colorPawns = new ArrayList<>();
        colorPawns.add(ColorPawn.GREEN);
        System.out.println(game.players.get(0).diningRoom.getNumGreen());
        System.out.println(nicola.getGreenPawn());
        System.out.println(nicola.coinPrice);
        card.useEffect.useEffect(game, 1, game.islands.get(0), game.players.get(0), colorPawns);
        System.out.println(game.players.get(0).diningRoom.getNumGreen());
        System.out.println(nicola.getGreenPawn());
        System.out.println(nicola.coinPrice);


    }
}