package it.polimi.ingsw.client;

import it.polimi.ingsw.view.Cli.Cli;
import it.polimi.ingsw.view.Cli.InputReadTask;
import it.polimi.ingsw.view.GUI.Gui;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ClientMain {

    /**Function MAIN that start the Cli or the Gui
     *
     * @param args
     * @throws IOException
     * @throws ExecutionException
     */
    public static void main(String[] args) throws IOException, ExecutionException {
        SocketNetworkHandler socketNetworkHandler = null;
        System.out.println("Inserisci l'indirizzo IP del server a cui vuoi collegarti:");
        String address;
        String view = null;
        address= readLine();
        System.out.println("Scrivere C per giocare con la Cli oppure G per giocare con la GUI:");
        while(!Objects.equals(view, "C") && !Objects.equals(view, "G") && !Objects.equals(view, "c") && !Objects.equals(view, "g")){
            view= readLine();
            if(!Objects.equals(view, "C") && !Objects.equals(view, "G") && !Objects.equals(view, "c") && !Objects.equals(view, "g")){
                System.out.println("Errore nell'inserimento: Scrivere C per giocare con la Cli oppure G per giocare con la GUI");
            }
        }
        if(view.equals("C") || view.equals("c")) {
            Cli cli = new Cli();
            socketNetworkHandler = new SocketNetworkHandler(cli);
            cli.run();
        }else if (view.equals("G") || view.equals("g")){
            Gui gui= new Gui();
             socketNetworkHandler= new SocketNetworkHandler(gui);
             //gui.run();
        }
        socketNetworkHandler.updateConnection(address, String.valueOf(4000));
        socketNetworkHandler.run();
    }

    /**Function that reads the input of the player
     *
     * @return
     * @throws ExecutionException
     */
    public static String readLine() throws ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new InputReadTask());
        Thread inputThread = new Thread(futureTask);
        inputThread.start();

        String input = null;

        try {
            input = futureTask.get();
        } catch (InterruptedException e) {
            futureTask.cancel(true);
            Thread.currentThread().interrupt();
        }
        return input;
    }
}
