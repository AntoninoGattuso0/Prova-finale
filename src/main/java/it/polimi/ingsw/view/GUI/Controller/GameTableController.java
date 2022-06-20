package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;

public class GameTableController {
    Gui gui;
    LightGame lightGame;
    @FXML
    Pane gameTable;
    @FXML
    BorderPane showCard;
    private List<Text> textGreen;
    private List<Text> textRed;
    private List<Text> textYellow;
    private List<Text> textPink;
    private List<Text> textBlue;

    public void setGui(Gui gui) {
        this.gui = gui;
        this.lightGame = gui.getLightGame();
    }

    //setta tutte le isole visibili
    public void setAllIslands(boolean visible, boolean disabled) {
        for (int i = 0; i < lightGame.getIslands().size(); i++) {
            String name = "island" + i;
            gameTable.lookup(name).setVisible(visible);
            gameTable.lookup(name).setDisable(disabled);
        }
    }

    //Setta un isola non visibile o visibile
    //non visibile utile quando due isole si uniscono
    public void setIsland(int island, boolean visible, boolean disabled) {
        String name = "island" + island;
        gameTable.lookup(name).setVisible(visible);
        gameTable.lookup(name).setDisable(disabled);
    }

    //aggiunge tutti i testi in base al colore a delle liste
    private void addText(){
        for(int i = 0; i < 12; i++){
            textGreen.add((Text) gameTable.lookup("textGreen" + i));
            textRed.add((Text) gameTable.lookup("textRed" + i));
            textYellow.add((Text) gameTable.lookup("textYellow" + i));
            textPink.add((Text) gameTable.lookup("textPink" + i));
            textBlue.add((Text) gameTable.lookup("textBlue" + i));
        }
    }

    //setta una pedina visibile o meno con il relativo testo accanto che indica quante pedine ci sono
    public void setPawnVisible(int color, int island, boolean visible) {
        String name;
        String text;
        if (color == 0) {
            name = "#green" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textGreen" + island;
            gameTable.lookup(text).setVisible(visible);
            textGreen.get(island).setText("TOT: " + lightGame.getIslands().get(island).getGreenPawn());
        } else if (color == 1) {
            name = "#red" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textRed" + island;
            gameTable.lookup(text).setVisible(visible);
            textRed.get(island).setText("TOT: " + lightGame.getIslands().get(island).getRedPawn());
        } else if (color == 2) {
            name = "#yellow" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textYellow" + island;
            gameTable.lookup(text).setVisible(visible);
            textYellow.get(island).setText("TOT: " + lightGame.getIslands().get(island).getYellowPawn());
        } else if (color == 3) {
            name = "#pink" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textPink" + island;
            gameTable.lookup(text).setVisible(visible);
            textPink.get(island).setText("TOT: " + lightGame.getIslands().get(island).getPinkPawn());
        } else if (color == 4) {
            name = "#blue" + island;
            gameTable.lookup(name).setVisible(visible);
            text = "#textBlue" + island;
            gameTable.lookup(text).setVisible(visible);
            textBlue.get(island).setText("TOT: " + lightGame.getIslands().get(island).getBluePawn());
        }
    }

    //setta su selezionabili o meno una pedina
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

    //da completare
    public void setCloud() {
        for(int numCloud = 0; numCloud < 4; numCloud++) {
        String name = "cloud" + numCloud;
        gameTable.lookup(name).setVisible(false);
        gameTable.lookup(name).setDisable(false);
        }
    }

    //quando seleziono una cloud tutto ciò che c'è sopra diventa non visibile
    public void setPawnCloudInvisible(int cloud, boolean visible) {
        String name;
            for(int position = 0; position < 4; position++){
                name = "#green" + cloud + position;
                gameTable.lookup(name).setVisible(visible);
                name = "#red" + cloud + position;
                gameTable.lookup(name).setVisible(visible);
                name = "#yellow" + cloud + position;
                gameTable.lookup(name).setVisible(visible);
                name = "#pink" + cloud + position;
                gameTable.lookup(name).setVisible(visible);
                name = "#blue" + cloud + position;
                gameTable.lookup(name).setVisible(visible);
            }
        }

    public void setPawnCloudVisible(int color, int cloud, boolean visible) {
        String name;
        int tot;
        if(lightGame.getNumPlayers()==2||lightGame.getNumPlayers()==4) tot=3;
        else tot=4;

        for(int numCloud = 0; numCloud < lightGame.getNumPlayers(); numCloud++) {
            for(int position = 0; position < tot; position++){
                name = "#green" + numCloud + position;
                gameTable.lookup(name).setVisible(visible);
                name = "#red" + numCloud + position;
                gameTable.lookup(name).setVisible(visible);
                name = "#yellow" + numCloud + position;
                gameTable.lookup(name).setVisible(visible);
                name = "#pink" + numCloud + position;
                gameTable.lookup(name).setVisible(visible);
                name = "#blue" + numCloud + position;
                gameTable.lookup(name).setVisible(visible);
            }
        }
    }


    //Setta visibile solo una mother nature
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
