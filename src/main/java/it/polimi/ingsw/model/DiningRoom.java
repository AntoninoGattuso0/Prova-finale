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

    public void addPawnToDiningRoom(ColorPawn colorPawn, Player player, Entrance entrance) {

        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), Game.m.get(0))) {
            for (j = 0; j < 10; j++) {
                if (position[0][j] != 1) {
                    position[0][j] = 1;
                    setNumGreen(j);
                    entrance.setGreenPawn(entrance.getGreenPawn() - 1);
                    if (Game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(1))) {
            for (j = 0; j < 10; j++) {
                if (position[1][j] != 1) {
                    position[1][j] = 1;
                    setNumRed(j);
                    entrance.setRedPawn(entrance.getRedPawn() - 1);
                    if (Game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(2))) {
            for (j = 0; j < 10; j++) {
                if (position[2][j] != 1) {
                    position[2][j] = 1;
                    setNumYellow(j);
                    entrance.setYellowPawn(entrance.getYellowPawn() - 1);
                    if (Game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(3))) {
            for (j = 0; j < 10; j++) {
                if (position[3][j] != 1) {
                    position[3][j] = 1;
                    setNumPink(j);
                    entrance.setPinkPawn(entrance.getPinkPawn() - 1);
                    if (Game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(4))) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 0; j < 10; j++) {
                if (position[4][j] != 1) {
                    position[4][j] = 1;
                    setNumBlue(j);
                    entrance.setBluePawn(entrance.getBluePawn() - 1);
                    if (Game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
    }

    public void addPawn(int m, ColorPawn colorPawn, Player player, Entrance entrance) {
        if ((Game.totPlayer == 2 || Game.totPlayer == 4) && (m > 0 && m < 4)) {
            while (m != 0) {
                addPawnToDiningRoom(colorPawn, player, entrance);
                m--;
            }
        }

        if (Game.totPlayer == 3 && (m > 0 && m < 5)) {
            while (m != 0) {
                addPawnToDiningRoom(colorPawn, player, entrance);
                m--;
            }
        }
    }

    public void removePawnFromDiningRoom(ColorPawn colorPawn, Player player) { //le sposta da dining al sacchetto

        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), Game.m.get(0))) {
            for (j = 10; j > 0; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumGreen(getNumGreen() - 1);
                    StudentBag.setGreenNum(StudentBag.getGreenNum() + 1);
                    StudentBag.setNum(StudentBag.getNum() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(1))) {
            for (j = 10; j > 0; j--) {
                for (j = 10; j > 0; j--) {
                    if (position[1][j] != 0) {
                        position[1][j] = 0;
                        setNumRed(getNumRed() - 1);
                        StudentBag.setRedNum(StudentBag.getRedNum() + 1);
                        StudentBag.setNum(StudentBag.getNum() + 1);
                        break;
                    }
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(2))) {
            for (j = 10; j > 0; j--) {
                for (j = 10; j > 0; j--) {
                    if (position[2][j] != 0) {
                        position[2][j] = 0;
                        setNumYellow(getNumYellow() - 1);
                        StudentBag.setYellowNum(StudentBag.getYellowNum() + 1);
                        StudentBag.setNum(StudentBag.getNum() + 1);
                        break;
                    }
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(3))) {
            for (j = 10; j > 0; j--) {
                for (j = 10; j > 0; j--) {
                    if (position[3][j] != 0) {
                        position[3][j] = 0;
                        setNumPink(getNumPink() - 1);
                        StudentBag.setPinkNum(StudentBag.getPinkNum() + 1);
                        StudentBag.setNum(StudentBag.getNum() + 1);
                        break;
                    }
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(4))) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 10; j > 0; j--) {
                for (j = 10; j > 0; j--) {
                    if (position[4][j] != 0) {
                        position[4][j] = 0;
                        setNumBlue(getNumBlue() - 1);
                        StudentBag.setBlueNum(StudentBag.getBlueNum() + 1);
                        StudentBag.setNum(StudentBag.getNum() + 1);
                        break;
                    }
                }
            }
        }
    }

    public void removePawnFromDiningRoom(ColorPawn colorPawn, Player player, Entrance entrance) {//le sposta da dining all'entrance

        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), Game.m.get(0))) {
            for (j = 10; j > 0; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumGreen(getNumGreen() - 1);
                    entrance.setGreenPawn(entrance.getGreenPawn() + 1);
                    if (Game.isExpert && (position[0][2] == 1 || position[0][5] == 1 || position[0][8] == 1))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(1))) {
            for (j = 10; j > 0; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumRed(getNumRed() - 1);
                    entrance.setRedPawn(entrance.getRedPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(2))) {
            for (j = 10; j > 0; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumYellow(getNumYellow() - 1);
                    entrance.setYellowPawn(entrance.getYellowPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(3))) {
            for (j = 10; j > 0; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumPink(getNumPink() - 1);
                    entrance.setPinkPawn(entrance.getPinkPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), Game.m.get(4))) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 10; j > 0; j--) {
                if (position[0][j] != 0) {
                    position[0][j] = 0;
                    setNumBlue(getNumBlue() - 1);
                    entrance.setBluePawn(entrance.getBluePawn() + 1);
                    break;
                }
            }
        }
    }
}