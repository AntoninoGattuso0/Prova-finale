package it.polimi.ingsw.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ErnestoTest {
    @Test
    public void TestErnesto(){
        Game game = new Game(3, true);
        String nick1 = "Rebeca";
        String nick2 = "Paolo";
        String nick3 = "Antonino";
        Game.newPlayer(nick1, game);
        Game.newPlayer(nick2, game);
        Game.newPlayer(nick3, game);
        Ernesto ernesto = new Ernesto();
        CharacterCard characterCardErnesto = new CharacterCard(ernesto);
        assertEquals(2, ernesto.coinPrice);
    }
    @Test
    public void TestNotInfluence(){
        Game game = new Game(3, true);
        String nick1 = "Rebeca";
        String nick2 = "Paolo";
        String nick3 = "Antonino";
        Game.newPlayer(nick1, game);
        Game.newPlayer(nick2, game);
        Game.newPlayer(nick3, game);
        Island island = new Island();
        Ernesto ernesto = new Ernesto();
        CharacterCard characterCardErnesto = new CharacterCard(ernesto);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        characterCardErnesto.useEffect.useEffect(game, 2, Game.islands.get(0), Game.players.get(0), colorPawn);
        assertTrue(island.getProhibited());   //credo che il metodo topInfluence di game crei problemi
        assertEquals(3, ernesto.coinPrice);
        System.out.println("coinPrice " + ernesto.coinPrice);
    }
}