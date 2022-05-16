package it.polimi.ingsw.view.Cli;


import it.polimi.ingsw.model.*;
import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.view.View;

import java.awt.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import java.io.*;

public class Cli implements Runnable, View {
    Scanner scanner = new Scanner(System.in); //Per leggere input da tastiera
    private final PrintStream out;
    private Thread inputThread;

    public Cli() {
        out = System.out;
    }

    public String readline() throws ExecutionException {
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

            String address = readline();

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


        while (isExpert != 0 || numPlayers != 1) { //non ho capito cosa controlla questo -Paul
            System.out.println("ERROR: type 0 for normal mode or type 1 for expert mode \n");
            isExpert = checkInteger();
        }

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
    public void displayCloud(Game game) {
        int i;
        for (i = 0; i < game.getClouds().size(); i++) {
            out.println("La Cloud numero " + i + " ha:");
            out.println(" - " + game.getClouds().get(i).getGreenPawn() + " GreenPawn,");
            out.println(" - " + game.getClouds().get(i).getRedPawn() + " RedPawn,");
            out.println(" - " + game.getClouds().get(i).getYellowPawn() + " YelloPawn,");
            out.println(" - " + game.getClouds().get(i).getPinkPawn() + " PinkPawn,");
            out.println(" - " + game.getClouds().get(i).getBluePawn() + " BluePawn.");


        }
    }

    @Override
    public void displayDiningRoom(Game game) {
        int i, j;
        for (i = 0; i < game.getPlayers().size(); i++) {
            out.println("Player: " + game.getPlayers().get(i).getNickname());
            for (j = 0; j < game.getPlayers().get(i).getDiningRoom().getNumGreen(); j++)
                out.print(ColorCli.GREEN + "● ");
            for (j = 0; j < game.getPlayers().get(i).getDiningRoom().getNumRed(); j++) out.print(ColorCli.RED + "● ");
            for (j = 0; j < game.getPlayers().get(i).getDiningRoom().getNumYellow(); j++)
                out.print(ColorCli.YELLOW + "● ");
            for (j = 0; j < game.getPlayers().get(i).getDiningRoom().getNumPink(); j++) out.print(ColorCli.PINK + "● ");
            for (j = 0; j < game.getPlayers().get(i).getDiningRoom().getNumBlue(); j++) out.print(ColorCli.BLUE + "● ");
            out.println();
            out.println("-------------------");
            out.println();
        }
    }

    @Override
    public void displayEntrance(Game game) {
        int i, j;
        for (i = 0; i < game.getPlayers().size(); i++) {
            out.println("Player: " + game.getPlayers().get(i).getNickname());
            for (j = 0; j < game.getPlayers().get(i).getEntrance().getGreenPawn(); j++)
                out.print(ColorCli.GREEN + "● ");
            for (j = 0; j < game.getPlayers().get(i).getEntrance().getRedPawn(); j++) out.print(ColorCli.RED + "● ");
            for (j = 0; j < game.getPlayers().get(i).getEntrance().getYellowPawn(); j++)
                out.print(ColorCli.YELLOW + "● ");
            for (j = 0; j < game.getPlayers().get(i).getEntrance().getPinkPawn(); j++) out.print(ColorCli.PINK + "● ");
            for (j = 0; j < game.getPlayers().get(i).getEntrance().getBluePawn(); j++) out.print(ColorCli.BLUE + "● ");
            out.println();
            out.println("-------------------");
            out.println();
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

        /*int i, j;
        for(i=0; i<game.getIslands().size(); i++){
            out.println("Isola numero " + i);
            out.print(ColorCli.GREEN +"●: " + game.getIslands().get(i).getGreenPawn());
            out.print(ColorCli.RED +"●: " + game.getIslands().get(i).getRedPawn());
            out.print(ColorCli.YELLOW +"●: " + game.getIslands().get(i).getYellowPawn());
            out.print(ColorCli.PINK +"●: " + game.getIslands().get(i).getPinkPawn());
            out.print(ColorCli.BLUE +"●: " + game.getIslands().get(i).getBluePawn());*/
        }

    private String color4Island(ArrayList<Island> islands, int island, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("●: ").append(islands.get(island).getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("●: ").append(islands.get(island).getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("●: ").append(islands.get(island).getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("●: ").append(islands.get(island).getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("●: ").append(islands.get(island).getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        return showColor.toString();
    }

    @Override
    public void displayProfTable(Game game){
        out.println("Il giocatore " + game.getPlayers().get(game.getProfTable().getGreenProf()).getNickname() + " ha il professore VERDE");
        out.println("Il giocatore " + game.getPlayers().get(game.getProfTable().getRedProf()).getNickname() + " ha il professore ROSSO");
        out.println("Il giocatore " + game.getPlayers().get(game.getProfTable().getYellowProf()).getNickname() + " ha il professore GIALLO");
        out.println("Il giocatore " + game.getPlayers().get(game.getProfTable().getPinkProf()).getNickname() + " ha il professore ROSA");
        out.println("Il giocatore " + game.getPlayers().get(game.getProfTable().getBlueProf()).getNickname() + " ha il professore BLU");
    }

    @Override
    public void displayTowerSpace() {

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
    public void displayTurn(StartTurnMessage startTurnMessage){
        System.out.println(startTurnMessage.getMessage());
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

    @Override
    public void displayWinner(String winner){
        out.println("Game ended, " + winner + " WIN!");
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
}
