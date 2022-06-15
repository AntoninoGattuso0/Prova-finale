package it.polimi.ingsw.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
public class Lancillotto extends UseEffect implements Serializable {
    @Serial
    private static final long serialVersionUID= -3530330329008197496L;
    private int coinPrice;
    private int colorNumber;
    private boolean effectActive;
    public Lancillotto(){
        coinPrice=3;
        this.effectActive=false;
    }
    public void setCoinPrice(int coinPrice){this.coinPrice = coinPrice;}
    public int getCoinPrice(){return coinPrice;}
    public int getPedina() {
        return colorNumber;
    }
    public void setEffectActive(boolean effectActive) {
        this.effectActive = effectActive;
    }
    public boolean isEffectActive() {
        return effectActive;
    }

    /**CharacterCard 9: choose a color. In this turn the students of that color don't count in the influence
     *
     * @param game
     * @param i
     * @param island
     * @param player
     * @param colorPawn
     */
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){//(Game game, int i,Island island,Player player,ArrayList<ColorPawn> colorPawn)
        switch (colorPawn.get(0)){
            case GREEN -> this.colorNumber=0;
            case RED -> this.colorNumber=1;
            case YELLOW -> this.colorNumber=2;
            case PINK -> this.colorNumber=3;
            case BLUE -> this.colorNumber=4;
        }
        effectActive=true;
        setCoinPrice(4);
    }
}
