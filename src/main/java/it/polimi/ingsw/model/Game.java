package it.polimi.ingsw.model;
import java.util.*;
public class Game {
    protected ArrayList<Player> players = new ArrayList<>();
    protected int totPlayer;
    protected ArrayList<Cloud> clouds;
    protected ProfTable profTable;
    protected ArrayList<Island> islands = new ArrayList<>();
    protected boolean isExpert;
    protected ArrayList<CharacterCard> cards = new ArrayList<>(); //cambiato in arraylist;
    protected ArrayList<CharacterCard> characterCards = new ArrayList<>(3);//insieme dei 3 characters usati
    protected Map<Integer, String> m = new HashMap<>();
    protected StudentBag studentBag;

    public void setTotPlayer(int i) {
        totPlayer = i;
    }
    public int getTotPlayer() {
        return totPlayer;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public Game(int giocatori, boolean expert) {
        totPlayer = giocatori;
        isExpert = expert;
    }
    public void start (Game game){
        int i;
        studentBag = new StudentBag();
        profTable = new ProfTable();
//creazione isole
        for(i=0; i<12; i++){
            Island island = new Island();
            islands.add(island);
        }
//mappa che associa numeri a colori ("m.get(int)" per ricevere il colore in base al numero inserito in int)
        m.put(0, "GREEN");
        m.put(1, "RED");
        m.put(2, "YELLOW");
        m.put(3, "PINK");
        m.put(4, "BLUE");
//randomizza madre natura
        Random rnd = new Random();
        int n = rnd.nextInt(12);
        Island island = islands.get(n);
        island.setMotherNature(true);
        islands.set(n, island);lol
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
        i = n + 1;
        if (i == 12) i = 0;
        Random rnd1 = new Random();
        while (!(islands.get(i).getMotherNature())&&startingPawn.size()>0){
            int random = rnd1.nextInt(startingPawn.size());
            if (Objects.equals(startingPawn.get(random), m.get(0))) {
                g--;
                islands.get(i).setGreenPawn(islands.get(i).getGreenPawn() + 1);
                if (g == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(1))) {
                r--;
                islands.get(i).setRedPawn(islands.get(i).getRedPawn() + 1);
                if (r == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(2))) {
                y--;
                islands.get(i).setYellowPawn(islands.get(i).getYellowPawn() + 1);
                if (y == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(3))) {
                p--;
                islands.get(i).setPinkPawn(islands.get(i).getPinkPawn() + 1);
                if (p == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(4))) {
                b--;
                islands.get(i).setBluePawn(islands.get(i).getBluePawn() + 1);
                if (b == 0) startingPawn.remove(random);
            }
            i++;
            if ((i == n + 6)) i++;
            else if (i == n - 6) i++;
            if (i >= 12) i = 0;
        }
        // creazione nuvole e inizializzazione
        clouds = new ArrayList<>();
        for (i = 0; i < totPlayer; i++) {
            Cloud cloud = new Cloud();
            cloud.refillCloud(studentBag, game);
            clouds.add(cloud);
        }
    }
    static ArrayList<String> createArrayPawn(StudentBag studentBag) {//crea un array per ogni colore (utilizzato per funzioni random)
        ArrayList<String> arrayPawn = new ArrayList<>(5);
        if (studentBag.getGreenNum() > 0)
            arrayPawn.add("GREEN");
        if (studentBag.getRedNum() > 0)
            arrayPawn.add("RED");
        if (studentBag.getYellowNum() > 0)
            arrayPawn.add("YELLOW");
        if (studentBag.getPinkNum() > 0)
            arrayPawn.add("PINK");
        if (studentBag.getBlueNum() > 0)
            arrayPawn.add("BLUE");
        return arrayPawn;
    }
    public static void newPlayer(String nick,Game game) {
        Player player = new Player(nick,game);//inizializzazione player fatta in player -NINO
        game.players.add(player);
    }
    public void moveMotherNature(int num) {
        int i;
        int totIsland = islands.size();
        for (i = 0; !islands.get(i).getMotherNature(); i++) ;
        islands.get(i).setMotherNature(false);
        num += i;
        if (num >= totIsland) num -= totIsland;
        islands.get(num).setMotherNature(true);
    }
    public static void unifyIsland(int i, Game game) { // si fa sempre dopo aver messo una torre, mettiamo in ingresso l'isola con madre natura
        int j, k;
        boolean prevTrue, postTrue;
        if (game.islands.get(i).getTower()) {
            j = i - 1;
            k = i+1;
            if (j < 0) j = game.islands.size() - 1;
            if (k >= game.islands.size()) k = 0;
            prevTrue = checkIsland(i, j, game);
            postTrue = checkIsland(i, k, game);
            if(prevTrue) game.islands.remove(j);
            if(postTrue && prevTrue) game.islands.remove(k-1);
            else if(postTrue) game.islands.remove(k);
        }
    }
    public static boolean checkIsland(int i, int j, Game game) { //controlla se le due isole si possono unire, nel caso le unisce
        if (game.islands.get(j).getTower() && game.islands.get(j).getColorTower() == game.islands.get(i).getColorTower()) {
            game.islands.get(i).setGreenPawn(game.islands.get(i).getGreenPawn() + game.islands.get(j).getGreenPawn());
            game.islands.get(i).setRedPawn(game.islands.get(i).getRedPawn() + game.islands.get(j).getRedPawn());
            game.islands.get(i).setYellowPawn(game.islands.get(i).getYellowPawn() + game.islands.get(j).getYellowPawn());
            game.islands.get(i).setBluePawn(game.islands.get(i).getBluePawn() + game.islands.get(j).getBluePawn());
            game.islands.get(i).setTotIsland(game.islands.get(i).getTotIsland() + 1);
            return true;
        }
        return false;
    }
    public static void topInfluence(Island island,Game game) {
        int i, j, k, n, color, max;
        if (island.getProhibited()) {
            island.setProhibited(false);
            //carte di ernesto +1
        } else {
            boolean notunique = false;
            ArrayList<Integer> influence = new ArrayList<>();
            for (i = 0; i < game.totPlayer; i++) influence.add(0);
            for (color = 0; color < 5; color++) {
                n = game.profTable.checkProf(color);
                if (color == 0 && n != -1) influence.set(n, influence.get(n) + island.getGreenPawn());

                else if (color == 1 && n != -1) influence.set(n, influence.get(n) + island.getRedPawn());

                else if (color == 2 && n != -1) influence.set(n, influence.get(n) + island.getYellowPawn());

                else if (color == 3 && n != -1) influence.set(n, influence.get(n) + island.getPinkPawn());

                else if (color == 4 && n != -1) influence.set(n, influence.get(n) + island.getBluePawn());
            }
            if (game.totPlayer == 4) {
                for (i = 1; game.players.get(i).towerSpace.colorTower == game.players.get(0).towerSpace.colorTower; i++) ;
                influence.set(0, influence.get(0) + influence.get(i));//ho tutte le pedine di una squadra sommate al player 0
                for (j = 1; j < game.totPlayer && j == i; j++) ;
                for (k = 2; k < game.totPlayer && (k == i || k == j); k++) ;
                influence.set(j, influence.get(j) + influence.get(k));//sommo tutte le pedine dell'altra squadra all'indirizzo j
                influence.set(i, 0);
                influence.set(k, 0);
            }

            for (i = 0; i < game.totPlayer; i++) {
                if (island.getTower() && island.getColorTower() == game.players.get(i).towerSpace.colorTower)
                    influence.set(i, influence.get(i) + island.getTotIsland());
            }
            max = Collections.max(influence);
            for (i = 0; i < influence.size() && !notunique; i++) {
                for (j = i + 1; j < influence.size() && !notunique; j++) {
                    if ((influence.get(i).equals(influence.get(j))) && influence.get(i).equals(max) && game.players.get(i).towerSpace.colorTower != game.players.get(j).towerSpace.colorTower)
                        notunique = true;
                }
            }
            if (!notunique) island.setColorTower(game.players.get(influence.indexOf(max)).towerSpace.colorTower);
            unifyIsland(game.islands.indexOf(island), game);
        }
    }
        public boolean endGame () {
            return studentBag.getNum() == 0;
        }

        public void setCharacterCards (Game game) { //posiziona a caso dei personaggi (3)
            if (game.isExpert) {
                Antonio antonio = new Antonio(game.studentBag);
                Barbara barbara = new Barbara(game);
                Ciro ciro = new Ciro();
                Dante dante = new Dante();
                Ernesto ernesto = new Ernesto();
                Felix felix = new Felix();
                Giuseppe giuseppe = new Giuseppe(game.studentBag, game);
                Ivan ivan = new Ivan();
                Lancillotto lancillotto = new Lancillotto();
                Maria maria = new Maria();
                Nicola nicola = new Nicola(game.studentBag, game);
                Omnia omnia = new Omnia();

                Random rnd = new Random();
                int random = rnd.nextInt(12);
                int random1 = rnd.nextInt(12);
                int random2 = rnd.nextInt(12);
                while (random == random1 || random1 == random2 || random == random2) {
                    random = rnd.nextInt(12);
                    random1 = rnd.nextInt(12);
                    random2 = rnd.nextInt(12);
                }
                if (random == 0 || random1 == 0 || random2 == 0) {
                    CharacterCard card = new CharacterCard(antonio);
                    game.characterCards.add(card);
                }
                if (random == 1 || random1 == 1 || random2 == 1) {
                    CharacterCard card = new CharacterCard(barbara);
                    game.characterCards.add(card);
                }
                if (random == 2 || random1 == 2 || random2 == 2) {
                    CharacterCard card = new CharacterCard(ciro);
                    game.characterCards.add(card);
                }
                if (random == 3 || random1 == 3 || random2 == 3) {
                    CharacterCard card = new CharacterCard(dante);
                    game.characterCards.add(card);
                }
                if (random == 4 || random1 == 4 || random2 == 4) {
                    CharacterCard card = new CharacterCard(ernesto);
                    game.characterCards.add(card);
                }
                if (random == 5 || random1 == 5 || random2 == 5) {
                    CharacterCard card = new CharacterCard(felix);
                    game.characterCards.add(card);
                }
                if (random == 6 || random1 == 6 || random2 == 6) {
                    CharacterCard card = new CharacterCard(giuseppe);
                    game.characterCards.add(card);
                }
                if (random == 7 || random1 == 7 || random2 == 7) {
                    CharacterCard card = new CharacterCard(ivan);
                    game.characterCards.add(card);
                }
                if (random == 8 || random1 == 8 || random2 == 8) {
                    CharacterCard card = new CharacterCard(lancillotto);
                    game.characterCards.add(card);
                }
                if (random == 9 || random1 == 9 || random2 == 9) {
                    CharacterCard card = new CharacterCard(maria);
                    game.characterCards.add(card);
                }
                if (random == 10 || random1 == 10 || random2 == 10) {
                    CharacterCard card = new CharacterCard(nicola);
                    game.characterCards.add(card);
                }
                if (random == 11 || random1 == 11 || random2 == 11) {
                    CharacterCard card = new CharacterCard(omnia);
                    game.characterCards.add(card);
                }
            }
        }
        public void moveProf () {
            int i, j;
            ArrayList<Integer> maxColor = new ArrayList<>();
            for (i = 0; i < 5; i++) {
                if (i == 0) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumGreen());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)) ProfTable.setGreenProf(indexMax);
                    maxColor.clear();
                } else if (i == 1) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumRed());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)) ProfTable.setRedProf(indexMax);
                    maxColor.clear();
                } else if (i == 2) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumYellow());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)) ProfTable.setYellowProf(indexMax);
                    maxColor.clear();
                } else if (i == 3) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumPink());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)) ProfTable.setPinkProf(indexMax);
                    maxColor.clear();
                } else if (i == 4) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumBlue());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)) ProfTable.setBlueProf(indexMax);
                    maxColor.clear();
                }
            }
        }
    }