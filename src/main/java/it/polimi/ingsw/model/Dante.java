package it.polimi.ingsw.model;
import java.util.ArrayList;
public class Dante extends UseEffect{
    private int coinPrice;
    Dante(){
        coinPrice=1;
    }
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        int step;
        step=player.getCurrentAssistant().getStep()+2;
        player.getCurrentAssistant().setStep(step);
        coinPrice++;
    }
}
