package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.ModelLight.LightPlayer;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class DisplayTurnForOtherPlayersController {
    Gui gui;
    LightGame lightGame;

    public DisplayTurnForOtherPlayersController(Gui gui) {
        this.gui = gui;
    }

    @FXML
    public Pane displayOtherTurn;

    public void setTurn(String name) {//nome CurrentPlayer
        for (LightPlayer player : lightGame.getPlayers()) {
            if (player.getNickname().equals(name)) {
                for (Node turn : displayOtherTurn.getChildren()) {
                    if (turn.getId().equals("turnText")) {
                        turn.setAccessibleText(name);
                        turn.setVisible(true);
                    } else
                        turn.setVisible(false);
                }
            } else {
                for (Node turn : displayOtherTurn.getChildren()) {
                    if (!turn.getId().equals("turnText")) {
                        turn.setVisible(true);
                    } else
                        turn.setVisible(false);
                }
            }
        }
    }
}
