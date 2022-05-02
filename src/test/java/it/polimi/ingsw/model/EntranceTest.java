package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntranceTest {
    @Test
    public void TestEntrance(){
        Game game = new Game(2, true);
        Game.newPlayer("Player0",game);
        Game.newPlayer("Player1",game);
        StudentBag studentBag = new StudentBag();
        assertEquals(9, Game.players.get(0).entrance.getNumPawn());
        System.out.println("Green Pawns in entrance: " + Game.players.get(0).entrance.getGreenPawn());
        System.out.println("Red Pawns in entrance: " + Game.players.get(0).entrance.getRedPawn());
        System.out.println("Yellow Pawns in entrance: " + Game.players.get(0).entrance.getYellowPawn());
        System.out.println("Pink Pawns in entrance: " + Game.players.get(0).entrance.getPinkPawn());
        System.out.println("Blue Pawns in entrance: " + Game.players.get(0).entrance.getBluePawn());
        assertEquals(9, Game.players.get(0).entrance.getGreenPawn() + Game.players.get(0).entrance.getRedPawn() + Game.players.get(0).entrance.getYellowPawn() + Game.players.get(0).entrance.getPinkPawn() + Game.players.get(0).entrance.getBluePawn());
        assertEquals(102, game.studentBag.getNum());
    }
    @Test
    public void testMovePawnToIsland(){
        Game game= new Game(3,true);
        Game.newPlayer("Paolo",game);
        Game.newPlayer("Rebeca",game);
        Game.newPlayer("Antonino",game);


    }
}