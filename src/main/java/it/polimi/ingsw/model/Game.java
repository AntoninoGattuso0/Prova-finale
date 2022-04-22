package it.polimi.ingsw.model;


import java.io.Console;
import java.util.*;

public class Game {
    protected static ArrayList<Player> players = new ArrayList<>(4);
    protected static int totPlayer = 0;
    private static ArrayList<Cloud> clouds;
    private static ProfTable profTable;
    protected static final ArrayList<Island> islands = new ArrayList<>(12);
    protected static boolean isExpert;
    protected final ArrayList<CharacterCard> cards = new ArrayList<>(3); //cambiato in arraylist;
    protected static ArrayList<CharacterCard> characterCards = new ArrayList<>(12);//insieme di tutti i characters
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

        Game.profTable = new ProfTable();


       Game.newPlayer("richiedi nick da controller che catzo");//bisogna capire come fare...

//randomizza madre natura
        Random rnd = new Random();
        int n = rnd.nextInt(12);
        islands.get(n).isMotherNature = true;
//randomizza pedine per ogni isola iniziale
        int g = 2;
        int r = 2;
        int y = 2;
        int p = 2;
        int b = 2; //conteggio 2 pedine per colore
//arraylist per ogni colore
        ArrayList<String> startingPawn = new ArrayList<>(5);
        startingPawn.add(m.get(0));
        startingPawn.add(m.get(1));
        startingPawn.add(m.get(2));
        startingPawn.add(m.get(3));
        startingPawn.add(m.get(4));

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
            int j =  players.get(i).entrance.numPawn;   //che cosa restituisce? numPawn si modifica nel tempo
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

        //creazione arraylist con tutte i personaggi
        Antonio antonio = new Antonio();
        Barbara barbara = new Barbara();
        Ciro ciro = new Ciro();
        Dante dante = new Dante();
        Ernesto ernesto = new Ernesto();
        Felix felix = new Felix();
        Giuseppe giuseppe = new Giuseppe();
        Ivan ivan = new Ivan();
        Lancillotto lancillotto = new Lancillotto();
        Maria maria = new Maria();
        Nicola nicola = new Nicola();
        Omnia omnia = new Omnia();
        characterCards.add(antonio);
        characterCards.add(barbara);
        characterCards.add(ciro);
        characterCards.add(dante);
        characterCards.add(ernesto);
        characterCards.add(felix);
        characterCards.add(giuseppe);
        characterCards.add(ivan);
        characterCards.add(lancillotto);
        characterCards.add(maria);
        characterCards.add(nicola);
        characterCards.add(omnia);

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
            player.entrance.setNumPawn();
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

    public void unifyIsland(int i){ // si fa sempre dopo aver messo una torre, mettiamo in ingresso l'isola con madre natura
       int j;
       if(islands.get(i).isTower){
           j=i-1;
           if(j<0) j = islands.size();
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
            islands.get(i).totIsland++;
            islands.remove(j);
        }
    }



    public void topInfluence(){
       int i, j, n, color;
       n = -1;
       for(i=0; !islands.get(i).isMotherNature; i++);
       ArrayList<Integer> influence = new ArrayList<>(3);
       for(j=0; j<totPlayer; j++) influence.add(0);
       for(color=0; color<5; color++) {
           n = ProfTable.checkProf(color); //boh, sei arrivato qui ma manca il metodo
           influence.get(n).equals(islands.get(i).greenPawn);
       }
       islands.get(i).isTower = true;
       islands.get(i).colorTower = players.get(n).towerSpace.colorTower;
       unifyIsland(i);
    };

    public boolean endGame(){
        return StudentBag.num == 0;
    };

    public void setCard() { //posiziona a caso dei personaggi (3)
        int i;
        Random rnd = new Random();
        int random = rnd.nextInt(characterCards.size());
        for (i = 0; i < 3; i++) {
            cards.add(characterCards.get(random));
            cards.get(random).On= true;
            characterCards.remove(random);
            random = rnd.nextInt(characterCards.size());
        }
    }

    public void moveProf(){
        int i, j;
        ArrayList<Integer> maxColor = new ArrayList<>();
        for(i=0; i<5; i++){
            if(i==0) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numGreen);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.greenProf = indexMax;
                maxColor.clear();
            }
            else if (i==1) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numRed);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.redProf = indexMax;
                maxColor.clear();
            }
            else if (i==2) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numYellow);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.yellowProf = indexMax;
                maxColor.clear();
            }
            else if (i==3) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numPink);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.pinkProf = indexMax;
                maxColor.clear();
            }
            else if (i==4) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numBlue);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.blueProf = indexMax;
                maxColor.clear();
            }
        }
    }
}