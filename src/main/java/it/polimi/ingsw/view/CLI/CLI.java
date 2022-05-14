package it.polimi.ingsw.view.CLI;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.view.View;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class CLI implements Runnable, View{
    Scanner scanner = new Scanner(System.in); //Per leggere input da tastiera

    public CLI(){

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





}
