package it.polimi.ingsw.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BarbaraTest {
    @Test
    public void test1() {
        Barbara barbara = new Barbara();
        Game game = new Game(3, true);
        int i;
        game.profTable.setGreenProf(1);
        for (i = 0; i < game.characterCards.size(); i++) {
            if (game.characterCards.get(i).getClass().equals(barbara.getClass())) ;
            {
                game.characterCards.get(i).useEffect(game.players.get(i).getIDplayer(),game);
            }
        }
        assertEquals(2, game.profTable.getGreenProf());
    }
}