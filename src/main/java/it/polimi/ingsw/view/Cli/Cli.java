package it.polimi.ingsw.view.Cli;


import it.polimi.ingsw.model.Cloud;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Island;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.ClientAcceptedMessage;
import it.polimi.ingsw.network.Message.StartTurnMessage;
import it.polimi.ingsw.observer.NetworkHandlerObservable;
import it.polimi.ingsw.view.View;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cli extends NetworkHandlerObservable implements Runnable, View {
    Scanner scanner = new Scanner(System.in); //Per leggere input da tastiera
    private final PrintStream out;
    private Thread inputThread;

    public Cli() {
        out = System.out;
    }

    public String readLine() throws ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new InputReadTask());
        inputThread = new Thread(futureTask);
        inputThread.start();

        String input = null;

        try {
            input = futureTask.get();
        } catch (InterruptedException e) {
            futureTask.cancel(true);
            Thread.currentThread().interrupt();
        }
        return input;
    }

    //start the cli
    public void init() {
        out.println("Benvenuto in Eryantis!");

        try {
            askServerInfo();
        } catch (ExecutionException e) {
            out.println("User input canceled.");
        }
    }

    public void askServerInfo() throws ExecutionException {
        Map<String, String> serverInfo = new HashMap<>();
        String defaultAddress = "localhost";
        String defaultPort = "16847";
        boolean validInput;

        out.println("Seleziona una delle opzioni, il valore di default è tra le parentesi");

        do {
            out.print("Inserisci il server address [" + defaultAddress + "]: ");

            String address = readLine();

            if (address.equals("")) {
                serverInfo.put("address", defaultAddress);
                validInput = true;
            } /*else if (ClientcController.isValidIpAddress(address)){
                serverInfo.put("address", address);
                validInput= true;
            }*/ else {
                out.println("Invalid Address!!!");
                clearCli();
                validInput = false;
            }
        } while (!validInput);
    }


    public int checkInteger() {
        boolean isInteger = false;
        int integer = -1;
        while (!isInteger) {
            try {
                integer = scanner.nextInt();
                isInteger = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("ERROR: insert an integer number");
            } finally {
                scanner.close();
            }
        }
        return integer;
    }

    @Override
    public void startGame() {

    }

    @Override
    public void loginPlayers() {

    }

    /* This method asks the first player the number of player
        and if the game mode is expert or not
    */
    @Override
    public void askNumPlayerIsExpert() {
        System.out.println("You are the first player logged. \n");
        System.out.println("Please insert the number of Players. It must be a number between 2 and 4. \n");
        int numPlayers = checkInteger();

        while (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Please insert the number of Players again. It must be a number between 2 and 4. \n");
            numPlayers = checkInteger();
        }

        System.out.println("Choose the game mode: type 0 for normal mode or type 1 for expert mode \n");
        int isExpert = checkInteger();


        while (isExpert != 0 || isExpert != 1) { //non ho capito cosa controlla questo -Paul
            System.out.println("ERROR: type 0 for normal mode or type 1 for expert mode \n");
            isExpert = checkInteger();
        }//il controllo così non va bene, va fatto all'interno dello scambio dei messaggi e non nella CLI -NINO

    }

    @Override
    public void displayAssistantCard(Player player) {
        int i;
        for (i = 0; i < player.getDeckAssistant().size(); i++) {
            out.println(i + "Valore: " + player.getDeckAssistant().get(i).getCardValue());
            out.println(" " + "Passi: " + player.getDeckAssistant().get(i).getStep());
            out.println("-----------------------");
        }
    }

    @Override
    public void displayIslands(Game game) {
        clearCli();

        int i;
        StringBuilder tabIslands = new StringBuilder();
        out.println(print1_4Index(game.getIslands()));
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 0; i < game.getIslands().size() && i < 4; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 0; i < game.getIslands().size() && i < 4; i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(game.getIslands(), i, j));
            tabIslands.append("|\n").append(ColorCli.RESET);
        }
        for (i = 0; i < game.getIslands().size() && i < 4; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());

        out.println(print4_8Index(game.getIslands()));
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 4; i < game.getIslands().size() && i < 8; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 4; i < game.getIslands().size() && i < 8; i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(game.getIslands(), i, j));
            tabIslands.append("|").append(ColorCli.RESET).append("\n");
        }
        for (i = 4; i < game.getIslands().size() && i < 8; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());

        out.println(print8_12Index(game.getIslands()));
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 8; i < game.getIslands().size(); i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 8; i < game.getIslands().size(); i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(game.getIslands(), i, j));
            tabIslands.append("|\n").append(ColorCli.RESET);
        }
        for (i = 8; i < game.getIslands().size(); i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());
    }

    private String color4Island(ArrayList<Island> islands, int island, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("●: ").append(islands.get(island).getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("●: ").append(islands.get(island).getRedPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("●: ").append(islands.get(island).getYellowPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("●: ").append(islands.get(island).getPinkPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("●: ").append(islands.get(island).getBluePawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        return showColor.toString();
    }

    @Override
    public void displayCloud(Game game) {
        clearCli();

        int i;
        StringBuilder cloudCards = new StringBuilder();
        out.println(" ");
        out.println(" ");
        cloudCards.append(ColorCli.BOLDCYAN);
        for (i = 0; i < game.getClouds().size() && i < 4; i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("     ").append(" +*******+").append("        ");

        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < game.getIslands().size() && i < game.getTotPlayer() ; i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("   *            *      ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < game.getIslands().size() && i < game.getTotPlayer(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append(" *                *    ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");

        for (int j = 0; j < 5; j++) {
            for (i = 0; i < game.getClouds().size() && i < 4; i++)
                    cloudCards.append(ColorCli.BOLDCYAN).append("*").append(ColorCli.RESET).append(color4Clouds(game.getClouds(), i, j)).append(" *   ");
            cloudCards.append("\n").append(ColorCli.RESET);
        }

        for (i = 0; i < game.getIslands().size() && i < game.getTotPlayer(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append(" *                *    ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < game.getIslands().size() && i < game.getTotPlayer() ; i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("   *            *      ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");

        for (i = 0; i < game.getClouds().size() && i < 4; i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("     ").append(" +*******+").append("        ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n").append(ColorCli.RESET);


        out.print(cloudCards);
        cloudCards.delete(0, cloudCards.capacity());

    }

    private String color4Clouds(ArrayList<Cloud> clouds, int cloud, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("     ●: ").append(clouds.get(cloud).getGreenPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("     ●: ").append(clouds.get(cloud).getRedPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("     ●: ").append(clouds.get(cloud).getYellowPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("     ●: ").append(clouds.get(cloud).getPinkPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("     ●: ").append(clouds.get(cloud).getBluePawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        return showColor.toString();
    }

    @Override
    public String displayEntrance(Game game, Player player) {
        clearCli();

        StringBuilder entranceSpace = new StringBuilder();
        out.println(" ");
        out.println(" ");
        entranceSpace.append(ColorCli.BOLDCYAN);
        int j;
        entranceSpace.append(ColorCli.BOLDCYAN);
        //for (i = 0; i < game.getPlayers().size() && i < 4; i++){
        entranceSpace.append(ColorCli.BOLDCYAN).append("Player: " + player.getNickname()).append("\n").append("+--------------+ \n");
        for (j = 0; j < 5; j++) {
            entranceSpace.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(player, j));
            entranceSpace.append("|\n").append(ColorCli.RESET);
        }
        entranceSpace.append(ColorCli.BOLDCYAN).append("+--------------+");
        // }
        out.print(entranceSpace);
        entranceSpace.delete(0, entranceSpace.capacity());
        return entranceSpace.toString();
    }

    private String color4Entrance(Player player, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("●: ").append(player.getEntrance().getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("●: ").append(player.getEntrance().getRedPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("●: ").append(player.getEntrance().getYellowPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("●: ").append(player.getEntrance().getPinkPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("●: ").append(player.getEntrance().getBluePawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        return showColor.toString();
    }

    @Override
    public String displayDiningRoom(Game game, Player player) {
        clearCli();

        StringBuilder diningSpace = new StringBuilder();
        out.println(" ");
        out.println(" ");
        diningSpace.append(ColorCli.BOLDCYAN);
        int j, m;
        diningSpace.append(ColorCli.BOLDCYAN);
       // for (i = 0; i < game.getPlayers().size() && i < 4; i++){
            diningSpace.append(ColorCli.BOLDCYAN).append("+------------------------------+ \n");
            for (j = 0; j < 5; j++)

                 diningSpace.append(ColorCli.BOLDCYAN);
                for (m = 0; m < player.getDiningRoom().getNumGreen(); m++)
                    if(m==2||m==5||m==8) diningSpace.append(ColorCli.GREEN).append("  ◎");
                    else diningSpace.append(color4DiningRoom(0)).append(ColorCli.BOLDCYAN);
                diningSpace.append("\n");
                diningSpace.append(ColorCli.BOLDCYAN);
                for (m = 0; m < player.getDiningRoom().getNumRed(); m++)
                    if(m==2||m==5||m==8) diningSpace.append(ColorCli.RED).append("  ◎");
                    else diningSpace.append(color4DiningRoom(1)).append(ColorCli.BOLDCYAN);
                diningSpace.append("\n");
                diningSpace.append(ColorCli.BOLDCYAN);
                for (m = 0; m < player.getDiningRoom().getNumYellow(); m++)
                    if(m==2||m==5||m==8) diningSpace.append(ColorCli.YELLOW).append("  ◎");
                    else diningSpace.append(color4DiningRoom(2)).append(ColorCli.BOLDCYAN);
                diningSpace.append("\n");
                diningSpace.append(ColorCli.BOLDCYAN);
                for (m = 0; m < player.getDiningRoom().getNumPink(); m++)
                    if(m==2||m==5||m==8) diningSpace.append(ColorCli.PINK).append("  ◎");
                    else diningSpace.append(color4DiningRoom(3)).append(ColorCli.BOLDCYAN);
                diningSpace.append("\n");
                diningSpace.append(ColorCli.BOLDCYAN);
                for (m = 0; m < player.getDiningRoom().getNumBlue(); m++)
                    if(m==2||m==5||m==8) diningSpace.append(ColorCli.BLUE).append("  ◎");
                    else diningSpace.append(color4DiningRoom(4)).append(ColorCli.BOLDCYAN);
                diningSpace.append("\n");

                diningSpace.append(ColorCli.RESET);

            diningSpace.append(ColorCli.BOLDCYAN).append("+------------------------------+ ");
       // }
        out.print(diningSpace);
        diningSpace.delete(0, diningSpace.capacity());
        return diningSpace.toString();
    }


    private String color4DiningRoom(int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0)
            showColor.append(ColorCli.GREEN).append("  ●");
        else if(color == 1)
            showColor.append(ColorCli.RED).append("  ●");
        else if(color == 2)
            showColor.append(ColorCli.YELLOW).append("  ●");
        else if(color == 3)
            showColor.append(ColorCli.PINK).append("  ●");
        else if(color == 4)
            showColor.append(ColorCli.BLUE).append("  ●");
        return showColor.toString();
    }

    @Override
    public void displayProfTable(Game game){
        StringBuilder profTable = new StringBuilder();
        for(int i = 0; i < game.getPlayers().size(); i++){
            profTable.append("+---+").append("\n");
            for (int j = 0; j < 5; j++){
                profTable.append(ColorCli.BOLDCYAN).append("| ").append(color4ProfTable(game, j, i)).append(ColorCli.BOLDCYAN).append(" |");
                profTable.append("\n");
            }
            profTable.append("+---+").append("\n");

        }
        out.print(profTable);
       profTable.delete(0, profTable.capacity());
    }


    private String color4ProfTable(Game game, int color, int profOfPlayer){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            if(game.getPlayers().get(game.getProfTable().getGreenProf()) == game.getPlayers().get(profOfPlayer))
                showColor.append(ColorCli.GREEN).append("●");
            else showColor.append(ColorCli.GREEN).append("✖︎︎");
        }
        else if(color == 1){
            if(game.getPlayers().get(game.getProfTable().getRedProf()) == game.getPlayers().get(profOfPlayer))
                showColor.append(ColorCli.RED).append("●");
            else showColor.append(ColorCli.RED).append("✖︎︎");
        }
        else if(color == 2){
            if(game.getPlayers().get(game.getProfTable().getYellowProf()) == game.getPlayers().get(profOfPlayer))
                showColor.append(ColorCli.YELLOW).append("●");
            else showColor.append(ColorCli.YELLOW).append("✖︎︎");
        }
        else if(color == 3){
            if(game.getPlayers().get(game.getProfTable().getPinkProf()) == game.getPlayers().get(profOfPlayer))
                showColor.append(ColorCli.PINK).append("●");
            else showColor.append(ColorCli.PINK).append("✖︎︎");
        }
        else if(color == 4){
            if(game.getPlayers().get(game.getProfTable().getBlueProf()) == game.getPlayers().get(profOfPlayer))
                showColor.append(ColorCli.BLUE).append("●");
            else showColor.append(ColorCli.BLUE).append("✖︎︎");
        }
        return showColor.toString();
    }

    @Override
    public String displayTowerSpace(Game game, int player) {
        clearCli();

        StringBuilder towerSpace = new StringBuilder();
        out.println(" ");
        out.println(" ");

        towerSpace.append(ColorCli.BOLDCYAN).append("+-------+ \n");
        towerSpace.append(color4TowerSpace(game, player));
        towerSpace.append(ColorCli.BOLDCYAN).append("+-------+ \n");
        towerSpace.append("\n");
        out.print(towerSpace);
        towerSpace.delete(0, towerSpace.capacity());
        return towerSpace.toString();
    }

    private String color4TowerSpace(Game game, int player){
        StringBuilder showColor = new StringBuilder();
        if(player == 0){
            if(game.getPlayers().get(player).getTowerSpace().getNumTower()%2==0) {
                for(int m = 0; m < game.getPlayers().get(player).getTowerSpace().getNumTower()/2; m++)
                showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|\n");
            }else if(game.getPlayers().get(player).getTowerSpace().getNumTower()%2==1) {
                for(int m = 0; m < game.getPlayers().get(player).getTowerSpace().getNumTower()/2; m++)
                    showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|\n");
                showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖      ").append(ColorCli.BOLDCYAN).append("|\n");
            }
        }
        else if(player == 1){
            if(game.getPlayers().get(player).getTowerSpace().getNumTower()%2==0) {
                for(int m = 0; m < game.getPlayers().get(player).getTowerSpace().getNumTower()/2; m++)
            showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.BLACK).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|\n");
            }else if(game.getPlayers().get(player).getTowerSpace().getNumTower()%2==1) {
                for(int m = 0; m < game.getPlayers().get(player).getTowerSpace().getNumTower()/2; m++)
                    showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.BLACK).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|\n");
                showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.BLACK).append("♖      ").append(ColorCli.BOLDCYAN).append("|\n");
            }
        }
        else if(player == 2){
                if(game.getPlayers().get(player).getTowerSpace().getNumTower()%2==0) {
                    for(int m = 0; m < game.getPlayers().get(player).getTowerSpace().getNumTower()/2; m++);
                    showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.GREY).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|\n");
                }else if(game.getPlayers().get(player).getTowerSpace().getNumTower()%2==1) {
                    for(int m = 0; m < game.getPlayers().get(player).getTowerSpace().getNumTower()/2; m++)
                        showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.GREY).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|\n");
                    showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.GREY).append("♖      ").append(ColorCli.BOLDCYAN).append("|\n");
                }
        }
        return showColor.toString();
    }


    public void displaySchoolBoard(Game game){
        clearCli();
        int i, m;
        StringBuilder schoolBoard = new StringBuilder();

        for(i = 0; i < game.getTotPlayer(); i++ ){
            out.println(" ");
            out.println(" ");
            schoolBoard.append(ColorCli.BOLDCYAN);

            schoolBoard.append("Player: " + game.getPlayers().get(i).getNickname()).append("\n").append("+------------------------------------------------------+\n");

            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(game.getPlayers().get(i),  0));
            schoolBoard.append("| ").append(ColorCli.RESET);
            schoolBoard.append(ColorCli.BOLDCYAN);
            for (m = 0; m < game.getPlayers().get(i).getDiningRoom().getNumGreen(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.GREEN).append("  ◎");
                else schoolBoard.append(color4DiningRoom(0)).append(ColorCli.BOLDCYAN);
            }
            if(game.getPlayers().get(i).getTowerSpace().getNumTower()>1) {
                schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|");
            }else if(game.getPlayers().get(i).getTowerSpace().getNumTower()==1) {
                schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖      ").append(ColorCli.BOLDCYAN).append("|");
            }
            schoolBoard.append("\n");
            int j;
            j = game.getPlayers().get(i).getTowerSpace().getNumTower() - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(game.getPlayers().get(i),  1));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < game.getPlayers().get(i).getDiningRoom().getNumRed(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.RED).append("  ◎");
                else schoolBoard.append(color4DiningRoom(1)).append(ColorCli.BOLDCYAN);
            }
            if(j >1) {
                schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|");
            }else if(j==1) {
                schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖      ").append(ColorCli.BOLDCYAN).append("|");
            }
            schoolBoard.append("\n");
            j = j - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(game.getPlayers().get(i),  2));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < game.getPlayers().get(i).getDiningRoom().getNumYellow(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.YELLOW).append("  ◎");
                else schoolBoard.append(color4DiningRoom(2)).append(ColorCli.BOLDCYAN);
            }
            if(j >1) {
                schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|");
            }else if(j==1) {
                schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖      ").append(ColorCli.BOLDCYAN).append("|");
            }
            schoolBoard.append("\n");
            j = j - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(game.getPlayers().get(i),  3));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < game.getPlayers().get(i).getDiningRoom().getNumPink(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.PINK).append("  ◎");
                else schoolBoard.append(color4DiningRoom(3)).append(ColorCli.BOLDCYAN);
            }
            if(j >1) {
                schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖    ♖ ").append(ColorCli.BOLDCYAN).append("|");
            }else if(j==1) {
                schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("♖      ").append(ColorCli.BOLDCYAN).append("|");
            }
            schoolBoard.append("\n");


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(game.getPlayers().get(i),  4));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < game.getPlayers().get(i).getDiningRoom().getNumBlue(); m++){
                    if(m==2||m==5||m==8) schoolBoard.append(ColorCli.BLUE).append("  ◎");
                    else schoolBoard.append(color4DiningRoom(4)).append(ColorCli.BOLDCYAN);
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("       ").append(ColorCli.BOLDCYAN).append("|");
            schoolBoard.append("\n");
            schoolBoard.append(ColorCli.BOLDCYAN).append("+------------------------------------------------------+ \n");
        }

        out.print(schoolBoard);
        schoolBoard.delete(0, schoolBoard.capacity());

    }

    @Override
    public void displayCharacterCard() {

    }

    @Override
    public void updateAssistantCard() {

    }

    @Override
    public void updateCloud() {

    }

    @Override
    public void updateDiningRoom() {

    }

    @Override
    public void updateEntrance() {

    }

    @Override
    public void updateIsland() {

    }

    @Override
    public void updateProfTable() {

    }

    @Override
    public void updateTowerSpace() {

    }

    @Override
    public void updateCharacterCard() {

    }

    @Override
    public void registerClient(ClientAcceptedMessage m) {

    }

    @Override
    public void displayNetError() {

    }

    @Override
    public void requestNickname() {

    }

    @Override
    public void requestNumPlayers() {

    }

    @Override
    public void waitOtherPlayers(String waitMessage) {

    }


    @Override
    public void displayNumPlayers(int numPlayers){
        System.out.println("The number of players is: " + numPlayers);
    }

    @Override
    public void displayIsExpert(int isExpert){
        if(isExpert == 1)
            System.out.println("The game mode will be expert.\n");
        if(isExpert == 0)
            System.out.println("The game mode will be normal.\n");
    }
    @Override
    public void displayNick(Game game){
        int i;
        for(i=0; i<game.getTotPlayer(); i++)
            System.out.println(game.getPlayers().get(i).getNickname() + " è il giocatore numero " + (i+1));
    }

    @Override
    public void waitForPlayers(){
            System.out.println("Attendendo giocatori...");
    }

   // @Override
    public void displayWinner(String winner){
        out.println("Game ended, " + winner + " WIN!");
    }

    @Override
    public void requestCloud() {

    }

    @Override
    public void dysplayNetError() {
    }

    @Override
    public void dysplayTurn(StartTurnMessage object) {
        System.out.println(object.getMessage());
    }

    public void clearCli(){
        out.print(ColorCli.CLEAR);
        out.flush();
    }

    private String print1_4Index(ArrayList<Island> islands){
        StringBuilder index = new StringBuilder();
        for(int i = 0; i<islands.size() && i<4; i++)
            index.append("   ").append("Isola: ").append(i).append("   ");
        return index.toString();
    }

    private String print4_8Index(ArrayList<Island> islands){
        StringBuilder index = new StringBuilder();
        if(islands.size()>=4){
            for(int i = 4; i<islands.size() && i<8; i++)
                index.append("   ").append("Isola: ").append(i).append("   ");
        }
        return index.toString();
    }

    private String print8_12Index(ArrayList<Island> islands){
        StringBuilder index = new StringBuilder();
        if(islands.size()>=8){
            for(int i = 8; i<islands.size(); i++)
                index.append("   ").append("Isola: ").append(i).append("   ");
        }
        return index.toString();
    }


    @Override
    public void run() {

    }

  /*  public void displayNetError(){

    }

    public void requestNickname(){

    }

    public void requestNumPlayers(){

    }

    public void registerClient(ClientAcceptedMessage m){

    }*/
}