package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.Ping;
import it.polimi.ingsw.network.Message.ServerToClient.WrongTurnMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientHandler implements ClientHandlerInterface,Runnable {//DA RIVEDERE
    private final Lobby lobby;
    private final Socket mySocket;
    private String userNickname;
    private volatile boolean connected;
    private volatile boolean myTurn;
    private Message message;
    private final Ping ping = new Ping();
    private volatile boolean messageReady;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ClientHandler(Socket socket, Lobby lobby) {
        this.lobby= lobby;
        this.mySocket = socket;
        this.connected = true;
        this.myTurn = false;
        this.messageReady = false;
    }
    public String getUserNickname() {
        return userNickname;
    }

    @Override
    public void setTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }
    public void setUserNickname(String userNickname) {
        this.userNickname=userNickname;
    }

    public void sendObject(Message object) {
        try {
            objectOutputStream.writeObject(object);
            objectOutputStream.reset();
            objectOutputStream.flush();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    private void pingToClient(){
        Thread thread= new Thread(()-> {
            int c = 0;
            while (connected) {
                try {
                    Thread.sleep(50);
                    c++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    if(c>100){
                        c=0;
                        objectOutputStream.writeObject(ping);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    public void closeConnect(){
        if(userNickname==null){
            synchronized (this){
                messageReady=true;
                message=null;
                notifyAll();
            }
        }
        connected=false;
        try{
            objectOutputStream.close();
            objectInputStream.close();
            mySocket.close();
            System.out.println("SERVER: "+userNickname+" connection close by the server.\n");
        }catch (IOException e){
            System.out.println("SERVER: errore closing: "+userNickname+"\n");
            e.printStackTrace();
        }
    }
    public void readFromClient(){
        Thread thread= new Thread(()->{
            while (connected) {
                try {
                    mySocket.setSoTimeout(30000);
                    Message toServer = null;
                    try {
                        toServer = (Message) objectInputStream.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (!(toServer instanceof Ping)) {
                        if (myTurn) {
                            message = toServer;
                            messageReady = true;
                            synchronized (this) {
                                notifyAll();
                            }
                        } else {
                            sendObject(new WrongTurnMessage());
                        }
                    }
                }catch (IOException |NullPointerException|IllegalArgumentException e){
                    System.out.println("SERVER: "+userNickname+" connection close by the client");
                    closeConnect();

                    break;
                }
            }
        });
        thread.start();
    }
    public Message read() {
        synchronized (this) {
            while (!messageReady) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        messageReady = false;
        return message;
    }
    public void run() {
        try {
            System.out.println("c");
            this.objectOutputStream = new ObjectOutputStream(mySocket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(mySocket.getInputStream());
            System.out.println("[SERVER] new Client Created.");
            readFromClient();
            pingToClient();
            lobby.loginUser(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}