package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testGame(){
        Game game = new Game(4, true);
        assertEquals(4, game.getTotPlayer());
        assertEquals(12, Game.islands.size());
        int i;
        for(i=0; !Game.islands.get(i).getMotherNature(); i++);
        System.out.println("Madre natura è sull'isola " + i);
        int s = i+1;
        if(s==12) s = 0;
        int r = Game.islands.get(s).getRedPawn();
        System.out.println("Sull'isola " + s + " ci sono " + r + " pedine rosse");
        assertEquals(4, game.clouds.size());
        assertEquals(24, game.studentBag.getGreenNum());
    }
    @Test
    public void testCreateArrayPawn(){
        Game game = new Game(4, true);
        ArrayList<String> a = Game.createArrayPawn(game.studentBag);
        System.out.println(a);
    }
    @Test
    public void testMoveMotherNature(){
        Game game = new Game(4, true);
        int i;
        for(i=0; !Game.islands.get(i).getMotherNature(); i++);
        assertTrue(Game.islands.get(i).getMotherNature());
        int j = i+3;
        if(j>Game.islands.size())j = j - Game.islands.size();
        assertFalse(Game.islands.get(j).getMotherNature());
        game.moveMotherNature(3);
        assertFalse(Game.islands.get(i).getMotherNature());
        assertTrue(Game.islands.get(j).getMotherNature());
    }
    @Test
    public void testCheckIsland(){
        Game game = new Game(4, true);
        Game.islands.get(0).setTower(true);
        Game.islands.get(0).setColorTower(ColorTower.BLACK);
        Game.islands.get(1).setTower(true);
        Game.islands.get(1).setColorTower(ColorTower.BLACK);
        Game.islands.get(2).setTower(true);
        Game.islands.get(2).setColorTower(ColorTower.BLACK);
        assertTrue(Game.checkIsland(1, 0));
        assertTrue(Game.checkIsland(1, 2));
    }
    @Test
    public void testUnifyIsland(){
        Game game = new Game(4, true);
        System.out.println(Game.islands.size());
        Game.islands.get(0).setTower(true);
        Game.islands.get(0).setColorTower(ColorTower.BLACK);
        Game.islands.get(1).setTower(true);
        Game.islands.get(1).setColorTower(ColorTower.BLACK);
        Game.islands.get(2).setTower(true);
        Game.islands.get(2).setColorTower(ColorTower.WHITE);
        Game.unifyIsland(1);
        System.out.println(Game.islands.size());
    }
}