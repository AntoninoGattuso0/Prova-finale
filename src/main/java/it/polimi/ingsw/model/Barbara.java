package it.polimi.ingsw.model;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * the second effect (Barbara because "B" is the second alphabet letter)
 * @see UseEffect
 */
public class Barbara extends UseEffect implements Serializable {
    @Serial
    private static final long serialVersionUID= 6437140673880575588L;
    private int coinPrice;
    public Barbara(){
        coinPrice=2;
    }

    public void setCoinPrice(int coinPrice) {
        this.coinPrice = coinPrice;
    }
    public int getCoinPrice() {
        return coinPrice;
    }

    /**CharacterCard 2: During this turn you obtain the professor even if the pawn in your DiningRoom are the same of the player who already has the professor
     * @param i is the index of the player that used Barbara
     */
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {
        int j;
        int max;
        max = 0;
        if (game.getProfTable().getGreenProf() != -1) {
            if (game.players.get(i).diningRoom.getNumGreen() == game.players.get(game.getProfTable().getGreenProf()).diningRoom.getNumGreen())
                game.getProfTable().setGreenProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {
                if (game.players.get(i).diningRoom.getNumGreen() < game.players.get(j).diningRoom.getNumGreen())
                    max = 1;
            }
            if (max == 0) {
                game.getProfTable().setGreenProf(i);
            }
        }
        max = 0;
        if (game.getProfTable().getRedProf() != -1) {
            if (game.players.get(i).diningRoom.getNumRed() == game.players.get(game.getProfTable().getRedProf()).diningRoom.getNumRed())
                game.getProfTable().setRedProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {

                if (game.players.get(i).diningRoom.getNumRed() < game.players.get(j).diningRoom.getNumRed())
                    max = 1;
            }
            if (max == 0) {
                game.getProfTable().setRedProf(i);
            }
        }
        max = 0;
        if (game.getProfTable().getBlueProf() != -1) {
            if (game.players.get(i).diningRoom.getNumBlue() == game.players.get(game.getProfTable().getBlueProf()).diningRoom.getNumBlue())
                game.getProfTable().setBlueProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {
                if (game.players.get(i).diningRoom.getNumBlue() < game.players.get(j).diningRoom.getNumBlue())
                    max = 1;
            }
            if (max == 0) {
                game.getProfTable().setBlueProf(i);
            }
        }
        max = 0;
        if (game.getProfTable().getPinkProf() != -1) {
            if (game.players.get(i).diningRoom.getNumPink() == game.players.get(game.getProfTable().getPinkProf()).diningRoom.getNumPink())
                game.getProfTable().setPinkProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {
                if (game.players.get(i).diningRoom.getNumPink() < game.players.get(j).diningRoom.getNumPink())
                    max = 1;
            }
            if (max == 0) {
                game.getProfTable().setPinkProf(i);
            }
        }
        max = 0;
        if (game.getProfTable().getYellowProf() != -1) {
            if (game.players.get(i).diningRoom.getNumYellow() == game.players.get(game.getProfTable().getYellowProf()).diningRoom.getNumYellow())
                game.getProfTable().setYellowProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {
                if (game.players.get(i).diningRoom.getNumYellow() < game.players.get(j).diningRoom.getNumYellow())
                    max = 1;
            }
            if (max == 0) {
                game.getProfTable().setYellowProf(i);
            }
        }
            setCoinPrice(3);
        }
    }