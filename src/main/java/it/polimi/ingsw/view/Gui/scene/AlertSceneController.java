/*package it.polimi.ingsw.view.Gui.scene;

import it.polimi.ingsw.view.Gui.SceneController;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AlertSceneController implements GenericSceneController{
    private final Stage stage;
    private double xOffset;
    private double yOffset;

    @FXML
    private BorderPane rootPane;
    @FXML
    private Label titleLbl;
    @FXML
    private Label messageLbl;
    @FXML
    private Button okBtn;


    public AlertSceneController() {
        stage = new Stage();
        stage.initOwner(SceneController.getActiveScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        xOffset=0;
        yOffset=0;
    }

    @FXML
    public void inizialize(){

        rootPane.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onRootPaneMousePressed);
        rootPane.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::onRootPaneMouseDragged);
        okBtn.add
    }

    private void onRootPaneMousePressed(MouseEvent event){
        xOffset = stage.getX() - event.getXOnScreen();
        yOffset = stage.getY() - event.getYOnScreen();
    }

    private void onRootPaneMouseDragged(MouseEvent event){
        stage.setX(event.getYOnScreen() + xOffset);
        stage.setY(event.getYOnScreen() + yOffset);
    }

    public void onOkBtnClick(MouseEvent event){
        stage.close();
    }
}
*/