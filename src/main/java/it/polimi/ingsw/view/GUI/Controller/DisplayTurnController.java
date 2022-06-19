package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class DisplayTurnController {
    public Text turnText;
    public Button selectAssistantButton;
    Gui gui;

    public void setGui(Gui gui){this.gui=gui;}

    public void setDisplayTurn(String nickname) {
        turnText.setText(nickname);
        turnText.setVisible(true);
        selectAssistantButton.setVisible(true);
        selectAssistantButton.setDisable(false);
    }
}
