package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class CharacterCardController {
    Gui gui;
    @FXML public Pane characterCard;

    public CharacterCardController(Gui gui){
        this.gui=gui;
    }


    public void setDisableAll(){
        for(Node character : characterCard.getChildren()){
            character.setDisable(true);
        }
    }

    public void setInvisibleAll(){
        for(Node character : characterCard.getChildren()){
            character.setVisible(false);
        }
    }

    public void setAble(int n){
        String name = "#characterCard" + n;
        characterCard.lookup(name).setDisable(false);
    }
    public void setVisible(int n){
        String name = "#characterCard" + n;
        characterCard.lookup(name).setVisible(true);
    }

    public void setInvisible(int n){
        String name = "#characterCard" + n;
        characterCard.lookup(name).setVisible(false);
    }

    public void setColorCharacterVisible(int color, int character, boolean visible){
        String name;
        String text;
        if(color == 0){
            name = "#greenCharacter" + character;
            characterCard.lookup(name).setVisible(visible);
            text = "#textGreenCharacter" + character;
            characterCard.lookup(text).setVisible(visible);
        }
        else if(color == 1){
            name = "#redCharacter" + character;
            characterCard.lookup(name).setVisible(visible);
            text = "#textRedCharacter" + character;
            characterCard.lookup(text).setVisible(visible);
        }
        else if(color == 2){
            name = "#yellowCharacter" + character;
            characterCard.lookup(name).setVisible(visible);
            text = "#textYellowCharacter" + character;
            characterCard.lookup(text).setVisible(visible);
        }
        else if(color == 3){
            name = "#pinkCharacter" + character;
            characterCard.lookup(name).setVisible(visible);
            text = "#textPinkCharacter" + character;
            characterCard.lookup(text).setVisible(visible);
        }
        else if(color == 4){
            name = "#blueCharacter" + character;
            characterCard.lookup(name).setVisible(visible);
            text = "#textBlueCharacter" + character;
            characterCard.lookup(text).setVisible(visible);
        }
    }


    public void setColorDisabled(int color, int character, boolean disabled){
        String name;
        if(color == 0){
            name = "#greenCharacter" + character;
            characterCard.lookup(name).setDisable(disabled);
        }
        else if(color == 1){
            name = "#redCharacter" + character;
            characterCard.lookup(name).setDisable(disabled);
        }
        else if(color == 2){
            name = "#yellowCharacter" + character;
            characterCard.lookup(name).setDisable(disabled);
        }
        else if(color == 3){
            name = "#pinkCharacter" + character;
            characterCard.lookup(name).setDisable(disabled);
        }
        else if(color == 4){
            name = "#blueCharacter" + character;
            characterCard.lookup(name).setDisable(disabled);
        }
    }

    public void setCoinVisible(int character, boolean visible){
        String name = "coin" + character;
        characterCard.lookup(name).setVisible(visible);
    }
}
