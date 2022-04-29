package it.polimi.ingsw.model;

public class Barbara extends CharacterCard{
    Barbara(){
        coinPrice=2;
    }
    public void useEffect(int actualPlayer){
        if(Game.players.get(actualPlayer).diningRoom.numGreen==Game.players.get(ProfTable.getGreenProf()).diningRoom.numGreen)
                ProfTable.setGreenProf(actualPlayer);
        if(Game.players.get(actualPlayer).diningRoom.numRed==Game.players.get(ProfTable.getRedProf()).diningRoom.numRed)
            ProfTable.setRedProf(actualPlayer);
        if(Game.players.get(actualPlayer).diningRoom.numBlue==Game.players.get(ProfTable.getBlueProf()).diningRoom.numBlue)
            ProfTable.setBlueProf(actualPlayer);
        if(Game.players.get(actualPlayer).diningRoom.numPink==Game.players.get(ProfTable.getPinkProf()).diningRoom.numPink)
            ProfTable.setPinkProf(actualPlayer);
        if(Game.players.get(actualPlayer).diningRoom.numYellow==Game.players.get(ProfTable.getYellowProf()).diningRoom.numYellow)
            ProfTable.setYellowProf(actualPlayer);
    }
}
