package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarbaraTest {
    @Test
    public void test1() {
        Barbara barbara = new Barbara();
        Game game = new Game(3, true);
        game.start();
        game.profTable.greenProf = 1;
        game.profTable.redProf = 2;
        int i;
        for (i = 0; i < game.characterCards.size(); i++) {
            if (game.characterCards.get(i).getClass().equals(barbara.getClass())) ;
            {
                game.characterCards.get(i).useEffect(2);
            }
        }

        assertEquals(2, game.profTable.greenProf);
    }
}