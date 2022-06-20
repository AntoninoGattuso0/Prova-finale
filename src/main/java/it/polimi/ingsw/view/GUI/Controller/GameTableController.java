package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;

public class GameTableController {
    Gui gui;
    LightGame lightGame;
    @FXML
    Pane gameTable;
    @FXML
    BorderPane showCard;

    public void setGui(Gui gui) {
        this.gui = gui;
        this.lightGame = gui.getLightGame();
    }

    public void setAllIslands(boolean visible, boolean disabled) {
        for (int i = 0; i < lightGame.getIslands().size(); i++) {
            String name = "island" + i;
            gameTable.lookup(name).setVisible(visible);
            gameTable.lookup(name).setDisable(disabled);
        }
    }

    public void setIsland(int island, boolean visible, boolean disabled) {
        String name = "island" + island;
        gameTable.lookup(name).setVisible(visible);
        gameTable.lookup(name).setDisable(disabled);
    }

    public void setPawnVisible(int color, int island, boolean visible) {
        String name;
        String text;
        if (color == 0) {
            name = "#green" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textGreen" + island;
            gameTable.lookup(text).setVisible(visible);
        } else if (color == 1) {
            name = "#red" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textRed" + island;
            gameTable.lookup(text).setVisible(visible);
        } else if (color == 2) {
            name = "#yellow" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textYellow" + island;
            gameTable.lookup(text).setVisible(visible);
        } else if (color == 3) {
            name = "#pink" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textPink" + island;
            gameTable.lookup(text).setVisible(visible);
        } else if (color == 4) {
            name = "#blue" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textBlueCharacter" + island;
            gameTable.lookup(text).setVisible(visible);
        }
    }

    public void setColorDisabled(int color, int island, boolean disabled) {
        String name;
        if (color == 0) {
            name = "#green" + island;
            gameTable.lookup(name).setDisable(disabled);
        } else if (color == 1) {
            name = "#red" + island;
            gameTable.lookup(name).setDisable(disabled);
        } else if (color == 2) {
            name = "#yellow" + island;
            gameTable.lookup(name).setDisable(disabled);
        } else if (color == 3) {
            name = "#pink" + island;
            gameTable.lookup(name).setDisable(disabled);
        } else if (color == 4) {
            name = "#blue" + island;
            gameTable.lookup(name).setDisable(disabled);
        }
    }

    public void setCloud(int cloud, boolean visible, boolean disabled) {
        String name = "cloud" + cloud;
        gameTable.lookup(name).setVisible(visible);
        gameTable.lookup(name).setDisable(disabled);
        //pedine sempre visibili?
    }

    public void setMotherNatureVisible(int island) {
        for (int i = 0; i < 12; i++) {
            if (i == island)
                gameTable.lookup("motherNature" + i).setVisible(true);
            else
                gameTable.lookup("motherNature" + i).setVisible(false);
        }
    }

    public void setTowers(int island, int color, boolean visible) {
        String name = null;
        String text = "textIsland" + island;
        if (color == 0) {
            name = "blackTower" + island;
        } else if (color == 1) {
            name = "whiteTower" + island;
        } else if (color == 2) {
            name = "greyTower" + island;
        }
        gameTable.lookup(name).setVisible(visible);
        gameTable.lookup(text).setVisible(visible);
    }

    public void island0Select(MouseEvent mouseEvent) {
    }

    public Pane getPage(String fileName) {
        Pane view = null;
        try {
            URL fileUrl = getClass().getResource("/resources/" + fileName + ".fxml");
            if (fileUrl == null)
                throw new java.io.FileNotFoundException("Impossibile trovare file");
            new FXMLLoader();
            view = FXMLLoader.load(fileUrl);
        } catch (Exception e) {
            System.out.println("No Page Found");
        }
    return view;
}
    public void switchToAssistantCard(ActionEvent actionEvent) {
        FXMLLoader object = new FXMLLoader();
        Pane view = getPage("AssistantCard");
        showCard.setCenter(view);
    }

    public void switchToCharacterCard(ActionEvent actionEvent) {
        FXMLLoader object = new FXMLLoader();
        Pane view = getPage("CharacterCard");
        showCard.setCenter(view);
    }
}
