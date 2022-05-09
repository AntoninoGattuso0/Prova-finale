package it.polimi.ingsw.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GiuseppeTest {
    @Test
    public void TestGiuseppe(){
        Game game = new Game(2,true);
        game.start(game);
        Giuseppe giuseppe = new Giuseppe(game.studentBag, game);
        System.out.println("Numero pedine verdi: " + giuseppe.getNumGreenPawn());
        System.out.println("Numero pedine rosse: " + giuseppe.getNumRedPawn());
        System.out.println("Numero pedine gialle: " + giuseppe.getNumYellowPawn());
        System.out.println("Numero pedine rosa: " + giuseppe.getNumPinkPawn());
        System.out.println("Numero pedine blue: " + giuseppe.getNumBluePawn());
    }

   @Test
    public void TestUseGiuseppeEffect(){
       Game game = new Game(2,true);
       game.start(game);
       Game.newPlayer("Abner", game);
       Game.newPlayer("Tamar", game);
       game.players.get(0).entrance.setGreenPawn(2);
       game.players.get(0).entrance.setBluePawn(1);
       game.players.get(0).entrance.setRedPawn(3);
       Giuseppe giuseppe = new Giuseppe(game.studentBag, game);
       ArrayList<ColorPawn> colorPawn = new ArrayList<>(3);
       colorPawn.add(ColorPawn.GREEN);
       colorPawn.add(ColorPawn.BLUE);
       colorPawn.add(ColorPawn.RED);
       giuseppe.useEffect(game, 7, game.islands.get(5), game.players.get(0), colorPawn);
    }

}