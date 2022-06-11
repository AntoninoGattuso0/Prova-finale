package it.polimi.ingsw.view.Cli;


import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.*;
import it.polimi.ingsw.view.View;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cli implements Runnable, View {
    Scanner scanner = new Scanner(System.in); //PER PAUL: QUI CI SONO LE RIGHE A CUI DEVI ANDARE IN LOBBY, LI' TI DIRO' COSA MODIFICARE: riga 337, riga 555,riga 1113,riga 1128.
    private final PrintStream out;          //se è possibile stampare gli assistenti uno accanto all'altro.
    private Thread inputThread;             //molto importante:non toccare per nessun motivo le funzioni al di fuori di quelle righe e non modificare cose che non sai cosa fanno. testa sempre il gioco prima di committare
    private boolean isExpert;
    private boolean gameStart;              //PRIMA di ogni messaggio di mossa chiedere se vuole giocare il characterCard
    private LightGame lightGame;              //nel controllo del movimento di pedine inserire il controllo che se in diningroom hanno 10 pedine già inserite, non ne può spostare altre
    private SocketNetworkHandler socketNetworkHandler;
    private String actualPlayer;
    private int pedineDaSpostare;
    private int numPawnMove;
    private ArrayList<String> orderPlayer;

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
            socketNetworkHandler.setNicknameThisPlayer(nickname);
        } catch (ExecutionException e) {
            out.println("ERRORE");
        }
    }

    @Override
    public void requestMovePawn(String nickname,int numPawnMoved){
        if(Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {
            displayIslands();
            displaySchoolBoard();
            pedineDaSpostare = pedineDaSpostare - numPawnMoved;//pedine che rimangono da spostare
            out.println("Digita 1 per usare una Character Card");
            out.println("Digita 2 per spostare delle pedine verso la DiningRoom");
            out.println("Digita 3 per spostare delle pedine verso un'Isola");
            int scelta = scanner.nextInt();
            while (scelta < 0 || scelta > 3) {
                out.println("Numero Errato!");
                out.println("Digita 1 per usare una Character Card");
                out.println("Digita 2 per spostare delle pedine verso la DiningRoom");
                out.println("Digita 3 per spostare delle pedine verso un'Isola");
                scelta = scanner.nextInt();
            }
            if (scelta == 1) requestCharacterCard(nickname,true);
            else if (scelta == 2)
                requestMovePawnToDiningRoom(pedineDaSpostare);//mando in ingresso il numero di pedine così controlli il numero che ti da in ingresso
            else if (scelta == 3) requestMovePawnToIsland(pedineDaSpostare);
            pedineDaSpostare = numPawnMove;
        }else{
            System.out.println(nickname+" sta spostando le pedine");
        }
    }

    @Override
    public void requestMovePawnToDiningRoom(int pedineDaSpostare) {
        out.println("Quante pedine vuoi spostare verso la DiningRoom? puoi spostare fino a " + pedineDaSpostare +" pedine.");// va fatto il controllo sul numero di pedine possibili da spostare
        int numDining = scanner.nextInt();
        while(numDining<1||numDining>pedineDaSpostare){
            out.println("stai cercando di spostare più pedine di quante sono consentite. inserisci un numero valido");
            numDining= scanner.nextInt();
        }
        out.println("Sposterai " + numDining + " pedine verso la DiningRoom");
        out.println("");
        ArrayList<ColorPawn> colori = new ArrayList<>();
        ColorPawn nomeColore = null;
        ArrayList<Integer> numPawn=new ArrayList<>();
        numPawn.add(0);
        numPawn.add(0);
        numPawn.add(0);
        numPawn.add(0);
        numPawn.add(0);
        int i;
        for(i = 0; i<lightGame.getNumPlayers() && !(lightGame.getPlayers().get(i).getNickname().equals(socketNetworkHandler.getNicknameThisPlayer())); i++);
        int player = i;
        for (i = 0; i < numDining; i++) {
            out.print("Scegli la pedina numero " + (i + 1) + " da spostare nella DiningRoom");
            out.println("Digita il nome corrispondente al colore: ");
            out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
            int colore = scanner.nextInt();
            boolean check = false;
            while(!check) {
                if (colore == 1 && lightGame.getPlayers().get(player).getEntrance().getGreenPawn() > numPawn.get(0)) {
                    nomeColore = ColorPawn.GREEN;
                    numPawn.set(0, numPawn.get(0)+1);
                    check = true;
                } else if (colore == 2 && lightGame.getPlayers().get(player).getEntrance().getRedPawn() > numPawn.get(1)) {
                    nomeColore = ColorPawn.RED;
                    numPawn.set(1, numPawn.get(1)+1);
                    check = true;
                } else if (colore == 3 && lightGame.getPlayers().get(player).getEntrance().getYellowPawn()> numPawn.get(2)) {
                    nomeColore = ColorPawn.YELLOW;
                    numPawn.set(2, numPawn.get(2)+1);
                    check = true;
                } else if (colore == 4 && lightGame.getPlayers().get(player).getEntrance().getPinkPawn() > numPawn.get(3)) {
                    nomeColore = ColorPawn.PINK;
                    numPawn.set(3, numPawn.get(3)+1);
                    check = true;
                } else if (colore == 5 && lightGame.getPlayers().get(player).getEntrance().getBluePawn() > numPawn.get(4)) {
                    nomeColore = ColorPawn.BLUE;
                    numPawn.set(4, numPawn.get(4)+1);
                    check = true;
                } else {
                    out.println("Non hai pedine di questo colore, inserisci un altro colore: ");
                    colore = scanner.nextInt();
                }
            }
            colori.add(nomeColore);
            out.println("Hai spostato correttamente una pedina, ne rimangono: " + (numDining-i) + "/" + numDining);//??? non lo fai qui lo spostamento!! se ci sono errori non li sposto!
        }
        socketNetworkHandler.sendMessage(new MovePawnToDiningMessage(numDining, colori));
        out.println("");
    }

    @Override
    public void requestMovePawnToIsland(int pedineDaSpostare) {
        ArrayList<Integer> numP=new ArrayList<>();
        numP.add(0);
        numP.add(0);
        numP.add(0);
        numP.add(0);
        numP.add(0);
        out.println("Quante pedine vuoi spostare verso un'Isola? puoi spostare fino a" + pedineDaSpostare +"pedine.");// serve il controllo sulle pedine possibili da spostare (pedinedaspostate)
        int numPawn = scanner.nextInt();
        while (numPawn<1||numPawn>pedineDaSpostare){
            out.println("stai cercando di spostare più pedine di quante sono consentite. inserisci un numero valido");
            numPawn=scanner.nextInt();
        }
        out.println("Verso quale isola vuoi spostarle? ");
        int numIsland = scanner.nextInt();
        while(numIsland<1 || numIsland>lightGame.getIslands().size()){
            out.println("Isola inesistente, inserisci un numero dell'isola corretto");
            numIsland = scanner.nextInt();
        }
        out.println("Sposterai " + numPawn + " pedine verso l'Isola numero " + (numIsland));
        out.println();
        ArrayList<ColorPawn> colori = new ArrayList<>();
        ColorPawn nomeColore = null;
        int i;
        for(i = 0; i<lightGame.getNumPlayers() && !(lightGame.getPlayers().get(i).getNickname().equals(socketNetworkHandler.getNicknameThisPlayer())); i++);
        int player = i;
        for (i = 0; i < numPawn; i++) {
            out.print("Scegli la pedina numero " + (i + 1) + " da spostare sull'Isola numero " + numIsland);
            out.println("Digita il nome corrispondente al colore: ");
            out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
            int colore = scanner.nextInt();
            boolean check = false;
            while(!check) {
                if (colore == 1 && lightGame.getPlayers().get(player).getEntrance().getGreenPawn() > numP.get(0)) {
                    nomeColore = ColorPawn.GREEN;
                    numP.set(0,numP.get(0)+1);
                    check = true;
                } else if (colore == 2 && lightGame.getPlayers().get(player).getEntrance().getRedPawn() > numP.get(1)) {
                    nomeColore = ColorPawn.RED;
                    numP.set(1,numP.get(1)+1);
                    check = true;
                } else if (colore == 3 && lightGame.getPlayers().get(player).getEntrance().getYellowPawn() > numP.get(2)) {
                    nomeColore = ColorPawn.YELLOW;
                    numP.set(2,numP.get(2)+1);
                    check = true;
                } else if (colore == 4 && lightGame.getPlayers().get(player).getEntrance().getPinkPawn() > numP.get(3)) {
                    nomeColore = ColorPawn.PINK;
                    numP.set(3,numP.get(3)+1);
                    check = true;
                } else if (colore == 5 && lightGame.getPlayers().get(player).getEntrance().getBluePawn() > numP.get(4)) {
                    nomeColore = ColorPawn.BLUE;
                    numP.set(4,numP.get(4)+1);
                    check = true;
                } else {
                    out.println("Non hai pedine di questo colore, inserisci un altro colore: ");
                    colore = scanner.nextInt();
                }
            }
            colori.add(nomeColore);
            out.println("Hai scelto correttamente una pedina, ne rimangono: " + (numPawn-i-1) + "/" + numPawn);
        }
        socketNetworkHandler.sendMessage(new MovePawnToIslandMessage(numIsland-1, numPawn, colori));
    }


    @Override
    public void newGameStart(){
        System.out.println("Siete tutti in lobby. Il Game inizia!");
        displayAll();
        if(lightGame.getNumPlayers()==2||lightGame.getNumPlayers()==4){
            pedineDaSpostare=3;
            numPawnMove=3;
        }else{
            pedineDaSpostare=4;
            numPawnMove=4;
        }
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
                if (lightGame.getPlayers().get(player).getDeckAssistant().get(i).getCardValue() == 10) {
                    out.println(ColorCli.BOLDCYAN + "| Card Value: " + ColorCli.RED + lightGame.getPlayers().get(player).getDeckAssistant().get(i).getCardValue() + ColorCli.BOLDCYAN + "        |");
                    out.println(ColorCli.BOLDCYAN + "| MN steps: " + ColorCli.GREEN + lightGame.getPlayers().get(player).getDeckAssistant().get(i).getStep() + ColorCli.BOLDCYAN + "           |");
                    out.println(ColorCli.BOLDCYAN + "+-----------------------+");
                } else {
                    out.println(ColorCli.BOLDCYAN + "| Card Value: " + ColorCli.RED + lightGame.getPlayers().get(player).getDeckAssistant().get(i).getCardValue() + ColorCli.BOLDCYAN + "         |");
                    out.println(ColorCli.BOLDCYAN + "| MN steps: " + ColorCli.GREEN + lightGame.getPlayers().get(player).getDeckAssistant().get(i).getStep() + ColorCli.BOLDCYAN + "           |");
                    out.println(ColorCli.BOLDCYAN + "+-----------------------+");
                }
                out.println("");
        }
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
        for (int j = 0; j < 6; j++) {
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
        for (int j = 0; j < 6; j++) {
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
        for (int j = 0; j < 6; j++) {
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

        for(i = 0; i < lightGame.getNumPlayers(); i++ ) {
            StringBuilder schoolBoard = new StringBuilder();
            out.println(" ");
            out.println(" ");
            schoolBoard.append(ColorCli.BOLDCYAN);

            schoolBoard.append("Player: " + lightGame.getPlayers().get(i).getNickname()).append("\n").append("+--------------+--------------------------------+---+\n");
            for (int j = 0; j < 5; j++)
                schoolBoard.append("|").append(color4Entrance(i, j));
            out.println(schoolBoard);
            out.println();
        }
    }
    @Override
    public void sendNick(String nickname){
        String nick = nickname;
        if(nick!=null)
            socketNetworkHandler.sendMessage(new RequestNicknameAfterFirstLoginMessage(nick));
        }

    @Override
    public void requestCharacterCard(String nickname,boolean bool) {//Gestire il fatto di dirgli quante pedine ha e che in caso le sue monete non bastino non gli fa proprio scegliere le character, se invece c'è qualche carta che costa meno e qualcuna che costa di più fargli inserire la possibilità di non giocarne nessuna o inserirne una nuova
        ArrayList<ColorPawn> colori=new ArrayList<>();//AGGIUNGI CONTROLLO PRIMA DI SPOSTARE LE PEDINE (CONTROLLA CHE CI SIANO PEDINE ES. NELLA DINING)
        int numPawn = -1, numIsland = -1, i;//gestire il fatto che alcune carachter non possono essere giocate se non ci sono abbastanza pedine in sla/isole/diningroom. in questo caso devi inviare un messaggio tipo "non ci sono abbastanza pedine " e poi gestire come la riga sopra
        if (Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {// controllare anche come vengono gestiti: mi ha chiamato felix quando non era la sua carta. come mai? il problema potrebbe essere di model o di qualche int-1. ma meglio controllare anche la cli
            if (!bool) {
                boolean check = false;
                String b = null;
                System.out.println("Vuoi giocare un CharacterCard? SI per giocarlo, NO per saltare questa fase");
                while (!check) {
                    try {
                        b = readLine();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    if (Objects.equals(b, "SI")) {
                        check = true;
                        bool = true;
                    } else if (Objects.equals(b, "NO")) {
                        check = true;
                    } else {
                        System.out.println("Errore in inserimento: inserire SI o NO");
                    }
                }

            }
            if (bool) {
                displayCharacterCard();
                out.println("Scegli il CharacterCard da utilizzare: (inserisci un numero compreso tra 1 e 3)");
                String selectedString = null;
                int selected = -1;
                try {
                    selectedString = readLine();
                    selected = convertStringToNumber(selectedString);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                while (selected < 0 || selected > 3) {
                    out.println("Numero errato, per favore inserisci un numero valido: ");
                    try {
                        selectedString = readLine();
                        selected = convertStringToNumber(selectedString);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                selected = selected - 1;
                for (i = 0; i < lightGame.getNumPlayers() && !(lightGame.getPlayers().get(i).getNickname().equals(nickname)); i++);
                int player = i;//giocatore

                if (lightGame.getCharacterCards().get(selected).getNumCard() == 0) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getAntonio().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getAntonio().getCoinPrice());
                        out.println("Scegli il colore di uno studente presente sulla carta  da spostare su un'Isola ");
                        out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                        int colore = -1;
                        String coloreString = null;
                        try {
                            coloreString = readLine();
                            colore = convertStringToNumber(coloreString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        ColorPawn nomeColore = null;
                        boolean check = false;
                        while (!check) {
                            if (colore == 1 && lightGame.getAntonio().getGreenPawn() > 0) {
                                nomeColore = ColorPawn.GREEN;
                                check = true;
                            } else if (colore == 2 && lightGame.getAntonio().getRedPawn() > 0) {
                                nomeColore = ColorPawn.RED;
                                check = true;
                            } else if (colore == 3 && lightGame.getAntonio().getYellowPawn() > 0) {
                                nomeColore = ColorPawn.YELLOW;
                                check = true;
                            } else if (colore == 4 && lightGame.getAntonio().getPinkPawn() > 0) {
                                nomeColore = ColorPawn.PINK;
                                check = true;
                            } else if (colore == 5 && lightGame.getAntonio().getBluePawn() > 0) {
                                nomeColore = ColorPawn.BLUE;
                                check = true;
                            } else {
                                out.println("Non ci sono pedine di questo colore, inserisci un altro colore: ");
                                try {
                                    coloreString = readLine();
                                    colore = convertStringToNumber(coloreString);
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        check = false;
                        out.println("Inserisci il numero dell'isola su cui spostate la pedina: (tra 1 e  "+lightGame.getIslands().size()+")");
                        while(!check){
                            String numIslandString = null;
                            try {
                                numIslandString = readLine();
                            }catch(ExecutionException e){
                                out.println(e);
                            }
                            numIsland = convertStringToNumber(numIslandString);
                            if(!(numIsland<1 || numIsland > lightGame.getIslands().size())){
                                check = true;
                                numIsland = numIsland-1;
                            }
                            else
                                out.println("Numero isola non corretto, inserisci un numero valido (tra 1 e "+lightGame.getIslands().size()+")");
                        }
                        colori.add(nomeColore);
                        numPawn = 1;
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 1) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getBarbara().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getBarbara().getCoinPrice());
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 2) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getCiro().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getCiro().getCoinPrice());
                        out.println("Scegli un'Isola (puoi scegliere un numero tra 1 e " + lightGame.getIslands().size() + "):");
                        String numIslandString = null;
                        try {
                            numIslandString = readLine();
                            numIsland = convertStringToNumber(numIslandString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        while (numIsland < 1 || numIsland > lightGame.getIslands().size()) {
                            out.println("Numero isola inesistente, inserisci un numero valido: (puoi scegliere un numero tra 1 e " + lightGame.getIslands().size() + "):");
                            try {
                                numIslandString = readLine();
                                numIsland = convertStringToNumber(numIslandString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        numIsland = numIsland - 1;
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 3) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getDante().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getDante().getCoinPrice());
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 4) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getErnesto().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getErnesto().getCoinPrice());
                        out.println("Scegli l'Isola su cui piazzare una tessera Divieto (puoi scegliere un numero tra 1 e " + lightGame.getIslands().size() + "):");
                        String numIslandString = null;
                        try {
                            numIslandString = readLine();
                            numIsland = convertStringToNumber(numIslandString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        while (numIsland < 1 || numIsland > lightGame.getIslands().size()) {
                            out.println("Numero isola inesistente, inserisci un numero valido: (puoi scegliere un numero tra 1 e " + lightGame.getIslands().size() + "):");
                            try {
                                numIslandString = readLine();
                                numIsland = convertStringToNumber(numIslandString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 5) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getFelix().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getFelix().getCoinPrice());
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 6) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getGiuseppe().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getGiuseppe().getCoinPrice());
                        out.println("Quanti studenti vuoi spostare da questa Carta al tuo Ingresso e viceversa? Puoi scegliere un numero tra 1 e 3");
                        String numPawnString = null;
                        try {
                            numPawnString = readLine();
                            numPawn = convertStringToNumber(numPawnString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        while (numPawn < 1 || numPawn > 3) {
                            out.println("Numero errato, inserisci un numero tra 1 e 3: ");
                            try {
                                numPawnString = readLine();
                                numPawn = convertStringToNumber(numPawnString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        if (numPawn > (lightGame.getPlayers().get(player).getEntrance().getGreenPawn() + lightGame.getPlayers().get(player).getEntrance().getRedPawn() + lightGame.getPlayers().get(player).getEntrance().getYellowPawn() + lightGame.getPlayers().get(player).getEntrance().getPinkPawn() + lightGame.getPlayers().get(player).getEntrance().getBluePawn()) || numPawn > (lightGame.getPlayers().get(player).getDiningRoom().getNumGreen() + lightGame.getPlayers().get(player).getDiningRoom().getNumRed() + lightGame.getPlayers().get(player).getDiningRoom().getNumYellow() + lightGame.getPlayers().get(player).getDiningRoom().getNumPink() + lightGame.getPlayers().get(player).getDiningRoom().getNumBlue())) {
                            out.println("Non hai abbastanza pedine da spostare!");
                            requestMovePawn(nickname, pedineDaSpostare);
                        } else {
                            for (int j = 0; j < numPawn; j++) {
                                out.println("Seleziona il colore dello studente " + (i + 1) + "/" + numPawn + " da spostare da questa Carta al tuo Ingresso");
                                out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                                int colore = -1;
                                String coloreString;
                                try {
                                    coloreString = readLine();
                                    colore = convertStringToNumber(coloreString);
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
                                ColorPawn nomeColore = null;
                                boolean check = false;
                                while (!check) {
                                    if (colore == 1 && lightGame.getGiuseppe().getNumGreenPawn() > 0) {
                                        nomeColore = ColorPawn.GREEN;
                                        check = true;
                                    } else if (colore == 2 && lightGame.getGiuseppe().getNumRedPawn() > 0) {
                                        nomeColore = ColorPawn.RED;
                                        check = true;
                                    } else if (colore == 3 && lightGame.getGiuseppe().getNumYellowPawn() > 0) {
                                        nomeColore = ColorPawn.YELLOW;
                                        check = true;
                                    } else if (colore == 4 && lightGame.getGiuseppe().getNumPinkPawn() > 0) {
                                        nomeColore = ColorPawn.PINK;
                                        check = true;
                                    } else if (colore == 5 && lightGame.getGiuseppe().getNumBluePawn() > 0) {
                                        nomeColore = ColorPawn.BLUE;
                                        check = true;
                                    } else {
                                        out.println("Non ci sono pedine di questo colore, inserisci un altro colore: ");
                                        try {
                                            coloreString = readLine();
                                            colore = convertStringToNumber(coloreString);
                                        } catch (ExecutionException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                colori.add(nomeColore);
                            }
                            for (int j = 0; j < numPawn; j++) {
                                out.println("Seleziona il colore dello studente " + (i + 1) + "/" + numPawn + " da spostare dal tuo Ingresso su questa Carta");
                                out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                                int colore = -1;
                                String coloreString;
                                try {
                                    coloreString = readLine();
                                    colore = convertStringToNumber(coloreString);
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
                                ColorPawn nomeColore = null;
                                boolean check = false;
                                while (!check) {
                                    if (colore == 1 && lightGame.getPlayers().get(player).getDiningRoom().getNumGreen() > 0) {
                                        nomeColore = ColorPawn.GREEN;
                                        check = true;
                                    } else if (colore == 2 && lightGame.getPlayers().get(player).getDiningRoom().getNumRed() > 0) {
                                        nomeColore = ColorPawn.RED;
                                        check = true;
                                    } else if (colore == 3 && lightGame.getPlayers().get(player).getDiningRoom().getNumYellow() > 0) {
                                        nomeColore = ColorPawn.YELLOW;
                                        check = true;
                                    } else if (colore == 4 && lightGame.getPlayers().get(player).getDiningRoom().getNumPink() > 0) {
                                        nomeColore = ColorPawn.PINK;
                                        check = true;
                                    } else if (colore == 5 && lightGame.getPlayers().get(player).getDiningRoom().getNumBlue() > 0) {
                                        nomeColore = ColorPawn.BLUE;
                                        check = true;
                                    } else {
                                        out.println("Non ci sono pedine di questo colore, inserisci un altro colore: ");
                                        try {
                                            coloreString = readLine();
                                            colore = convertStringToNumber(coloreString);
                                        } catch (ExecutionException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                colori.add(nomeColore);
                            }
                            socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
                        }
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 7) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getIvan().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getIvan().getCoinPrice());
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }
                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 8) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getLancillotto().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getLancillotto().getCoinPrice());
                        out.println("Scegli un colore da non conteggiare nell'influenza di questo turno: ");
                        out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                        int colore = -1;
                        String coloreString;
                        try {
                            coloreString = readLine();
                            colore = convertStringToNumber(coloreString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        ColorPawn nomeColore = null;
                        if (colore == 1 && lightGame.getAntonio().getGreenPawn() > 0) {
                            nomeColore = ColorPawn.GREEN;
                        } else if (colore == 2 && lightGame.getAntonio().getRedPawn() > 0) {
                            nomeColore = ColorPawn.RED;
                        } else if (colore == 3 && lightGame.getAntonio().getYellowPawn() > 0) {
                            nomeColore = ColorPawn.YELLOW;
                        } else if (colore == 4 && lightGame.getAntonio().getPinkPawn() > 0) {
                            nomeColore = ColorPawn.PINK;
                        } else if (colore == 5 && lightGame.getAntonio().getBluePawn() > 0) {
                            nomeColore = ColorPawn.BLUE;
                        }
                        colori.add(nomeColore);
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }
                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 9) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getMaria().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getMaria().getCoinPrice());
                        out.println("Scegli quanti studenti vuoi scambiare tra il tuo Ingresso e la tua Diningroom (puoi scegliere un numero tra 1 e 2): ");
                        String numPawnString;
                        try {
                            numPawnString = readLine();
                            numPawn = convertStringToNumber(numPawnString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        while (numPawn < 1 || numPawn > 2) {
                            out.println("Numero errato, inserisci un numero tra 1 e 2: ");
                            try {
                                numPawnString = readLine();
                                numPawn = convertStringToNumber(numPawnString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        if (numPawn > (lightGame.getPlayers().get(player).getDiningRoom().getNumGreen() + lightGame.getPlayers().get(player).getDiningRoom().getNumRed() + lightGame.getPlayers().get(player).getDiningRoom().getNumYellow() + lightGame.getPlayers().get(player).getDiningRoom().getNumPink() + lightGame.getPlayers().get(player).getDiningRoom().getNumBlue())) {
                            out.println("Numero non sufficiente di pedine nella DiningRoom");
                            requestMovePawn(nickname, pedineDaSpostare);
                        } else {
                            for (i = 0; i < numPawn; i++) {
                                out.println("Seleziona il colore dello studente " + (i + 1) + "/" + numPawn + " da spostare dal tuo Ingresso alla DiningRoom");
                                out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                                int colore = -1;
                                String coloreString;
                                try {
                                    coloreString = readLine();
                                    colore = convertStringToNumber(coloreString);
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
                                ColorPawn nomeColore = null;
                                boolean check = false;
                                while (!check) {
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
                                        out.println("Non ci sono pedine di questo colore, inserisci un altro colore: ");
                                        try {
                                            coloreString = readLine();
                                            colore = convertStringToNumber(coloreString);
                                        } catch (ExecutionException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                colori.add(nomeColore);
                            }
                            for (i = 0; i < numPawn; i++) {
                                out.println("Seleziona il colore dello studente " + (i + 1) + "/" + numPawn + " da spostare dalla DiningRoome al tuo Ingresso");
                                out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                                int colore = -1;
                                String coloreString;
                                try {
                                    coloreString = readLine();
                                    colore = convertStringToNumber(coloreString);
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
                                ColorPawn nomeColore = null;
                                boolean check = false;
                                while (!check) {
                                    if (colore == 1 && lightGame.getPlayers().get(player).getDiningRoom().getNumGreen() > 0) {
                                        nomeColore = ColorPawn.GREEN;
                                        check = true;
                                    } else if (colore == 2 && lightGame.getPlayers().get(player).getDiningRoom().getNumRed() > 0) {
                                        nomeColore = ColorPawn.RED;
                                        check = true;
                                    } else if (colore == 3 && lightGame.getPlayers().get(player).getDiningRoom().getNumYellow() > 0) {
                                        nomeColore = ColorPawn.YELLOW;
                                        check = true;
                                    } else if (colore == 4 && lightGame.getPlayers().get(player).getDiningRoom().getNumPink() > 0) {
                                        nomeColore = ColorPawn.PINK;
                                        check = true;
                                    } else if (colore == 5 && lightGame.getPlayers().get(player).getDiningRoom().getNumBlue() > 0) {
                                        nomeColore = ColorPawn.BLUE;
                                        check = true;
                                    } else {
                                        out.println("Non ci sono pedine di questo colore, inserisci un altro colore: ");
                                        try {
                                            coloreString = readLine();
                                            colore = convertStringToNumber(coloreString);
                                        } catch (ExecutionException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                colori.add(nomeColore);
                            }
                            socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
                        }
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 10) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getNicola().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getNicola().getCoinPrice());
                        out.println("Scegli uno studente da questa Carta e posizionalo nella tua DiningRoom: ");
                        out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                        int colore = -1;
                        String coloreString;
                        try {
                            coloreString = readLine();
                            colore = convertStringToNumber(coloreString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        ColorPawn nomeColore = null;
                        boolean check = false;
                        while (!check) {
                            if (colore == 1 && lightGame.getNicola().getGreenPawn() > 0) {
                                nomeColore = ColorPawn.GREEN;
                                check = true;
                            } else if (colore == 2 && lightGame.getNicola().getRedPawn() > 0) {
                                nomeColore = ColorPawn.RED;
                                check = true;
                            } else if (colore == 3 && lightGame.getNicola().getYellowPawn() > 0) {
                                nomeColore = ColorPawn.YELLOW;
                                check = true;
                            } else if (colore == 4 && lightGame.getNicola().getPinkPawn() > 0) {
                                nomeColore = ColorPawn.PINK;
                                check = true;
                            } else if (colore == 5 && lightGame.getNicola().getBluePawn() > 0) {
                                nomeColore = ColorPawn.BLUE;
                                check = true;
                            } else {
                                out.println("Non ci sono pedine di questo colore, inserisci un altro colore: ");
                                try {
                                    coloreString = readLine();
                                    colore = convertStringToNumber(coloreString);
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        colori.add(nomeColore);
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }

                } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 11) {
                    if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getOmnia().getCoinPrice()) {
                        out.println("Non hai abbastanza Coin per usare questa carta");
                        requestMovePawn(nickname, pedineDaSpostare);
                    } else {
                        lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getOmnia().getCoinPrice());
                        out.println("Scegli un Colore: ogni giocatore rimetterà nel sacchetto 3 Studenti dalla propria DiningRoom di quel Colore");
                        out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                        int colore = -1;
                        String coloreString;
                        try {
                            coloreString = readLine();
                            colore = convertStringToNumber(coloreString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        ColorPawn nomeColore = null;
                        boolean check = false;
                        while(!check) {
                            if (colore == 1) {
                                nomeColore = ColorPawn.GREEN;
                                check = true;
                            } else if (colore == 2) {
                                nomeColore = ColorPawn.RED;
                                check = true;
                            } else if (colore == 3) {
                                nomeColore = ColorPawn.YELLOW;
                                check = true;
                            } else if (colore == 4) {
                                nomeColore = ColorPawn.PINK;
                                check = true;
                            } else if (colore == 5) {
                                nomeColore = ColorPawn.BLUE;
                                check = true;
                            } else {
                                out.println("Colore inesistente, inserisci un colore corretto:");
                                out.println(ColorCli.GREEN + "1●" + "   " + ColorCli.RED + "2●" + "   " + ColorCli.YELLOW + "3●" + "   " + ColorCli.PINK + "4●" + "   " + ColorCli.BLUE + "5●" + ColorCli.RESET);
                                try {
                                    coloreString = readLine();
                                    colore = convertStringToNumber(coloreString);
                                } catch (ExecutionException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        colori.add(nomeColore);
                        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori,bool));
                    }
                }
            } else {
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0,0,0,colori,bool));
            }
        }else{
            System.out.println(nickname + " sta giocando la fase CharacterCard");
        }
    }
    @Override
    public void displayCharacterCard() {
        for(int i = 0; i < lightGame.getCharacterCards().size(); i++) {
            out.println("CharacterCard numero " + (i+1) + ":");
            if (lightGame.getCharacterCards().get(i).getNumCard() == 0) {
                out.println("");
                out.println("EFFETTO: Prendi 1 studente dalla carta e piazzalo su un'Isola a tua scelta. Poi pesca 1 studente dal sacchetto e mettilo su questa carta");
                out.println("Prezzo carta: " + lightGame.getAntonio().getCoinPrice() + "✪");
                out.println(ColorCli.GREEN + "●: " + lightGame.getAntonio().getGreenPawn());
                out.println(ColorCli.RED + "●: " + lightGame.getAntonio().getRedPawn());
                out.println(ColorCli.YELLOW + "●: " + lightGame.getAntonio().getYellowPawn());
                out.println(ColorCli.PINK + "●: " + lightGame.getAntonio().getPinkPawn());
                out.println(ColorCli.BLUE + "●: " + lightGame.getAntonio().getBluePawn() + ColorCli.RESET);
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println();
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 1) {
                out.println("");
                out.println("EFFETTO: Durante questo turno, prendi il controllo dei professori anche se nella tua Sala hai lo stesso numero di Studenti del giocatore che li controlla in quel momento");
                out.println("Prezzo carta: " + lightGame.getBarbara().getCoinPrice() + "✪");
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 2) {
                out.println("");
                out.println("EFFETTO: Scegli un'isola e calcola la maggioranza come se Madre Natura avesse terminato il suo movimento lì. In questo turno madre natura si muoverà come di consueto");
                out.println("Prezzo carta: " + lightGame.getCiro().getCoinPrice() + "✪");
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 3) {
                out.println("");
                out.println("Puoi muovere Madre Natura fino a 2 isole addizionali");
                out.println("Prezzo carta: " + lightGame.getDante().getCoinPrice() + "✪");
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 4) {
                out.println("");
                out.println("EFFETTO: Piazza una tessera Divieto su un'Isola a tua scelta. La prima volta che Madre Natura termina lì il suo movimento rimuovete la tessera Divieto SENZA calcolare l'influenza su quell'isola");
                out.println("Prezzo carta: " + lightGame.getErnesto().getCoinPrice() + "✪");
                out.println("Numero carte Divieto rimanenti: " + lightGame.getErnesto().getNumProhibitionCard());
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 5) {
                out.println("");
                out.println("EFFETTO: Durante il conteggio dell'influenza su in'Isola , le Torri presenti non vengono calcolate");
                out.println("Prezzo carta: " + lightGame.getFelix().getCoinPrice() + "✪");
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 6) {
                out.println("");
                out.println("EFFETTO: Poi prendere fino a 3 Studenti da questa carta e scambiarli con altrettanti Studenti presenti nel tuo Ingresso");
                out.println("Prezzo carta: " + lightGame.getGiuseppe().getCoinPrice() + "✪");
                out.println(ColorCli.GREEN + "●: " + lightGame.getGiuseppe().getNumGreenPawn());
                out.println(ColorCli.RED + "●: " + lightGame.getGiuseppe().getNumRedPawn());
                out.println(ColorCli.YELLOW + "●: " + lightGame.getGiuseppe().getNumYellowPawn());
                out.println(ColorCli.PINK + "●: " + lightGame.getGiuseppe().getNumPinkPawn());
                out.println(ColorCli.BLUE + "●: " + lightGame.getGiuseppe().getNumBluePawn() + ColorCli.RESET);
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 7) {
                out.println("");
                out.println("EFFETTO: in questo turno, durante il calcolo dell'influenza, hai 2 punti addizionali");
                out.println("Prezzo carta: " + lightGame.getIvan().getCoinPrice() + "✪");
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 8) {
                out.println("");
                out.println("EFFETTO: Scegli un colore Studente; in questo turno quel colore non fornisce influenza");
                out.println("Prezzo carta: " + lightGame.getLancillotto().getCoinPrice() + "✪");
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 9) {
                out.println("");
                out.println("EFFETTO: Puoi scabiare fino a 2 Studenti presenti nella tua Sala e nel tuo Ingresso");
                out.println("Prezzo carta: " + lightGame.getMaria().getCoinPrice() + "✪");
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 10) {
                out.println("");
                out.println("EFFETTO: Prendi 1 Studente da questa carta e piazzalo nella tua Sala. Poi pesca un nuovo Studente e posizionalo su questa carta");
                out.println("Prezzo carta: " + lightGame.getNicola().getCoinPrice() + "✪");
                out.println(ColorCli.GREEN + "●: " + lightGame.getNicola().getGreenPawn());
                out.println(ColorCli.RED + "●: " + lightGame.getNicola().getRedPawn());
                out.println(ColorCli.YELLOW + "●: " + lightGame.getNicola().getYellowPawn());
                out.println(ColorCli.PINK + "●: " + lightGame.getNicola().getPinkPawn());
                out.println(ColorCli.BLUE + "●: " + lightGame.getNicola().getBluePawn()+ ColorCli.RESET);
                out.println();
                out.println("+-----------------------------------------------------+");
                out.println("");
            } else if (lightGame.getCharacterCards().get(i).getNumCard() == 11) {
                out.println("");
                out.println("EFFETTO: Scegli un colore di Studente; ogni giocatore (incluso te) deve rimettere nel sacchetto 3 studenti di quel colore presenti nella sua Sala");
                out.println("Prezzo carta: " + lightGame.getOmnia().getCoinPrice() + "✪");
                out.println();
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
    public void turnOrder(ArrayList<String> orderNamePlayers){
        out.println(ColorCli.RESET);
        out.println("L'ordine dei giocatori per questo round è: ");
        for(int i = 0; i<orderNamePlayers.size(); i++){
            out.println((i+1) + ") " + orderNamePlayers.get(i));
        }
    }

    @Override
    public void startTurn(ArrayList<String> players, String player) {
        if (Objects.equals(player, socketNetworkHandler.getNicknameThisPlayer())) {
            displayEndTurn();
        }
        int i;
        int j;
        for (j = 0; !Objects.equals(players.get(j), player); j++) ;
        if (j< players.size()-1) {
            for (i = j; Objects.equals(players.get(i), player); i++) ;
            if (Objects.equals(players.get(i), socketNetworkHandler.getNicknameThisPlayer())) {
                displayStartTurn();
            } else
                out.println(players.get(i) + " sta iniziando il suo turno");
        }else{
            out.println("round finito, inizia uno nuovo");
        }
    }

    @Override
    public void displayDisconnection(String playerDisconnected) {
        if(Objects.equals(playerDisconnected, socketNetworkHandler.getNicknameThisPlayer())){

        }else{
            socketNetworkHandler.sendMessage(new iHaveToDisconnectMessage(socketNetworkHandler.getNicknameThisPlayer()));
        }
    }

    @Override
    public void displayStartTurn() {
        out.println("È il tuo turno! Puoi fare le tue mosse:");
    }
    public void displayEndTurn(){
        out.println("il tuo turno è finito.");
    }
    @Override
    public void displayEndRound(){
        out.println("il round è finito");
    }
    @Override
    public void displayResponseMessage() {

    }
    @Override
    public void displayAll(){
        displayIslands();
        displayCloud();
        out.println();
        out.println();
        displayCharacterCard();
        displayNick();
        out.println();
        displaySchoolBoard();
        displayIsExpert();
        displayNumPlayers();
    }
    @Override
    public void lobbyFull(){
        System.out.println("Sorry,lobby is full");
    }
    @Override
    public void updateAll(LightGame object) {
        this.lightGame = object;
    }

    @Override
    public void selectCloud(String nickname) {//inserire quali sono le cloud non vuote
        if (Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {
            displayCloud();
            out.println("Scegli una delle nuvole presenti: ");
            int cloud = scanner.nextInt();
            while (cloud < 1 || cloud > (lightGame.getClouds().size() + 1) || lightGame.getClouds().get(cloud - 1).getNumPawn() == 0) {
                out.println("Numero nuvola errato OPPURE Nuvola Vuota. Inserisci un numero valido: ");
                cloud = scanner.nextInt();
            }
            socketNetworkHandler.sendMessage(new ChooseCloudMessage(cloud - 1)); //Penso sia carino che scelga le cloud partendo da 1 e non da 0
        }else{
            out.println(nickname +" sta scegliendo la cloud");
        }
    }
    @Override
    public void selectAssistantCard(String nickname) {
        int i,m=-1;// SE HAI UN IDEA MIGLIORE DIMMELO PERCHE' ANCORA NON HO MODIFICATO LA FUNZIONE DEL PLAYER E QUESTA NON MI SE,BRA NEMMENO LA MIGLIORE
        int numAssistant = -1;//dire anche quali sono gli assistenti giocati dagli altri in quel turno.
        if (Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {
            for (i = 0; !Objects.equals(lightGame.getPlayers().get(i).getNickname(), nickname); i++) ;
            displayAssistantCard(i);
            boolean check = false;
            out.println("Scegli uno degli Assistenti presenti: ");
            while (!check) {
                String assistant = null;
                try {
                    assistant = readLine();
                    numAssistant = convertStringToNumber(assistant);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                int j;
                boolean check1 = false;
                for (j = 0; j < lightGame.getPlayers().get(i).getDeckAssistant().size() && !check1; j++) {
                    if (lightGame.getPlayers().get(i).getDeckAssistant().get(j).getCardValue() == numAssistant) {
                        check1 = true;
                        m=j;
                    }
                }
                boolean check2 = true;
                if (check1) {
                    for (j = 0; j < lightGame.getPlayers().size()&& check2; j++) {
                            if ((lightGame.getPlayers().get(j).getCurrentAssistant()!=null)&&Objects.equals(lightGame.getPlayers().get(i).getDeckAssistant().get(m).getCardValue(), lightGame.getPlayers().get(j).getCurrentAssistant().getCardValue()) && (lightGame.getPlayers().get(i).getDeckAssistant().size() > 1)) {
                                check2 = false;
                            }
                        }
                    }
                check = check1 && check2;
                if (!check) {
                    out.println("Assistente errato o già utilizzato, inserisci un numero valido: ");
                }
            }
            socketNetworkHandler.sendMessage(new ChooseAssistantCardMessage(m));
        } else {
            System.out.println(nickname + " sta scegliendo l'AssistantCard");
        }
    }
    public int convertStringToNumber(String num){
        int c=-1;
        if(Objects.equals(num, "0")){
            c=0;
            return c;
        } if(Objects.equals(num, "1")){
            c=1;
            return c;
        } if(Objects.equals(num, "2")) {
            c = 2;
            return c;
        } if(Objects.equals(num, "3")){
            c=3;
            return c;
        } if(Objects.equals(num, "4")){
            c=4;
            return c;
        } if(Objects.equals(num, "5")){
            c=5;
            return c;
        } if(Objects.equals(num, "6")){
            c=6;
            return c;
        } if(Objects.equals(num, "7")){
            c=7;
            return c;
        } if(Objects.equals(num, "8")){
            c=8;
            return c;
        } if(Objects.equals(num, "9")){
            c=9;
            return c;
        } if(Objects.equals(num, "10")){
            c=10;
            return c;
        } if(Objects.equals(num, "11")){
            c=11;
            return c;
        } if(Objects.equals(num, "12")){
            c=12;
            return c;
        }
        return c;
    }

    @Override
    public void requestMoveMotherNature(String nickname) {
        if(Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {
            int i;
            for (i = 0; !Objects.equals(lightGame.getPlayers().get(i).getNickname(), nickname); i++) ;
            out.println("Inserisci i passi da far fare a Madre Natura: puoi inserire massimo "+ lightGame.getPlayers().get(i).getCurrentAssistant().getStep() +" step");
            int step = scanner.nextInt();
            while (step < 1 || step > lightGame.getPlayers().get(i).getCurrentAssistant().getStep()) {
                out.println("Numero Errato! Inserisci i passi da far fare a Madre Natura. Massimo di step " +lightGame.getPlayers().get(i).getCurrentAssistant().getStep());
                step = scanner.nextInt();
            }
            socketNetworkHandler.sendMessage(new MoveMotherNatureMessage(step));
        }else{
            System.out.println(nickname+" sta spostando madre natura");
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
    private String color4Island(int island, int color){
        StringBuilder showColor = new StringBuilder();
        if(color == 0){
            showColor.append(ColorCli.GREEN).append("    ●: ").append(lightGame.getIslands().get(island).getGreenPawn()).append("      ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 1){
            showColor.append(ColorCli.RED).append("    ●: ").append(lightGame.getIslands().get(island).getRedPawn()).append("      ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("    ●: ").append(lightGame.getIslands().get(island).getYellowPawn()).append("      ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 3){
            showColor.append(ColorCli.PINK).append("    ●: ").append(lightGame.getIslands().get(island).getPinkPawn()).append("      ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("    ●: ").append(lightGame.getIslands().get(island).getBluePawn()).append("      ").append(ColorCli.BOLDCYAN);
        }
        else if(color == 5){
            if(lightGame.getIslands().get(island).getMotherNature())
                showColor.append(ColorCli.GREEN).append("   MN: ").append("OK     ").append(ColorCli.BOLDCYAN);
            else
                showColor.append(ColorCli.RED).append("   MN: ").append("NO     ").append(ColorCli.BOLDCYAN);
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

    private String color4Entrance(int player, int color){
        int m;
        StringBuilder showColor = new StringBuilder();

        if(color == 0){
            showColor.append(ColorCli.GREEN).append("●: ").append(lightGame.getPlayers().get(player).getEntrance().getGreenPawn()).append("          ");
            showColor.append(ColorCli.BOLDCYAN).append("|  ").append(ColorCli.GREEN);
            for (m = 0; m < lightGame.getPlayers().get(player).getDiningRoom().getNumGreen(); m++) {
                if (m == 2 || m == 5 || m == 8)
                    showColor.append(" ◎ ");
                else
                    showColor.append(" ● " );
            }
            while (m < 10) {
                showColor.append(" ◌ ");
                m++;
            }
            showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.GREEN);
            if(lightGame.getProfTable().getGreenProf() == player) {
                showColor.append(" ❂ ");
                out.println(lightGame.getProfTable().getGreenProf());
                out.println(lightGame.getProfTable().getRedProf());
                out.println(lightGame.getProfTable().getYellowProf());
                out.println(lightGame.getProfTable().getPinkProf());
                out.println(lightGame.getProfTable().getBlueProf());
            }
            else
                showColor.append(" ◌ ");
            showColor.append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }


        else if(color == 1){
            showColor.append(ColorCli.RED).append("●: ").append(lightGame.getPlayers().get(player).getEntrance().getRedPawn()).append("          ");
            showColor.append(ColorCli.BOLDCYAN).append("|  ").append(ColorCli.RED);
            for (m = 0; m < lightGame.getPlayers().get(player).getDiningRoom().getNumRed(); m++) {
                if (m == 2 || m == 5 || m == 8)
                    showColor.append(" ◎ ");
                else
                    showColor.append(" ● " );
            }
            while (m < 10) {
                showColor.append(" ◌ ");
                m++;
            }
            showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RED);
            if(lightGame.getProfTable().getRedProf() == player)
                showColor.append(" ❂ ");
            else
                showColor.append(" ◌ ");
            showColor.append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }

        else if(color == 2){
            showColor.append(ColorCli.YELLOW).append("●: ").append(lightGame.getPlayers().get(player).getEntrance().getYellowPawn()).append("          ");
            showColor.append(ColorCli.BOLDCYAN).append("|  ").append(ColorCli.YELLOW);
            for (m = 0; m < lightGame.getPlayers().get(player).getDiningRoom().getNumYellow(); m++) {
                if (m == 2 || m == 5 || m == 8)
                    showColor.append(" ◎ ");
                else
                    showColor.append(" ● " );
            }
            while (m < 10) {
                showColor.append(" ◌ ");
                m++;
            }
            showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.YELLOW);
            if(lightGame.getProfTable().getYellowProf() == player)
                showColor.append(" ❂ ");
            else
                showColor.append(" ◌ ");
            showColor.append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }

        else if(color == 3){
            showColor.append(ColorCli.PINK).append("●: ").append(lightGame.getPlayers().get(player).getEntrance().getPinkPawn()).append("          ");
            showColor.append(ColorCli.BOLDCYAN).append("|  ").append(ColorCli.PINK);
            for (m = 0; m < lightGame.getPlayers().get(player).getDiningRoom().getNumPink(); m++) {
                if (m == 2 || m == 5 || m == 8)
                    showColor.append(" ◎ ");
                else
                    showColor.append(" ● " );
            }
            while (m < 10) {
                showColor.append(" ◌ ");
                m++;
            }
            showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.PINK);
            if(lightGame.getProfTable().getPinkProf() == player)
                showColor.append(" ❂ ");

            else
                showColor.append(" ◌ ");
            showColor.append(ColorCli.BOLDCYAN).append("|");
            showColor.append("\n");
        }

        else if(color == 4){
            showColor.append(ColorCli.BLUE).append("●: ").append(lightGame.getPlayers().get(player).getEntrance().getBluePawn()).append("          ");
            showColor.append(ColorCli.BOLDCYAN).append("|  ").append(ColorCli.BLUE);
            for (m = 0; m < lightGame.getPlayers().get(player).getDiningRoom().getNumBlue(); m++) {
                if (m == 2 || m == 5 || m == 8)
                    showColor.append(" ◎ ");
                else
                    showColor.append(" ● " );
            }
            while (m < 10) {
                showColor.append(" ◌ ");
                m++;
            }
            showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.BLUE);
            if(lightGame.getProfTable().getBlueProf() == player)
                showColor.append(" ❂ ");
            else
                showColor.append(" ◌ ");
            showColor.append(ColorCli.BOLDCYAN).append("|").append(ColorCli.RESET).append("\n");
            showColor.append("Il numero totale di torri ").append(lightGame.getPlayers().get(player).getTowerSpace().getColorTower()).append(" disponibili è: ").append(ColorCli.BOLDWITE).append(lightGame.getPlayers().get(player).getTowerSpace().getNumTower()).append("\n");
            showColor.append(ColorCli.BOLDCYAN).append("+---------------------------------------------------+\n").append(ColorCli.RESET);
            showColor.append("\n");
        }
        return showColor.toString();
    }

    private String print1_4Index(){
        StringBuilder index = new StringBuilder();
        for(int i = 0; i < lightGame.getIslands().size() && i<4; i++)
            index.append("   ").append("Isola: ").append(i+1).append("   ");
        return index.toString();
    }

    private String print4_8Index(){
        StringBuilder index = new StringBuilder();
        if(lightGame.getIslands().size()>=4){
            for(int i = 4; i < lightGame.getIslands().size() && i<8; i++)
                index.append("   ").append("Isola: ").append(i+1).append("   ");
        }
        return index.toString();
    }

    private String print8_12Index(){
        StringBuilder index = new StringBuilder();
        if(lightGame.getIslands().size()>=8){
            for(int i = 8; i < lightGame.getIslands().size(); i++)
                index.append("   ").append("Isola: ").append(i+1).append("   ");
        }
        return index.toString();
    }


}