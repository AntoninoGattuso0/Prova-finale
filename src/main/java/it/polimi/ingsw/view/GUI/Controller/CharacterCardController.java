package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class CharacterCardController {
    Gui gui;
    @FXML public Pane characterCards;

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void setDisableAll(){
        for(Node character : characterCards.getChildren()){
            character.setDisable(true);
        }
    }
    public void setAble(int n){
        String name = "#characterCard" + n;
        characterCards.lookup(name).setDisable(false);
    }
    public void setVisible(int n){
        String name = "#characterCard" + n;
        characterCards.lookup(name).setVisible(true);
    }

    public void setColorCharacterVisible(int color, int character, boolean visible){
        String name;
        String text;
        if(color == 0){
            name = "#greenCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textGreenCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        }
        else if(color == 1){
            name = "#redCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textRedCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        }
        else if(color == 2){
            name = "#yellowCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textYellowCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        }
        else if(color == 3){
            name = "#pinkCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textPinkCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        }
        else if(color == 4){
            name = "#blueCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textBlueCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        }
    }


    public void setColorDisabled(int color, int character, boolean disabled){
        String name;
        if(color == 0){
            name = "#greenCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        }
        else if(color == 1){
            name = "#redCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        }
        else if(color == 2){
            name = "#yellowCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        }
        else if(color == 3){
            name = "#pinkCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        }
        else if(color == 4){
            name = "#blueCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        }
    }

    public void setCoinVisible(int character, boolean visible){
        String name = "#coin" + character;
        characterCards.lookup(name).setVisible(visible);
    }
}
