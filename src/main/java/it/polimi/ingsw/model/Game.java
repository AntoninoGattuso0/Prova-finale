package it.polimi.ingsw.model;

import it.polimi.ingsw.client.ModelLight.*;

import java.util.*;
public class Game {
    protected ArrayList<Player> players = new ArrayList<>();
    protected int totPlayer;
    protected ArrayList<Cloud> clouds;
    protected ProfTable profTable;// = new ProfTable()
    protected ArrayList<Island> islands = new ArrayList<>();
    protected boolean isExpert;
    protected ArrayList<CharacterCard> characterCards = new ArrayList<>();//insieme dei 3 characters usati
    protected Map<Integer, String> m = new HashMap<>();
    protected StudentBag studentBag;

    private Antonio antonio;
    private Barbara barbara;
    private Ciro ciro;
    private Dante dante;
    private Ernesto ernesto;
    private Felix felix;
    private Giuseppe giuseppe;
    private Ivan ivan;
    private Lancillotto lancillotto;
    private Maria maria;
    private Nicola nicola;
    private Omnia omnia;

    public ArrayList<CharacterCard> getCharacterCards() {
        return characterCards;
    }

    public StudentBag getStudentBag() {
        return studentBag;
    }

    public ProfTable getProfTable() {
        return profTable;
    }

    public LightGame getLightGame(){
        int i;
        ArrayList<LightCloud> lightClouds=new ArrayList<>();
        for(i=0;i<clouds.size();i++) {
            LightCloud cloud = new LightCloud(clouds.get(i).getRedPawn(),clouds.get(i).getBluePawn(),clouds.get(i).getNumPawn(),clouds.get(i).getPinkPawn(),clouds.get(i).getYellowPawn(),clouds.get(i).getGreenPawn());
            lightClouds.add(cloud);
        }
        ArrayList<LightPlayer> lightPlayers= new ArrayList<>();
        for(i=0;i<players.size();i++){
            LightDiningRoom lightDiningRoom=new LightDiningRoom(players.get(i).getDiningRoom().getNumBlue(),players.get(i).getDiningRoom().getNumGreen(),players.get(i).getDiningRoom().getNumPink(),players.get(i).getDiningRoom().getNumRed(),players.get(i).getDiningRoom().getNumYellow());
            LightTowerSpace lightTowerSpace=new LightTowerSpace(players.get(i).getTowerSpace().getColorTower(),players.get(i).getTowerSpace().getNumTower());
            LightEntrance lightEntrance=new LightEntrance(players.get(i).getEntrance().getNumPawn(),players.get(i).getEntrance().getGreenPawn(),players.get(i).getEntrance().getRedPawn(),players.get(i).getEntrance().getYellowPawn(),players.get(i).getEntrance().getPinkPawn(),players.get(i).getEntrance().getBluePawn());
            LightPlayer lightPlayer=new LightPlayer(players.get(i).getNickname(),players.get(i).getNumCoin(),players.get(i).getDeckAssistant(),players.get(i).getCurrentAssistant(),lightEntrance,lightTowerSpace,lightDiningRoom,players.get(i).getCurrentPhase() );
            lightPlayers.add(lightPlayer);
        }
        return new LightGame(characterCards,isExpert, lightClouds, lightPlayers, islands, totPlayer, getProfTable(), this.antonio, this.barbara, this.ciro, this.dante, this.ernesto, this.felix, this.giuseppe, this.ivan, this.lancillotto, this.maria, this.nicola, this.omnia);
    }

    public int getTotPlayer() {
        return totPlayer;
    }

