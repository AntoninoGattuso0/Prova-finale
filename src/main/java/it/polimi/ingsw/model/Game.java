package it.polimi.ingsw.model;


import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Player> players = new ArrayList<>(4);
    private int totPlayer;
    private Cloud[] cloud = new Cloud[4];
    private ArrayList<Island> islands = new ArrayList<>(12);
    private boolean isExpert;
    private CharacterCard[] card = new CharacterCard[3];

    private void start(){
        int i;
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

        for(i=0, i<totPlayer-1, i++){
            Player player = new Player();
            newPlayer(player);
            players.add(player);
        }

        Random rnd = new Random();
        int n = rnd.nextInt(12);
        islands.get(n).isMotherNature = true;
        for(i=n+1, , i++){
            if(i==12) i=0;
            if((i==n+6) || (i==n+6)) i++;
        }
    };

    public void newPlayer(Player player){
        Console console = System.console();
        String str = console.readLine(" Inserisci il nome del Giocatore : ");
        player.chooseNick(str);
        player.numCoin = 0;
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

