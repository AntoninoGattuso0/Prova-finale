package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class SchoolBoard0Controller {
    Gui gui;

    public SchoolBoard0Controller(Gui gui){this.gui=gui;}

    @FXML Pane schoolBoard0;

    public void setSchoolBoard0ColorEntrance(int color, int position, boolean visible){
        String name;
        if(color == 0)
            name = "entranceGreen0" + position;
        else if(color == 1)
            name = "entranceRed0" + position;
        else if(color == 2)
            name = "entranceYellow" + position;
        else if(color == 3)
            name = "entrancePink" + position;
        else if(color == 4)
            name = "entranceBlue" + position;
    }
}
