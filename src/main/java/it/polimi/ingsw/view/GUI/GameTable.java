package it.polimi.ingsw.view.GUI;


import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseAssistantCardMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GameTable {
    private Gui gui;
    private Pane rootFXML;
    private SocketNetworkHandler socketNetworkHandler;
    private LightGame lightGame;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int cloudSelected;
    boolean cloudIsAlreadySelected = false;

    @FXML
    private List<ImageView> islands;
    @FXML
    private List<ImageView> motherNature;
    @FXML
    private List<ImageView> greenPawns;
    @FXML
    private List<ImageView> redPawns;
    @FXML
    private List<ImageView> yellowPawns;
    @FXML
    private List<ImageView> pinkPawns;
    @FXML
    private List<ImageView> bluePawns;
    @FXML
    private List<Text> textGreen;
    @FXML
    private List<Text> textRed;
    @FXML
    private List<Text> textYellow;
    @FXML
    private List<Text> textPink;
    @FXML
    private List<Text> textBlue;

    @FXML
    private List<ImageView> blackTowers;
    @FXML
    private List<ImageView> whiteTowers;
    @FXML
    private List<ImageView> greyTowers;

    @FXML
    private List<ImageView> clouds;
    @FXML
    private List<ImageView> greenPawnClouds;
    @FXML
    private List<ImageView> redPawnClouds;
    @FXML
    private List<ImageView> yellowPawnClouds;
    @FXML
    private List<ImageView> pinkPawnClouds;
    @FXML
    private List<ImageView> bluePawnClouds;

    @FXML
    private List<ImageView> characterCards;

    @FXML
    private List<ImageView> greenSchool0;
    @FXML
    private List<ImageView> redSchool0;
    @FXML
    private List<ImageView> yellowSchool0;
    @FXML
    private List<ImageView> pinkSchool0;
    @FXML
    private List<ImageView> blueSchool0;
    @FXML
    private List<ImageView> blackTowersSchool0;


    public GameTable(Gui gui) {
        this.gui=gui;
        try {
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/GameTable.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ImageView> buttonAssistants = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            buttonAssistants.add((ImageView) rootFXML.lookup("AssistantCard" + i));
        }
        //quando il cursore arriva su un assistant card diventa a forma di mano
        for (ImageView imageAssistant : buttonAssistants) {
            imageAssistant.setOnMouseEntered(mouseEvent -> imageAssistant.setCursor(Cursor.HAND));
            imageAssistant.setOnMouseExited(mouseEvent -> imageAssistant.setCursor(Cursor.DEFAULT));
        }

        //questo devo vedere se metterlo in una funzione e poi richiamarlo dalla GUI
        //o se mettere direttamente nella gui
        boolean alreadySelected = false;
        for (ImageView imageAssistant : buttonAssistants) {
            if (!alreadySelected) {
                imageAssistant.setOnMouseClicked(mouseEvent -> {
                    int AssistantCard = buttonAssistants.indexOf(imageAssistant);
                    socketNetworkHandler.sendMessage(new ChooseAssistantCardMessage(AssistantCard));
                });
                alreadySelected = true;
            }
        }

//id per accedere alle varie immagini
        for (int i = 0; i < 12; i++) {
            islands.add((ImageView) rootFXML.lookup("island" + i));
            motherNature.add((ImageView) rootFXML.lookup("motherNature" + i));
            //Aggiunge le immagini delle pedine alle liste del colore corrispondenete
            greenPawns.add((ImageView) rootFXML.lookup("green" + i));
            redPawns.add((ImageView) rootFXML.lookup("red" + i));
            yellowPawns.add((ImageView) rootFXML.lookup("yellow" + i));
            pinkPawns.add((ImageView) rootFXML.lookup("pink" + i));
            bluePawns.add((ImageView) rootFXML.lookup("blue" + i));
            //aggiunge le torri del colore corrispondente
            blackTowers.add((ImageView) rootFXML.lookup("blackTower" + i));
            whiteTowers.add((ImageView) rootFXML.lookup("whiteTower" + i));
            greyTowers.add((ImageView) rootFXML.lookup("greyTowers" + i));

            textGreen.add((Text) rootFXML.lookup("textGreen" + i));
            textRed.add((Text) rootFXML.lookup("textRed" + i));
            textYellow.add((Text) rootFXML.lookup("textYellow" + i));
            textPink.add((Text) rootFXML.lookup("textPink" + i));
            textBlue.add((Text) rootFXML.lookup("textBlue" + i));
        }

        //setta tutte le pedine e madre natura invisibili all'inizio
        for (ImageView greenPawn : greenPawns)
            greenPawn.setVisible(false);
        for (ImageView redPawn : redPawns)
            redPawn.setVisible(false);
        for (ImageView yellowPawn : yellowPawns)
            yellowPawn.setVisible(false);
        for (ImageView pinkPawn : pinkPawns)
            pinkPawn.setVisible(false);
        for (ImageView pinkPawn : pinkPawns)
            pinkPawn.setVisible(false);

        for (ImageView mNature : motherNature)
            mNature.setVisible(false);
        //setta le torri non visibili
        for (ImageView blackTower : blackTowers)
            blackTower.setVisible(false);
        for (ImageView whiteTower : whiteTowers)
            whiteTower.setVisible(false);
        for (ImageView greyTower : greyTowers)
            greyTower.setVisible(false);

        //setta il testo delle pedine non visibili
        for (Text greenText : textGreen)
            greenText.setVisible(false);
        for (Text redText : textRed)
            redText.setVisible(false);
        for (Text yellowText : textYellow)
            yellowText.setVisible(false);
        for (Text pinkText : textPink)
            pinkText.setVisible(false);
        for (Text blueText : textBlue)
            blueText.setVisible(false);

        for (int i = 0; i < 4; i++) {
            clouds.add((ImageView) rootFXML.lookup("cloud" + i));
            clouds.get(i).setVisible(false);
        }
        //mette visibili un numero di clud in base al numero di players
        for (int i = 0; i < lightGame.getNumPlayers(); i++)
            clouds.get(i).setVisible(true);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                greenPawnClouds.add((ImageView) rootFXML.lookup("greenCloud" + i + j));
                redPawnClouds.add((ImageView) rootFXML.lookup("redCloud" + i + j));
                yellowPawnClouds.add((ImageView) rootFXML.lookup("yellowCloud" + i + j));
                pinkPawnClouds.add((ImageView) rootFXML.lookup("pinkCloud" + i + j));
                bluePawnClouds.add((ImageView) rootFXML.lookup("blueCloud" + i + j));
            }
        }
        for (int i = 0; i < 12; i++) {
            greenPawnClouds.get(i).setVisible(false);
            redPawnClouds.get(i).setVisible(false);
            yellowPawnClouds.get(i).setVisible(false);
            pinkPawnClouds.get(i).setVisible(false);
            bluePawnClouds.get(i).setVisible(false);
        }

        //quando il cursore arriva su una cloud diventa a forma di mano
        for (ImageView cloud : clouds) {
            cloud.setOnMouseEntered(mouseEvent -> cloud.setCursor(Cursor.HAND));
            cloud.setOnMouseExited(mouseEvent -> cloud.setCursor(Cursor.DEFAULT));
        }

        //questo devo vedere se metterlo in una funzione e poi richiamarlo dalla GUI
        //o se mettere direttamente nella gui
        for (ImageView cloud : clouds) {
            if (!cloudIsAlreadySelected) {
                cloud.setOnMouseClicked(mouseEvent -> cloudSelected = clouds.indexOf(cloud));
                cloudIsAlreadySelected = true;
            }
        }

        // da vedere come fare add image
        /*for(int j = 0; j < 3; j++){
            characterCards.add((ImageView) rootFXML.lookup("characterCard" + j));
            characterCards.get(j).setVisible(false);
        }
        if(lightGame.getIsExpert()){
            for(ImageView characterCard : characterCards)


        }*/

