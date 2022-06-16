package it.polimi.ingsw.model;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
/**
 * the first effect (Antonio because "A" is the first alphabet letter)
 * @see UseEffect
 */
public class Antonio extends UseEffect implements Serializable{
    @Serial
    private static final long serialVersionUID= 2137362576944932011L;
    private int coinPrice;
    private int numPawnAntonio;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;
    public Antonio(StudentBag studentBag){
        coinPrice=1;
        numPawnAntonio=0;
        greenPawn=0;
        redPawn=0;
        yellowPawn=0;
        pinkPawn=0;
        bluePawn=0;
        while(numPawnAntonio<4){
            Random rnd = new Random();
            ArrayList<ColorPawn> refillPawn = Game.createArrayPawn(studentBag);
            if (studentBag.getNum() > 0) {
                int random = rnd.nextInt(refillPawn.size());
                if (Objects.equals(refillPawn.get(random), ColorPawn.GREEN)) {
                    setGreenPawn(getGreenPawn()+1);
                    numPawnAntonio++;
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setGreenNum(studentBag.getGreenNum()-1);
                    if(studentBag.getGreenNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.RED)) {
                    setRedPawn(getRedPawn()+1);
                    numPawnAntonio++;
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setRedNum(studentBag.getRedNum()-1);
                    if(studentBag.getRedNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.YELLOW)) {
                    setYellowPawn(getYellowPawn()+1);
                    numPawnAntonio++;
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setYellowNum(studentBag.getYellowNum()-1);
                    if(studentBag.getYellowNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.PINK)) {
                    setPinkPawn(getPinkPawn()+1);
                    numPawnAntonio++;
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setPinkNum(studentBag.getPinkNum()-1);
                    if(studentBag.getPinkNum()==0){
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.BLUE)) {
                    setBluePawn(getBluePawn()+1);
                    numPawnAntonio++;
                    studentBag.setNum(studentBag.getNum()-1);
                    studentBag.setBlueNum(getBluePawn()-1);
                    if(studentBag.getBlueNum()==0){
                        refillPawn.remove(random);
                    }
                }
            }
        }
    }

    /**CharacterCard 1: take 1 Student from that card and put it on an Island.
     * @param colorPawn colorPawn.get(0) contain the pawn color
     */
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {
        Random rnd = new Random();
        ArrayList<ColorPawn> refillPawn = Game.createArrayPawn(game.studentBag);
        if (colorPawn.get(0).toString().equals("GREEN") && getGreenPawn() > 0) {
            island.setGreenPawn(island.getGreenPawn() + 1);
            setGreenPawn(getGreenPawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else if (colorPawn.get(0).toString().equals("RED") && getRedPawn() > 0) {
            island.setRedPawn(island.getRedPawn() + 1);
            setRedPawn(getRedPawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else if (colorPawn.get(0).toString().equals("YELLOW") && getYellowPawn() > 0) {
            island.setYellowPawn(island.getYellowPawn() + 1);
            setYellowPawn(getYellowPawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else if (colorPawn.get(0).toString().equals("PINK") && getPinkPawn() > 0) {
            island.setPinkPawn(island.getPinkPawn() + 1);
            setPinkPawn(getPinkPawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else if ((colorPawn.get(0).toString().equals("BLUE")) && getBluePawn() > 0) {
            island.setBluePawn(island.getBluePawn() + 1);
            setBluePawn(getBluePawn() - 1);
            setNumPawnAntonio(getNumPawnAntonio() - 1);
        } else {
            System.out.println("errore colore non presente in entrata");
        }
        if (numPawnAntonio == 3) {
            if (game.studentBag.getNum() > 0 && refillPawn.size() > 0) {
                int random = rnd.nextInt(refillPawn.size());
                if (Objects.equals(refillPawn.get(random), ColorPawn.GREEN)) {
                    setGreenPawn(getGreenPawn() + 1);
                    setNumPawnAntonio(getNumPawnAntonio() + 1);
                    game.studentBag.setNum(game.studentBag.getNum() - 1);
                    game.studentBag.setGreenNum(game.studentBag.getGreenNum() - 1);
                    if (game.studentBag.getGreenNum() == 0) {
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.RED)) {
                    setRedPawn(getRedPawn() + 1);
                    setNumPawnAntonio(getNumPawnAntonio() + 1);
                    game.studentBag.setNum(game.studentBag.getNum() - 1);
                    game.studentBag.setRedNum(game.studentBag.getRedNum() - 1);
                    if (game.studentBag.getRedNum() == 0) {
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.YELLOW)) {
                    setYellowPawn(getYellowPawn() + 1);
                    setNumPawnAntonio(getNumPawnAntonio() + 1);
                    game.studentBag.setNum(game.studentBag.getNum() - 1);
                    game.studentBag.setYellowNum(game.studentBag.getYellowNum() - 1);
                    if (game.studentBag.getYellowNum() == 0) {
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.PINK)) {
                    setPinkPawn(getPinkPawn() + 1);
                    setNumPawnAntonio(getNumPawnAntonio() + 1);
                    game.studentBag.setNum(game.studentBag.getNum() - 1);
                    game.studentBag.setPinkNum(game.studentBag.getPinkNum() - 1);
                    if (game.studentBag.getPinkNum() == 0) {
                        refillPawn.remove(random);
                    }
                } else if (Objects.equals(refillPawn.get(random), ColorPawn.BLUE)) {
                    setBluePawn(getBluePawn() + 1);
                    setNumPawnAntonio(getNumPawnAntonio() + 1);
                    game.studentBag.setNum(game.studentBag.getNum() - 1);
                    game.studentBag.setBlueNum(game.studentBag.getBlueNum() - 1);
                    if (game.studentBag.getBlueNum() == 0) {
                        refillPawn.remove(random);

                    }
                }
            }
            setCoinPrice(2);
        }
    }

    public int getCoinPrice() {
        return coinPrice;
    }
    public void setCoinPrice(int coinPrice) {
        this.coinPrice = coinPrice;
    }
    public int getBluePawn() {
        return bluePawn;
    }
    public int getGreenPawn() {
        return greenPawn;
    }
    public int getNumPawnAntonio() {return numPawnAntonio;}
    public int getPinkPawn() {
        return pinkPawn;
    }
    public int getRedPawn() {
        return redPawn;
    }
    public int getYellowPawn() {
        return yellowPawn;
    }
    public void setBluePawn(int bluePawn) {
        this.bluePawn = bluePawn;
    }
    public void setGreenPawn(int greenPawn) {
        this.greenPawn = greenPawn;
    }
    public void setNumPawnAntonio(int numPawnAntonio) {
        this.numPawnAntonio = numPawnAntonio;
    }
    public void setPinkPawn(int pinkPawn) {
        this.pinkPawn = pinkPawn;
    }
    public void setRedPawn(int redPawn) {
        this.redPawn = redPawn;
    }
    public void setYellowPawn(int yellowPawn) {
        this.yellowPawn = yellowPawn;
    }
}