    public ArrayList<Island> getIslands(){
        return this.islands;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public boolean getIsExpert(){
        return this.isExpert;
    }
    public ArrayList<Cloud> getClouds(){
        return this.clouds;
    }

    public Antonio getAntonio() {
        return antonio;
    }

    public Barbara getBarbara() {
        return barbara;
    }

    public Ciro getCiro() {
        return ciro;
    }

    public Dante getDante() {
        return dante;
    }

    public Ernesto getErnesto() {
        return ernesto;
    }

    public Felix getFelix() {
        return felix;
    }

    public Giuseppe getGiuseppe() {
        return giuseppe;
    }

    public Ivan getIvan() {
        return ivan;
    }

    public Lancillotto getLancillotto() {
        return lancillotto;
    }

    public Maria getMaria() {
        return maria;
    }

    public Nicola getNicola() {
        return nicola;
    }

    public Omnia getOmnia() {
        return omnia;
    }

    public Game(int giocatori, boolean expert) {
        totPlayer = giocatori;
        isExpert = expert;
        //mappa che associa numeri a colori ("m.get(int)" per ricevere il colore in base al numero inserito in int)
        m.put(0, "GREEN");
        m.put(1, "RED");
        m.put(2, "YELLOW");
        m.put(3, "PINK");
        m.put(4, "BLUE");
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
        i = n + 1;
        if (i == 12) i = 0;
        while (!(islands.get(i).getMotherNature())&&startingPawn.size()>0){
            if(i!=(n+6) && i!=(n-6)) {
                Random rnd1 = new Random();
                int random = rnd1.nextInt(startingPawn.size());
                if (startingPawn.get(random).equals(m.get(0))) {
                    g--;
                    islands.get(i).setGreenPawn(islands.get(i).getGreenPawn() + 1);
                    if (g == 0) startingPawn.remove(random);
                } else if (startingPawn.get(random).equals(m.get(1))) {
                    r--;
                    islands.get(i).setRedPawn(islands.get(i).getRedPawn() + 1);
                    if (r == 0) startingPawn.remove(random);
                } else if (startingPawn.get(random).equals(m.get(2))) {
                    y--;
                    islands.get(i).setYellowPawn(islands.get(i).getYellowPawn() + 1);
                    if (y == 0) startingPawn.remove(random);
                } else if (startingPawn.get(random).equals(m.get(3))) {
                    p--;
                    islands.get(i).setPinkPawn(islands.get(i).getPinkPawn() + 1);
                    if (p == 0) startingPawn.remove(random);
                } else if (startingPawn.get(random).equals(m.get(4))) {
                    b--;
                    islands.get(i).setBluePawn(islands.get(i).getBluePawn() + 1);
                    if (b == 0) startingPawn.remove(random);
                }
            }
            i++;
            if (i >= 12) i = 0;
        }
        // creazione nuvole e inizializzazione
        clouds = new ArrayList<>();
        for (i = 0; i < totPlayer; i++) {
            Cloud cloud = new Cloud();
            cloud.refillCloud(studentBag, game);
            clouds.add(cloud);
        }
        setCharacterCards(game);
        }
    static ArrayList<ColorPawn> createArrayPawn(StudentBag studentBag) {//crea un array per ogni colore (utilizzato per funzioni random)
        ArrayList<ColorPawn> arrayPawn = new ArrayList<>(5);
        if (studentBag.getGreenNum() > 0)
            arrayPawn.add(ColorPawn.GREEN);
        if (studentBag.getRedNum() > 0)
            arrayPawn.add(ColorPawn.RED);
        if (studentBag.getYellowNum() > 0)
            arrayPawn.add(ColorPawn.YELLOW);
        if (studentBag.getPinkNum() > 0)
            arrayPawn.add(ColorPawn.PINK);
        if (studentBag.getBlueNum() > 0)
            arrayPawn.add(ColorPawn.BLUE);
        return arrayPawn;
    }
    public void newPlayer(String nick,Game game) {
        Player player = new Player(nick,game);
        game.players.add(player);
    }
    public void moveMotherNature(Island island) {
        int i;
        for (i = 0; !islands.get(i).getMotherNature(); i++) ;
        islands.get(i).setMotherNature(false);
        island.setMotherNature(true);
    }
    public void unifyIsland(int i, Game game) { // si fa sempre dopo aver messo una torre, mettiamo in ingresso l'isola con madre natura
        int j, k;
        boolean prevTrue, postTrue;
        if (game.islands.get(i).getTower()) {
            j = i - 1;
            k = i + 1;
            if (j == -1) j = game.islands.size() - 1;
            if (k == game.islands.size()) k = 0;
            prevTrue = checkIsland(i, j, game);
            postTrue = checkIsland(i, k, game);
            if (prevTrue) {
                game.getIslands().remove(j);
                if(j==game.getIslands().size()) j=0;
                game.getIslands().get(j).setMotherNature(true);
            }
            if (postTrue&&prevTrue) {
                if(i!=0) {
                    k = k - 1;
                }
                if(k==-1){
                    k=0;
                }
                game.getIslands().remove(k);
            } else if(postTrue) {
                    game.getIslands().remove(k);
            }
        }
        }
    public static boolean checkIsland(int i, int j, Game game) { //controlla se le due isole si possono unire, nel caso le unisce
        if (game.islands.get(j).getColorTower() == game.islands.get(i).getColorTower()) {
            game.islands.get(i).setGreenPawn(game.islands.get(i).getGreenPawn() + game.islands.get(j).getGreenPawn());
            game.islands.get(i).setRedPawn(game.islands.get(i).getRedPawn() + game.islands.get(j).getRedPawn());
            game.islands.get(i).setYellowPawn(game.islands.get(i).getYellowPawn() + game.islands.get(j).getYellowPawn());
            game.islands.get(i).setBluePawn(game.islands.get(i).getBluePawn() + game.islands.get(j).getBluePawn());
            game.islands.get(i).setTotIsland(game.islands.get(i).getTotIsland() + game.islands.get(j).getTotIsland());
            return true;
        }
        return false;
    }
    public void topInfluence(Island island, Game game) {
        int i, j, k, n, color, max;
        if (island.getProhibited()) {
            island.setProhibited(false);
            game.ernesto.setNumProhibitionCard(game.ernesto.getNumProhibitionCard() + 1);
        } else {
                boolean notUnique = false;
                ArrayList<Integer> influence = new ArrayList<>();
                for (i = 0; i < game.totPlayer; i++) influence.add(0);
                if(ivan!=null&&ivan.isEffectActive()){
                    influence.set(ivan.getNumPlayer(),2);
                }
                for (color = 0; color < 5; color++) {
                    n = game.profTable.checkProf(color);
                    if (color == 0 && n != -1&&!(lancillotto!=null&&lancillotto.isEffectActive()&&lancillotto.getPedina()==color)) influence.set(n, influence.get(n) + island.getGreenPawn());

                    else if (color == 1 && n != -1 &&!(lancillotto!=null&&lancillotto.isEffectActive()&&lancillotto.getPedina()==color)) influence.set(n, influence.get(n) + island.getRedPawn());

                    else if (color == 2 && n != -1&&!(lancillotto!=null&&lancillotto.isEffectActive()&&lancillotto.getPedina()==color)) influence.set(n, influence.get(n) + island.getYellowPawn());

                    else if (color == 3 && n != -1&&!(lancillotto!=null&&lancillotto.isEffectActive()&&lancillotto.getPedina()==color)) influence.set(n, influence.get(n) + island.getPinkPawn());

                    else if (color == 4 && n != -1&&!(lancillotto!=null&&lancillotto.isEffectActive()&&lancillotto.getPedina()==color)) influence.set(n, influence.get(n) + island.getBluePawn());
                }
                if (game.totPlayer == 4) {
                    for (i = 1; game.players.get(i).towerSpace.colorTower != game.players.get(0).towerSpace.colorTower; i++)
                        ;
                    influence.set(0, influence.get(0) + influence.get(i));//ho tutte le pedine di una squadra sommate al player 0
                    for (j = 1; j < game.totPlayer && j == i; j++) ;
                    for (k = 2; k < game.totPlayer && (k == i || k == j); k++) ;
                    influence.set(j, influence.get(j) + influence.get(k));//sommo tutte le pedine dell'altra squadra all'indirizzo j
                    influence.set(i, 0);
                    influence.set(k, 0);
                }
                if(felix.getEffectActive()&&felix!=null) {
                    for (i = 0; i < game.totPlayer; i++) {
                        if (island.getTower() && island.getColorTower() == game.players.get(i).towerSpace.colorTower)
                            influence.set(i, influence.get(i) + island.getTotIsland());
                    }
                }
                max = Collections.max(influence);
                for (i = 0; i < influence.size() && !notUnique; i++) {
                    for (j = i + 1; j < influence.size() && !notUnique; j++) {
                        if ((influence.get(i).equals(influence.get(j))) && influence.get(i).equals(max) && game.players.get(i).towerSpace.colorTower != game.players.get(j).towerSpace.colorTower)
                            notUnique = true;
                    }
                }
                if (!notUnique) {
                    if (!island.getTower()) {
                        island.setTower(true);
                        island.setColorTower(game.getPlayers().get(influence.indexOf(max)).getTowerSpace().getColorTower());
                        game.getPlayers().get(influence.indexOf(max)).getTowerSpace().setNumTower((game.getPlayers().get(influence.indexOf(max)).getTowerSpace().getNumTower()) - island.getTotIsland());
                    } else {
                        for (i = 0; island.getColorTower() != game.getPlayers().get(i).getTowerSpace().getColorTower(); i++) ;
                        game.getPlayers().get(i).getTowerSpace().setNumTower(players.get(i).getTowerSpace().getNumTower() + island.getTotIsland());
                        island.setColorTower(game.getPlayers().get(influence.indexOf(max)).getTowerSpace().getColorTower());
                        game.getPlayers().get(influence.indexOf(max)).getTowerSpace().setNumTower((game.getPlayers().get(influence.indexOf(max)).getTowerSpace().getNumTower()) - island.getTotIsland());
                    }
                }
                if(ivan!=null&&ivan.isEffectActive()){
                    ivan.setEffectActive(false);
                }
                if(felix.getEffectActive()&&felix!=null){
                    felix.setEffectActive(false);
                }
                if(lancillotto!=null&&lancillotto.isEffectActive()){
                    lancillotto.setEffectActive(false);
                }
                unifyIsland(game.islands.indexOf(island), game);
            }
    }
        public void setCharacterCards (Game game){ //posiziona a caso dei personaggi (3)
            if (game.isExpert) {

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
                    antonio = new Antonio(game.studentBag);
                    CharacterCard card = new CharacterCard(antonio, 0);
                    game.characterCards.add(card);
                }
                if (random == 1 || random1 == 1 || random2 == 1) {
                    barbara = new Barbara();
                    CharacterCard card = new CharacterCard(barbara, 1);
                    game.characterCards.add(card);
                }
                if (random == 2 || random1 == 2 || random2 == 2) {
                    ciro = new Ciro();
                    CharacterCard card = new CharacterCard(ciro, 2);
                    game.characterCards.add(card);
                }
                if (random == 3 || random1 == 3 || random2 == 3) {
                    dante = new Dante();
                    CharacterCard card = new CharacterCard(dante, 3);
                    game.characterCards.add(card);
                }
                if (random == 4 || random1 == 4 || random2 == 4) {
                    ernesto = new Ernesto();
                    CharacterCard card = new CharacterCard(ernesto, 4);
                    game.characterCards.add(card);
                }
                if (random == 5 || random1 == 5 || random2 == 5) {
                    felix = new Felix();
                    CharacterCard card = new CharacterCard(felix, 5);
                    game.characterCards.add(card);
                }
                if (random == 6 || random1 == 6 || random2 == 6) {
                    giuseppe = new Giuseppe(game.studentBag, game);
                    CharacterCard card = new CharacterCard(giuseppe, 6);
                    game.characterCards.add(card);
                }
                if (random == 7 || random1 == 7 || random2 == 7) {
                    ivan = new Ivan();
                    CharacterCard card = new CharacterCard(ivan, 7);
                    game.characterCards.add(card);
                }
                if (random == 8 || random1 == 8 || random2 == 8) {
                    lancillotto = new Lancillotto();
                    CharacterCard card = new CharacterCard(lancillotto, 8);
                    game.characterCards.add(card);
                }
                if (random == 9 || random1 == 9 || random2 == 9) {
                    maria = new Maria();
                    CharacterCard card = new CharacterCard(maria, 9);
                    game.characterCards.add(card);
                }
                if (random == 10 || random1 == 10 || random2 == 10) {
                    nicola = new Nicola(game.studentBag, game);
                    CharacterCard card = new CharacterCard(nicola, 10);
                    game.characterCards.add(card);
                }
                if (random == 11 || random1 == 11 || random2 == 11) {
                    omnia = new Omnia();
                    CharacterCard card = new CharacterCard(omnia, 11);
                    game.characterCards.add(card);
                }
            }
        }
        public void moveProf() {
            int i, j;
            ArrayList<Integer> maxColor = new ArrayList<>();
            for (i = 0; i < 5; i++) {
                if (i == 0) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumGreen());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max))
                        getProfTable().setGreenProf(indexMax);
                    maxColor.clear();
                } else if (i == 1) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumRed());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)){
                        getProfTable().setRedProf(indexMax);
                }
                    maxColor.clear();
                } else if (i == 2) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumYellow());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)){
                        getProfTable().setYellowProf(indexMax);
                    }
                    maxColor.clear();
                } else if (i == 3) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumPink());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)){
                        getProfTable().setPinkProf(indexMax);
                    }
                    maxColor.clear();
                } else if (i == 4) {
                    for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.getNumBlue());
                    int max = Collections.max(maxColor);
                    int indexMax = maxColor.indexOf(max);
                    maxColor.remove(indexMax);
                    if (!maxColor.contains(max)) {
                        getProfTable().setBlueProf(indexMax);
                    }
                    maxColor.clear();
                }
            }
        }

    public Player finish(Boolean lastTurn) {
        ArrayList<Integer> numTower = new ArrayList<>();
        numTower.add(0);
        numTower.add(0);
        numTower.add(0);
        ArrayList<Integer> numProf = new ArrayList<>();
        for(int i = 0; i<players.size(); i++) numProf.add(0);
        for(int i = 0; i<5; i++){//scorro tutti i colori
            if(profTable.checkProf(i)!=-1) {
                numProf.set(profTable.checkProf(i), numProf.get(profTable.checkProf(i)) + 1);//per ogni colore vedo quale player ha il suo professore e aggiungo +1 all'arraylist
            }
        }
        for (Island island : islands) {
            if (island.getColorTower() == ColorTower.WHITE)
                numTower.set(0, numTower.get(0) + island.getTotIsland());
            else if (island.getColorTower() == ColorTower.BLACK)
                numTower.set(1, numTower.get(1) + island.getTotIsland());
            else if (island.getColorTower() == ColorTower.GREY)
                numTower.set(2, numTower.get(2) + island.getTotIsland());
        }
        int max = numTower.indexOf(Collections.max(numTower));

        int max1 = -1;

        for(int i = 0; i<numTower.size() && i<players.size(); i++){
            if((numTower.get(i) == numTower.indexOf(Collections.max(numTower)) && (i!= max)))
                max1 = i;
        }

        if((max1 != -1) && (numProf.get(max) < numProf.get(max1))){
            max = max1;
        }

        if(totPlayer!=4) {
            for (int i = 0; i < totPlayer; i++) {
                if (players.get(i).towerSpace.getNumTower() <= 0) { //caso 1, torri finite per 2 o 3 giocatori
                    System.out.println("1 " + players.get(max).getNickname());
                    return players.get(max);
                }
            }
        }else{
            for(int i=0;i<totPlayer/2;i++){
                if (players.get(i).towerSpace.getNumTower() == 0) { //caso 1, torri finite per 4 giocatori
                    System.out.println("1 " + players.get(max).getNickname());
                    return players.get(max);
                }
            }
        }
        if(islands.size() <= 3){//caso 2, 3 gruppi di isole
            System.out.println("2"+ players.get(max).getNickname());
            return players.get(max);
        }

        if(studentBag.getNum()==0) {//caso 3, fine studenti nel sacchetto
            System.out.println("3"+ players.get(max).getNickname());
            return players.get(max);
        }

        if((players.get(0).getDeckAssistant().size() == 0) && lastTurn)//caso 4, finiti gli assistenti & ultimo turno
            return players.get(max);
        return null;
    }
}