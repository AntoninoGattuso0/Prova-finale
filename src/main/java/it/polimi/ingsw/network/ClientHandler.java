package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.Ping;
import it.polimi.ingsw.observer.ConnectionObservable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientHandler extends ConnectionObservable implements ClientHandlerIntefrace {//DA RIVEDERE
    private final Socket mySocket;
    private String userNickname;
    private volatile boolean connected;
    private volatile boolean myTurn;
    private Message message;
    private final Ping ping;
    private volatile boolean messageReady;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ClientHandler(Socket socket) {
        this.mySocket = socket;
        this.connected = true;
        this.myTurn = false;
        this.messageReady = false;
        this.ping = new Ping();
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

    public void sendObject(Object object) {
        try {
            objectOutputStream.reset();
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    private void pingClient(){
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
            System.out.println("SERVER:"+userNickname+"connection close by the server.\n");
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
                            sendObject("wrong turn"); //NON SO COSA VA QUI DENTRO);
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
            objectOutputStream= new ObjectOutputStream(mySocket.getOutputStream());
            objectInputStream = new ObjectInputStream(mySocket.getInputStream());
            System.out.println("SERVER: new Client Created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        readFromClient();
        pingClient();
    }
}