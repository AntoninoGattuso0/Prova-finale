package it.polimi.ingsw.view.Cli;


import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.ModelLight.LightPlayer;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseCloudMessage;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNickname;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNumPlayersIsExpert;
import it.polimi.ingsw.network.Message.ServerToClient.InvalidNumPlayerMessage;
import it.polimi.ingsw.network.Message.ServerToClient.WrongNicknameMessage;
import it.polimi.ingsw.network.Message.ServerToClient.WrongTurnMessage;
import it.polimi.ingsw.observer.NetworkHandlerObservable;
import it.polimi.ingsw.view.View;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Integer.parseInt;

public class Cli extends NetworkHandlerObservable implements Runnable, View {
    Scanner scanner = new Scanner(System.in); //Per leggere input da tastiera
    private final PrintStream out;
    private Thread inputThread;
    private String actualPlayer;
    private boolean isExpert;
    private boolean gameStart;
    private LightGame lightGame;
    private SocketNetworkHandler socketNetworkHandler;

    public Cli() {
        out = System.out;
        gameStart = false;
    }

    public void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler) {
        this.socketNetworkHandler = socketNetworkHandler;
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
    public void run() {
        try {
            askServerInfo();
        } catch (ExecutionException e) {
            out.println("User input canceled.");
        }
        startGame();
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
                //  clearCli();
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
        out.println(ColorCli.GREEN +

                "EEEEEEEEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRR   IIIIIIIIII               AAA               NNNNNNNN        NNNNNNNNTTTTTTTTTTTTTTTTTTTTTTTYYYYYYY       YYYYYYY   SSSSSSSSSSSSSSS \n" +
                "E::::::::::::::::::::ER::::::::::::::::R  I::::::::I              A:::A              N:::::::N       N::::::NT:::::::::::::::::::::TY:::::Y       Y:::::Y SS:::::::::::::::S \n" +
                "E::::::::::::::::::::ER::::::RRRRRR:::::R I::::::::I             A:::::A             N::::::::N      N::::::NT:::::::::::::::::::::TY:::::Y       Y:::::YS:::::SSSSSS::::::S\n" + ColorCli.RED +
                "EE::::::EEEEEEEEE::::ERR:::::R     R:::::RII::::::II            A:::::::A            N:::::::::N     N::::::NT:::::TT:::::::TT:::::TY::::::Y     Y::::::YS:::::S     SSSSSSS \n" +
                "E:::::E       EEEEEE  R::::R     R:::::R  I::::I               A:::::::::A           N::::::::::N    N::::::NTTTTTT  T:::::T  TTTTTTYYY:::::Y   Y:::::YYYS:::::S \n" +
                "E:::::E               R::::R     R:::::R  I::::I              A:::::A:::::A          N:::::::::::N   N::::::N        T:::::T           Y:::::Y Y:::::Y   S:::::S\n" + ColorCli.YELLOW +
                "E::::::EEEEEEEEEE     R::::RRRRRR:::::R   I::::I             A:::::A A:::::A         N:::::::N::::N  N::::::N        T:::::T            Y:::::Y:::::Y     S::::SSSS\n" +
                "E:::::::::::::::E     R:::::::::::::RR    I::::I            A:::::A   A:::::A        N::::::N N::::N N::::::N        T:::::T             Y:::::::::Y       SS::::::SSSSS\n" +
                "E:::::::::::::::E     R::::RRRRRR:::::R   I::::I           A:::::A     A:::::A       N::::::N  N::::N:::::::N        T:::::T              Y:::::::Y          SSS::::::::SS\n" + ColorCli.PINK +
                "E::::::EEEEEEEEEE     R::::R     R:::::R  I::::I          A:::::AAAAAAAAA:::::A      N::::::N   N:::::::::::N        T:::::T               Y:::::Y              SSSSSS::::S\n" +
                "E:::::E               R::::R      R:::::R I::::I         A:::::::::::::::::::::A     N::::::N    N::::::::::N        T:::::T               Y:::::Y                   S:::::S\n" +
                "E:::::E       EEEEEE  R::::R       R:::::RI::::I        A:::::AAAAAAAAAAAAA:::::A    N::::::N     N:::::::::N        T:::::T               Y:::::Y                   S:::::S\n" +
                "EE::::::EEEEEEEE:::::ERR:::::R     R:::::RII::::::II   A:::::A             A:::::A   N::::::N      N::::::::N      TT:::::::TT             Y:::::Y       SSSSSSS     S:::::S\n" + ColorCli.BLUE +
                "E::::::::::::::::::::ER::::::R     R:::::RI::::::::I  A:::::A               A:::::A  N::::::N       N:::::::N      T:::::::::T          YYYY:::::YYYY    S::::::SSSSSS:::::S\n" +
                "E::::::::::::::::::::ER::::::R     R:::::RI::::::::I A:::::A                 A:::::A N::::::N        N::::::N      T:::::::::T          Y:::::::::::Y    S:::::::::::::::SS\n" +
                "EEEEEEEEEEEEEEEEEEEEEERRRRRRRR     RRRRRRRIIIIIIIIIIAAAAAAA                   AAAAAAANNNNNNNN         NNNNNNN      TTTTTTTTTTT          YYYYYYYYYYYYY     SSSSSSSSSSSSSSS   \n"
                + ColorCli.RESET
        );

        out.println("\n \n \n \n");

    }

    @Override
    public void requestNickname() {
        out.println("Digita il tuo nickname: ");
        try {
            String nickname = readLine();
            socketNetworkHandler.sendMessage(new RequestNickname(nickname));
        } catch (ExecutionException e) {
            out.println("ERRORE");
            socketNetworkHandler.sendMessage(new WrongNicknameMessage());
        }
        //NON SO SE COSI FUNZIONA -NINO
    }

    @Override
    public void requestNumPlayersIsExpert() {
        out.println("Inserisci il numero di giocatori (puoi inserire 2, 3 o 4 giocatori): ");
        try {
            int numPlayer = parseInt(readLine());
            while (numPlayer != 2 && numPlayer != 3 && numPlayer != 4) {
                out.println("Inserisci il numero di giocatori (puoi inserire 2, 3 o 4 giocatori): ");
                numPlayer = parseInt(readLine());
            }
            out.println("Inserisci E per variante esperta o B base");
            String isExpert = readLine();
            boolean expert = false;
            while (!Objects.equals(isExpert, "B") && !Objects.equals(isExpert, "E")) {
                out.println("Inserisci E per variante esperta o B base");
            }
            if (isExpert.equals("E")) {
                expert = true;
            } else if (isExpert.equals("B")) {
                expert = false;
            }
            socketNetworkHandler.sendMessage(new RequestNumPlayersIsExpert(numPlayer, expert));
        } catch (ExecutionException e) {
            out.println("ERRORE");
            socketNetworkHandler.sendMessage(new InvalidNumPlayerMessage());
        }
    }

    /*@Override
    public void requestIsExpert() {
        out.println("Per modalità esperta digita 1, altrimenti 0: ");
        try{
            int isExpert = parseInt(readLine());
            while(isExpert != 0 && isExpert != 1){
                out.println("Per modalità esperta digita 1, altrimenti 0: ");
                isExpert = parseInt(readLine());
            }
            if(isExpert == 1)
                this.isExpert = true;
            else
                this.isExpert = false;
            socketNetworkHandler.sendMessage(new RequestNumPlayersIsExpert());
        } catch (ExecutionException e){
            out.println("ERRORE");
        }
    } NON SERVE A UN TOPOCAZZO, LA FUNZIONE È PRESENTE SOPRA */

    @Override
    public void displayNick() {
        for (int i = 0; i < lightGame.getNumPlayers(); i++) {
            out.println("Giocatore " + i + 1 + " ha il nickname: " + lightGame.getPlayers().get(i).getNickname());
        }
    }

    @Override
    public void displayNumPlayers() {
        out.println("Player totali: " + lightGame.getNumPlayers());
    }

    @Override
    public void displayIsExpert() {
        if (isExpert)
            out.println("Il gioco è in modalità esperta");
        else
            out.println("Il gioco è in modalità normale");
    }

    @Override
    public void displayAssistantCard() {
        clearCli();

        int i;
        StringBuilder assistantCard = new StringBuilder();
        for (i = 0; i < lightGame.getPlayers().get(i).getDeckAssistant().size(); i++) {
            out.println(ColorCli.BOLDCYAN + "+-----------------------+");
            if (lightGame.getPlayers().get(i).getDeckAssistant().get(i).getCardValue() == 10)
                out.println(ColorCli.BOLDCYAN + "| Card Value: " + ColorCli.RED + lightGame.getPlayers().get(i).getDeckAssistant().get(i).getCardValue() + ColorCli.BOLDCYAN + "        |");
            else
                out.println(ColorCli.BOLDCYAN + "| Card Value: " + ColorCli.RED + lightGame.getPlayers().get(i).getDeckAssistant().get(i).getCardValue() + ColorCli.BOLDCYAN + "         |");

            out.println(ColorCli.BOLDCYAN + "| MN steps: " + ColorCli.GREEN + lightGame.getPlayers().get(i).getDeckAssistant().get(i).getStep() + ColorCli.BOLDCYAN + "           |");
            out.println(ColorCli.BOLDCYAN + "+-----------------------+");
        }
        out.println(assistantCard);
    }

    @Override
    public void displayCloud() {
        clearCli();

        int i;
        StringBuilder cloudCards = new StringBuilder();
        out.println(" ");
        out.println(" ");
        cloudCards.append(ColorCli.BOLDCYAN);
        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("     ").append(" +*******+").append("        ");

        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("   *            *      ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append(" *                *    ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");

        for (int j = 0; j < 5; j++) {
            for (i = 0; i < lightGame.getClouds().size(); i++)
                cloudCards.append(ColorCli.BOLDCYAN).append("*").append(ColorCli.RESET).append(color4Clouds(i, j)).append(" *   ");
            cloudCards.append("\n").append(ColorCli.RESET);
        }

        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append(" *                *    ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < lightGame.getClouds().size() ; i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("   *            *      ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");

        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("     ").append(" +*******+").append("        ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n").append(ColorCli.RESET);


        out.print(cloudCards);
        cloudCards.delete(0, cloudCards.capacity());

    }

    @Override
    public void displayIslands() {
        clearCli();

        int i;
        StringBuilder tabIslands = new StringBuilder();
        out.println(print1_4Index());
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 0; i < lightGame.getIslands().size() && i < 4; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 0; i < lightGame.getIslands().size() && i < 4; i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(i, j));
            tabIslands.append("|\n").append(ColorCli.RESET);
        }
        for (i = 0; i < lightGame.getIslands().size() && i < 4; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());

        out.println(print4_8Index());
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 4; i < lightGame.getIslands().size() && i < 8; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 4; i < lightGame.getIslands().size() && i < 8; i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(i, j));
            tabIslands.append("|").append(ColorCli.RESET).append("\n");
        }
        for (i = 4; i < lightGame.getIslands().size() && i < 8; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());

        out.println(print8_12Index());
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 8; i < lightGame.getIslands().size(); i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 8; i < lightGame.getIslands().size(); i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(i, j));
            tabIslands.append("|\n").append(ColorCli.RESET);
        }
        for (i = 8; i < lightGame.getIslands().size(); i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());
    }

    @Override
    public void displaySchoolBoard() {
        clearCli();
        int i, m;
        StringBuilder schoolBoard = new StringBuilder();

        for(i = 0; i < lightGame.getPlayers().size(); i++ ){
            out.println(" ");
            out.println(" ");
            schoolBoard.append(ColorCli.BOLDCYAN);

            schoolBoard.append("Player: " + lightGame.getPlayers().get(i).getNickname()).append("\n").append("+--------------+--------------------------------+---+------+\n");

            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  0));
            schoolBoard.append("| ").append(ColorCli.RESET);
            schoolBoard.append(ColorCli.BOLDCYAN);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumGreen(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.GREEN).append("  ◎");
                else schoolBoard.append(color4DiningRoom(0)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.GREEN).append("  ◌");
                m++;
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,0, i)).append(ColorCli.BOLDCYAN).append(" |");

            int j = lightGame.getPlayers().get(i).getTowerSpace().getNumTower();
            schoolBoard.append(color4TowerSpace(i, j));
            j = lightGame.getPlayers().get(i).getTowerSpace().getNumTower() - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  1));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumRed(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.RED).append("  ◎");
                else schoolBoard.append(color4DiningRoom(1)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.RED).append("  ◌");
                m++;
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,1, i)).append(ColorCli.BOLDCYAN).append(" |");
            schoolBoard.append(color4TowerSpace(i, j));
            j = j - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  2));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumYellow(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.YELLOW).append("  ◎");
                else schoolBoard.append(color4DiningRoom(2)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.YELLOW).append("  ◌");
                m++;
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,2, i)).append(ColorCli.BOLDCYAN).append(" |");
            schoolBoard.append(color4TowerSpace(i, j));
            j = j - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  3));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumPink(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.PINK).append("  ◎");
                else schoolBoard.append(color4DiningRoom(3)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.PINK).append("  ◌");
                m++;
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,3, i)).append(ColorCli.BOLDCYAN).append(" |");
            schoolBoard.append(color4TowerSpace(i, j));


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  4));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumBlue(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.BLUE).append("  ◎");
                else schoolBoard.append(color4DiningRoom(4)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.BLUE).append("  ◌");
                m++;
            }

            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,4, i)).append(ColorCli.BOLDCYAN).append(" |");
            schoolBoard.append("      ").append(ColorCli.BOLDCYAN).append("| \n");
            schoolBoard.append(ColorCli.BOLDCYAN).append("+--------------+--------------------------------+---+------+\n");
            schoolBoard.append(ColorCli.RESET);
        }

        out.print(schoolBoard);
        schoolBoard.delete(0, schoolBoard.capacity());
    }

    @Override
    public void displayCharacterCard() {
        //ndo stanno salvate le character card?
    }

    @Override
    public void displayWinner(String winner) {
        out.println("The winner is: " + winner);
    }

    @Override
    public void displayNetError() {
        out.println("NET ERROR");
    }

    @Override
    public void displayWrongNickname() {
        out.println("Nickname Errato o Già Presente!");
        socketNetworkHandler.sendMessage(new WrongNicknameMessage());
    }

    @Override
    public void displayWrongTurn() {
        out.println("Non è il tuo turno, aspetta...");
        socketNetworkHandler.sendMessage(new WrongTurnMessage());
    }

    @Override
    public void displayFetchNameMessage() {

    }

    @Override
    public void displayTurn() {
        //dove li abbiamo salvati i turni del gioco?

    }

    @Override
    public void displayResponseMessage() {

    }

    /*@Override
    public void displayTurn(StartTurnMessage object) {

    }*/

    /*@Override
    public void displayResponseMessage(String errorMessage) {

    }*/

    @Override
    public void updateAssistantCard() {

    }

    @Override
    public void updateCloud() {

    }

    @Override
    public void updateIsland() {

    }

    @Override
    public void updateEntrance() {

    }

    @Override
    public void updateDiningRoom() {

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
    public void updateNickname() {

    }

    @Override
    public void updateNumPlayers() {

    }

    @Override
    public void updateAll(LightGame object) {
        this.lightGame = object;
    }

    @Override
    public void selectCloud() {

    }

    @Override
    public void selectAssistantCard() {

    }

    @Override
    public void requestMoveMotherNature() {

    }


    @Override
    public void registerClient() {

    }

    @Override
    public void waitOtherPlayers() {

    }

    public void clearCli() {
        out.print(ColorCli.CLEAR);
        out.flush();
    }

    public void requestCloud() {
        out.println("Please select a cloud between 0 and "+ lightGame.getClouds().size() + ": ");
        int cloud = checkInteger();

        while(cloud < 0 || cloud > lightGame.getClouds().size()){
            out.println("Please select a cloud between 0 and "+ lightGame.getClouds().size() + ": ");
            cloud = checkInteger();
        }
        socketNetworkHandler.sendMessage(new ChooseCloudMessage(cloud));
    }
    private String color4Island(int island, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("●: ").append(lightGame.getIslands().get(island).getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("●: ").append(lightGame.getIslands().get(island).getRedPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("●: ").append(lightGame.getIslands().get(island).getYellowPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("●: ").append(lightGame.getIslands().get(island).getPinkPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("●: ").append(lightGame.getIslands().get(island).getBluePawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        return showColor.toString();
    }


    private String color4Clouds(int cloud, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("     ●: ").append(lightGame.getClouds().get(cloud).getGreenPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("     ●: ").append(lightGame.getClouds().get(cloud).getRedPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("     ●: ").append(lightGame.getClouds().get(cloud).getYellowPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("     ●: ").append(lightGame.getClouds().get(cloud).getPinkPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("     ●: ").append(lightGame.getClouds().get(cloud).getBluePawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        return showColor.toString();
    }

    private String color4Entrance(LightPlayer player, int color){
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


    private String color4ProfTable(LightGame game, int color, int profOfPlayer){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            if(game.getProfTable().getGreenProf() == profOfPlayer)
                showColor.append(ColorCli.GREEN).append("❂");
            else showColor.append(ColorCli.GREEN).append("︎︎◌");
        }
        else if(color == 1){
            if(game.getProfTable().getRedProf() == profOfPlayer)
                showColor.append(ColorCli.RED).append("❂");
            else showColor.append(ColorCli.RED).append("︎︎◌");
        }
        else if(color == 2){
            if(game.getProfTable().getYellowProf() == profOfPlayer)
                showColor.append(ColorCli.YELLOW).append("❂");
            else showColor.append(ColorCli.YELLOW).append("◌");
        }
        else if(color == 3){
            if(game.getProfTable().getPinkProf() == profOfPlayer)
                showColor.append(ColorCli.PINK).append("❂");
            else showColor.append(ColorCli.PINK).append("◌");
        }
        else if(color == 4){
            if(game.getProfTable().getBlueProf() == profOfPlayer)
                showColor.append(ColorCli.BLUE).append("❂");
            else showColor.append(ColorCli.BLUE).append("◌");
        }
        return showColor.toString();
    }

    private String color4TowerSpace(int player, int numTower){
        StringBuilder showColor = new StringBuilder();
        if(player == 0){
            if(numTower > 1) {
                showColor.append(ColorCli.RESET).append("♖    ♖").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower == 1) {
                showColor.append(ColorCli.RESET).append("♖    ☒").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower <= 0)
                showColor.append(ColorCli.RESET).append("☒    ☒").append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }

        else if(player == 1){
            if(numTower > 1) {
                showColor.append(ColorCli.BLACK).append("♖    ♖").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower==1) {
                showColor.append(ColorCli.BLACK).append("♖    ☒").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower <= 0)
                showColor.append(ColorCli.BLACK).append("☒    ☒").append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }
        else if(player == 2){
            if(numTower > 1) {
                showColor.append(ColorCli.GREY).append("♖    ♖").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower==1) {
                showColor.append(ColorCli.GREY).append("♖    ☒").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower <= 0)
                showColor.append(ColorCli.GREY).append("☒    ☒").append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }
        return showColor.toString();
    }

    private String print1_4Index(){
        StringBuilder index = new StringBuilder();
        for(int i = 0; i < lightGame.getIslands().size() && i<4; i++)
            index.append("   ").append("Isola: ").append(i).append("   ");
        return index.toString();
    }

    private String print4_8Index(){
        StringBuilder index = new StringBuilder();
        if(lightGame.getIslands().size()>=4){
            for(int i = 4; i < lightGame.getIslands().size() && i<8; i++)
                index.append("   ").append("Isola: ").append(i).append("   ");
        }
        return index.toString();
    }

    private String print8_12Index(){
        StringBuilder index = new StringBuilder();
        if(lightGame.getIslands().size()>=8){
            for(int i = 8; i < lightGame.getIslands().size(); i++)
                index.append("   ").append("Isola: ").append(i).append("   ");
        }
        return index.toString();
    }
}

   /* @Override
    public void loginPlayers() {
        System.out.println("Welcome in Eriantys. Insert your NICKNAME: ");
        String nick = scanner.nextLine();
        System.out.println("\n Do you want to join. Insert 1 for Yes, 0 for No: ");
        boolean joinGame = scanner.nextBoolean();
        notifyMessage(new LoginSettMessage(nick, joinGame));
        System.out.println("\n");
    }*/
/*
    @Override
    public void requestNickname() {
        out.println("Please insert your Nickname:  ");
        String nick = scanner.nextLine();
        out.println("\n");

        notifyMessage(new RequestNickname(nick));
    }

    @Override
    public void requestNumPlayers(){

        System.out.println("Please insert the number of Players. It must be a number between 2 and 4. \n");
        int numPlayers = checkInteger();
        out.println("\n");
        while (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Please insert the number of Players again. It must be a number between 2 and 4. \n");
            numPlayers = checkInteger();
        }
        notifyMessage(new RequestNumPlayers(numPlayers));
    }

    @Override
    public void requestIsExpert() {
        int mode;
        do{
            System.out.println("Choose the game mode: type 0 for normal mode or type 1 for expert mode: \n");
            mode = checkInteger();
        }while(mode!=0 || mode!=1);
        if(mode==0) isExpert = false;
        else if(mode==1) isExpert = true;
        notifyMessage(new RequestIsExpert(isExpert));
    }


    @Override
    public void displayNick(){
        int i;
        for(i = 0; i < lightGame.getNumPlayers(); i++)
            out.println(lightGame.getPlayers().get(i).getNickname() + " è il giocatore numero " + (i+1)+ "\n");
    }

    @Override
    public void displayNumPlayers(){
        System.out.println("The number of players is: " + lightGame.getNumPlayers());
    }

    @Override
    public void displayIsExpert(){
        if(isExpert)
            out.println("The game mode will be expert.\n");
        else
            out.println("The game mode will be normal.\n");
    }

    @Override
    public void displayAssistantCard() {
        clearCli();

        int i;
        StringBuilder assistantCard = new StringBuilder();
        for (i = 0; i < lightGame.getPlayers().get(i).getDeckAssistant().size(); i++) {
            out.println(ColorCli.BOLDCYAN + "+-----------------------+");
            if(lightGame.getPlayers().get(i).getDeckAssistant().get(i).getCardValue() == 10)
                out.println(ColorCli.BOLDCYAN +"| Card Value: " + ColorCli.RED + lightGame.getPlayers().get(i).getDeckAssistant().get(i).getCardValue() + ColorCli.BOLDCYAN + "        |");
            else
                out.println(ColorCli.BOLDCYAN +"| Card Value: " + ColorCli.RED + lightGame.getPlayers().get(i).getDeckAssistant().get(i).getCardValue() + ColorCli.BOLDCYAN + "         |");

            out.println(ColorCli.BOLDCYAN +"| MN steps: " + ColorCli.GREEN + lightGame.getPlayers().get(i).getDeckAssistant().get(i).getStep() + ColorCli.BOLDCYAN + "           |");
            out.println(ColorCli.BOLDCYAN + "+-----------------------+");
        }
        out.println(assistantCard);
    }

    @Override
    public void displayCloud() {
        clearCli();

        int i;
        StringBuilder cloudCards = new StringBuilder();
        out.println(" ");
        out.println(" ");
        cloudCards.append(ColorCli.BOLDCYAN);
        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("     ").append(" +*******+").append("        ");

        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("   *            *      ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append(" *                *    ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");

        for (int j = 0; j < 5; j++) {
            for (i = 0; i < lightGame.getClouds().size(); i++)
                cloudCards.append(ColorCli.BOLDCYAN).append("*").append(ColorCli.RESET).append(color4Clouds(i, j)).append(" *   ");
            cloudCards.append("\n").append(ColorCli.RESET);
        }

        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append(" *                *    ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");
        for (i = 0; i < lightGame.getClouds().size() ; i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("   *            *      ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n");

        for (i = 0; i < lightGame.getClouds().size(); i++)
            cloudCards.append(ColorCli.BOLDCYAN).append("     ").append(" +*******+").append("        ");
        cloudCards.append(ColorCli.BOLDCYAN).append("\n").append(ColorCli.RESET);


        out.print(cloudCards);
        cloudCards.delete(0, cloudCards.capacity());

    }

    @Override
    public void displayIslands() {
        clearCli();

        int i;
        StringBuilder tabIslands = new StringBuilder();
        out.println(print1_4Index());
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 0; i < lightGame.getIslands().size() && i < 4; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 0; i < lightGame.getIslands().size() && i < 4; i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(i, j));
            tabIslands.append("|\n").append(ColorCli.RESET);
        }
        for (i = 0; i < lightGame.getIslands().size() && i < 4; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());

        out.println(print4_8Index());
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 4; i < lightGame.getIslands().size() && i < 8; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 4; i < lightGame.getIslands().size() && i < 8; i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(i, j));
            tabIslands.append("|").append(ColorCli.RESET).append("\n");
        }
        for (i = 4; i < lightGame.getIslands().size() && i < 8; i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());

        out.println(print8_12Index());
        tabIslands.append(ColorCli.BOLDCYAN);
        for (i = 8; i < lightGame.getIslands().size(); i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        for (int j = 0; j < 5; j++) {
            for (i = 8; i < lightGame.getIslands().size(); i++)
                tabIslands.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Island(i, j));
            tabIslands.append("|\n").append(ColorCli.RESET);
        }
        for (i = 8; i < lightGame.getIslands().size(); i++)
            tabIslands.append(ColorCli.BOLDCYAN).append("+--------------");
        tabIslands.append(ColorCli.BOLDCYAN).append("+\n").append(ColorCli.RESET);
        out.print(tabIslands);
        tabIslands.delete(0, tabIslands.capacity());
    }

    public void displaySchoolBoard(){
        clearCli();
        int i, m;
        StringBuilder schoolBoard = new StringBuilder();

        for(i = 0; i < lightGame.getPlayers().size(); i++ ){
            out.println(" ");
            out.println(" ");
            schoolBoard.append(ColorCli.BOLDCYAN);

            schoolBoard.append("Player: " + lightGame.getPlayers().get(i).getNickname()).append("\n").append("+--------------+--------------------------------+---+------+\n");

            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  0));
            schoolBoard.append("| ").append(ColorCli.RESET);
            schoolBoard.append(ColorCli.BOLDCYAN);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumGreen(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.GREEN).append("  ◎");
                else schoolBoard.append(color4DiningRoom(0)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.GREEN).append("  ◌");
                m++;
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,0, i)).append(ColorCli.BOLDCYAN).append(" |");

            int j = lightGame.getPlayers().get(i).getTowerSpace().getNumTower();
            schoolBoard.append(color4TowerSpace(i, j));
            j = lightGame.getPlayers().get(i).getTowerSpace().getNumTower() - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  1));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumRed(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.RED).append("  ◎");
                else schoolBoard.append(color4DiningRoom(1)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.RED).append("  ◌");
                m++;
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,1, i)).append(ColorCli.BOLDCYAN).append(" |");
            schoolBoard.append(color4TowerSpace(i, j));
            j = j - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  2));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumYellow(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.YELLOW).append("  ◎");
                else schoolBoard.append(color4DiningRoom(2)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.YELLOW).append("  ◌");
                m++;
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,2, i)).append(ColorCli.BOLDCYAN).append(" |");
            schoolBoard.append(color4TowerSpace(i, j));
            j = j - 2;


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  3));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumPink(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.PINK).append("  ◎");
                else schoolBoard.append(color4DiningRoom(3)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.PINK).append("  ◌");
                m++;
            }
            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,3, i)).append(ColorCli.BOLDCYAN).append(" |");
            schoolBoard.append(color4TowerSpace(i, j));


            schoolBoard.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append(color4Entrance(lightGame.getPlayers().get(i),  4));
            schoolBoard.append("| ").append(ColorCli.RESET);
            for (m = 0; m < lightGame.getPlayers().get(i).getDiningRoom().getNumBlue(); m++){
                if(m==2||m==5||m==8) schoolBoard.append(ColorCli.BLUE).append("  ◎");
                else schoolBoard.append(color4DiningRoom(4)).append(ColorCli.BOLDCYAN);
            }
            while(m < 10){
                schoolBoard.append(ColorCli.BLUE).append("  ◌");
                m++;
            }

            schoolBoard.append(ColorCli.BOLDCYAN).append(" | ").append(color4ProfTable(lightGame,4, i)).append(ColorCli.BOLDCYAN).append(" |");
            schoolBoard.append("      ").append(ColorCli.BOLDCYAN).append("| \n");
            schoolBoard.append(ColorCli.BOLDCYAN).append("+--------------+--------------------------------+---+------+\n");
            schoolBoard.append(ColorCli.RESET);
        }

        out.print(schoolBoard);
        schoolBoard.delete(0, schoolBoard.capacity());

    }

    @Override
    public void displayCharacterCard() {

    }


    @Override
    public void updateAssistantCard(AssistantCardUpdateMessage assistant) {
        lightGame.updateAssistantCard(assistant);
    }

    @Override
    public void updateCloud(CloudUpdateMessage cloud) {
        lightGame.updateCloud(cloud);
    }

    @Override
    public void updateIsland(IslandUpdateMessage island) {
        lightGame.updateIsland(island);
    }
    @Override
    public void updateEntrance(EntranceUpdateMessage entrance) {
        lightGame.updateEntrance(entrance);
    }

    @Override
    public void updateDiningRoom(DiningRoomUpdateMessage diningRoom) {
        lightGame.updateDiningRoom(diningRoom);
    }

    @Override
    public void updateProfTable(ProfTableUpdateMessage profTable) {
        lightGame.updateProfTable(profTable);
    }
    @Override
    public void updateTowerSpace(TowerSpaceUpdateMessage towerSpace) {
        lightGame.updateTowerSpace(towerSpace);
    }

    @Override
    public void updateCharacterCard(CharacterCardUpdateMessage characterCard) {
        lightGame.updateCharacterCard(characterCard);

    }

    @Override
    public void updateNickname(NicknameUpdateMessage m) {

    }

    @Override
    public void updateNumPlayers() {

    }

    @Override
    public void updateAll(AllUpdateMessage object) {

    }

    @Override
    public void selectCloud(int cloud) {

    }

    @Override
    public void selectAssistantCard(int assistant) {

    }

    @Override
    public void requestMoveMotherNature(int island) {

    }

    @Override
    public void updateMoveMotherNature(int island) {

    }

    @Override
    public void updatePawnToDining(int numDiningRoom, ArrayList<ColorPawn> arrayPawn) {

    }

    @Override
    public void updatePawnToIsland(int island, int numPawn, ArrayList<ColorPawn> arrayPawn) {

    }

    @Override
    public void registerClient(ClientAcceptedMessage m) {

    }

    @Override
    public void waitOtherPlayers(String object) {
        out.println(object);
    }

    @Override
    public void displayWinner(String winner){
        notifyMessage(new WinnerMessage(winner));
    }

    public void requestCloud() {
        out.println("Please select a cloud between 0 and "+ lightGame.getClouds().size() + ": ");
        int cloud = checkInteger();

        while(cloud < 0 || cloud > lightGame.getClouds().size()){
            out.println("Please select a cloud between 0 and "+ lightGame.getClouds().size() + ": ");
            cloud = checkInteger();
        }
        notifyMessage(new ChooseCloudMessage(cloud));
    }

    @Override
    public void displayWrongTurn(){
        out.println("It's not your turn!");
    }

    @Override
    public void displayFetchNameMessage() {

    }

    @Override
    public void displayNetError() {
    }

    @Override
    public void displayTurn(StartTurnMessage object) {
        out.println("\n");
        if(object.getCurrentPlayer().equals(actualPlayer)){
            out.println("It is your turn!");
            if(gameStart)
                displaySchoolBoard();

        }
    }

    @Override
    public void displayResponseMessage(String errorMessage) {

    }

    public void clearCli(){
        out.print(ColorCli.CLEAR);
        out.flush();
    }

    private String color4Island(int island, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("●: ").append(lightGame.getIslands().get(island).getGreenPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("●: ").append(lightGame.getIslands().get(island).getRedPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("●: ").append(lightGame.getIslands().get(island).getYellowPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("●: ").append(lightGame.getIslands().get(island).getPinkPawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("●: ").append(lightGame.getIslands().get(island).getBluePawn()).append("          ").append(ColorCli.BOLDCYAN);
        }
        return showColor.toString();
    }


    private String color4Clouds(int cloud, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("     ●: ").append(lightGame.getClouds().get(cloud).getGreenPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("     ●: ").append(lightGame.getClouds().get(cloud).getRedPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("     ●: ").append(lightGame.getClouds().get(cloud).getYellowPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("     ●: ").append(lightGame.getClouds().get(cloud).getPinkPawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("     ●: ").append(lightGame.getClouds().get(cloud).getBluePawn()).append("        ").append(ColorCli.BOLDCYAN);
        }
        return showColor.toString();
    }

    private String color4Entrance(LightPlayer player, int color){
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


    private String color4ProfTable(LightGame game, int color, int profOfPlayer){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            if(game.getProfTable().getGreenProf() == profOfPlayer)
                showColor.append(ColorCli.GREEN).append("❂");
            else showColor.append(ColorCli.GREEN).append("︎︎◌");
        }
        else if(color == 1){
            if(game.getProfTable().getRedProf() == profOfPlayer)
                showColor.append(ColorCli.RED).append("❂");
            else showColor.append(ColorCli.RED).append("︎︎◌");
        }
        else if(color == 2){
            if(game.getProfTable().getYellowProf() == profOfPlayer)
                showColor.append(ColorCli.YELLOW).append("❂");
            else showColor.append(ColorCli.YELLOW).append("◌");
        }
        else if(color == 3){
            if(game.getProfTable().getPinkProf() == profOfPlayer)
                showColor.append(ColorCli.PINK).append("❂");
            else showColor.append(ColorCli.PINK).append("◌");
        }
        else if(color == 4){
            if(game.getProfTable().getBlueProf() == profOfPlayer)
                showColor.append(ColorCli.BLUE).append("❂");
            else showColor.append(ColorCli.BLUE).append("◌");
        }
        return showColor.toString();
    }

    private String color4TowerSpace(int player, int numTower){
        StringBuilder showColor = new StringBuilder();
        if(player == 0){
            if(numTower > 1) {
                showColor.append(ColorCli.RESET).append("♖    ♖").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower == 1) {
                showColor.append(ColorCli.RESET).append("♖    ☒").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower <= 0)
                showColor.append(ColorCli.RESET).append("☒    ☒").append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }

        else if(player == 1){
            if(numTower > 1) {
                showColor.append(ColorCli.BLACK).append("♖    ♖").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower==1) {
                showColor.append(ColorCli.BLACK).append("♖    ☒").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower <= 0)
                showColor.append(ColorCli.BLACK).append("☒    ☒").append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }
        else if(player == 2){
            if(numTower > 1) {
                showColor.append(ColorCli.GREY).append("♖    ♖").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower==1) {
                showColor.append(ColorCli.GREY).append("♖    ☒").append(ColorCli.BOLDCYAN).append("|");
            }else if(numTower <= 0)
                showColor.append(ColorCli.GREY).append("☒    ☒").append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }
        return showColor.toString();
    }

    private String print1_4Index(){
        StringBuilder index = new StringBuilder();
        for(int i = 0; i < lightGame.getIslands().size() && i<4; i++)
            index.append("   ").append("Isola: ").append(i).append("   ");
        return index.toString();
    }

    private String print4_8Index(){
        StringBuilder index = new StringBuilder();
        if(lightGame.getIslands().size()>=4){
            for(int i = 4; i < lightGame.getIslands().size() && i<8; i++)
                index.append("   ").append("Isola: ").append(i).append("   ");
        }
        return index.toString();
    }

    private String print8_12Index(){
        StringBuilder index = new StringBuilder();
        if(lightGame.getIslands().size()>=8){
            for(int i = 8; i < lightGame.getIslands().size(); i++)
                index.append("   ").append("Isola: ").append(i).append("   ");
        }
        return index.toString();
    }


    @Override
    public void run() {

    }

    @Override
    public void displayWrongNickname(){

    }

   /* void updateNickname(NickUpdateMessage m){

    }*/