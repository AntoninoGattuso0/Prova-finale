package it.polimi.ingsw.model;

public class Barbara extends CharacterCard{
    Barbara(){
        coinPrice=2;
    }
    public int useEffect(int actualPlayer){
        if(Game.players.get(actualPlayer).diningRoom.numGreen==Game.players.get(ProfTable.greenProf).diningRoom.numGreen)
                ProfTable.greenProf=actualPlayer;
        if(Game.players.get(actualPlayer).diningRoom.numRed==Game.players.get(ProfTable.greenProf).diningRoom.numRed)
            ProfTable.redProf=actualPlayer;
        if(Game.players.get(actualPlayer).diningRoom.numBlue==Game.players.get(ProfTable.greenProf).diningRoom.numBlue)
            ProfTable.blueProf=actualPlayer;
        if(Game.players.get(actualPlayer).diningRoom.numPink==Game.players.get(ProfTable.greenProf).diningRoom.numPink)
            ProfTable.pinkProf=actualPlayer;
        if(Game.players.get(actualPlayer).diningRoom.numYellow==Game.players.get(ProfTable.greenProf).diningRoom.numYellow)
            ProfTable.yellowProf=actualPlayer;
        return actualPlayer;
    }
}
