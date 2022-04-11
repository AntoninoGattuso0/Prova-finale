package it.polimi.ingsw.model;


import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private static ArrayList<Player> players = new ArrayList<>(4);
    protected static int totPlayer = 0;
    private static Cloud[] clouds;
    private static final ArrayList<Island> islands = new ArrayList<>(12);
    protected boolean isExpert;
    private CharacterCard[] card = new CharacterCard[3];

    protected static void start() {
        int i;

        StudentBag.num = 120;
        StudentBag.greenNum = StudentBag.redNum = StudentBag.yellowNum = StudentBag.pinkNum = StudentBag.blueNum = 24;

        for (i = 0; i < 11; i++) {
            Island island = new Island();
            island.isMotherNature = false;
            island.greenPawn = 0;
            island.redPawn = 0;
            island.yellowPawn = 0;
            island.pinkPawn = 0;
            island.bluePawn = 0;
            island.isTower = false;
            island.colorTower = null;
            island.isProhibited = false;
            island.totIsland = 1;
            islands.add(island);
        }


        newPlayer();

//randomizza pedine per ogni isola
        Random rnd = new Random();
        int n = rnd.nextInt(12);
        islands.get(n).isMotherNature = true;
        int g = 2;
        int r = 2;
        int y = 2;
        int p = 2;
        int b = 2; //conteggio 2 pedine per colore
        for (i = n + 1; !islands.get(i).isMotherNature; i++) {
            if (i == 12) i = 0;
            if ((i == n + 6) || (i == n - 6)) i++;
            int color = rnd.nextInt(5);
            boolean check = false;
            while (!check) {
                if (color == 0 && g != 0) {
                    g--;
                    islands.get(i).greenPawn++;
                    check = true;
                } else if (color == 1 && r != 0) {
                    r--;
                    islands.get(i).redPawn++;
                    check = true;
                } else if (color == 2 && y != 0) {
                    y--;
                    islands.get(i).yellowPawn++;
                    check = true;
                } else if (color == 3 && p != 0) {
                    p--;
                    islands.get(i).pinkPawn++;
                    check = true;
                } else if (color == 4 && b != 0) {
                    b--;
                    islands.get(i).bluePawn++;
                    check = true;
                } else {
                    color++;
                    if (color == 5) color = 0;
                }
            }
        }

        // creazione nuvole
        clouds = new Cloud[4];
        for (i = 0; i < totPlayer; i++) {
            Cloud cloud = new Cloud();
            cloud.refillCloud();
            clouds[i] = cloud;
        }

    }

    public static void newPlayer() {
        Player player = new Player();
        Console console = System.console();
        String str = console.readLine(" Inserisci il nome del Giocatore : ");
        player.chooseNick(str);
        player.numCoin = 0;
        players.add(player);
        totPlayer += 1; //non saprei, tot player si deve sapere a prescindere no?
    }

    public void moveMotherNature(int num){
        int i;
        int totIsland = islands.size();
        for(i=0; islands.get(i).isMotherNature; i++);
        islands.get(i).isMotherNature = false;
        num += i;
        if(num >= totIsland) num -= totIsland;
        islands.get(i+num).isMotherNature = true;
    };

    public void unifyIsland(){
       int i,j;
       for(i=0; !islands.get(i).isMotherNature; i++);
       if(islands.get(i).isTower){
           j=i-1;
           if(j<0) j= islands.size();
           if(islands.get(j).isTower && islands.get(j).colorTower == islands.get(i).colorTower){
               islands.get(i).greenPawn += islands.get(j).greenPawn;
               islands.get(i).redPawn += islands.get(j).redPawn;
               islands.get(i).yellowPawn += islands.get(j).yellowPawn;
               islands.get(i).pinkPawn += islands.get(j).pinkPawn;
               islands.get(i).bluePawn += islands.get(j).bluePawn;
               islands.get(i).totIsland += islands.get(j).totIsland;
               islands.remove(j);
           }
           j=i+1;
           if(j> islands.size()) j=0;
           if(islands.get(j).isTower && islands.get(j).colorTower == islands.get(i).colorTower) {
               islands.get(i).greenPawn += islands.get(j).greenPawn;
               islands.get(i).redPawn += islands.get(j).redPawn;
               islands.get(i).yellowPawn += islands.get(j).yellowPawn;
               islands.get(i).pinkPawn += islands.get(j).pinkPawn;
               islands.get(i).bluePawn += islands.get(j).bluePawn;
               islands.get(i).totIsland += islands.get(j).totIsland;
               islands.remove(j);
           }
       }
    };

    public void topInfluence(){
       int i;
       for(i=0; !islands.get(i).isMotherNature; i++);
       
    };

    public boolean endGame(){
        if(StudentBag.checkNum())return true;
    };

    public void setCard(CharacterCard card) {
        int i;
        Random count = new Random();
        int num = count.nextInt(11);
        for (i = 0; i < 4; i++) {
            card[i] = num;
        }
    }
}