package it.polimi.ingsw.model;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DiningRoomTest {
    @Test
    public void testDiningRoom(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Ezechiel",game);
        Game.newPlayer("Candace",game);
        assertEquals(0, game.players.get(1).diningRoom.getNumYellow());
        assertEquals(0, game.players.get(1).diningRoom.getNumBlue());
        assertEquals(0, game.players.get(0).diningRoom.getNumPink());
    }

    @Test
    public void testAddPawnToDiningRoom(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Abner", game);
        Game.newPlayer("Tamar", game);
        game.players.get(0).entrance.setNumPawn(4);
        game.players.get(0).entrance.setRedPawn(3);
        game.players.get(0).setNumCoin(4);
        for(int i = 0; i < 3; i++){
            game.players.get(0).diningRoom.addPawnToDiningRoom(ColorPawn.RED,  game.players.get(0), game);
        }
        assertEquals(3, game.players.get(0).diningRoom.getNumRed());
        assertEquals(0, game.players.get(0).entrance.getRedPawn());
        assertEquals(5, game.players.get(0).getNumCoin());
    }

    @Test
    public void testAddPawn(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Ezra", game);
        Game.newPlayer("Joshua", game);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(3);
        colorPawn.add(ColorPawn.BLUE);
        colorPawn.add(ColorPawn.YELLOW);
        colorPawn.add(ColorPawn.BLUE);
        game.players.get(1).diningRoom.setNumYellow(0);
        game.players.get(1).diningRoom.setNumBlue(2);
        int m = colorPawn.size();
        game.players.get(1).diningRoom.addPawn(m, colorPawn, game.players.get(1), game);
        assertEquals(1, game.players.get(1).diningRoom.getNumYellow());
        assertEquals(4, game.players.get(1).diningRoom.getNumBlue());.
    }

    @Test
    public void testRemovePawnFromDiningRoom(){
        int i;
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Ezra", game);
        Game.newPlayer("Joshua", game);
        game.players.get(1).entrance.setNumPawn(8);
        game.players.get(1).entrance.setPinkPawn(8);
        for(i=0;i<8;i++) {
            game.players.get(1).diningRoom.addPawnToDiningRoom(ColorPawn.PINK, game.players.get(1), game);
        }
        game.players.get(1).diningRoom.removePawnFromDiningRoom(ColorPawn.PINK, game.players.get(1), game);
        assertEquals(7, game.players.get(1).diningRoom.getNumPink());
    }
    @Test
    public void testRemovePawnFromDiningRoom2(){
        Game game = new Game(2, true);
        game.start(game);
        Game.newPlayer("Ezra", game);
        Game.newPlayer("Joshua", game);
        int i;
        game.players.get(1).entrance.setGreenPawn(5);
        game.players.get(1).entrance.setNumPawn(5);
        for(i=0; i<3; i++)
            game.players.get(1).diningRoom.addPawnToDiningRoom(ColorPawn.GREEN, game.players.get(1), game);
        game.players.get(1).diningRoom.removePawnFromDiningRoomToEntrance(ColorPawn.GREEN,  game.players.get(1), game);
        assertEquals(2, game.players.get(1).diningRoom.getNumGreen());
        assertEquals(3, game.players.get(1).entrance.getGreenPawn());
        assertEquals(3, game.players.get(1).entrance.getNumPawn());
    }

}