package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MariaTest {
    @Test
    public void testUseEffectMaria(){
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
        game.players.get(0).diningRoom.setNumYellow(2);
        ArrayList<ColorPawn> colorPawns = new ArrayList<>();
        colorPawns.add(ColorPawn.GREEN);
        colorPawns.add(ColorPawn.YELLOW);
        colorPawns.add(ColorPawn.BLUE);
        colorPawns.add(ColorPawn.PINK);
        Maria maria = new Maria();
        CharacterCard card1 = new CharacterCard(maria,9);
        System.out.println(game.players.get(0).diningRoom.getNumGreen());
        System.out.println(game.players.get(0).entrance.getGreenPawn());
        card1.useEffect.useEffect(game, 1, game.islands.get(0), game.players.get(0), colorPawns);
        System.out.println(game.players.get(0).diningRoom.getNumGreen());
        System.out.println(game.players.get(0).entrance.getGreenPawn());


    }
}