package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CloudTest {
    @Test
    public void testRefillCloud() {
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Player0",game);
        Game.newPlayer("Player1",game);
        StudentBag studentBag = new StudentBag();
        System.out.println("numero pedine dentro StudentBag: " + studentBag.getNum());
        game.clouds.get(0).refillCloud(studentBag, game);
        System.out.println("numero pedine dentro StudentBag: " + studentBag.getNum());
        assertEquals(3, game.clouds.get(0).getNumPawn());
        assertEquals(117, studentBag.getNum());
    }
}