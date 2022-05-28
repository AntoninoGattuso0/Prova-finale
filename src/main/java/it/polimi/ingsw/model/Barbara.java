package it.polimi.ingsw.model;
import java.util.ArrayList;
public class Barbara extends UseEffect{
    private int coinPrice;
    public Barbara(){
        coinPrice=2;
    }

    public void setCoinPrice(int coinPrice) {
        this.coinPrice = coinPrice;
    }
    public int getCoinPrice() {
        return coinPrice;
    }
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {
        int j;
        int max;
        max = 0;
        if (game.getProfTable().getGreenProf() != -1) {
            if (game.players.get(i).diningRoom.getNumGreen() == game.players.get(game.getProfTable().getGreenProf()).diningRoom.getNumGreen())
                ProfTable.setGreenProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {
                if (game.players.get(i).diningRoom.getNumGreen() < game.players.get(j).diningRoom.getNumGreen())
                    max = 1;
            }
            if (max == 0) {
                ProfTable.setGreenProf(i);
            }
        }
        max = 0;
        if (game.getProfTable().getRedProf() != -1) {
            if (game.players.get(i).diningRoom.getNumRed() == game.players.get(game.getProfTable().getRedProf()).diningRoom.getNumRed())
                ProfTable.setRedProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {

                if (game.players.get(i).diningRoom.getNumRed() < game.players.get(j).diningRoom.getNumRed())
                    max = 1;
            }
            if (max == 0) {
                ProfTable.setRedProf(i);
            }
        }
        max = 0;
        if (game.getProfTable().getBlueProf() != -1) {
            if (game.players.get(i).diningRoom.getNumBlue() == game.players.get(game.getProfTable().getBlueProf()).diningRoom.getNumBlue())
                ProfTable.setBlueProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {
                if (game.players.get(i).diningRoom.getNumBlue() < game.players.get(j).diningRoom.getNumBlue())
                    max = 1;
            }
            if (max == 0) {
                ProfTable.setBlueProf(i);
            }
        }
        max = 0;
        if (game.getProfTable().getPinkProf() != -1) {
            if (game.players.get(i).diningRoom.getNumPink() == game.players.get(game.getProfTable().getPinkProf()).diningRoom.getNumPink())
                ProfTable.setPinkProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {
                if (game.players.get(i).diningRoom.getNumPink() < game.players.get(j).diningRoom.getNumPink())
                    max = 1;
            }
            if (max == 0) {
                ProfTable.setPinkProf(i);
            }
        }
        max = 0;
        if (game.getProfTable().getYellowProf() != -1) {
            if (game.players.get(i).diningRoom.getNumYellow() == game.players.get(game.getProfTable().getYellowProf()).diningRoom.getNumYellow())
                ProfTable.setYellowProf(i);
        } else {
            for (j = 0; j < game.getTotPlayer(); j++) {
                if (game.players.get(i).diningRoom.getNumYellow() < game.players.get(j).diningRoom.getNumYellow())
                    max = 1;
            }
            if (max == 0) {
                ProfTable.setYellowProf(i);
            }
        }
            setCoinPrice(3);
        }
    }