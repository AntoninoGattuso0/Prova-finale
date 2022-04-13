package it.polimi.ingsw.model;


import java.io.Console;
import java.util.*;

public class Game {
    private static ArrayList<Player> players = new ArrayList<>(4);
    protected static int totPlayer = 0;
    private static ArrayList<Cloud> clouds;
    private static final ArrayList<Island> islands = new ArrayList<>(12);
    protected boolean isExpert;
    private CharacterCard[] card = new CharacterCard[3];

    protected static void start() {
        int i;

        StudentBag.num = 120;
        StudentBag.greenNum = StudentBag.redNum = StudentBag.yellowNum = StudentBag.pinkNum = StudentBag.blueNum = 24;
//creazione isole
        for (i = 0; i < 12; i++) {
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
//mappa che associa numeri a colori ("m.get(int)" per ricevere il colore in base al numero inserito in int)
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(0, "GREEN");
        m.put(1, "RED");
        m.put(2, "YELLOW");
        m.put(3, "PINK");
        m.put(4, "BLUE");


        newPlayer();

//randomizza pedine per ogni isola iniziale
        Random rnd = new Random();
        int n = rnd.nextInt(12);
        islands.get(n).isMotherNature = true;

        int g = 2;
        int r = 2;
        int y = 2;
        int p = 2;
        int b = 2; //conteggio 2 pedine per colore
//arraylist per ogni colore
        ArrayList<String> startingPawn = new ArrayList<>(5);
        startingPawn.add("GREEN");
        startingPawn.add("RED");
        startingPawn.add("YELLOW");
        startingPawn.add("PINK");
        startingPawn.add("BLUE");

        for (i = n + 1; !islands.get(i).isMotherNature; i++) {
            if (i == 12) i = 0;
            if ((i == n + 6) || (i == n - 6)) i++;
            int random = rnd.nextInt(startingPawn.size());
            String color = m.get(random);
                if (Objects.equals(startingPawn.get(random), "GREEN")) {
                    g--;
                    islands.get(i).greenPawn++;
                    if(g==0)startingPawn.remove(random);
                } else if (Objects.equals(startingPawn.get(random), "RED")) {
                    r--;
                    islands.get(i).redPawn++;
                    if(r==0)startingPawn.remove(random);
                } else if (Objects.equals(startingPawn.get(random), "YELLOW")) {
                    y--;
                    islands.get(i).yellowPawn++;
                    if(y==0)startingPawn.remove(random);
                } else if (Objects.equals(startingPawn.get(random), "PINK")) {
                    p--;
                    islands.get(i).pinkPawn++;
                    if(p==0)startingPawn.remove(random);
                } else if (Objects.equals(startingPawn.get(random), "BLUE") && b != 0) {
                    b--;
                    islands.get(i).bluePawn++;
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
        for(i=0; !islands.get(i).isMotherNature; i++);
        islands.get(i).isMotherNature = false;
        num += i;
        if(num >= totIsland) num -= totIsland;
        islands.get(num).isMotherNature = true;
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
           if(j>= islands.size()) j=0;
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