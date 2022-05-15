package it.polimi.ingsw.view.Cli;


import it.polimi.ingsw.model.*;
import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Cli implements Runnable, View{
    Scanner scanner = new Scanner(System.in); //Per leggere input da tastiera
    private final PrintStream out;
    private Thread inputThread;

    public Cli(){
        out = System.out;
    }

    public String readline() throws ExecutionException{
        FutureTask<String> futureTask = new FutureTask<>(new InputReadTask());
        inputThread = new Thread(futureTask);
        inputThread.start();

        String input = null;

        try{
            input = futureTask.get();
        } catch (InterruptedException e){
            futureTask.cancel(true);
            Thread.currentThread().interrupt();
        }
        return input;
    }

    //start the cli
    public void init() {
        out.println("Benvenuto in Eryantis!");

        try{
            askServerInfo();
        }catch (ExecutionException e){
            out.println("User input canceled.");
        }
    }
    public void askServerInfo() throws ExecutionException{
        Map<String, String> serverInfo = new HashMap<>();
        String defaultAddress = "localhost";
        String defaultPort = "16847";
        boolean validInput;

        out.println("Seleziona una delle opzioni, il valore di default è tra le parentesi");

        do{
            out.print("Inserisci il server address [" +defaultAddress+ "]: ");

            String address = readline();

            if(address.equals("")){
                serverInfo.put("address", defaultAddress);
                validInput = true;
            } else if (ClientcController.isValidIpAddress(address)){
                serverInfo.put("address", address);
                validInput= true;
            } else{
                out.println("Invalid Address!!!");
                clearCli();
                validInput = false;
            }
        } while (!validInput);
    }


    public int checkInteger(){
        boolean isInteger = false;
        int integer = -1;
        while(!isInteger){
            try{
                integer = scanner.nextInt();
                isInteger = true;
            }catch(InputMismatchException | NumberFormatException e){
                System.out.println("ERROR: insert an integer number");
            }finally{
                scanner.close();
            }
        }
        return integer;
    }

    @Override
    public void askNumPlayerIsExpert(){
        System.out.println("You are the first player logged. \n");
        System.out.println("Please insert the number of Players. It must be a number between 2 and 4. \n");
        int numPlayers = checkInteger();

        while(numPlayers < 2 || numPlayers > 4){
            System.out.println("Please insert the number of Players again. It must be a number between 2 and 4. \n");
            numPlayers = checkInteger();
        }

        System.out.println("Choose the game mode: type 0 for normal mode or type 1 for expert mode \n");
        int isExpert = checkInteger();


         while(isExpert !=  0 || numPlayers != 1){ //non ho capito cosa controlla questo -Paul
            System.out.println("ERROR: type 0 for normal mode or type 1 for expert mode \n");
            isExpert = checkInteger();
        }

    }

    @Override
    public void displayAssistantCard(Player player){
        int i;
        for(i=0; i<player.getDeckAssistant().size(); i++){
            out.println(i + "Valore: " +player.getDeckAssistant().get(i).getCardValue());
            out.println(" " + "Passi: " + player.getDeckAssistant().get(i).getStep());
            out.println("-----------------------");
        }
    }

    @Override
    public void displayCloud(Game game){
        int i;
        for(i=0; i<game.getClouds().size(); i++){
            out.println("La Cloud numero " + i + " ha:");
            out.println(" - " + game.getClouds().get(i).getGreenPawn() + " GreenPawn,");
            out.println(" - " + game.getClouds().get(i).getRedPawn() + " RedPawn,");
            out.println(" - " + game.getClouds().get(i).getYellowPawn() + " YelloPawn,");
            out.println(" - " + game.getClouds().get(i).getPinkPawn() + " PinkPawn,");
            out.println(" - " + game.getClouds().get(i).getBluePawn() + " BluePawn.");


        }
    }

    @Override
    public void displayDiningRoom(Game game){
        int i, j;
        for(i=0; i<game.getPlayers().size(); i++){
            out.println("Player: " + game.getPlayers().get(i).getNickname());
            for(j=0; j<game.getPlayers().get(i).getDiningRoom().getNumGreen(); j++) out.print(ColorCli.GREEN +"● ");
            for(j=0; j<game.getPlayers().get(i).getDiningRoom().getNumRed(); j++) out.print(ColorCli.RED +"● ");
            for(j=0; j<game.getPlayers().get(i).getDiningRoom().getNumYellow(); j++) out.print(ColorCli.YELLOW +"● ");
            for(j=0; j<game.getPlayers().get(i).getDiningRoom().getNumPink(); j++) out.print(ColorCli.PINK +"● ");
            for(j=0; j<game.getPlayers().get(i).getDiningRoom().getNumBlue(); j++) out.print(ColorCli.BLUE +"● ");
            out.println("-------------------");
        }
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




}
