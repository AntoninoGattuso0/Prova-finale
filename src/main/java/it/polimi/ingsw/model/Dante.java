package it.polimi.ingsw.model;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * the fourth effect (Dante because "D" is the fourth alphabet letter)
 * @see UseEffect
 */
public class Dante extends UseEffect implements Serializable {
    @Serial
    private static final long serialVersionUID= -1428465615073943049L;
    private int coinPrice;
    public Dante() {
        coinPrice = 1;
    }

    /**CharacterCard 4: you can move MotherNature with +2 steps
     * @param player who played the CharacterCard
     */
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {
        int step;
        step = player.getCurrentAssistant().getStep() + 2;
        player.getCurrentAssistant().setStep(step);
        setCoinPrice(2);
    }

    public void setCoinPrice(int coinPrice) {
        this.coinPrice = coinPrice;
    }
    public int getCoinPrice() {
        return coinPrice;
    }
}