package it.polimi.ingsw.model;


import java.io.Console;
import java.util.*;

public class Game {
    private static ArrayList<Player> players = new ArrayList<>(4);
    protected static int totPlayer = 0;
    private static ArrayList<Cloud> clouds;
    private static final ArrayList<Island> islands = new ArrayList<>(12);
    protected static boolean isExpert;
    private CharacterCard[] card = new CharacterCard[3];
    protected static Map<Integer, String> m = new HashMap<Integer, String>();

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
        m.put(0, "GREEN");
        m.put(1, "RED");
        m.put(2, "YELLOW");
        m.put(3, "PINK");
        m.put(4, "BLUE");


        newPlayer();//bisogna capire come fare...

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
            if (Objects.equals(startingPawn.get(random), m.get(0))) {
                g--;
                islands.get(i).greenPawn++;
                if (g == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(1))) {
                r--;
                islands.get(i).redPawn++;
                if (r == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(2))) {
                y--;
                islands.get(i).yellowPawn++;
                if (y == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(3))) {
                p--;
                islands.get(i).pinkPawn++;
                if (p == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(4))) {
                b--;
                islands.get(i).bluePawn++;
                if (b == 0) startingPawn.remove(random);
            }
        }

        // creazione nuvole e inizializzazione
        clouds = new ArrayList<>();
        for (i = 0; i < totPlayer; i++) {
            Cloud cloud = new Cloud();
            cloud.refillCloud();
            clouds.add(cloud);
        }

        //aggiunta di pedine all'entrata di ogni player


        for (i = 0; i < totPlayer; i++) {
            int j =  players.get(i).entrance.numPawn;
            while (j > 0) {
                ArrayList<String> entrancePawn = createArrayPawn();
                if (StudentBag.num > 0) {
                    int random = rnd.nextInt(entrancePawn.size());
                    if (Objects.equals(entrancePawn.get(random), m.get(0))) {//verde
                        players.get(i).entrance.greenPawn++;
                        players.get(i).entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.greenNum--;
                        if (StudentBag.greenNum == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(1))) {//rosso
                        players.get(i).entrance.redPawn++;
                        players.get(i).entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.redNum--;
                        if (StudentBag.redNum == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(2))) {//giallo
                        players.get(i).entrance.yellowPawn++;
                        players.get(i).entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.yellowNum--;
                        if (StudentBag.yellowNum == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(3))) {//rosa
                        players.get(i).entrance.pinkPawn++;
                        players.get(i).entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.pinkNum--;
                        if (StudentBag.pinkNum == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(4))) {//blu
                        players.get(i).entrance.bluePawn++;
                        players.get(i).entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.blueNum--;
                        if (StudentBag.blueNum == 0) entrancePawn.remove(random);
                    }
                    j--;
                }
            }
        }
    }

    static ArrayList<String> createArrayPawn() {//crea un array per ogni colore (utilizzato per funzioni random)
        ArrayList<String> arrayPawn = new ArrayList<>();
        if (StudentBag.greenNum != 0)
            arrayPawn.add("GREEN");
        if (StudentBag.redNum != 0)
            arrayPawn.add("RED");
        if (StudentBag.yellowNum != 0)
            arrayPawn.add("YELLOW");
        if (StudentBag.pinkNum != 0)
            arrayPawn.add("PINK");
        if (StudentBag.blueNum != 0)
            arrayPawn.add("BLUE");
        return arrayPawn;
    }

    public static void newPlayer(String nick) {
        int i, j, k;
        for(i=0; i<totPlayer; i++) {
            Player player = new Player();
            player.chooseNick(nick);
            if (isExpert) player.numCoin = 1;
            else player.numCoin = -1;
            //creazione assistenti
            ArrayList<AssistantCard> deckAssistant = new ArrayList<>(10);
            k = 1;
            //aggiunta assistenti
            for (j = 1; j < 11; j++) {
                AssistantCard assistant = new AssistantCard();
                assistant.cardValue = j;
                if (j == 3 || j == 5 || j == 7 || j == 9) k++;
                assistant.stepMotherNature = k;
                deckAssistant.add(assistant);
            }
            player.deckAssistant = deckAssistant;
            //collegamento a tower, dining and entrance
            player.entrance = new Entrance();
            player.diningRoom = new DiningRoom();
            player.towerSpace = new TowerSpace();
            players.add(player);
        }
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
           checkIsland(i, j);
           j=i+1;
           if(j>= islands.size()) j=0;
           checkIsland(i, j);
       }
    }

    private void checkIsland(int i, int j) { //controlla se le due isole si possono unire, nel caso le unisce
        if(islands.get(j).isTower && islands.get(j).colorTower == islands.get(i).colorTower){
            islands.get(i).greenPawn += islands.get(j).greenPawn;
            islands.get(i).redPawn += islands.get(j).redPawn;
            islands.get(i).yellowPawn += islands.get(j).yellowPawn;
            islands.get(i).pinkPawn += islands.get(j).pinkPawn;
            islands.get(i).bluePawn += islands.get(j).bluePawn;
            islands.get(i).totIsland += islands.get(j).totIsland;
            islands.remove(j);
        }
    }

    ;

    public void topInfluence(){
       int i;
       for(i=0; !islands.get(i).isMotherNature; i++);
       int n = ProfTable.checkProf();
       
    };

    public boolean endGame(){
        if(StudentBag.num == 0)return true;
    };

    public void setCard(CharacterCard card) {
        int i;
        Random count = new Random();
        int num = count.nextInt(11);
        for (i = 0; i < 4; i++) {
            card[i] = num;
        }
    }

    public int moveProf(){
        int i;
        return i;
    }
}