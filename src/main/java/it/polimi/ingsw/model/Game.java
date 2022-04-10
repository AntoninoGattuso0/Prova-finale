package it.polimi.ingsw.model;


import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Player> players = new ArrayList<>(4);
    protected int totPlayer = 0;
    private Cloud[] cloud = new Cloud[4];
    private ArrayList<Island> islands = new ArrayList<>(12);
    protected boolean isExpert;
    private CharacterCard[] card = new CharacterCard[3];

    private void start(){
        int i;

        StudentBag.num=120;
        StudentBag.greenNum=StudentBag.redNum=StudentBag.yellowNum=StudentBag.pinkNum=StudentBag.blueNum=24;

        for(i=0, i<11, i++){
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

        for(i=0; i<totPlayer-1; i++){
            Player player = new Player();
            newPlayer(player);
            players.add(player);
        }

        Random rnd = new Random();
        int n = rnd.nextInt(12);
        islands.get(n).isMotherNature = true;
        int g, r, y, p, b = 2; //conteggio 2 pedine per colore
        for(i=n+1; islands.get(i).isMotherNature = false; i++){
            if(i==12) i=0;
            if((i==n+6) || (i==n-6)) i++;
            int color = rnd.nextInt(5);
            if((color == 0 && g!=0)){
                g--;
                islands.get(i).greenPawn += 1;
            }
            else if(color == 1){
                r--;
                islands.get(i).redPawn += 1;
            }
            else if(color == 2){
                r--;
                islands.get(i).yellowPawn += 1;
            }
            else if(color == 3){
                p--;
                islands.get(i).pinkPawn += 1;
            }
            else{
                b--;
                islands.get(i).bluePawn += 1;
            }
        };

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

