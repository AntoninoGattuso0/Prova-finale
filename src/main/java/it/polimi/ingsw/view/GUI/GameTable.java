package it.polimi.ingsw.view.GUI;


import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseAssistantCardMessage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GameTable {
    private Pane rootFXML;
    private SocketNetworkHandler socketNetworkHandler;

    public GameTable(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/GameTable.fxml")));
        }catch(IOException e){
        e.printStackTrace();
        }

        List<ImageView> buttonAssistants = new ArrayList<>();
        for(int i = 1; i < 11; i++){
            buttonAssistants.add((ImageView) rootFXML.lookup("AssistantCard" + i));
        }

        //quando il cursore arriva su un assistant card diventa a forma di mano
        for(ImageView imageAssistant : buttonAssistants){
            imageAssistant.setOnMouseEntered(mouseEvent -> imageAssistant.setCursor(Cursor.HAND));
            imageAssistant.setOnMouseExited(mouseEvent -> imageAssistant.setCursor(Cursor.DEFAULT));
        }

        //questo devo vedere se metterlo in una funzione e poi richiamarlo dalla GUI
        //o se mettere direttamente nella gui
        boolean alreadySelected = false;
        for(ImageView imageAssistant : buttonAssistants){
            if(!alreadySelected){
               imageAssistant.setOnMouseClicked(mouseEvent -> {
                   int AssistantCard = buttonAssistants.indexOf(imageAssistant);
                   socketNetworkHandler.sendMessage(new ChooseAssistantCardMessage(AssistantCard));
               });
                alreadySelected = true;
            }
        }




    }

}
