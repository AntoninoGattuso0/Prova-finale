package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
       game.newPlayer("Abner", game);
       game.newPlayer("Tamar", game);
       game.players.get(0).entrance.setGreenPawn(2);
       game.players.get(0).entrance.setRedPawn(3);
       game.players.get(0).entrance.setYellowPawn(3);
       game.players.get(0).entrance.setPinkPawn(3);
       game.players.get(0).entrance.setBluePawn(1);
       Giuseppe giuseppe = new Giuseppe(game.studentBag, game);
       CharacterCard card = new CharacterCard(giuseppe,6);
       giuseppe.setNumGreenPawn(1);
       giuseppe.setNumRedPawn(1);
       giuseppe.setNumYellowPawn(1);
       giuseppe.setNumPinkPawn(2);
       giuseppe.setNumBluePawn(1);
       ArrayList<ColorPawn> colorPawn = new ArrayList<>(2);
       colorPawn.add(ColorPawn.GREEN);
       colorPawn.add(ColorPawn.BLUE);
       card.useEffect.useEffect(game, 7, game.islands.get(5), game.players.get(0), colorPawn);
       assertEquals(3, game.players.get(0).entrance.getGreenPawn());
       assertEquals(0, giuseppe.getNumGreenPawn());
       assertEquals(0, game.players.get(0).entrance.getBluePawn());
       assertEquals(2, giuseppe.getNumBluePawn());
    }

}