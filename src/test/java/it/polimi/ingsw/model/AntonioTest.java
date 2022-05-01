package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AntonioTest {
    @Test
    public void TestAntonio(){
        Game game=new Game(3,true);
        System.out.println(game.studentBag.getNum());
    Antonio antonio = new Antonio(game.studentBag);
    assertEquals(4,antonio.getNumPawnAntonio());
    assertEquals(4,antonio.getBluePawn()+antonio.getGreenPawn()+antonio.getPinkPawn()+antonio.getRedPawn()+antonio.getYellowPawn());
    assertEquals(116,game.studentBag.getNum());
    System.out.println(antonio.getGreenPawn());
        System.out.println(antonio.getPinkPawn());
        System.out.println(antonio.getRedPawn());
        System.out.println(antonio.getBluePawn());
        System.out.println(antonio.getYellowPawn());



    }
    @Test
    public void TestUseEffectAntonio(){
        int i;
        Game game= new Game(3,true);
        System.out.println(game.studentBag.getNum());
        Antonio antonio=new Antonio(game.studentBag);
        System.out.println(game.studentBag.getNum());
        ArrayList<ColorPawn> colorPawn=new ArrayList<>();
        System.out.println(game.studentBag.getNum());
        for(i=0;i<2;i++){
            if(i==0)
                colorPawn.add(ColorPawn.GREEN);
            if(i==1)
                colorPawn.add(ColorPawn.RED);
        }
        System.out.println(game.studentBag.getNum());
        Game.newPlayer("a",game);
        System.out.println(game.studentBag.getNum());
        Game.newPlayer("b",game);
        Game.newPlayer("c",game);

        CharacterCard characterCard=new CharacterCard(antonio);
        characterCard.useEffect.useEffect(game,2,Game.islands.get(0),Game.players.get(0),colorPawn);
        assertEquals(4,antonio.getNumPawnAntonio());
    }
    }


