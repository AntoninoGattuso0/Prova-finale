package it.polimi.ingsw.model;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * the eleventh effect (Nicola because "N" is the eleventh alphabet letter)
 *  @see UseEffect
 */
public class Nicola extends UseEffect implements Serializable {
    @Serial
    private static final long serialVersionUID= 4274113059561342264L;
    protected int coinPrice;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;
    Nicola(StudentBag studentBag, Game game) {
        coinPrice = 2;
        Random rnd = new Random();
        ArrayList<ColorPawn> cards = createArrayPawn(studentBag);
        for(int i = 0; i < 4; i++) {
            if (studentBag.getNum() > 0) {
                int random = rnd.nextInt(cards.size());
                if (Objects.equals(cards.get(random), ColorPawn.GREEN)) {
                    setGreenPawn(getGreenPawn() + 1);
                    studentBag.setNum(studentBag.getNum() - 1);
                    studentBag.setGreenNum(studentBag.getGreenNum() - 1);
                    if (studentBag.getGreenNum() == 0) cards.remove(random);
                } else if (Objects.equals(cards.get(random), ColorPawn.RED)) {
                    setRedPawn(getRedPawn() + 1);
                    studentBag.setNum(studentBag.getNum() - 1);
                    studentBag.setRedNum(studentBag.getRedNum() - 1);
                    if (studentBag.getRedNum() == 0) cards.remove(random);
                } else if (Objects.equals(cards.get(random), ColorPawn.YELLOW)) {
                    setYellowPawn(getYellowPawn() + 1);
                    studentBag.setNum(studentBag.getNum() - 1);
                    studentBag.setYellowNum(studentBag.getYellowNum() - 1);
                    if (studentBag.getYellowNum() == 0) cards.remove(random);
                } else if (Objects.equals(cards.get(random), ColorPawn.PINK)) {
                    setPinkPawn(getPinkPawn() + 1);
                    studentBag.setNum(studentBag.getNum() - 1);
                    studentBag.setPinkNum(studentBag.getPinkNum() - 1);
                    if (studentBag.getPinkNum() == 0) cards.remove(random);
                } else if (Objects.equals(cards.get(random), ColorPawn.BLUE)) {
                    setBluePawn(getBluePawn() + 1);
                    studentBag.setNum(studentBag.getNum() - 1);
                    studentBag.setBlueNum(studentBag.getBlueNum() - 1);
                    if (studentBag.getBlueNum() == 0) cards.remove(random);
                }
            }
        }
    }
    public void setGreenPawn(int i) {
        greenPawn = i;
    }
    public int getGreenPawn() {
        return greenPawn;
    }
    public void setRedPawn(int i) {
        redPawn = i;
    }
    public int getRedPawn() {
        return redPawn;
    }
    public void setYellowPawn(int i) {
        yellowPawn = i;
    }
    public int getYellowPawn() {
        return yellowPawn;
    }
    public void setPinkPawn(int i) {
        pinkPawn = i;
    }
    public int getPinkPawn() {
        return pinkPawn;
    }
    public void setBluePawn(int i) {
        bluePawn = i;
    }
    public int getBluePawn() {
        return bluePawn;
    }

    public void setCoinPrice(int coinPrice){this.coinPrice = coinPrice;}
    public int getCoinPrice(){return coinPrice;}

