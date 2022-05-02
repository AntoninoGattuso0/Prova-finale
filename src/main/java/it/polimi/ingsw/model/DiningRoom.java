package it.polimi.ingsw.model;
import java.util.Objects;
public class DiningRoom {
    //modifiche all'UML: array di array: in cui gli elementi sono 0 o 1;
    //5 int che tengono conto di quante pedine di ogni colore sono presenti nella sala
    int[][] position = new int[5][10];
    private int numGreen;
    private int numRed;
    private int numYellow;
    private int numPink;
    private int numBlue;
    DiningRoom() {
        numGreen = 0;
        numRed = 0;
        numYellow = 0;
        numPink = 0;
        numBlue = 0;
    }
    public int getNumGreen() {
        return numGreen;
    }
    public int getNumRed() {
        return numRed;
    }
    public int getNumYellow() {
        return numYellow;
    }
    public int getNumPink() {
        return numPink;
    }
    public int getNumBlue() {
        return numBlue;
    }
    public void setNumGreen(int numGreen) {
        this.numGreen = numGreen;
    }
    public void setNumRed(int numRed) {
        this.numRed = numRed;
    }
    public void setNumYellow(int numYellow) {
        this.numYellow = numYellow;
    }
    public void setNumPink(int numPink) {
        this.numPink = numPink;
    }
    public void setNumBlue(int numBlue) {
        this.numBlue = numBlue;
    }

    public void addPawnToDiningRoom(ColorPawn colorPawn, Player player, Game game) {
        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), game.m.get(0)) && player.entrance.getGreenPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (position[0][j] != 1) {
                    position[0][j] = 1;
                    setNumGreen(j+1);
                    player.entrance.setGreenPawn(player.entrance.getGreenPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(1)) && player.entrance.getRedPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (position[1][j] != 1) {
                    position[1][j] = 1;
                    setNumRed(j+1);
                    player.entrance.setRedPawn(player.entrance.getRedPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(2)) && player.entrance.getYellowPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (position[2][j] != 1) {
                    position[2][j] = 1;
                    setNumYellow(j+1);
                    player.entrance.setYellowPawn(player.entrance.getYellowPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(3)) && player.entrance.getPinkPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (position[3][j] != 1) {
                    position[3][j] = 1;
                    setNumPink(j+1);
                    player.entrance.setPinkPawn(player.entrance.getPinkPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(4)) && player.entrance.getBluePawn() > 0) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 0; j < 10; j++) {
                if (position[4][j] != 1) {
                    position[4][j] = 1;
                    setNumBlue(j+1);
                    player.entrance.setBluePawn(player.entrance.getBluePawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
    }
    public void addPawn(int m, ColorPawn colorPawn, Player player, Game game) {
        if ((game.totPlayer == 2 || game.totPlayer == 4) && (m > 0 && m < 4)) {
            while (m != 0) {
                addPawnToDiningRoom(colorPawn, player);
                m--;
            }
        }
        if (game.totPlayer == 3 && (m > 0 && m < 5)) {
            while (m != 0) {
                addPawnToDiningRoom(colorPawn, player);
                m--;
            }
        }
    }
    public void removePawnFromDiningRoom(ColorPawn colorPawn, Player player, Game game) { //le sposta da dining al sacchetto
        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), game.m.get(0)) ) {
            for (j = 9; j > -1; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumGreen(getNumGreen() - 1);
                    game.studentBag.setGreenNum(game.studentBag.getGreenNum() + 1);
                    game.studentBag.setNum(game.studentBag.getNum() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(1))) {
            for (j = 9; j > -1; j--) {
                for (j = 10; j > 0; j--) {
                    if (position[1][j] != 0) {
                        position[1][j] = 0;
                        setNumRed(getNumRed() - 1);
                        game.studentBag.setRedNum(game.studentBag.getRedNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(2))) {
            for (j = 9; j > -1; j--) {
                for (j = 10; j > 0; j--) {
                    if (position[2][j] != 0) {
                        position[2][j] = 0;
                        setNumYellow(getNumYellow() - 1);
                        game.studentBag.setYellowNum(game.studentBag.getYellowNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(3))) {
            for (j = 9; j > -1; j--) {
                for (j = 10; j > 0; j--) {
                    if (position[3][j] != 0) {
                        position[3][j] = 0;
                        setNumPink(getNumPink() - 1);
                        game.studentBag.setPinkNum(game.studentBag.getPinkNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(4))) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 9; j > -1; j--) {
                for (j = 10; j > 0; j--) {
                    if (position[4][j] != 0) {
                        position[4][j] = 0;
                        setNumBlue(getNumBlue() - 1);
                        game.studentBag.setBlueNum(game.studentBag.getBlueNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
                }
            }
        }
    }
    public void removePawnFromDiningRoom(ColorPawn colorPawn, Player player, Game game, Entrance entrance) {//le sposta da dining all'entrance
        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), game.m.get(0)) && player.diningRoom.getNumGreen() > 0) {
            for (j = 9; j > -1; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumGreen(getNumGreen() - 1);
                    player.entrance.setGreenPawn(player.entrance.getGreenPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(1)) && player.diningRoom.getNumRed() > 0) {
            for (j = 9; j > -1; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumRed(getNumRed() - 1);
                    player.entrance.setRedPawn(player.entrance.getRedPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(2)) && player.diningRoom.getNumYellow() > 0) {
            for (j = 9; j > -1; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumYellow(getNumYellow() - 1);
                    player.entrance.setYellowPawn(player.entrance.getYellowPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(3))&& player.diningRoom.getNumPink() > 0) {
            for (j = 9; j > -1; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumPink(getNumPink() - 1);
                    player.entrance.setPinkPawn(player.entrance.getPinkPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(4)) && player.diningRoom.getNumBlue() > 0) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 9; j > -1; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumBlue(getNumBlue() - 1);
                    player.entrance.setBluePawn(player.entrance.getBluePawn() + 1);
                    break;
                }
            }
        }
    }
}