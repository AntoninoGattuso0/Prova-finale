package it.polimi.ingsw.model;

public class Barbara extends CharacterCard{
    Barbara(){
        coinPrice=2;
    }
    public void useEffect(int actualPlayer, Game game){
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
    }
}
