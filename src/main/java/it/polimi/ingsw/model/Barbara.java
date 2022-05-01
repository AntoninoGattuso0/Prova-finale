package it.polimi.ingsw.model;
import java.util.ArrayList;
public class Barbara extends UseEffect{
    private int coinPrice;
    public Barbara(){
        coinPrice=2;
    }
    //DEVO MODIFICARE IL FATTO CHE I PROF POSSONO AVERE ANCHE -1.
    //SE IL PROF NON LO HA NESSUNO IL CONTROLLO NON FUNZIONA PERCHè NON ESISTE
    // UNA DINING ROOM PER IL PLAYER -1
    public void useEffect(Game game, int actualPlayer, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        if(Game.players.get(actualPlayer).diningRoom.getNumGreen()==Game.players.get(ProfTable.getGreenProf()).diningRoom.getNumGreen())
                ProfTable.setGreenProf(actualPlayer);
        if(Game.players.get(actualPlayer).diningRoom.getNumRed()==Game.players.get(ProfTable.getRedProf()).diningRoom.getNumRed())
            ProfTable.setRedProf(actualPlayer);
        if(Game.players.get(actualPlayer).diningRoom.getNumBlue()==Game.players.get(ProfTable.getBlueProf()).diningRoom.getNumBlue())
            ProfTable.setBlueProf(actualPlayer);
        if(Game.players.get(actualPlayer).diningRoom.getNumPink()==Game.players.get(ProfTable.getPinkProf()).diningRoom.getNumPink())
            ProfTable.setPinkProf(actualPlayer);
        if(Game.players.get(actualPlayer).diningRoom.getNumYellow()==Game.players.get(ProfTable.getYellowProf()).diningRoom.getNumYellow())
            ProfTable.setYellowProf(actualPlayer);
        coinPrice++;
    }
}
