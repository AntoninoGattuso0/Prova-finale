package it.polimi.ingsw.view.Gui;

import it.polimi.ingsw.observer.ViewObservable;
import it.polimi.ingsw.view.Gui.scene.GenericSceneController;
import javafx.scene.Scene;

import java.util.List;

public class SceneController extends ViewObservable {

    public static Scene activeScene;
    public static GenericSceneController activeController;

    public static Scene getActiveScene(){
        return activeScene;
    }

    public static GenericSceneController getActiveController(){
        return activeController;
    }

    public static <T> T changeRootPane(List<ViewObservable>)
}
