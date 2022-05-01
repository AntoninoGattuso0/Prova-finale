package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

class EntranceTest {

    @Test
    public void testMovePawnToIsland(){
    Game game= new Game(3,true);
        Game.newPlayer("Paolo",game);
        Game.newPlayer("Rebeca",game);
        Game.newPlayer("Antonino",game);

        System.out.println("Pawns in player's 0 entrance at the begging of the game: "+ Game.players.get(0).entrance.getNumPawn());
        System.out.println("Pawns in player's 1 entrance at the begging of the game: "+ Game.players.get(1).entrance.getNumPawn());
        System.out.println("Pawns in player's 2 entrance at the begging of the game: "+ Game.players.get(2).entrance.getNumPawn());
        System.out.println("Pawns in the student bag: "+ game.studentBag.getNum());

    }
}