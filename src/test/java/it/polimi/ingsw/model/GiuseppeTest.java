package it.polimi.ingsw.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GiuseppeTest {
    @Test
    public void TestGiuseppe(){
        Game game=new Game(2,true);
        game.start(game);
        Giuseppe giuseppe = new Giuseppe(game.studentBag, game);
        System.out.println("Numero pedine verdi: " + giuseppe.getNumGreenPawn());
        System.out.println("Numero pedine rosse: " + giuseppe.getNumRedPawn());
        System.out.println("Numero pedine gialle: " + giuseppe.getNumYellowPawn());
        System.out.println("Numero pedine rosa: " + giuseppe.getNumPinkPawn());
        System.out.println("Numero pedine blue: " + giuseppe.getNumBluePawn());
    }

   /* @Test
    public void TestUseGiuseppeEffect(){

    }*/

}