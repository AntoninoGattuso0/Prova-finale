package it.polimi.ingsw.view.Cli;


import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.ModelLight.LightPlayer;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.*;
import it.polimi.ingsw.view.View;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cli implements Runnable, View {
    Scanner scanner = new Scanner(System.in); //Per leggere input da tastiera
    private final PrintStream out;
    private Thread inputThread;
    private boolean isExpert;
    private boolean gameStart;
    private LightGame lightGame;
    private SocketNetworkHandler socketNetworkHandler;
    private String actualPlayer;
    private int pedineDaSpostare = 3;

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
        startGame();
    }

    public void askServerInfo() throws ExecutionException {
        Map<String, String> serverInfo = new HashMap<>();
        String defaultAddress = "localhost";
        String defaultPort = "5555";
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

        out.println("\n \n");

    }

    @Override
    public void requestNickname() {
        out.println("Digita il tuo nickname: ");
        try {
            String nickname = readLine();
            socketNetworkHandler.sendMessage(new RequestNickname(nickname));
        } catch (ExecutionException e) {
            out.println("ERRORE");
        }
    }

    @Override
    public void requestMovePawn(){
        while(pedineDaSpostare>0) {
            out.println("Digita 1 per usare una Character Card");
            out.println("Digita 2 per spostare delle pedine verso la DiningRoom");
            out.println("Digita 1 per spostare delle pedine verso un'Isola");
            int scelta = scanner.nextInt();
            if(scelta == 1)
        }
    }

    @Override
    public void requestMovePawnToDiningRoom() {
        out.println("Quante pedine vuoi spostare verso la DiningRoom?");
        int numDining = scanner.nextInt();
        out.println("Sposterai " + numDining + " pedine verso la DiningRoom");
        out.println("");
        ArrayList<ColorPawn> colori = new ArrayList<>();
        ColorPawn nomeColore = null;
        int i;
        for(i = 0; i<lightGame.getNumPlayers() && !(lightGame.getPlayers().get(i).getNickname().equals(actualPlayer)); i++);
        int player = i;
        for (i = 0; i < numDining; i++) {
            out.print("Scegli la pedina numero " + (i + 1) + " da spostare nella DiningRoom");
            out.println("Digita il nome corrispondente al colore: ");
            out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
            int colore = scanner.nextInt();
            boolean check = false;
            while(!check) {
                if (colore == 1 && lightGame.getPlayers().get(player).getEntrance().getGreenPawn() > 0) {
                    nomeColore = ColorPawn.GREEN;
                    check = true;
                } else if (colore == 2 && lightGame.getPlayers().get(player).getEntrance().getRedPawn() > 0) {
                    nomeColore = ColorPawn.RED;
                    check = true;
                } else if (colore == 3 && lightGame.getPlayers().get(player).getEntrance().getYellowPawn() > 0) {
                    nomeColore = ColorPawn.YELLOW;
                    check = true;
                } else if (colore == 4 && lightGame.getPlayers().get(player).getEntrance().getPinkPawn() > 0) {
                    nomeColore = ColorPawn.PINK;
                    check = true;
                } else if (colore == 5 && lightGame.getPlayers().get(player).getEntrance().getBluePawn() > 0) {
                    nomeColore = ColorPawn.BLUE;
                    check = true;
                } else {
                    out.println("Non hai pedine di questo colore, inserisci un altro colore: ");
                    colore = scanner.nextInt();
                }
            }
            colori.add(nomeColore);
            out.println("Hai spostato correttamente una pedina, ne rimangono: " + (i + 1) + "/" + numDining);
        }
        socketNetworkHandler.sendMessage(new MovePawnToDiningMessage(numDining, colori));
        out.println("");
    }

    @Override
    public void requestMovePawnToIsland() {
        out.println("Quante pedine vuoi spostare verso un'Isola?");
        int numPawn = scanner.nextInt();
        out.println("Verso quale isola vuoi spostarle? ");
        int numIsland = scanner.nextInt();
        while(numIsland<0 || numIsland>lightGame.getIslands().size()+1){
            out.println("Isola inesistente, inserisci un numero dell'isola corretto");
            numIsland = scanner.nextInt();
        }
        out.println("Sposterai " + numPawn + " pedine verso l'Isola numero " + numIsland);
        out.println();
        ArrayList<ColorPawn> colori = new ArrayList<>();
        ColorPawn nomeColore = null;
        int i;
        for(i = 0; i<lightGame.getNumPlayers() && !(lightGame.getPlayers().get(i).getNickname().equals(actualPlayer)); i++);
        int player = i;
        for (i = 0; i < numPawn; i++) {
            out.print("Scegli la pedina numero " + (i + 1) + " da spostare sull'Isola numero " + numIsland);
            out.println("Digita il nome corrispondente al colore: ");
            out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
            int colore = scanner.nextInt();
            boolean check = false;
            while(!check) {
                if (colore == 1 && lightGame.getPlayers().get(player).getEntrance().getGreenPawn() > 0) {
                    nomeColore = ColorPawn.GREEN;
                    check = true;
                } else if (colore == 2 && lightGame.getPlayers().get(player).getEntrance().getRedPawn() > 0) {
                    nomeColore = ColorPawn.RED;
                    check = true;
                } else if (colore == 3 && lightGame.getPlayers().get(player).getEntrance().getYellowPawn() > 0) {
                    nomeColore = ColorPawn.YELLOW;
                    check = true;
                } else if (colore == 4 && lightGame.getPlayers().get(player).getEntrance().getPinkPawn() > 0) {
                    nomeColore = ColorPawn.PINK;
                    check = true;
                } else if (colore == 5 && lightGame.getPlayers().get(player).getEntrance().getBluePawn() > 0) {
                    nomeColore = ColorPawn.BLUE;
                    check = true;
                } else {
                    out.println("Non hai pedine di questo colore, inserisci un altro colore: ");
                    colore = scanner.nextInt();
                }
            }
            colori.add(nomeColore);
            out.println("Hai spostato correttamente una pedina, ne rimangono: " + (i + 1) + "/" + numPawn);
        }
        socketNetworkHandler.sendMessage(new MovePawnToIslandMessage(numIsland, numPawn, colori));
        out.println("");
    }


    @Override
    public void newGameStart(){
        System.out.println("Siete tutti in lobby. il Game inizia!");
    }
    @Override
    public void requestNumPlayersIsExpert() {
        out.println("Inserisci il numero di giocatori (puoi inserire 2, 3 o 4 giocatori): ");
        try {
            int num=0;
            String numPlayer = readLine();
            while (!Objects.equals(numPlayer, "2") && !Objects.equals(numPlayer, "3") && !Objects.equals(numPlayer, "4")) {
                out.println("Inserisci il numero di giocatori (puoi inserire 2, 3 o 4 giocatori): ");
                numPlayer = readLine();
            }
            out.println("Inserisci E per variante esperta o B base");
            String exp = readLine();
            isExpert=false;
            while (!Objects.equals(exp, "B") && !Objects.equals(exp, "E")) {
                out.println("Inserisci E per variante esperta o B base");
                exp=readLine();
            }
            if (exp.equals("E")) {
                isExpert=true;
            }
            switch (numPlayer) {
                case "2" -> num = 2;
                case "3" -> num = 3;
                case "4" -> num = 4;
            }
            socketNetworkHandler.sendMessage(new RequestNumPlayersIsExpert(num, isExpert));
        } catch (ExecutionException e) {
            out.println("ERRORE");
        }
    }
    @Override
    public void displayNick() {
        for (int i = 0; i < lightGame.getNumPlayers(); i++) {
            out.println("Giocatore " + (i + 1) + " ha il nickname: " + lightGame.getPlayers().get(i).getNickname());
        }
    }
    @Override
    public void playerWait(){
        System.out.println("sei l'ultimo ad entrare in lobby!");
    }

    @Override
    public void displayNumPlayers() {
        out.println("Player totali: " + lightGame.getNumPlayers());
    }

    @Override
    public void displayIsExpert() {
        if (lightGame.getIsExpert())
            out.println("Il gioco è in modalità esperta");
        else
            out.println("Il gioco è in modalità normale");
    }

    @Override
    public void displayAssistantCard(int player) {
        clearCli();
        int i;
        for (i = 0; i < lightGame.getPlayers().get(player).getDeckAssistant().size(); i++) {
            out.println(ColorCli.BOLDCYAN + "| Card Value: " + ColorCli.RED + lightGame.getPlayers().get(player).getDeckAssistant().get(i).getCardValue() + ColorCli.BOLDCYAN + "         |");
            out.println(ColorCli.BOLDCYAN + "| MN steps: " + ColorCli.GREEN + lightGame.getPlayers().get(player).getDeckAssistant().get(i).getStep() + ColorCli.BOLDCYAN + "           |");
            out.println(ColorCli.BOLDCYAN + "+-----------------------+");
        }
        out.println("");
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
    public void sendNick(String nickname){
        String nick = nickname;
        if(nick!=null)
            socketNetworkHandler.sendMessage(new RequestNicknameAfterFirstLoginMessage(nick));
        }

    @Override
    public void requestCharacterCard(){
        for(int i = 0; i < 3; i++)
            displayCharacterCard(i);
        out.println("Scegli il CharacterCard da utilizzare: (inserisci un numero compreso tra 1 e 3)");
        int selected = scanner.nextInt();
        while(selected<0||selected>3){
            out.println("Numero errato, per favore inserisci un numero valido: ");
            selected = scanner.nextInt();
        }
        socketNetworkHandler.sendMessage(new c);

    }
    @Override
    public void displayCharacterCard(int num) {
        for(int i = 0; i < lightGame.getCharacterCards().size(); i++) {
            out.println("CharacterCard numero " + num + ":");
            if (lightGame.getCharacterCards().get(i).getNumCard() == 0) {
                out.println("");
                out.println("EFFETTO: Prendi 1 studente dalla carta e piazzalo su un'Isola a tua scelta. Poi pesca 1 studente dal sacchetto e mettilo su questa carta");
                out.println("Prezzo carta: " + lightGame.getAntonio().getCoinPrice() + "✪");
                out.println(ColorCli.GREEN + "●: " + lightGame.getAntonio().getGreenPawn());
                out.println(ColorCli.RED + "●: " + lightGame.getAntonio().getRedPawn());
                out.println(ColorCli.YELLOW + "●: " + lightGame.getAntonio().getYellowPawn());
                out.println(ColorCli.BLUE + "●: " + lightGame.getAntonio().getBluePawn());
                out.println(ColorCli.PINK + "●: " + lightGame.getAntonio().getPinkPawn() + ColorCli.RESET);
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 1) {
                out.println("");
                out.println("EFFETTO: Durante questo turno, prendi il controllo dei professori anche se nella tua Sala hai lo stesso numero di Studenti del giocatore che li controlla in quel momento");
                out.println("Prezzo carta: " + lightGame.getBarbara().getCoinPrice() + "✪");
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 2) {
                out.println("");
                out.println("EFFETTO: Scegli un'isola e calcola la maggioranza come se Madre Natura avesse terminato il suo movimento lì. In questo turno madre natura si muoverà come di consueto");
                out.println("Prezzo carta: " + lightGame.getCiro().getCoinPrice() + "✪");
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 3) {
                out.println("");
                out.println("Puoi muovere Madre Natura fino a 2 isole addizionali");
                out.println("Prezzo carta: " + lightGame.getDante().getCoinPrice() + "✪");
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 4) {
                out.println("");
                out.println("EFFETTO: Piazza una tessera Divieto su un'Isola a tua scelta. La prima volta che Madre Natura termina lì il suo movimento rimuovete la tessera Divieto SENZA calcolare l'influenza su quell'isola");
                out.println("Prezzo carta: " + lightGame.getErnesto().getCoinPrice() + "✪");
                out.println("Numero carte Divieto rimanenti: " + lightGame.getErnesto().getNumProhibitionCard());
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 5) {
                out.println("");
                out.println("EFFETTO: Durante il conteggio dell'influenza su in'Isola , le Torri presenti non vengono calcolate");
                out.println("Prezzo carta: " + lightGame.getFelix().getCoinPrice() + "✪");
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 6) {
                out.println("");
                out.println("EFFETTO: Poi prendere fino a 3 Studenti da questa carta e scambiarli con altrettanti Studenti presenti nel tuo Ingresso");
                out.println("Prezzo carta: " + lightGame.getGiuseppe().getCoinPrice() + "✪");
                out.println(ColorCli.GREEN + "●: " + lightGame.getGiuseppe().getNumGreenPawn());
                out.println(ColorCli.RED + "●: " + lightGame.getGiuseppe().getNumRedPawn());
                out.println(ColorCli.YELLOW + "●: " + lightGame.getGiuseppe().getNumYellowPawn());
                out.println(ColorCli.BLUE + "●: " + lightGame.getGiuseppe().getNumBluePawn());
                out.println(ColorCli.PINK + "●: " + lightGame.getGiuseppe().getNumPinkPawn() + ColorCli.RESET);
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 7) {
                out.println("");
                out.println("EFFETTO: in questo turno, durante il calcolo dell'influenza, hai 2 punti addizionali");
                out.println("Prezzo carta: " + lightGame.getIvan().getCoinPrice() + "✪");
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 8) {
                out.println("");
                out.println("EFFETTO: Scegli un colore Studente; in questo turno quel colore non fornisce influenza");
                out.println("Prezzo carta: " + lightGame.getLancillotto().getCoinPrice() + "✪");
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 9) {
                out.println("");
                out.println("EFFETTO: Puoi scabiare fino a 2 Studenti presenti nella tua Sala e nel tuo Ingresso");
                out.println("Prezzo carta: " + lightGame.getMaria().getCoinPrice() + "✪");
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 10) {
                out.println("");
                out.println("EFFETTO: Prendi 1 Studente da questa carta e piazzalo nella tua Sala. Poi pesca un nuovo Studente e posizionalo su questa carta");
                out.println("Prezzo carta: " + lightGame.getNicola().getCoinPrice() + "✪");
                out.println(ColorCli.GREEN + "●: " + lightGame.getNicola().getGreenPawn());
                out.println(ColorCli.RED + "●: " + lightGame.getNicola().getRedPawn());
                out.println(ColorCli.YELLOW + "●: " + lightGame.getNicola().getYellowPawn());
                out.println(ColorCli.BLUE + "●: " + lightGame.getNicola().getBluePawn());
                out.println(ColorCli.PINK + "●: " + lightGame.getNicola().getPinkPawn() + ColorCli.RESET);
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 11) {
                out.println("");
                out.println("EFFETTO: Scegli un colore di Studente; ogni giocatore (incluso te) deve rimettere nel sacchetto 3 studenti di quel colore presenti nella sua Sala");
                out.println("Prezzo carta: " + lightGame.getOmnia().getCoinPrice() + "✪");
                out.println("+-----------------------------------------------------+");
                out.println("");
            }
        }
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
    }

    @Override
    public void displayWrongTurn() {
        out.println("Non è il tuo turno, aspetta...");}

    @Override
    public void turnOrder(ArrayList<LightPlayer> players){
        //Funzione che stampa al player l'ordine di turno (ese: l'ordine di turno è: paolo, antonino, rebeca)
    }
    @Override
    public void displayTurn() {
        out.println("È il tuo turno! Puoi fare le tue mosse:");
    }

    @Override
    public void displayResponseMessage() {

    }
    @Override
    public void lobbyFull(){
        System.out.println("Sorry,lobby is full");
    }

    @Override
    public void updateAll(LightGame object) {
        this.lightGame = object;
        displayIslands();
        displayCloud();
        for(int i = 0; i < 3; i++)
            displayCharacterCard(i);
        displayNick();
        displaySchoolBoard();
        displayIsExpert();
        displayNumPlayers();
    }

    @Override
    public void selectCloud() {
        displayCloud();
        out.println("Scegli una delle nuvole presenti: ");
        int cloud = scanner.nextInt();
        while(cloud<1 || cloud > (lightGame.getClouds().size() + 1) || lightGame.getClouds().get(cloud - 1).getNumPawn() == 0){
            out.println("Numero nuvola errato OPPURE Nuvola Vuota. Inserisci un numero valido: ");
            cloud = scanner.nextInt();
        }
        socketNetworkHandler.sendMessage(new ChooseCloudMessage(cloud - 1)); //Penso sia carino che scelga le cloud partendo da 1 e non da 0
    }

    @Override
    public void selectAssistantCard(String nickname) {
        if (nickname.equals(socketNetworkHandler.getNicknameThisPlayer())) {
            int player, assistant = -1;
            for (player = 0; lightGame.getPlayers().get(player).getNickname().equals(actualPlayer); player++) ;
            displayAssistantCard(player);
            boolean check = false;
            while (!check) {
                out.println("Scegli uno degli Assistenti presenti: ");
                assistant = scanner.nextInt();
                for (int i = 0; i < lightGame.getPlayers().get(player).getDeckAssistant().size(); i++) {
                    if (lightGame.getPlayers().get(player).getDeckAssistant().get(i).getCardValue() == assistant)
                        check = true;
                }
            }
            socketNetworkHandler.sendMessage(new ChooseAssistantCardMessage(assistant));
        }else{
            System.out.println(nickname+" sta scegliendo l'AssistantCard");
        }
    }

    @Override
    public void requestMoveMotherNature() {
        out.println("Inserisci i passi da far fare a Madre Natura: ");
        //dunque dovrei capire come trovare il giocatore che vuole muovere MN, per ora ho messo 2 a caso ma non saprei
        int step = scanner.nextInt();
        while (step <= 0 || step > lightGame.getPlayers().get(2).getCurrentAssistant().getStep()) {
            out.println("Numero Errato! Inserisci i passi da far fare a Madre Natura: ");
            step = scanner.nextInt();
            socketNetworkHandler.sendMessage(new MoveMotherNatureMessage(step));
        }
    }


    @Override
    public void registerClient() {
        out.println("Il client è stato accettato");
    }

    @Override
    public void waitOtherPlayers() {
        out.println("Aspettando ulteriori giocatori...");
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