package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntranceTest {
    @Test
    public void TestEntrance(){
        Game game = new Game(2, true);
        game.newPlayer("Player0",game);
        game.newPlayer("Player1",game);
        StudentBag studentBag = new StudentBag();
        assertEquals(7, game.players.get(0).entrance.getNumPawn());
        System.out.println("Player0: ");
        System.out.println("Green Pawns in entrance: " + game.players.get(0).entrance.getGreenPawn());
        System.out.println("Red Pawns in entrance: " + game.players.get(0).entrance.getRedPawn());
        System.out.println("Yellow Pawns in entrance: " + game.players.get(0).entrance.getYellowPawn());
        System.out.println("Pink Pawns in entrance: " + game.players.get(0).entrance.getPinkPawn());
        System.out.println("Blue Pawns in entrance: " + game.players.get(0).entrance.getBluePawn());

        //posso togliere dalla 23 a 28
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
    public void testMovePawnToIsland(){
        Game game1= new Game(3,true);
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
    public void TestStartNumPawn(){
        Game game3 = new Game(2, true);
        game3.newPlayer("Player0", game3);
        game3.newPlayer("Player1", game3);
        game3.players.get(0).entrance.startNumPawn(game3);
        assertEquals(7, game3.players.get(0).entrance.getNumPawn());
    }
    @Test
    public void testChooseCloud(){
        Game game2 = new Game(2, true);
        game2.newPlayer("Player0", game2);
        game2.newPlayer("Player1", game2);
        game2.players.get(0).entrance.setNumPawn(4);
        game2.players.get(0).entrance.chooseCloud(game2.clouds.get(0));
        assertEquals(7, game2.players.get(0).entrance.getNumPawn());


    }

}