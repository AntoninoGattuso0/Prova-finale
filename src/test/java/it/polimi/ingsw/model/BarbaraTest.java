package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BarbaraTest {
    @Test
    public void test1(){
        Game game = new Game(3,true);
        ProfTable profTable= new ProfTable();
        profTable.greenProf=1;
        profTable.redProf=2;
        int i;
        ArrayList<Player> players = new ArrayList<>(4);
        for(i=0;i<3;i++){
            Player player=new Player("ciao");
            players.add(player);
        }
        Barbara barbara= new Barbara();
        assertEquals(2,barbara.useEffect(2));
    }

}