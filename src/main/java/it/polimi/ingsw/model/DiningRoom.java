package it.polimi.ingsw.model;

import it.polimi.ingsw.client.ModelLight.LightDiningRoom;
public class DiningRoom {
    //modifiche all'UML: array di array: in cui gli elementi sono 0 o 1;
    //5 int che tengono conto di quante pedine di ogni colore sono presenti nella sala
    int[][] position = new int[5][10];
    private int numGreen;
    private int numRed;
    private int numYellow;
    private int numPink;
    private int numBlue;

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

     public DiningRoom() {
        int i,j;
        for(i=0;i<10;i++){
            for(j=0;j<5;j++){
                position[j][i]=0;
            }
        }
        numGreen = 0;
        numRed = 0;
        numYellow = 0;
        numPink = 0;
        numBlue = 0;
    }

    public void addPawnToDiningRoom(ColorPawn colorPawn, Player player, Game game) {
        int j; //variabile che serve a iterare dentro le righe della sala
        if (colorPawn.equals(ColorPawn.GREEN) && player.entrance.getGreenPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[0][j] != 1) {
                    player.diningRoom.position[0][j] = 1;
                    player.diningRoom.setNumGreen(player.getDiningRoom().getNumGreen()+1);
                    player.entrance.setGreenPawn(player.entrance.getGreenPawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.RED) && player.entrance.getRedPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[1][j] != 1) {
                    player.diningRoom.position[1][j] = 1;
                    player.diningRoom.setNumRed(j+1);
                    player.entrance.setRedPawn(player.entrance.getRedPawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.YELLOW) && player.entrance.getYellowPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[2][j] != 1) {
                    player.diningRoom.position[2][j] = 1;
                    player.diningRoom.setNumYellow(j+1);
                    player.entrance.setYellowPawn(player.entrance.getYellowPawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.PINK) && player.entrance.getPinkPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[3][j] != 1) {
                    player.diningRoom.position[3][j] = 1;
                    player.diningRoom.setNumPink(j+1);
                    player.entrance.setPinkPawn(player.entrance.getPinkPawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.BLUE) && player.entrance.getBluePawn() > 0) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[4][j] != 1) {
                    player.diningRoom.position[4][j] = 1;
                    player.diningRoom.setNumBlue(j+1);
                    player.entrance.setBluePawn(player.entrance.getBluePawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
    }

    public void removePawnFromDiningRoom(ColorPawn colorPawn, Player player, Game game) { //le sposta da dining al sacchetto
        int j; //variabile che serve a iterare dentro le righe della sala
        if (colorPawn.equals(ColorPawn.GREEN)) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[0][j] != 0) {
                    player.diningRoom.position[0][j] = 0;
                    player.diningRoom.setNumGreen(player.diningRoom.getNumGreen() - 1);
                    game.studentBag.setGreenNum(game.studentBag.getGreenNum() + 1);
                    game.studentBag.setNum(game.studentBag.getNum() + 1);
                }
            }
        } else if (colorPawn.equals(ColorPawn.RED)) {
                for (j = 9; j > -1; j--) {
                    if (player.diningRoom.position[1][j] != 0) {
                        player.diningRoom.position[1][j] = 0;
                        player.diningRoom.setNumRed(player.diningRoom.getNumRed() - 1);
                        game.studentBag.setRedNum(game.studentBag.getRedNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
            }
        } else if (colorPawn.equals(ColorPawn.YELLOW)) {
                for (j = 9; j > -1; j--) {
                    if (player.diningRoom.position[2][j] != 0) {
                        player.diningRoom.position[2][j] = 0;
                        player.diningRoom.setNumYellow(player.diningRoom.getNumYellow() - 1);
                        game.studentBag.setYellowNum(game.studentBag.getYellowNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
            }
        } else if (colorPawn.equals(ColorPawn.PINK)) {
                for (j = 9; j > -1; j--) {
                    if (player.diningRoom.position[3][j] != 0) {
                        player.diningRoom.position[3][j] = 0;
                        player.diningRoom.setNumPink(player.diningRoom.getNumPink() - 1);
                        game.studentBag.setPinkNum(game.studentBag.getPinkNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.BLUE)) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
                for (j = 9; j > -1; j--) {
                    if (player.diningRoom.position[4][j] != 0) {
                        player.diningRoom.position[4][j] = 0;
                        player.diningRoom.setNumBlue(player.diningRoom.getNumBlue() - 1);
                        game.studentBag.setBlueNum(game.studentBag.getBlueNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
                }
        }
    }
    public void removePawnFromDiningRoomToEntrance(ColorPawn colorPawn, Player player, Game game) {//le sposta da dining all'entrance
        int j; //variabile che serve a iterare dentro le righe della sala
        if (colorPawn.equals(ColorPawn.GREEN) && player.diningRoom.getNumGreen() > 0) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[0][j] != 0) {
                    player.diningRoom.position[0][j] = 0;
                    player.diningRoom.setNumGreen(player.diningRoom.getNumGreen() - 1);
                    player.entrance.setGreenPawn(player.entrance.getGreenPawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.RED) && player.diningRoom.getNumRed() > 0) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[1][j] != 0) {
                    player.diningRoom.position[1][j] = 0;
                    player.diningRoom.setNumRed(player.diningRoom.getNumRed() - 1);
                    player.entrance.setRedPawn(player.entrance.getRedPawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.YELLOW) && player.diningRoom.getNumYellow() > 0) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[2][j] != 0) {
                    player.diningRoom.position[2][j] = 0;
                    player.diningRoom.setNumYellow(player.diningRoom.getNumYellow() - 1);
                    player.entrance.setYellowPawn(player.entrance.getYellowPawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.PINK) && player.diningRoom.getNumPink() > 0) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[3][j] != 0) {
                    player.diningRoom.position[3][j] = 0;
                    player.diningRoom.setNumPink(player.diningRoom.getNumPink() - 1);
                    player.entrance.setPinkPawn(player.entrance.getPinkPawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        } else if (colorPawn.equals(ColorPawn.BLUE) && player.diningRoom.getNumBlue() > 0) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[4][j] != 0) {
                    player.diningRoom.position[4][j] = 0;
                    player.diningRoom.setNumBlue(player.diningRoom.getNumBlue() - 1);
                    player.entrance.setBluePawn(player.entrance.getBluePawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        }
    }
    public LightDiningRoom getLightDiningRoom(){
        LightDiningRoom lightDiningRoom=new LightDiningRoom(getNumBlue(),getNumGreen(),getNumPink(),getNumRed(),getNumYellow());
        return lightDiningRoom;
    }
}