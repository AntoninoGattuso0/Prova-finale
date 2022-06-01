package it.polimi.ingsw.model;
import java.io.Serializable;
import java.util.ArrayList;
public class Maria extends UseEffect implements Serializable {
    private int coinPrice;
    Maria(){
        coinPrice=1;
    }
    public void setCoinPrice(int coinPrice){this.coinPrice = coinPrice;}
    public int getCoinPrice(){return coinPrice;}
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        int k;
        for(k=0; k<colorPawn.size(); k++)
            if(k<colorPawn.size()/2)
                player.diningRoom.removePawnFromDiningRoomToEntrance(colorPawn.get(k), player, game);
            else
                player.diningRoom.addPawnToDiningRoom(colorPawn.get(k), player, game);
        setCoinPrice(2);
    }


}
