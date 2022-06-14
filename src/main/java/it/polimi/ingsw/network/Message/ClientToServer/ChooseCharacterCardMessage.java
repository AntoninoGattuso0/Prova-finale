package it.polimi.ingsw.network.Message.ClientToServer;


import it.polimi.ingsw.model.ColorPawn;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class ChooseCharacterCardMessage extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID = 2809026361437311296L;
    private final int numCharacter;
    private final int numIsland;
    private final ArrayList<ColorPawn> colorPawns;
    private final int numPawn;
    private final boolean check;

    public ChooseCharacterCardMessage(int numCharacter,int numPawn,int numIsland,ArrayList<ColorPawn> colorPawns,boolean check){
        this.numCharacter=numCharacter;
        this.colorPawns=colorPawns;
        this.numIsland=numIsland;
        this.numPawn=numPawn;
        this.check=check;
    }

    public int getNumPawn() {
        return numPawn;
    }
    public boolean getCheck(){
        return check;
    }
    public ArrayList<ColorPawn> getColorPawns() {
        return colorPawns;
    }
    public int getNumIsland() {
        return numIsland;
    }
    public int getNumCharacter(){
        return numCharacter;
    }
}
