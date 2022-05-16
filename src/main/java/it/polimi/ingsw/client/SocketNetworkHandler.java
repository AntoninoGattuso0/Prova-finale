package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.EndGame;
import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.Ping;
import it.polimi.ingsw.observer.NetworkHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;

public class SocketNetworkHandler implements Runnable, NetworkHandler {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private final View view;
    private volatile boolean connected;
    private volatile boolean ready;
    private final MessageManager messageManager;
    public SocketNetworkHandler(View view){
        connected=false;
        ready=false;
        this.view=view;
        this.messageManager=new MessageManager(view);
    }
    private void pingClient(){
        Thread thread= new Thread(()->{
            int c=0;
            while (connected){
                try{
                    Thread.sleep(50);
                    c++;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(c>100){
                    c=0;
                    updateMessage(new Ping());
                }
            }
        });
        thread.start();
    }
    @Override
    public void updateMessage(Message message){
        try{
            out.reset();
            out.writeObject(message);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void updateConnection(String ipAddress, String port){
        try{
            socket=new Socket(ipAddress,Integer.parseInt(port));
            ready=true;
            synchronized (this){
                notifyAll();}
        }catch (IOException| IllegalArgumentException e){
            System.out.println("Server unavailable");
            System.exit(0);
        }
        System.out.println("Connection up");
    }
    @Override
    public synchronized void closeConnection(){
        connected=false;
        try {
            System.out.println("Closing Client connection. ");
            in.close();
            out.close();
            socket.close();
            System.out.println("Connection close");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        synchronized (this){
            while(ready==false){
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        connected=true;
        try{
            in=new ObjectInputStream(socket.getInputStream());
            out=new ObjectOutputStream(socket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
        pingClient();
        try{
            while (true){
                try {
                    socket.setSoTimeout(30000);
                    Object input = in.readObject();
                    messageManager.manageInputToclient(input);
                    if (input instanceof EndGame || input instanceof RemoveClient) {
                        break;
                    }
                }catch (IOException|ClassNotFoundException e){
                    view.dysplayNetError();
                    break;
                }
            }
        }catch (NoSuchElementException e){
            view.dysplayNetError();
        }finally {
            closeConnection();
        }
    }
}
