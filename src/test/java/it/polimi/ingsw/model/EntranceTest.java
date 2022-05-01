package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

class EntranceTest {
    @Test
    public void testMovePawnToIsland(){
    Game game= new Game(3,true);
        Game.newPlayer("ciao",game);
        System.out.println(Game.players.get(0).entrance.getNumPawn());
        System.out.println(game.studentBag.getNum());



    }
}