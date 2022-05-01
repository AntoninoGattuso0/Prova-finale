package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AntonioTest {
    @Test
    public void TestAntonio(){
        Game game=new Game(3,true);
    Antonio antonio = new Antonio(game.studentBag);
    assertEquals(4,antonio.getNumPawnAntonio());
    assertEquals(4,antonio.getBluePawn()+antonio.getGreenPawn()+antonio.getPinkPawn()+antonio.getRedPawn()+antonio.getYellowPawn());
    assertEquals(116,game.studentBag.getNum());
    }
    @Test
    public void TestUseEffectAntonio(){
        int i;
        Game game= new Game(3,true);
        ArrayList<ColorPawn> colorPawn=new ArrayList<>();
        for(i=0;i<2;i++){
            if(i==0)
                colorPawn.add(ColorPawn.GREEN);
            if(i==1)
                colorPawn.add(ColorPawn.RED);
        }
        Game.newPlayer("a",game);
        Game.newPlayer("b",game);
        Game.newPlayer("c",game);
        Antonio antonio=new Antonio(game.studentBag);
        CharacterCard characterCard=new CharacterCard(antonio);
        characterCard.useEffect.useEffect(game,i,Game.islands.get(0),Game.players.get(0));

    }
    }


