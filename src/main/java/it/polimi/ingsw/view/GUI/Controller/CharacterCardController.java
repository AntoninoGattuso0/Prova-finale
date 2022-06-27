package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseCharacterCardMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CharacterCardController {
    @FXML
    public Pane characterCards;
    public Text textGreenCharacter0;
    public Text textRedCharacter0;
    public Text textYellowCharacter0;
    public Text textPinkCharacter0;
    public Text textBlueCharacter0;
    public Text textGreenCharacter1;
    public Text textRedCharacter1;
    public Text textYellowCharacter1;
    public Text textPinkCharacter1;
    public Text textBlueCharacter1;
    public Text textGreenCharacter2;
    public Text textRedCharacter2;
    public Text textYellowCharacter2;
    public Text textPinkCharacter2;
    public Text textBlueCharacter2;
    ArrayList<ColorPawn> colori = new ArrayList<>();
    int island = -1;
    Gui gui;
    GameTableController gameTableController;

    public Pane getCharacterCards(){return characterCards;}

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void setCharacterCards(){
        setInvisibleAll();
        setDisableAll();
        showCharacter();
        showCharacterPawn();
    }
    
    public void setDisableAll() {
        for (Node character : characterCards.getChildren()) {
            character.setDisable(true);
        }
    }

    public void setInvisibleAll(){
        for (Node character : characterCards.getChildren()) {
            character.setVisible(false);
        }
    }


    public void showCharacter(){
        for(int i = 0; i < gui.getLightGame().getCharacterCards().size(); i++){
                for(Node character : characterCards.getChildren()){
                    if(character.getId().equals(i + "characterCard" + gui.getLightGame().getCharacterCards().get(i).getNumCard()))
                        character.setVisible(true);
                }
            }
        }


    public void showCharacterPawn(){
        ArrayList<Integer> characterPawn = new ArrayList<>();
        characterPawn.add(0);
        characterPawn.add(6);
        characterPawn.add(8);
        characterPawn.add(10);
        characterPawn.add(11);
        for(int i = 0; i<gui.getLightGame().getCharacterCards().size();i++){
            if(characterPawn.contains(gui.getLightGame().getCharacterCards().get(i).getNumCard())){
                for(Node character : characterCards.getChildren()){
                    if(character.getId().equals("greenCharacter" + i))
                        character.setVisible(true);
                    else if(character.getId().equals("redCharacter" + i))
                        character.setVisible(true);
                    else if(character.getId().equals("yellowCharacter" + i))
                        character.setVisible(true);
                    else if(character.getId().equals("pinkCharacter" + i))
                        character.setVisible(true);
                    else if(character.getId().equals("blueCharacter" + i))
                        character.setVisible(true);
                    else if(character.getId().equals("redCharacter" + i))
                        character.setVisible(true);
                    if (i == 0) {
                        if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 0) {
                            textGreenCharacter0.setText(Integer.toString(gui.getLightGame().getAntonio().getGreenPawn()));
                            textRedCharacter0.setText(Integer.toString(gui.getLightGame().getAntonio().getRedPawn()));
                            textYellowCharacter0.setText(Integer.toString(gui.getLightGame().getAntonio().getYellowPawn()));
                            textPinkCharacter0.setText(Integer.toString(gui.getLightGame().getAntonio().getPinkPawn()));
                            textBlueCharacter0.setText(Integer.toString(gui.getLightGame().getAntonio().getBluePawn()));
                        } else if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 6) {
                            textGreenCharacter0.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumGreenPawn()));
                            textRedCharacter0.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumRedPawn()));
                            textYellowCharacter0.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumYellowPawn()));
                            textPinkCharacter0.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumPinkPawn()));
                            textBlueCharacter0.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumBluePawn()));
                        } else if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 10) {
                            textGreenCharacter0.setText(Integer.toString(gui.getLightGame().getNicola().getGreenPawn()));
                            textRedCharacter0.setText(Integer.toString(gui.getLightGame().getNicola().getRedPawn()));
                            textYellowCharacter0.setText(Integer.toString(gui.getLightGame().getNicola().getYellowPawn()));
                            textPinkCharacter0.setText(Integer.toString(gui.getLightGame().getNicola().getPinkPawn()));
                            textBlueCharacter0.setText(Integer.toString(gui.getLightGame().getNicola().getBluePawn()));
                        }
                        if(gui.getLightGame().getCharacterCards().get(i).getNumCard() != 8 && gui.getLightGame().getCharacterCards().get(i).getNumCard() != 11) {
                            textGreenCharacter0.setVisible(true);
                            textRedCharacter0.setVisible(true);
                            textYellowCharacter0.setVisible(true);
                            textPinkCharacter0.setVisible(true);
                            textBlueCharacter0.setVisible(true);
                        }
                    }
                    else if(i == 1){
                        if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 0) {
                            textGreenCharacter1.setText(Integer.toString(gui.getLightGame().getAntonio().getGreenPawn()));
                            textRedCharacter1.setText(Integer.toString(gui.getLightGame().getAntonio().getRedPawn()));
                            textYellowCharacter1.setText(Integer.toString(gui.getLightGame().getAntonio().getYellowPawn()));
                            textPinkCharacter1.setText(Integer.toString(gui.getLightGame().getAntonio().getPinkPawn()));
                            textBlueCharacter1.setText(Integer.toString(gui.getLightGame().getAntonio().getBluePawn()));
                        } else if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 6) {
                            textGreenCharacter1.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumGreenPawn()));
                            textRedCharacter1.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumRedPawn()));
                            textYellowCharacter1.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumYellowPawn()));
                            textPinkCharacter1.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumPinkPawn()));
                            textBlueCharacter1.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumBluePawn()));
                        } else if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 10) {
                            textGreenCharacter1.setText(Integer.toString(gui.getLightGame().getNicola().getGreenPawn()));
                            textRedCharacter1.setText(Integer.toString(gui.getLightGame().getNicola().getRedPawn()));
                            textYellowCharacter1.setText(Integer.toString(gui.getLightGame().getNicola().getYellowPawn()));
                            textPinkCharacter1.setText(Integer.toString(gui.getLightGame().getNicola().getPinkPawn()));
                            textBlueCharacter1.setText(Integer.toString(gui.getLightGame().getNicola().getBluePawn()));
                        }
                        if(gui.getLightGame().getCharacterCards().get(i).getNumCard() != 8 && gui.getLightGame().getCharacterCards().get(i).getNumCard() != 11) {
                            textGreenCharacter1.setVisible(true);
                            textRedCharacter1.setVisible(true);
                            textYellowCharacter1.setVisible(true);
                            textPinkCharacter1.setVisible(true);
                            textBlueCharacter1.setVisible(true);
                        }
                    }
                    else if(i == 2){
                        if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 0) {
                            textGreenCharacter2.setText(Integer.toString(gui.getLightGame().getAntonio().getGreenPawn()));
                            textRedCharacter2.setText(Integer.toString(gui.getLightGame().getAntonio().getRedPawn()));
                            textYellowCharacter2.setText(Integer.toString(gui.getLightGame().getAntonio().getYellowPawn()));
                            textPinkCharacter2.setText(Integer.toString(gui.getLightGame().getAntonio().getPinkPawn()));
                            textBlueCharacter2.setText(Integer.toString(gui.getLightGame().getAntonio().getBluePawn()));
                        } else if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 6) {
                            textGreenCharacter2.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumGreenPawn()));
                            textRedCharacter2.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumRedPawn()));
                            textYellowCharacter2.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumYellowPawn()));
                            textPinkCharacter2.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumPinkPawn()));
                            textBlueCharacter2.setText(Integer.toString(gui.getLightGame().getGiuseppe().getNumBluePawn()));
                        } else if (gui.getLightGame().getCharacterCards().get(i).getNumCard() == 10) {
                            textGreenCharacter2.setText(Integer.toString(gui.getLightGame().getNicola().getGreenPawn()));
                            textRedCharacter2.setText(Integer.toString(gui.getLightGame().getNicola().getRedPawn()));
                            textYellowCharacter2.setText(Integer.toString(gui.getLightGame().getNicola().getYellowPawn()));
                            textPinkCharacter2.setText(Integer.toString(gui.getLightGame().getNicola().getPinkPawn()));
                            textBlueCharacter2.setText(Integer.toString(gui.getLightGame().getNicola().getBluePawn()));
                        }
                        if(gui.getLightGame().getCharacterCards().get(i).getNumCard() != 8 && gui.getLightGame().getCharacterCards().get(i).getNumCard() != 11) {
                            textGreenCharacter2.setVisible(true);
                            textRedCharacter2.setVisible(true);
                            textYellowCharacter2.setVisible(true);
                            textPinkCharacter2.setVisible(true);
                            textBlueCharacter2.setVisible(true);
                        }
                    }
                }
            }
        }
    }


    /*public void setDisable(int n, boolean disable) {
        String name = "#characterCard" + n;
        characterCards.lookup(name).setDisable(disable);
    }
    ABBIAMO CAMBIATO I NOMI DEI CC

    public void setVisible(int n, boolean visible) {
        String name = "#characterCard" + n;
        characterCards.lookup(name).setVisible(visible);
    }*/

    public void setColorCharacterVisible(int color, int character, boolean visible) {
        String name;
        String text;
        if (color == 0) {
            name = "#greenCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textGreenCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        } else if (color == 1) {
            name = "#redCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textRedCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        } else if (color == 2) {
            name = "#yellowCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textYellowCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        } else if (color == 3) {
            name = "#pinkCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textPinkCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        } else if (color == 4) {
            name = "#blueCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textBlueCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        }
    }


    public void setColorCharacterDisabled(int color, int character, boolean disabled) {
        String name;
        if (color == 0) {
            name = "#greenCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        } else if (color == 1) {
            name = "#redCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        } else if (color == 2) {
            name = "#yellowCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        } else if (color == 3) {
            name = "#pinkCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        } else if (color == 4) {
            name = "#blueCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        }
    }

    public void setCoinVisible(int character, boolean visible) {
        String name = "#coin" + character;
        characterCards.lookup(name).setVisible(visible);
    }

    public void character0Select(MouseEvent mouseEvent) {
        gui.getColorPawns().clear();
        gui.setNumPawns(-1);
        gui.setIslandSelected(-1);
        int player;
        for(player = 0; player < gui.getLightGame().getNumPlayers() && !gui.getLightGame().getPlayers().get(player).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer()); player++);
        if (gui.getLightGame().getCharacterCards().get(0).getNumCard() == 0) {
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getAntonio().getCoinPrice());
            gui.setButtonClicked(ButtonAction.ANTONIO);
            gui.getGameTable().setMessages("Select Pawn From CC");
            if (gui.getLightGame().getAntonio().getGreenPawn() > 0) {
                setColorCharacterDisabled(0, 0, false);
            }
            if (gui.getLightGame().getAntonio().getRedPawn() > 0) {
                setColorCharacterDisabled(1, 0, false);
            }
            if (gui.getLightGame().getAntonio().getYellowPawn() > 0) {
                setColorCharacterDisabled(2, 0, false);
            }
            if (gui.getLightGame().getAntonio().getPinkPawn() > 0) {
                setColorCharacterDisabled(3, 0, false);
            }
            if (gui.getLightGame().getAntonio().getBluePawn() > 0) {
                setColorCharacterDisabled(4, 0, false);
            }
        } else if (gui.getLightGame().getCharacterCards().get(0).getNumCard() == 1) {
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getBarbara().getCoinPrice());
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(1, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 2){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getCiro().getCoinPrice());
            gui.setButtonClicked(ButtonAction.CIRO);
            gui.getGameTable().setMessages("Select Island for CC");
            for(int i = 0; i < gui.getLightGame().getIslands().size(); i++)
                gui.getGameTable().getGameTablePane().lookup("#island" + i).setDisable(false);
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 3){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getDante().getCoinPrice());
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(3, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 4){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getErnesto().getCoinPrice());
            gui.setButtonClicked(ButtonAction.ERNESTO);
            gui.getGameTable().setMessages("Select Island for CC");
            for(int i = 0; i < gui.getLightGame().getIslands().size(); i++)
                gui.getGameTable().getGameTablePane().lookup("#island" + i).setDisable(false);
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 5){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getFelix().getCoinPrice());
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(5, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 6){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getGiuseppe().getCoinPrice());
            gui.setButtonClicked(ButtonAction.GIUSEPPE);
            gui.getGameTable().setMessages("Select Num Pawn");
            gui.getGameTable().number0.setVisible(true);
            gui.getGameTable().number0.setDisable(false);
            gui.getGameTable().number1.setVisible(true);
            gui.getGameTable().number1.setDisable(false);
            gui.getGameTable().number2.setVisible(true);
            gui.getGameTable().number2.setDisable(false);
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 7){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getIvan().getCoinPrice());
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(7, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 8){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getLancillotto().getCoinPrice());
            gui.setButtonClicked(ButtonAction.LANCILLOTTO);
            characterCards.lookup("#greenCharacterCard0").setDisable(false);
            characterCards.lookup("#redCharacterCard0").setDisable(false);
            characterCards.lookup("#yellowCharacterCard0").setDisable(false);
            characterCards.lookup("#pinkCharacterCard0").setDisable(false);
            characterCards.lookup("#blueCharacterCard0").setDisable(false);
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 9){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getMaria().getCoinPrice());
            gui.setButtonClicked(ButtonAction.MARIA);
            gui.getGameTable().setMessages("Select Num Pawn to Swap");
            gui.getGameTable().number0.setVisible(true);
            gui.getGameTable().number0.setDisable(false);
            gui.getGameTable().number1.setVisible(true);
            gui.getGameTable().number1.setDisable(false);
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 10){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getNicola().getCoinPrice());
            gui.setButtonClicked(ButtonAction.NICOLA);
            characterCards.lookup("#greenCharacterCard0").setDisable(false);
            characterCards.lookup("#redCharacterCard0").setDisable(false);
            characterCards.lookup("#yellowCharacterCard0").setDisable(false);
            characterCards.lookup("#pinkCharacterCard0").setDisable(false);
            characterCards.lookup("#blueCharacterCard0").setDisable(false);
        } else if(gui.getLightGame().getCharacterCards().get(0).getNumCard() == 11){
            gui.getLightGame().getPlayers().get(player).setNumCoin(gui.getLightGame().getPlayers().get(player).getNumCoin() - gui.getLightGame().getOmnia().getCoinPrice());
            gui.setButtonClicked(ButtonAction.OMNIA);
            characterCards.lookup("#greenCharacterCard0").setDisable(false);
            characterCards.lookup("#redCharacterCard0").setDisable(false);
            characterCards.lookup("#yellowCharacterCard0").setDisable(false);
            characterCards.lookup("#pinkCharacterCard0").setDisable(false);
            characterCards.lookup("#blueCharacterCard0").setDisable(false);
        }
    }


    public void moveGreenCharacter0(MouseEvent mouseEvent) {
        colori.add(ColorPawn.GREEN);
        if (gui.getLightGame().getCharacterCards().get(0).getNumCard() == 0) {
            characterCards.lookup("greenCharacter0").setDisable(true);
            characterCards.lookup("redCharacter0").setDisable(true);
            characterCards.lookup("yellowCharacter0").setDisable(true);
            characterCards.lookup("pinkCharacter0").setDisable(true);
            characterCards.lookup("blueCharacter0").setDisable(true);
            gameTableController.setAllIslands(false);
        }
    }


    public void character1Select(MouseEvent mouseEvent) {
    }

    public void character2Select(MouseEvent mouseEvent) {
    }

    public void moveYellowCharacter0(MouseEvent mouseEvent) {
    }

    public void movePinkCharacter0(MouseEvent mouseEvent) {
    }

    public void moveBlueCharacter0(MouseEvent mouseEvent) {
    }

    public void moveGreenCharacter1(MouseEvent mouseEvent) {
    }

    public void moveRedCharacter1(MouseEvent mouseEvent) {
    }

    public void moveYellowCharacter1(MouseEvent mouseEvent) {
    }

    public void moveRedCharacter0(MouseEvent mouseEvent) {
    }

    public void moveBlueCharacter2(MouseEvent mouseEvent) {
    }

    public void movePinkCharacter2(MouseEvent mouseEvent) {
    }

    public void moveYellowCharacter2(MouseEvent mouseEvent) {
    }

    public void moveRedCharacter2(MouseEvent mouseEvent) {
    }

    public void moveGreenCharacter2(MouseEvent mouseEvent) {
    }

    public void movePinkCharacter1(MouseEvent mouseEvent) {
    }

    public void moveBlueCharacter1(MouseEvent mouseEvent) {
    }
}
