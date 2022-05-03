package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EntranceTest {
    @Test
    public void TestEntrance(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Player0",game);
        Game.newPlayer("Player1",game);
        StudentBag studentBag = new StudentBag();
        assertEquals(7, game.players.get(0).entrance.getNumPawn());
        System.out.println("Player0: ");
        System.out.println("Green Pawns in entrance: " + game.players.get(0).entrance.getGreenPawn());
        System.out.println("Red Pawns in entrance: " + game.players.get(0).entrance.getRedPawn());
        System.out.println("Yellow Pawns in entrance: " + game.players.get(0).entrance.getYellowPawn());
        System.out.println("Pink Pawns in entrance: " + game.players.get(0).entrance.getPinkPawn());
        System.out.println("Blue Pawns in entrance: " + game.players.get(0).entrance.getBluePawn());

        System.out.println("Player1: ");
        System.out.println("Green Pawns in entrance: " + game.players.get(1).entrance.getGreenPawn());
        System.out.println("Red Pawns in entrance: " + game.players.get(1).entrance.getRedPawn());
        System.out.println("Yellow Pawns in entrance: " + game.players.get(1).entrance.getYellowPawn());
        System.out.println("Pink Pawns in entrance: " + game.players.get(1).entrance.getPinkPawn());
        System.out.println("Blue Pawns in entrance: " + game.players.get(1).entrance.getBluePawn());
        assertEquals(7, game.players.get(0).entrance.getGreenPawn() + game.players.get(0).entrance.getRedPawn() + game.players.get(0).entrance.getYellowPawn() + game.players.get(0).entrance.getPinkPawn() + game.players.get(0).entrance.getBluePawn());
        assertEquals(106, game.studentBag.getNum());
    }

    @Test
    public void TestStartNumPawn(){
        Game game3 = new Game(2, true);
        game3.start(game3);
        game3.newPlayer("Player0", game3);
        game3.newPlayer("Player1", game3);
        game3.players.get(0).entrance.startNumPawn(game3);
        assertEquals(7, game3.players.get(0).entrance.getNumPawn());
    }

    @Test
    public void TestCheckNum(){
        Game game5 = new Game(2, true);
        game5.start(game5);
        game5.newPlayer("Player0", game5);
        game5.newPlayer("Player1", game5);
        game5.players.get(0).entrance.setNumPawn(5);
        assertTrue(game5.players.get(0).entrance.checkNum(game5));
        game5.players.get(0).entrance.setNumPawn(3);
        assertFalse(game5.players.get(0).entrance.checkNum(game5));
    }

    @Test
    public void testMovePawnToIsland(){
        Game game1= new Game(3,true);
        game1.start(game1);
        game1.newPlayer("Paolo", game1);
        game1.newPlayer("Rebeca", game1);
        game1.newPlayer("Antonino", game1);
        int k =  game1.players.get(0).entrance.getYellowPawn();
        int s = game1.islands.get(2).getYellowPawn();
        System.out.println("Yellow Pawns in player0 entrance: " + game1.players.get(0).entrance.getYellowPawn());
        System.out.println("Yellow Pawns on the 3 island: " + game1.islands.get(2).getYellowPawn());
        boolean minPawn =  game1.players.get(0).entrance.checkNum(game1);
        if(k > 0 && minPawn){
            ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
            colorPawn.add(ColorPawn.YELLOW);
            game1.players.get(0).entrance.movePawnToIsland(ColorPawn.YELLOW, game1.islands.get(2), game1);
            assertEquals(s + 1 , game1.islands.get(2).getYellowPawn());
            assertEquals(k - 1 , game1.players.get(0).entrance.getYellowPawn());
            System.out.println("Yellow Pawns in player0 entrance: " + game1.players.get(0).entrance.getYellowPawn());
            System.out.println("Yellow Pawns on the 3 island: " + game1.islands.get(2).getYellowPawn());
        }

    }


    @Test
    public void testMoveToIsland(){
        Game game4 = new Game(2, true);
        game4.start(game4);
        Game.newPlayer("Player0", game4);
        Game.newPlayer("Player1", game4);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(3);
        colorPawn.add(ColorPawn.GREEN);
        colorPawn.add(ColorPawn.GREEN);
        colorPawn.add(ColorPawn.RED);
        game4.players.get(1).entrance.setGreenPawn(5);
        game4.players.get(1).entrance.setRedPawn(2);
        game4.islands.get(4).setRedPawn(3);
        game4.islands.get(4).setGreenPawn(0);
        int n = 3;
        game4.players.get(1).entrance.moveToIsland(n, colorPawn, game4.islands.get(4), game4);
        assertEquals(4, game4.islands.get(4).getRedPawn());
        assertEquals(2, game4.islands.get(4).getGreenPawn());
    }

    @Test
    public void testChooseCloud(){
        Game game2 = new Game(2, true);
        game2.start(game2);
        Game.newPlayer("Player0", game2);
        Game.newPlayer("Player1", game2);
        game2.players.get(0).entrance.setNumPawn(4);
        game2.players.get(0).entrance.setPinkPawn(2);
        game2.clouds.get(0).setPinkPawn(1);
        game2.players.get(0).entrance.chooseCloud(game2.clouds.get(0), game2);
        assertEquals(7, game2.players.get(0).entrance.getNumPawn());
        assertEquals(3, game2.players.get(0).entrance.getPinkPawn());
        assertEquals(0, game2.clouds.get(0).getNumPawn());
        assertEquals(0, game2.clouds.get(0).getPinkPawn());
    }
}