//setta su non visibili le pedine della schoolBoard
        for (int i = 0; i < 10; i++) {
            greenSchool0.add((ImageView) rootFXML.lookup("schoolGreen" + i));
            redSchool0.add((ImageView) rootFXML.lookup("schoolRed" + i));
            yellowSchool0.add((ImageView) rootFXML.lookup("schoolYellow" + i));
            pinkSchool0.add((ImageView) rootFXML.lookup("schoolPink" + i));
            blueSchool0.add((ImageView) rootFXML.lookup("schoolBlue" + i));
            greenSchool0.get(i).setVisible(false);
            redSchool0.get(i).setVisible(false);
            yellowSchool0.get(i).setVisible(false);
            pinkSchool0.get(i).setVisible(false);
            blueSchool0.get(i).setVisible(false);
        }
        for (int i = 0; i < 8; i++) {
            blackTowersSchool0.add((ImageView) rootFXML.lookup("blackTowerSchool" + i));
            blackTowers.get(i).setVisible(false);
        }

    }


    //settato nel costruttore le pedine presenti invibili all'inizio
    //poi quando vengono randomizzate le pedine  e MN all'inizio del gioco, vengono settate su visibiili
    //io l'ho fatto poi è da vedere se funziona ;)
    @FXML
    public void displayInitialGameTable() {
        for (int i = 0; i < 12; i++) {
            if (lightGame.getIslands().get(i).getGreenPawn() > 0) {
                greenPawns.get(i).setVisible(true);
                textGreen.get(i).setVisible(true);
                textGreen.get(i).setText("1");
            } else if (lightGame.getIslands().get(i).getRedPawn() > 0) {
                redPawns.get(i).setVisible(true);
                textRed.get(i).setVisible(true);
                textRed.get(i).setText("1");
            } else if (lightGame.getIslands().get(i).getYellowPawn() > 0) {
                yellowPawns.get(i).setVisible(true);
                textYellow.get(i).setVisible(true);
                textYellow.get(i).setText("1");
            } else if (lightGame.getIslands().get(i).getPinkPawn() > 0) {
                pinkPawns.get(i).setVisible(true);
                textPink.get(i).setVisible(true);
                textPink.get(i).setText("1");
            } else if (lightGame.getIslands().get(i).getBluePawn() > 0) {
                bluePawns.get(i).setVisible(true);
                textBlue.get(i).setVisible(true);
                textBlue.get(i).setText("1");
            }
            if (lightGame.getIslands().get(i).getMotherNature())
                motherNature.get(i).setVisible(true);
        }
    }

    //queste due funzioni di switch devo vedere ancora come gestirle sulla parte destra della scena che vi ho fatto vedere
    public void switchToAssistantCard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/AssistantCard.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCharacterCard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/CharacterCard.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public int getCloudSelected() {
        return cloudSelected;
    }

    public boolean cloudIsAlreadySelected() {
        return cloudIsAlreadySelected;
    }

    public Pane getRootFXML() {
        return rootFXML;
    }

    /*public void character0Select(MouseEvent mouseEvent) {
        int i;
        ArrayList<ColorPawn> colori = new ArrayList<>();
        for (i = 0; i < lightGame.getNumPlayers() && !(lightGame.getPlayers().get(i).getNickname().equals(socketNetworkHandler.getNicknameThisPlayer())); i++) ;
        int player = i;
        if (lightGame.getCharacterCards().get(0).getNumCard() == 0) {
            characterCards.get(0).setVisible(true);




                out.println("Scegli il colore di uno studente presente sulla carta  da spostare su un'Isola ");
                out.println(ColorCli.GREEN + "1O" + "   " + ColorCli.RED + "2O" + "   " + ColorCli.YELLOW + "3O" + "   " + ColorCli.PINK + "4O" + "   " + ColorCli.BLUE + "5O" + ColorCli.RESET);
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
                out.println("Inserisci il numero dell'isola su cui spostate la pedina: (tra 1 e  " + lightGame.getIslands().size() + ")");
                while (!check) {
                    String numIslandString = null;
                    try {
                        numIslandString = readLine();
                    } catch (ExecutionException e) {
                        out.println(e);
                    }
                    numIsland = convertStringToNumber(numIslandString);
                    if (!(numIsland < 1 || numIsland > lightGame.getIslands().size())) {
                        check = true;
                        numIsland = numIsland - 1;
                    } else
                        out.println("Numero isola non corretto, inserisci un numero valido (tra 1 e " + lightGame.getIslands().size() + ")");
                }
                colori.add(nomeColore);
                numPawn = 1;
                lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getAntonio().getCoinPrice());
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 1) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getBarbara().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));

            } else {
                int j;
                for (j = 0; !Objects.equals(lightGame.getPlayers().get(j).getNickname(), nickname); j++) ;
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, j, numIsland, colori, bool));
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 2) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getCiro().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
                out.println("Scegli un'Isola su cui calcolare l'influenza (puoi scegliere un numero tra 1 e " + lightGame.getIslands().size() + "):");
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
                lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getCiro().getCoinPrice());
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 3) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getDante().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
                lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getDante().getCoinPrice());
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 4) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getErnesto().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
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
                numIsland = numIsland - 1;
                lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getErnesto().getCoinPrice());
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 5) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getFelix().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
                lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getFelix().getCoinPrice());
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 6) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getGiuseppe().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
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
                if (numPawn > (lightGame.getPlayers().get(player).getEntrance().getGreenPawn() + lightGame.getPlayers().get(player).getEntrance().getRedPawn() + lightGame.getPlayers().get(player).getEntrance().getYellowPawn() + lightGame.getPlayers().get(player).getEntrance().getPinkPawn() + lightGame.getPlayers().get(player).getEntrance().getBluePawn())) {
                    out.println("Non hai abbastanza pedine da spostare!");
                    socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
                } else {
                    for (int j = 0; j < numPawn; j++) {
                        out.println("Seleziona il colore dello studente " + (j + 1) + "/" + numPawn + " da spostare da questa Carta al tuo Ingresso");
                        out.println(ColorCli.GREEN + "1" + "   " + ColorCli.RED + "2" + "   " + ColorCli.YELLOW + "3" + "   " + ColorCli.PINK + "4" + "   " + ColorCli.BLUE + "5" + ColorCli.RESET);
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
                        out.println("Seleziona il colore dello studente " + (j + 1) + "/" + numPawn + " da spostare dal tuo Ingresso su questa Carta");
                        out.println(ColorCli.GREEN + "1" + "   " + ColorCli.RED + "2" + "   " + ColorCli.YELLOW + "3" + "   " + ColorCli.PINK + "4" + "   " + ColorCli.BLUE + "5" + ColorCli.RESET);
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
                    lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getGiuseppe().getCoinPrice());
                    socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
                }
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 7) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getIvan().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
                int j;
                for (j = 0; !Objects.equals(lightGame.getPlayers().get(i).getNickname(), nickname); j++) ;
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, j, numIsland, colori, bool));
            }
        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 8) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getLancillotto().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
                out.println("Scegli un colore da non conteggiare nell'influenza di questo turno: ");
                out.println(ColorCli.GREEN + "1O" + "   " + ColorCli.RED + "2O" + "   " + ColorCli.YELLOW + "3O" + "   " + ColorCli.PINK + "4O" + "   " + ColorCli.BLUE + "5O" + ColorCli.RESET);
                int colore = -1;
                String coloreString;
                try {
                    coloreString = readLine();
                    colore = convertStringToNumber(coloreString);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                ColorPawn nomeColore = null;
                if (colore == 1) {
                    nomeColore = ColorPawn.GREEN;
                } else if (colore == 2) {
                    nomeColore = ColorPawn.RED;
                } else if (colore == 3) {
                    nomeColore = ColorPawn.YELLOW;
                } else if (colore == 4) {
                    nomeColore = ColorPawn.PINK;
                } else if (colore == 5) {
                    nomeColore = ColorPawn.BLUE;
                }
                colori.add(nomeColore);
                lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getLancillotto().getCoinPrice());
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
            }
        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 9) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getMaria().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
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
                    requestMovePawn(nickname, 0);
                } else {
                    for (i = 0; i < numPawn; i++) {
                        out.println("Seleziona il colore dello studente " + (i + 1) + "/" + numPawn + " da spostare dal tuo Ingresso alla DiningRoom");
                        out.println(ColorCli.GREEN + "1" + "   " + ColorCli.RED + "2" + "   " + ColorCli.YELLOW + "3" + "   " + ColorCli.PINK + "4" + "   " + ColorCli.BLUE + "5" + ColorCli.RESET);
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
                                if (lightGame.getPlayers().get(player).getDiningRoom().getNumGreen() == 10) {
                                    out.println("Numero massimo raggiunto sulla DiningRoom per il colore GREEN, scegli un altro colore: ");
                                    try {
                                        coloreString = readLine();
                                        colore = convertStringToNumber(coloreString);
                                    } catch (ExecutionException e) {
                                        e.printStackTrace();
                                    }
                                } else
                                    check = true;
                            } else if (colore == 2 && lightGame.getPlayers().get(player).getEntrance().getRedPawn() > 0) {
                                nomeColore = ColorPawn.RED;
                                if (lightGame.getPlayers().get(player).getDiningRoom().getNumRed() == 10) {
                                    out.println("Numero massimo raggiunto sulla DiningRoom per il colore RED, scegli un altro colore: ");
                                    try {
                                        coloreString = readLine();
                                        colore = convertStringToNumber(coloreString);
                                    } catch (ExecutionException e) {
                                        e.printStackTrace();
                                    }
                                } else
                                    check = true;
                            } else if (colore == 3 && lightGame.getPlayers().get(player).getEntrance().getYellowPawn() > 0) {
                                nomeColore = ColorPawn.YELLOW;
                                if (lightGame.getPlayers().get(player).getDiningRoom().getNumYellow() == 10) {
                                    out.println("Numero massimo raggiunto sulla DiningRoom per il colore YELLOW, scegli un altro colore: ");
                                    try {
                                        coloreString = readLine();
                                        colore = convertStringToNumber(coloreString);
                                    } catch (ExecutionException e) {
                                        e.printStackTrace();
                                    }
                                } else
                                    check = true;
                            } else if (colore == 4 && lightGame.getPlayers().get(player).getEntrance().getPinkPawn() > 0) {
                                nomeColore = ColorPawn.PINK;
                                if (lightGame.getPlayers().get(player).getDiningRoom().getNumPink() == 10) {
                                    out.println("Numero massimo raggiunto sulla DiningRoom per il colore PINK, scegli un altro colore: ");
                                    try {
                                        coloreString = readLine();
                                        colore = convertStringToNumber(coloreString);
                                    } catch (ExecutionException e) {
                                        e.printStackTrace();
                                    }
                                } else
                                    check = true;
                            } else if (colore == 5 && lightGame.getPlayers().get(player).getEntrance().getBluePawn() > 0) {
                                nomeColore = ColorPawn.BLUE;
                                if (lightGame.getPlayers().get(player).getDiningRoom().getNumBlue() == 10) {
                                    out.println("Numero massimo raggiunto sulla DiningRoom per il colore BLUE, scegli un altro colore: ");
                                    try {
                                        coloreString = readLine();
                                        colore = convertStringToNumber(coloreString);
                                    } catch (ExecutionException e) {
                                        e.printStackTrace();
                                    }
                                } else
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
                        out.println(ColorCli.GREEN + "1" + "   " + ColorCli.RED + "2" + "   " + ColorCli.YELLOW + "3" + "   " + ColorCli.PINK + "4" + "   " + ColorCli.BLUE + "5" + ColorCli.RESET);
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
                    lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getMaria().getCoinPrice());
                    socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
                }
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 10) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getNicola().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
                out.println("Scegli uno studente da questa Carta e posizionalo nella tua DiningRoom: ");
                out.println(ColorCli.GREEN + "1O" + "   " + ColorCli.RED + "2O" + "   " + ColorCli.YELLOW + "3O" + "   " + ColorCli.PINK + "4O" + "   " + ColorCli.BLUE + "5O" + ColorCli.RESET);
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
                        if (lightGame.getPlayers().get(player).getDiningRoom().getNumGreen() == 10) {
                            out.println("Numero massimo raggiunto sulla DiningRoom per il colore GREEN, scegli un altro colore: ");
                            try {
                                coloreString = readLine();
                                colore = convertStringToNumber(coloreString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        } else
                            check = true;
                    } else if (colore == 2 && lightGame.getNicola().getRedPawn() > 0) {
                        nomeColore = ColorPawn.RED;
                        if (lightGame.getPlayers().get(player).getDiningRoom().getNumRed() == 10) {
                            out.println("Numero massimo raggiunto sulla DiningRoom per il colore RED, scegli un altro colore: ");
                            try {
                                coloreString = readLine();
                                colore = convertStringToNumber(coloreString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        } else
                            check = true;
                    } else if (colore == 3 && lightGame.getNicola().getYellowPawn() > 0) {
                        nomeColore = ColorPawn.YELLOW;
                        if (lightGame.getPlayers().get(player).getDiningRoom().getNumYellow() == 10) {
                            out.println("Numero massimo raggiunto sulla DiningRoom per il colore YELLOW, scegli un altro colore: ");
                            try {
                                coloreString = readLine();
                                colore = convertStringToNumber(coloreString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        } else
                            check = true;
                    } else if (colore == 4 && lightGame.getNicola().getPinkPawn() > 0) {
                        nomeColore = ColorPawn.PINK;
                        if (lightGame.getPlayers().get(player).getDiningRoom().getNumPink() == 10) {
                            out.println("Numero massimo raggiunto sulla DiningRoom per il colore PINK, scegli un altro colore: ");
                            try {
                                coloreString = readLine();
                                colore = convertStringToNumber(coloreString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        } else
                            check = true;
                    } else if (colore == 5 && lightGame.getNicola().getBluePawn() > 0) {
                        nomeColore = ColorPawn.BLUE;
                        if (lightGame.getPlayers().get(player).getDiningRoom().getNumBlue() == 10) {
                            out.println("Numero massimo raggiunto sulla DiningRoom per il colore BLUE, scegli un altro colore: ");
                            try {
                                coloreString = readLine();
                                colore = convertStringToNumber(coloreString);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        } else
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
                lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getNicola().getCoinPrice());
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
            }

        } else if (lightGame.getCharacterCards().get(selected).getNumCard() == 11) {
            if (lightGame.getPlayers().get(player).getNumCoin() < lightGame.getOmnia().getCoinPrice()) {
                out.println("Non hai abbastanza Coin per usare questa carta\n");
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, false));
            } else {
                out.println("Scegli un Colore: ogni giocatore rimetterà nel sacchetto 3 Studenti dalla propria DiningRoom di quel Colore");
                out.println(ColorCli.GREEN + "1O" + "   " + ColorCli.RED + "2O" + "   " + ColorCli.YELLOW + "3O" + "   " + ColorCli.PINK + "4O" + "   " + ColorCli.BLUE + "5O" + ColorCli.RESET);
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
                        out.println(ColorCli.GREEN + "1O" + "   " + ColorCli.RED + "2O" + "   " + ColorCli.YELLOW + "3O" + "   " + ColorCli.PINK + "4O" + "   " + ColorCli.BLUE + "5O" + ColorCli.RESET);
                        try {
                            coloreString = readLine();
                            colore = convertStringToNumber(coloreString);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }
                colori.add(nomeColore);
                lightGame.getPlayers().get(player).setNumCoin(lightGame.getPlayers().get(player).getNumCoin() - lightGame.getOmnia().getCoinPrice());
                socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(selected, numPawn, numIsland, colori, bool));
            }
        }
    } else

    {
        socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0, 0, 0, colori, bool));
    }*/


    public void character1Select(MouseEvent mouseEvent) {
    }

    public void character2Select(MouseEvent mouseEvent) {
    }
}