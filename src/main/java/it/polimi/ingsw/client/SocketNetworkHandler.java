package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.Ping;
import it.polimi.ingsw.view.View;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;

public class SocketNetworkHandler implements Runnable{
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private final View view;
    private String nicknameThisPlayer;
    private volatile boolean connected;
    private volatile boolean ready;

    private final ClientMessageManager clientMessageManager;
    public SocketNetworkHandler(View view){
        connected=false;
        ready=false;
        this.view=view;
        this.clientMessageManager =new ClientMessageManager(view);
        view.setSocketNetworkHandler(this);
    }
    public String getNicknameThisPlayer() {
        return nicknameThisPlayer;
    }
    public void setNicknameThisPlayer(String nicknameThisPlayer) {
        this.nicknameThisPlayer = nicknameThisPlayer;
    }
    private void pingToServer(){
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
                    sendMessage(new Ping());
                }
            }
        });
        thread.start();
    }
    public void sendMessage(Message message){
        try{
            out.writeObject(message);
            out.reset();
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void updateConnection(String ipAddress,String port){
        try{
            socket=new Socket(ipAddress, Integer.parseInt(port));
            ready=true;
            System.out.println("Connection up");
        }catch (IOException| IllegalArgumentException e){
            System.out.println("Server unavailable");
            System.exit(0);
        }
    }
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
            while(!ready){
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
        pingToServer();
        try{
            while (true){
                try {
                    socket.setSoTimeout(30000);
                    Object input = in.readObject();
                    clientMessageManager.manageInputToClient(input);
                }catch (IOException|ClassNotFoundException|InterruptedException e){
                    view.displayNetError();
                    break;
                }
            }
        }catch (NoSuchElementException e){
            view.displayNetError();
        }finally {
            closeConnection();
        }
    }
}
