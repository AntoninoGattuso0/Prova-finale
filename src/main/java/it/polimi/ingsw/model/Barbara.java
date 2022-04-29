package it.polimi.ingsw.model;

public class Barbara extends CharacterCard{
    Barbara(){
        coinPrice=2;
    }
    public void useEffect(int actualPlayer){
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
    }
}
