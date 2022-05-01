package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Barbara extends UseEffect{
    private int coinPrice;
    public Barbara(){
        coinPrice=2;
    }
    public void useEffect(Game game, int actualPlayer, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        if(game.players.get(actualPlayer).diningRoom.getNumGreen()==game.players.get(ProfTable.getGreenProf()).diningRoom.getNumGreen())
                ProfTable.setGreenProf(actualPlayer);
        if(game.players.get(actualPlayer).diningRoom.getNumRed()==game.players.get(ProfTable.getRedProf()).diningRoom.getNumRed())
            ProfTable.setRedProf(actualPlayer);
        if(game.players.get(actualPlayer).diningRoom.getNumBlue()==game.players.get(ProfTable.getBlueProf()).diningRoom.getNumBlue())
            ProfTable.setBlueProf(actualPlayer);
        if(game.players.get(actualPlayer).diningRoom.getNumPink()==game.players.get(ProfTable.getPinkProf()).diningRoom.getNumPink())
            ProfTable.setPinkProf(actualPlayer);
        if(game.players.get(actualPlayer).diningRoom.getNumYellow()==game.players.get(ProfTable.getYellowProf()).diningRoom.getNumYellow())
            ProfTable.setYellowProf(actualPlayer);
        coinPrice++;
    }
}
