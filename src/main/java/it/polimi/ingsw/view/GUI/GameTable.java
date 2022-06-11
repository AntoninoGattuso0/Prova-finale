package it.polimi.ingsw.view.GUI;


import it.polimi.ingsw.client.ModelLight.LightGame;
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
    private LightGame lightGame;

    private final List<ImageView> islands = null;
    private final List<ImageView> greenPawns = null;
    private final List<ImageView> redPawns = null;
    private final List<ImageView> yellowPawns = null;
    private final List<ImageView> pinkPawns = null;
    private final List<ImageView> bluePawns= null;

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





    }

    public void displayInitialGameTable(){

        for(int i = 0; i < 12; i++)
            islands.add((ImageView) rootFXML.lookup("island" + i));
        //Aggiunge le immagini delle pedine alle liste del colore corrispondenete
        for(int i = 0; i < 12; i++)
            greenPawns.add((ImageView) rootFXML.lookup("green" + i));

        for(int i = 0; i < 12; i++)
            redPawns.add((ImageView) rootFXML.lookup("red" + i));

        for(int i = 0; i < 12; i++)
            yellowPawns.add((ImageView) rootFXML.lookup("yellow" + i));

        for(int i = 0; i < 12; i++)
            pinkPawns.add((ImageView) rootFXML.lookup("pink" + i));

        for(int i = 0; i < 12; i++)
            bluePawns.add((ImageView) rootFXML.lookup("blue" + i));

        //setta tutte le pedine invisibili all'inizio
        for(ImageView greenPawn : greenPawns)
            greenPawn.setVisible(false);

         for(ImageView redPawn : redPawns)
            redPawn.setVisible(false);

         for(ImageView yellowPawn : yellowPawns)
            yellowPawn.setVisible(false);

         for(ImageView pinkPawn : pinkPawns)
            pinkPawn.setVisible(false);

         for(ImageView pinkPawn : pinkPawns)
            pinkPawn.setVisible(false);

         for(int i = 0; i < 12; i++){
             if(lightGame.getIslands().get(i).getGreenPawn()>0)
                 greenPawns.get(i).setVisible(true);
             if(lightGame.getIslands().get(i).getRedPawn()>0)
                 redPawns.get(i).setVisible(true);
             if(lightGame.getIslands().get(i).getYellowPawn()>0)
                 yellowPawns.get(i).setVisible(true);
             if(lightGame.getIslands().get(i).getPinkPawn()>0)
                 pinkPawns.get(i).setVisible(true);
             if(lightGame.getIslands().get(i).getBluePawn()>0)
                 bluePawns.get(i).setVisible(true);
         }

    }

    public void chooseAssistantCard()
}