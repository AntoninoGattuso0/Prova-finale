package it.polimi.ingsw.model;


import java.util.*;

public class Game {
    protected static ArrayList<Player> players = new ArrayList<>(4);
    protected static int totPlayer;
    private ArrayList<Cloud> clouds;
    protected static ProfTable profTable;
    protected static final ArrayList<Island> islands = new ArrayList<>(12);
    protected static boolean isExpert;
    protected static ArrayList<CharacterCard> cards = new ArrayList<>(3); //cambiato in arraylist;
    protected static ArrayList<CharacterCard> characterCards = new ArrayList<>(12);//insieme di tutti i characters
    protected static Map<Integer, String> m = new HashMap<>();

    public void setTotPlayer(int i){
        totPlayer = i;
    }
    public int getTotPlayer(){
        return totPlayer;
    }
    public Game(int h, boolean isExpert) {
        totPlayer = h;
        this.isExpert = isExpert;
        int i;
        StudentBag studentBag= new StudentBag();
        ProfTable profTable = new ProfTable();
//creazione isole
        for (i = 0; i < 12; i++) {
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
        islands.get(n).setMotherNature(true);
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
        for (i = n + 1; !islands.get(i).getMotherNature(); i++) {
            if (i == 12) i = 0;
            if ((i == n + 6) || (i == n - 6)) i++;
            int random = rnd.nextInt(startingPawn.size());
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
            Player player= new Player("nick");
            int j =  player.entrance.getNumPawn();   //che cosa restituisce? numPawn si modifica nel tempo
            while (j > 0) {
                ArrayList<String> entrancePawn = createArrayPawn();
                if (StudentBag.getNum() > 0) {
                    int random = rnd.nextInt(entrancePawn.size());
                    if (Objects.equals(entrancePawn.get(random), m.get(0))) {//verde
                        player.entrance.setGreenPawn(player.entrance.getGreenPawn() + 1);
                        player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setGreenNum(StudentBag.getGreenNum() - 1);
                        if (StudentBag.getGreenNum() == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(1))) {//rosso
                        player.entrance.setRedPawn(player.entrance.getRedPawn() + 1);
                        player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setRedNum(StudentBag.getRedNum() - 1);
                        if (StudentBag.getRedNum() == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(2))) {//giallo
                        player.entrance.setYellowPawn(player.entrance.getYellowPawn() + 1);
                        player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setYellowNum(StudentBag.getYellowNum() - 1);
                        if (StudentBag.getYellowNum() == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(3))) {//rosa
                        player.entrance.setPinkPawn(player.entrance.getPinkPawn() + 1);
                        player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setPinkNum(StudentBag.getPinkNum() - 1);
                        if (StudentBag.getPinkNum() == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(4))) {//blu
                        player.entrance.setBluePawn(player.entrance.getBluePawn() + 1);
                        player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                        StudentBag.setNum(StudentBag.getNum() - 1);
                        StudentBag.setBlueNum(StudentBag.getBlueNum() - 1);
                        if (StudentBag.getBlueNum() == 0) entrancePawn.remove(random);
                    }
                    players.add(player);
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
        if (StudentBag.getGreenNum() != 0)
            arrayPawn.add("GREEN");
        if (StudentBag.getRedNum() != 0)
            arrayPawn.add("RED");
        if (StudentBag.getYellowNum() != 0)
            arrayPawn.add("YELLOW");
        if (StudentBag.getPinkNum() != 0)
            arrayPawn.add("PINK");
        if (StudentBag.getBlueNum() != 0)
            arrayPawn.add("BLUE");
        return arrayPawn;
    }

  /*  public static void newPlayer(String nick) {
        int i;
        for(i=0; i<totPlayer; i++) {
            Player player = new Player(nick);//inizializzazione player fatta in player -NINO
            players.add(player);
        }
    }*/
    public void moveMotherNature(int num){
        int i;
        int totIsland = islands.size();
        for(i=0; !islands.get(i).getMotherNature(); i++);
        islands.get(i).setMotherNature(false);
        num += i;
        if(num >= totIsland) num -= totIsland;
        islands.get(num).setMotherNature(true);
    }

    public static void unifyIsland(int i){ // si fa sempre dopo aver messo una torre, mettiamo in ingresso l'isola con madre natura
       int j;
       if(islands.get(i).getTower()){
           j=i-1;
           if(j<0) j = islands.size();
           checkIsland(i, j);
           j=i+1;
           if(j>= islands.size()) j=0;
           checkIsland(i, j);
       }
    }

    private static void checkIsland(int i, int j) { //controlla se le due isole si possono unire, nel caso le unisce
        if(islands.get(j).getTower() && islands.get(j).getColorTower() == islands.get(i).getColorTower()){
            islands.get(i).setGreenPawn(islands.get(i).getGreenPawn() + islands.get(j).getGreenPawn());
            islands.get(i).setRedPawn(islands.get(i).getRedPawn() + islands.get(j).getRedPawn());
            islands.get(i).setYellowPawn(islands.get(i).getYellowPawn() + islands.get(j).getYellowPawn());
            islands.get(i).setBluePawn(islands.get(i).getBluePawn() + islands.get(j).getBluePawn());
            islands.get(i).setTotIsland(islands.get(i).getTotIsland() + 1);
            islands.remove(j);
        }
    }



    public static void topInfluence(Island island){
       int i, j, k, n, color, max;
       boolean notunique = false;
       ArrayList<Integer> influence = new ArrayList<>();
       for(i=0; i<totPlayer; i++) influence.add(0);
       for(color=0; color<5; color++) {
           n = profTable.checkProf(color);
           if(color==0 && n!=-1) influence.set(n, influence.get(n) + island.getGreenPawn());

           else if(color==1 && n!=-1) influence.set(n, influence.get(n) + island.getRedPawn());

           else if(color==2 && n!=-1)influence.set(n, influence.get(n) + island.getYellowPawn());

           else if(color==3 && n!=-1)influence.set(n, influence.get(n) + island.getPinkPawn());

           else if(color==4 && n!=-1)influence.set(n, influence.get(n) + island.getBluePawn());
       }
       if(totPlayer==4){
           for(i=1; players.get(i).towerSpace.colorTower == players.get(0).towerSpace.colorTower; i++);
           influence.set(0, influence.get(0) + influence.get(i));//ho tutte le pedine di una squadra sommate al player 0
           for(j=1; j<totPlayer && j==i; j++);
           for(k=2; k<totPlayer && (k==i || k==j); k++);
           influence.set(j, influence.get(j) + influence.get(k));//sommo tutte le pedine dell'altra squadra all'indirizzo j
           influence.set(i, 0);
           influence.set(k, 0);
       }

       for(i=0; i<totPlayer; i++){
           if(island.getTower() && island.getColorTower() == players.get(i).towerSpace.colorTower)
               influence.set(i, influence.get(i) + island.getTotIsland());
       }

       max = Collections.max(influence);

       for(i=0; i<influence.size() && !notunique;i++){
           for(j=i+1; j<influence.size() && !notunique; j++){
               if((influence.get(i).equals(influence.get(j))) && influence.get(i).equals(max) && players.get(i).towerSpace.colorTower != players.get(j).towerSpace.colorTower) notunique = true;
           }
       }
       if(!notunique) island.setColorTower(players.get(influence.indexOf(max)).towerSpace.colorTower);
       unifyIsland(islands.indexOf(island));
    }

    public boolean endGame(){
        return StudentBag.getNum() == 0;
    }

    public void setCard() { //posiziona a caso dei personaggi (3)
        int i;
        Random rnd = new Random();
        int random = rnd.nextInt(characterCards.size());
        for (i = 0; i < 3; i++) {
            cards.add(characterCards.get(random));
            characterCards.remove(random);
            random = rnd.nextInt(characterCards.size());
        }
    }

    public void moveProf(){
        int i, j;
        ArrayList<Integer> maxColor = new ArrayList<>();
        for(i=0; i<5; i++){
            if(i==0) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumGreen());
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.setGreenProf(indexMax);
                maxColor.clear();
            }
            else if (i==1) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumRed());
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.setRedProf(indexMax);
                maxColor.clear();
            }
            else if (i==2) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumYellow());
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.setYellowProf(indexMax);
                maxColor.clear();
            }
            else if (i==3) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumPink());
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.setPinkProf(indexMax);
                maxColor.clear();
            }
            else if (i==4) {
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