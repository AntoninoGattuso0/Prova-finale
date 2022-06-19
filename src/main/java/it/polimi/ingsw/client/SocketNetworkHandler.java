package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.ClientToServer.RequestNicknameAfterFirstLoginMessage;
import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.Ping;
import it.polimi.ingsw.view.View;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;

/**
 * SocketNetworkHandler is the client
 */
public class SocketNetworkHandler implements Runnable{
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private final View view;
    private String nicknameThisPlayer;
    private volatile boolean connected;
    private volatile boolean ready;
    private final Ping ping;
    private final ClientMessageManager clientMessageManager;

    /**
     * Associate Client to Cli or Gui
     * @param view Cli or Gui
     */
    public SocketNetworkHandler(View view){
        connected=false;
        ready=false;
        this.view=view;
        this.clientMessageManager =new ClientMessageManager(view);
        view.setSocketNetworkHandler(this);
        ping=new Ping();
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public View getView() {
        return view;
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
                if(c>=100){
                    c=0;
                    if(connected)
                        sendMessage(ping);
                }
            }
        });
        thread.start();
    }

    /**
     * Send the message
     * if the message is a RequestNickname Message, don't reset out because the client has to keep the "nickname" until it is accepted/rejected
     * @param message
     */
    public synchronized void sendMessage(Message message){
        try{
            if(!(message instanceof RequestNicknameAfterFirstLoginMessage)) {
                out.reset();
            }
            out.writeObject(message);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void updateConnection(String ipAddress,String port){
        try{
            socket=new Socket(ipAddress, Integer.parseInt(port));
            ready=true;
            connected=true;
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
        Thread thread = new Thread(() ->{
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
                        if(connected) {
                            socket.setSoTimeout(30000);
                            Object input = in.readObject();
                            clientMessageManager.manageInputToClient(input, this);
                        }
                    }catch (IOException|ClassNotFoundException|InterruptedException e){
                        if(!connected) {
                            closeConnection();
                        }else{
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }catch (NoSuchElementException e){
                view.displayNetError();
                closeConnection();
            }});
        thread.start();
        }
    }
