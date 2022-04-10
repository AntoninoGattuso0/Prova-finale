package it.polimi.ingsw.model;


import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Player> players = new ArrayList<>(4);
    protected int totPlayer = 0;
    private Cloud[] cloud;
    private ArrayList<Island> islands = new ArrayList<>(12);
    protected boolean isExpert;
    private CharacterCard[] card = new CharacterCard[3];

    private void start() {
        int i;

        StudentBag.num = 120;
        StudentBag.greenNum = StudentBag.redNum = StudentBag.yellowNum = StudentBag.pinkNum = StudentBag.blueNum = 24;

        for (i = 0, i < 11, i++) {
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
        int g, r, y, p, b = 2; //conteggio 2 pedine per colore
        for (i = n + 1; !islands.get(i).isMotherNature; i += 1) {
            if (i == 12) i = 0;
            if ((i == n + 6) || (i == n - 6)) i += 1;
            int color = rnd.nextInt(5);
            boolean check = false;
            while (!check) {
                if (color == 0 && g != 0) {
                    g -= 1;
                    islands.get(i).greenPawn += 1;
                    check=true;
                } else if (color == 1 && r != 0) {
                    r -= 1;
                    islands.get(i).redPawn += 1;
                    check=true;
                } else if (color == 2 && y != 0) {
                    y -= 1;
                    islands.get(i).yellowPawn += 1;
                    check=true;
                } else if (color == 3 && p != 0) {
                    p -= 1;
                    islands.get(i).pinkPawn += 1;
                    check=true;
                } else if (color == 4 && b != 0) {
                    b -= 1;
                    islands.get(i).bluePawn += 1;
                    check=true;
                }
                else {
                    color += 1;
                    if (color == 5) color = 0;
                }
            }
        }

        // creazione nuvole
        cloud = new Cloud[4]
        for(i=0; i<totPlayer; i++){
            Cloud nuvola = new Cloud();
            cloud[i] = nuvola;
        }
    }

    public void newPlayer(){
        Player player = new Player();
        Console console = System.console();
        String str = console.readLine(" Inserisci il nome del Giocatore : ");
        player.chooseNick(str);
        player.numCoin = 0;
        players.add(player);
        totPlayer += 1; //non saprei, tot player si deve sapere a prescindere no?
    };


    public void moveMotherNature(int num);

    public void unifyIsland();

    public void topInfluence(int toIsland);

    public void endGame();

    public void setCard(CharacterCard card){
        int i;
        Random count = new Random();
        int num = count.nextInt(11);
        for(i=0, i<4, i++){
        card[i] = num;
    };

    public int moveProf();
}