    /**
     * CharacterCard 11: choose 1 student from that card and put it in your DiningRoom
     */
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {
        int j;
        if (colorPawn.get(0).equals(ColorPawn.GREEN)) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[0][j] != 1) {
                    player.diningRoom.position[0][j] = 1;
                    player.diningRoom.setNumGreen(j+1);
                    setGreenPawn(getGreenPawn() - 1);
                    if (game.isExpert && (player.diningRoom.position[0][2] == 1 || player.diningRoom.position[0][5] == 1 || player.diningRoom.position[0][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
        if (colorPawn.get(0).equals(ColorPawn.RED)) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[1][j] != 1) {
                    player.diningRoom.position[1][j] = 1;
                    player.diningRoom.setNumRed(j+1);
                    setRedPawn(getRedPawn() - 1);
                    if (game.isExpert && (player.diningRoom.position[1][2] == 1 || player.diningRoom.position[1][5] == 1 || player.diningRoom.position[1][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
        if (colorPawn.get(0).equals(ColorPawn.YELLOW)) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[2][j] != 1) {
                    player.diningRoom.position[2][j] = 1;
                    player.diningRoom.setNumYellow(j+1);
                    setYellowPawn(getYellowPawn() - 1);
                    if (game.isExpert && (player.diningRoom.position[2][2] == 1 || player.diningRoom.position[2][5] == 1 || player.diningRoom.position[2][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
        if (colorPawn.get(0).equals(ColorPawn.PINK)) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[3][j] != 1) {
                    player.diningRoom.position[3][j] = 1;
                    player.diningRoom.setNumPink(j+1);
                    setPinkPawn(getPinkPawn() - 1);
                    if (game.isExpert && (player.diningRoom.position[3][2] == 1 || player.diningRoom.position[3][5] == 1 || player.diningRoom.position[3][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
        if (colorPawn.get(0).equals(ColorPawn.BLUE)) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[4][j] != 1) {
                    player.diningRoom.position[4][j] = 1;
                    player.diningRoom.setNumBlue(j+1);
                    setBluePawn(getBluePawn() - 1);
                    if (game.isExpert && (player.diningRoom.position[4][2] == 1 || player.diningRoom.position[4][5] == 1 || player.diningRoom.position[4][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
        //Refill Nicola
        ArrayList<ColorPawn> cards = createArrayPawn(game.studentBag);
        Random rnd = new Random();
        if (game.studentBag.getNum() > 0) {
            int random = rnd.nextInt(cards.size());
            if (cards.get(random).equals(ColorPawn.GREEN)) {
                setGreenPawn(getGreenPawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setGreenNum(game.studentBag.getGreenNum() - 1);
                if (game.studentBag.getGreenNum() == 0) cards.remove(random);
            } else if (cards.get(random).equals(ColorPawn.RED)) {
                setRedPawn(getRedPawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setRedNum(game.studentBag.getRedNum() - 1);
                if (game.studentBag.getRedNum() == 0) cards.remove(random);
            } else if (cards.get(random).equals(ColorPawn.YELLOW)) {
                setYellowPawn(getYellowPawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setYellowNum(game.studentBag.getYellowNum() - 1);
                if (game.studentBag.getYellowNum() == 0) cards.remove(random);
            } else if (cards.get(random).equals(ColorPawn.PINK)) {
                setPinkPawn(getPinkPawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setPinkNum(game.studentBag.getPinkNum() - 1);
                if (game.studentBag.getPinkNum() == 0) cards.remove(random);
            } else if (cards.get(random).equals(ColorPawn.BLUE)) {
                setBluePawn(getBluePawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setBlueNum(game.studentBag.getBlueNum() - 1);
                if (game.studentBag.getBlueNum() == 0) cards.remove(random);
            }
        }
        setCoinPrice(3);
    }
    static ArrayList<ColorPawn> createArrayPawn(StudentBag studentBag) {
        ArrayList<ColorPawn> arrayPawn = new ArrayList<>();
        if (studentBag.getGreenNum() != 0)
            arrayPawn.add(ColorPawn.GREEN);
        if (studentBag.getRedNum() != 0)
            arrayPawn.add(ColorPawn.RED);
        if (studentBag.getYellowNum() != 0)
            arrayPawn.add(ColorPawn.YELLOW);
        if (studentBag.getPinkNum() != 0)
            arrayPawn.add(ColorPawn.PINK);
        if (studentBag.getBlueNum() != 0)
            arrayPawn.add(ColorPawn.BLUE);
        return arrayPawn;
    }
}
