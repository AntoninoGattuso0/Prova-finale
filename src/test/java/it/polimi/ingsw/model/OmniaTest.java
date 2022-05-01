package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OmniaTest {
    @Test
    public void testUseEffectOmnia(){
        Game game = new Game(4, true);
        Game.newPlayer("Johnny", game);
        Game.newPlayer("Frank", game);
        Game.newPlayer("Sibilla", game);
        Game.newPlayer("Ruperta", game);
        Game.players.get(0).diningRoom.position[0][0] = 1;
        Game.players.get(0).diningRoom.position[0][1] = 1;
        Game.players.get(0).diningRoom.position[0][2] = 1;
        Game.players.get(0).diningRoom.position[0][3] = 1;
        Game.players.get(0).diningRoom.setNumGreen(4);
        Game.players.get(0).diningRoom.position[2][0] = 1;
        Game.players.get(0).diningRoom.position[2][1] = 1;
        Game.players.get(0).diningRoom.setNumYellow(3);
        ArrayList<ColorPawn> colorPawns = new ArrayList<>();
        colorPawns.add(ColorPawn.GREEN);
        Omnia omnia = new Omnia();
        CharacterCard card = new CharacterCard(omnia);
        System.out.println(Game.players.get(0).diningRoom.getNumGreen());
        card.useEffect.useEffect(game, 1, Game.islands.get(0), Game.players.get(0), colorPawns);
        System.out.println(Game.players.get(0).diningRoom.getNumGreen());
    }
}