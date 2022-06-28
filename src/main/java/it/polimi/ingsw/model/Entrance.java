package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
public class Entrance {
    private int numPawn;
    private int greenPawn;
    private int bluePawn;
    private int pinkPawn;
    private int yellowPawn;
    private int redPawn;

    public int getNumPawn(){
        return this.numPawn;
    }
    public int getGreenPawn() {
        return this.greenPawn;
    }
    public int getRedPawn(){
        return this.redPawn;
    }
    public int getYellowPawn() {
        return this.yellowPawn;
    }
    public int getPinkPawn() {
        return this.pinkPawn;
    }
    public int getBluePawn() {
        return bluePawn;
    }
    public void setNumPawn(int numPawn) {
        this.numPawn = numPawn;
    }
    public void setGreenPawn(int greenPawn) {
        this.greenPawn = greenPawn;
    }
    public void setRedPawn(int redPawn) {
        this.redPawn = redPawn;
    }
    public void setYellowPawn(int yellowPawn) {
        this.yellowPawn = yellowPawn;
    }
    public void setPinkPawn(int pinkPawn) {
        this.pinkPawn = pinkPawn;
    }
    public void setBluePawn(int bluePawn) {
        this.bluePawn = bluePawn;
    }

    public Entrance(Game game){
        this.greenPawn=0;
        this.redPawn=0;
        this.yellowPawn=0;
        this.pinkPawn=0;
        this.bluePawn=0;
       Random rnd = new Random();
        if(game.totPlayer == 2 || game.totPlayer == 4)
            this.numPawn=7;
        else if(game.totPlayer == 3)
            this.numPawn=9;
        int i,k;
        ArrayList<ColorPawn> entrancePawn = Game.createArrayPawn(game.studentBag);
        for(i = 0; i < this.numPawn;){
            if (game.studentBag.getNum() > 0 && entrancePawn.size() > 0) {
                int random = rnd.nextInt(entrancePawn.size());
                if (Objects.equals(entrancePawn.get(random), ColorPawn.GREEN) && game.studentBag.getGreenNum() > 0) {//verde
                        this.greenPawn++;
                        k = (game.studentBag.getNum()) - 1;
                        game.studentBag.setNum(k);
                        k = (game.studentBag.getGreenNum()) - 1;
                        game.studentBag.setGreenNum(k);
                        i++;
                        if (game.studentBag.getGreenNum() == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), ColorPawn.RED) && game.studentBag.getRedNum() > 0) {//rosso
                        this.redPawn++;
                        k = game.studentBag.getNum() - 1;
                        game.studentBag.setNum(k);
                        k = game.studentBag.getRedNum() - 1;
                        game.studentBag.setRedNum(k);
                        i++;
                        if (game.studentBag.getRedNum() == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), ColorPawn.YELLOW) && game.studentBag.getYellowNum() > 0) {//giallo
                        this.yellowPawn++;
                        k = (game.studentBag.getNum()) - 1;
                        game.studentBag.setNum(k);
                        k = (game.studentBag.getYellowNum()) - 1;
                        game.studentBag.setYellowNum(k);
                        i++;
                        if (game.studentBag.getYellowNum() == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), ColorPawn.PINK) && game.studentBag.getPinkNum() > 0) {//rosa
                        this.pinkPawn++;
                        k = (game.studentBag.getNum()) - 1;
                        game.studentBag.setNum(k);
                        k = (game.studentBag.getPinkNum()) - 1;
                        game.studentBag.setPinkNum(k);
                        i++;
                        if (game.studentBag.getPinkNum() == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), ColorPawn.BLUE) && game.studentBag.getBlueNum() > 0) {//blu
                        this.bluePawn++;
                        k = (game.studentBag.getNum()) - 1;
                        game.studentBag.setNum(k);
                        k = (game.studentBag.getBlueNum()) - 1;
                        game.studentBag.setBlueNum(k);
                        i++;
                        if (game.studentBag.getBlueNum() == 0) entrancePawn.remove(random);
                    }
            }
        }
    }

    /**sets the starting num of pawns on the entrance
     * based on the num of players
     */
    public void startNumPawn(Game game){
        if(game.totPlayer == 2 || game.totPlayer == 4)
            setNumPawn(7);
        else if(game.totPlayer == 3)
            setNumPawn(9);
    }

    /**
     * @return
     */
    public boolean checkNum(Game game){
        if((game.totPlayer == 2 || game.totPlayer == 4) && numPawn > 4 )
            return true;
       else if(game.totPlayer == 3 && numPawn > 5)
            return true;
       else return false;
    }

    /**it allows to move the pawns from the entrance to the island selected
     * @param island is the island selected
     */
    public void movePawnToIsland(ColorPawn colorPawn, Island island, Game game){
               if(Objects.equals(colorPawn.toString(), "GREEN") && this.greenPawn > 0){
                   island.setGreenPawn(island.getGreenPawn() + 1);
                   setGreenPawn(getGreenPawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }else if(Objects.equals(colorPawn.toString(), "RED") && this.redPawn > 0){
                   island.setRedPawn(island.getRedPawn() + 1);
                   setRedPawn(getRedPawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }else if(Objects.equals(colorPawn.toString(), "YELLOW") && this.yellowPawn > 0){
                   island.setYellowPawn(island.getYellowPawn() + 1);
                   setYellowPawn(getYellowPawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }else if(Objects.equals(colorPawn.toString(), "PINK") && this.pinkPawn > 0){
                   island.setPinkPawn(island.getPinkPawn() + 1);
                   setPinkPawn(getPinkPawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }else if(Objects.equals(colorPawn.toString(), "BLUE") && this.bluePawn > 0){
                   island.setBluePawn(island.getBluePawn() + 1);
                   setBluePawn(getBluePawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }
            }

    /**
     * invokes the function MovePawnToIsland
     * @param n number of Pawns
     * @param colorPawn array with Pawns
     */
    public void moveToIsland(int n, ArrayList<ColorPawn> colorPawn, Island island,Game game) {
        if((game.totPlayer == 2 || game.totPlayer == 4) && (n > 0 &&  n < 4 )){
            while(n != 0){
                movePawnToIsland(colorPawn.get(n - 1), island, game);
                n--;
                colorPawn.remove(n);
            }
        }
            if(game.totPlayer == 3 && (n > 0 &&  n < 5 )){
                while(n != 0){
                    movePawnToIsland(colorPawn.get(n - 1), island, game);
                    n--;
                    colorPawn.remove(n);
                }
        }
    }

    /**
     * after choosing the cloud i, it refills the Entrance with the pawns on the cloud selected
     */
    public void chooseCloud (Cloud cloud,Game game,Player player){
        if(cloud.getNumPawn()!=0){
            player.entrance.setGreenPawn(player.entrance.getGreenPawn() + cloud.getGreenPawn());
            player.entrance.setRedPawn(player.entrance.getRedPawn() + cloud.getRedPawn());
            player.entrance.setYellowPawn(player.entrance.getYellowPawn() + cloud.getYellowPawn());
            player.entrance.setPinkPawn(player.entrance.getPinkPawn() + cloud.getPinkPawn());
            player.entrance.setBluePawn(player.entrance.getBluePawn() + cloud.getBluePawn());
            cloud.setNumPawn(0);
            cloud.setGreenPawn(0);
            cloud.setRedPawn(0);
            cloud.setYellowPawn(0);
            cloud.setPinkPawn(0);
            cloud.setBluePawn(0);
            player.entrance.startNumPawn(game);
        }
    }
}