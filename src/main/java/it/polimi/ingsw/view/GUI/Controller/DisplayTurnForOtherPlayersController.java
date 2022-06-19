package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.scene.text.Text;

public class DisplayTurnForOtherPlayersController {
    public Text turnText;
    Gui gui;

    public DisplayTurnForOtherPlayersController(Gui gui) {
        this.gui = gui;
    }

    public void setTurn(String currPlayer) {//nome CurrentPlayer
        turnText.setText(currPlayer);
        turnText.setVisible(true);
    }
}
