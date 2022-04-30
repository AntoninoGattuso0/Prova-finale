package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Nicola extends UseEffect {
    private int coinPrice;
    private static int greenPawn;
    private static int redPawn;
    private static int yellowPawn;
    private static int pinkPawn;
    private static int bluePawn;

    Nicola(StudentBag studentBag) {
        Random rnd = new Random();
        ArrayList<String> cards = createArrayPawn(studentBag);
        if (studentBag.getNum() > 0) {
            int random = rnd.nextInt(cards.size());
            if (Objects.equals(cards.get(random), Game.m.get(0))) {//verde
                setGreenPawn(getGreenPawn() + 1);
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setGreenNum(studentBag.getGreenNum() - 1);
                if (studentBag.getGreenNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(1))) {//rosso
                setRedPawn(getRedPawn() + 1);
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setRedNum(studentBag.getRedNum() - 1);
                if (studentBag.getRedNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(2))) {//giallo
                setYellowPawn(getYellowPawn() + 1);
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setYellowNum(studentBag.getYellowNum() - 1);
                if (studentBag.getYellowNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(3))) {//rosa
                setPinkPawn(getPinkPawn() + 1);
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setPinkNum(studentBag.getPinkNum() - 1);
                if (studentBag.getPinkNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(4))) {//blu
                setBluePawn(getBluePawn() + 1);
                studentBag.setNum(studentBag.getNum() - 1);
                studentBag.setBlueNum(studentBag.getBlueNum() - 1);
                if (studentBag.getBlueNum() == 0) cards.remove(random);
            }
        }
        coinPrice = 2;
    }

    public static void setGreenPawn(int i) {
        greenPawn = i;
    }

    public static int getGreenPawn() {
        return greenPawn;
    }

    public static void setRedPawn(int i) {
        redPawn = i;
    }

    public static int getRedPawn() {
        return redPawn;
    }

    public static void setYellowPawn(int i) {
        yellowPawn = i;
    }

    public static int getYellowPawn() {
        return yellowPawn;
    }

    public void setPinkPawn(int i) {
        pinkPawn = i;
    }

    public static int getPinkPawn() {
        return pinkPawn;
    }

    public static void setBluePawn(int i) {
        bluePawn = i;
    }

    public static int getBluePawn() {
        return bluePawn;
    }


    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {
        int j; //variabile che serve a iterare dentro le righe della sala
        if (colorPawn.get(0).equals(Game.m.get(0))) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[0][j] != 1) {
                    player.diningRoom.position[0][j] = 1;
                    player.diningRoom.setNumGreen(j);
                    setGreenPawn(getGreenPawn() - 1);
                    if (Game.isExpert && (player.diningRoom.position[0][2] == 1 || player.diningRoom.position[0][5] == 1 || player.diningRoom.position[0][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }

        if (Objects.equals(colorPawn.toString(), Game.m.get(1))) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[1][j] != 1) {
                    player.diningRoom.position[1][j] = 1;
                    player.diningRoom.setNumRed(j);
                    setRedPawn(getRedPawn() - 1);
                    if (Game.isExpert && (player.diningRoom.position[1][2] == 1 || player.diningRoom.position[1][5] == 1 || player.diningRoom.position[1][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }

        if (Objects.equals(colorPawn.toString(), Game.m.get(2))) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[2][j] != 1) {
                    player.diningRoom.position[2][j] = 1;
                    player.diningRoom.setNumYellow(j);
                    setYellowPawn(getYellowPawn() - 1);
                    if (Game.isExpert && (player.diningRoom.position[2][2] == 1 || player.diningRoom.position[2][5] == 1 || player.diningRoom.position[2][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }

        if (Objects.equals(colorPawn.toString(), Game.m.get(3))) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[3][j] != 1) {
                    player.diningRoom.position[3][j] = 1;
                    player.diningRoom.setNumPink(j);
                    setPinkPawn(getPinkPawn() - 1);
                    if (Game.isExpert && (player.diningRoom.position[3][2] == 1 || player.diningRoom.position[3][5] == 1 || player.diningRoom.position[3][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }

        if (Objects.equals(colorPawn.toString(), Game.m.get(4))) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[4][j] != 1) {
                    player.diningRoom.position[4][j] = 1;
                    player.diningRoom.setNumBlue(j);
                    setBluePawn(getBluePawn() - 1);
                    if (Game.isExpert && (player.diningRoom.position[4][2] == 1 || player.diningRoom.position[4][5] == 1 || player.diningRoom.position[4][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
        //Refill Nicola
        ArrayList<String> cards = createArrayPawn(game.studentBag);
        Random rnd = new Random();
        if (game.studentBag.getNum() > 0) {
            int random = rnd.nextInt(cards.size());
            if (Objects.equals(cards.get(random), Game.m.get(0))) {//verde
                setGreenPawn(getGreenPawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setGreenNum(game.studentBag.getGreenNum() - 1);
                if (game.studentBag.getGreenNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(1))) {//rosso
                setRedPawn(getRedPawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setRedNum(game.studentBag.getRedNum() - 1);
                if (game.studentBag.getRedNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(2))) {//giallo
                setYellowPawn(getYellowPawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setYellowNum(gamestudentBag.getYellowNum() - 1);
                if (game.studentBag.getYellowNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(3))) {//rosa
                setPinkPawn(getPinkPawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setPinkNum(game.studentBag.getPinkNum() - 1);
                if (game.studentBag.getPinkNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(4))) {//blu
                setBluePawn(getBluePawn() + 1);
                game.studentBag.setNum(game.studentBag.getNum() - 1);
                game.studentBag.setBlueNum(game.studentBag.getBlueNum() - 1);
                if (game.studentBag.getBlueNum() == 0) cards.remove(random);
            }
        }
        coinPrice++;
    }
    static ArrayList<String> createArrayPawn(StudentBag studentBag) {//crea un array per ogni colore (utilizzato per funzioni random)
        ArrayList<String> arrayPawn = new ArrayList<>();
        if (studentBag.getGreenNum() != 0)
            arrayPawn.add("GREEN");
        if (studentBag.getRedNum() != 0)
            arrayPawn.add("RED");
        if (studentBag.getYellowNum() != 0)
            arrayPawn.add("YELLOW");
        if (studentBag.getPinkNum() != 0)
            arrayPawn.add("PINK");
        if (studentBag.getBlueNum() != 0)
            arrayPawn.add("BLUE");
        return arrayPawn;
    }
}
