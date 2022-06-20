package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class GameTableController {
    Gui gui;
    @FXML Pane gameTable;

    public void setGui(Gui gui) {
        this.gui = gui;
    }
    public void setAllIslands(boolean visible){
        for(int i = 0; i<12; i++){
            String name = "island" + i;
            gameTable.lookup(name).setVisible(visible);
        }
    }

    public void setIsland(int island, boolean visible, boolean disabled){
        String name = "island" + island;
        gameTable.lookup(name).setVisible(visible);
        gameTable.lookup(name).setDisable(disabled);
    }

    public void setPawnVisible(int color, int island, boolean visible){
        String name;
        String text;
        if(color == 0){
            name = "#green" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textGreen" + island;
            gameTable.lookup(text).setVisible(visible);
        }
        else if(color == 1){
            name = "#red" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textRed" + island;
            gameTable.lookup(text).setVisible(visible);
        }
        else if(color == 2){
            name = "#yellow" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textYellow" + island;
            gameTable.lookup(text).setVisible(visible);
        }
        else if(color == 3){
            name = "#pink" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textPink" + island;
            gameTable.lookup(text).setVisible(visible);
        }
        else if(color == 4){
            name = "#blue" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textBlueCharacter" + island;
            gameTable.lookup(text).setVisible(visible);
        }
    }

    public void setColorDisabled(int color, int island, boolean disabled){
        String name;
        if(color == 0){
            name = "#green" + island;
            gameTable.lookup(name).setDisable(disabled);
        }
        else if(color == 1){
            name = "#red" + island;
            gameTable.lookup(name).setDisable(disabled);
        }
        else if(color == 2){
            name = "#yellow" + island;
            gameTable.lookup(name).setDisable(disabled);
        }
        else if(color == 3){
            name = "#pink" + island;
            gameTable.lookup(name).setDisable(disabled);
        }
        else if(color == 4){
            name = "#blue" + island;
            gameTable.lookup(name).setDisable(disabled);
        }
    }

    public void setCloud(int cloud, boolean visible, boolean disabled){
        String name = "cloud" + cloud;
        gameTable.lookup(name).setVisible(visible);
        gameTable.lookup(name).setDisable(disabled);
        //pedine sempre visibili?
    }

    public void setMotherNatureVisible(int island){
        for(int i = 0; i<12; i++){
            if(i == island)
                gameTable.lookup("motherNature" + i).setVisible(true);
            else
                gameTable.lookup("motherNature" + i).setVisible(false);
        }
    }

    public void setTowers(int island, int color, boolean visible){
        String name = null;
        String text = "textIsland" + island;
        if(color == 0){
            name = "blackTower" + island;
        }else if (color == 1){
            name = "whiteTower" + island;
        }else if (color == 2){
            name = "greyTower" + island;
        }
        gameTable.lookup(name).setVisible(visible);
        gameTable.lookup(text).setVisible(visible);
    }
}
