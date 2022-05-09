package it.polimi.ingsw.model;
import java.util.*;
public class Giuseppe extends UseEffect{
    private int coinPrice;
    private int nPawn;
    private int numGreenPawn;
    private int numRedPawn;
    private int numYellowPawn;
    private int numPinkPawn;
    private int numBluePawn;

    public int getNumGreenPawn(){
        return numGreenPawn;
    }

    public int getNumRedPawn() {
        return numRedPawn;
    }

    public int getNumYellowPawn() {
        return numYellowPawn;
    }

    public int getNumPinkPawn() {
        return numPinkPawn;
    }

    public int getNumBluePawn() {
        return numBluePawn;
    }

    public int getCoinPrice(){
        return coinPrice;
    }

    public void setNumGreenPawn(int numGreenPawn) {
        this.numGreenPawn = numGreenPawn;
    }

    public void setNumRedPawn(int numRedPawn) {
        this.numRedPawn = numRedPawn;
    }

    public void setNumYellowPawn(int numYellowPawn) {
        this.numYellowPawn = numYellowPawn;
    }

    public void setNumPinkPawn(int numPinkPawn) {
        this.numPinkPawn = numPinkPawn;
    }

    public void setNumBluePawn(int numBluePawn) {
        this.numBluePawn = numBluePawn;
    }

    public void setCoinPrice(int coin){
        this.coinPrice=coin;
    }

    public Giuseppe(StudentBag  studentBag, Game game){
        coinPrice=1;
        nPawn = 0;
        numGreenPawn = 0;
        numRedPawn = 0;
        numYellowPawn = 0;
        numPinkPawn=0;
        numBluePawn=0;
        Random rdm = new Random();
        ArrayList<String> refillCharacterCard = Game.createArrayPawn(game.studentBag);
        for(int i = 0; i < 6; i++){
            int random = rdm.nextInt(refillCharacterCard.size());
            if(Objects.equals(refillCharacterCard.get(random), game.m.get(0))) {
                numGreenPawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setGreenNum(studentBag.getGreenNum() - 1);
                if(studentBag.getGreenNum() == 0) refillCharacterCard.remove(random);
            }else if(Objects.equals(refillCharacterCard.get(random), game.m.get(1))) {
                numRedPawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setRedNum(studentBag.getRedNum() - 1);
                if(studentBag.getRedNum() == 0) refillCharacterCard.remove(random);
            }else if(Objects.equals(refillCharacterCard.get(random), game.m.get(2))) {
                numYellowPawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setYellowNum(studentBag.getYellowNum() - 1);
                if(studentBag.getYellowNum() == 0) refillCharacterCard.remove(random);
            }else if(Objects.equals(refillCharacterCard.get(random), game.m.get(3))) {
                numPinkPawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setPinkNum(studentBag.getPinkNum() - 1);
                if(studentBag.getPinkNum() == 0) refillCharacterCard.remove(random);
            }else if(Objects.equals(refillCharacterCard.get(random), game.m.get(4))) {
                numBluePawn++;
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setBlueNum(studentBag.getBlueNum() - 1);
                if(studentBag.getBlueNum() == 0) refillCharacterCard.remove(random);
            }
        }
        nPawn = 6;
    }
    public void swapPawn(ColorPawn colorPawnCard, ColorPawn colorPawnEntrance, Player player){
        if(!Objects.equals(colorPawnCard, colorPawnEntrance) && this.nPawn > 3){
            if(Objects.equals(colorPawnCard.toString(), "GREEN")){
                setNumGreenPawn(getNumGreenPawn() - 1);
                player.entrance.setGreenPawn(player.entrance.getGreenPawn() + 1);
            }else if(Objects.equals(colorPawnCard.toString(), "RED")){
                setNumRedPawn(getNumRedPawn() - 1);
                player.entrance.setRedPawn(player.entrance.getRedPawn() + 1);
            }else if(Objects.equals(colorPawnCard.toString(), "YELLOW")){
                setNumYellowPawn(getNumYellowPawn() - 1);
                player.entrance.setYellowPawn(player.entrance.getYellowPawn() + 1);
            }else if(Objects.equals(colorPawnCard.toString(), "PINK")){
                setNumPinkPawn(getNumPinkPawn() - 1);
                player.entrance.setPinkPawn(player.entrance.getPinkPawn() + 1);
            }else if(Objects.equals(colorPawnCard.toString(), "BLUE")){
                setNumBluePawn(getNumBluePawn() - 1);
                player.entrance.setBluePawn(player.entrance.getBluePawn() + 1);
            }
            if(Objects.equals(colorPawnEntrance.toString(), "GREEN")){
                setNumGreenPawn(getNumGreenPawn() + 1);
                player.entrance.setGreenPawn(player.entrance.getGreenPawn() - 1);
            }else if(Objects.equals(colorPawnEntrance.toString(), "RED")){
                setNumRedPawn(getNumRedPawn() + 1);
                player.entrance.setRedPawn(player.entrance.getRedPawn() - 1);
            }else if(Objects.equals(colorPawnEntrance.toString(), "YELLOW")){
                setNumYellowPawn(getNumYellowPawn() + 1);
                player.entrance.setYellowPawn(player.entrance.getYellowPawn() - 1);
            }else if(Objects.equals(colorPawnEntrance.toString(), "PINK")){
                setNumPinkPawn(getNumPinkPawn() + 1);
                player.entrance.setPinkPawn(player.entrance.getPinkPawn() - 1);
            }else if(Objects.equals(colorPawnEntrance.toString(), "BLUE")){
                setNumBluePawn(getNumBluePawn() + 1);
                player.entrance.setBluePawn(player.entrance.getBluePawn() - 1);
            }
        }
    }
    //LEGGIMI :( non va bene il fatto che anche se la funzione viene chiamata n volte viene richiamata sempre su stessa isola e pedina
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        boolean swap = false;
        int j;
        if(colorPawn.size()/2 < 4 && colorPawn.size()/2 > 0)
            swap = true;
        if(swap){
            for(i = 0, j = colorPawn.size() - 1; i < colorPawn.size()/2 && j >= colorPawn.size()/2; i++, j--){
                swapPawn(colorPawn.get(i), colorPawn.get(j), player);
            }
        }
        setCoinPrice(2);
    }
}