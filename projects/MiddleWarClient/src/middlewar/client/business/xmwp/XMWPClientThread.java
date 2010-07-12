/*
 * Middle War Client
 *
 */

package middlewar.client.business.xmwp;

import java.io.*;
import java.net.*;
import java.util.*;

import middlewar.client.business.Game;

import middlewar.xmwp.*;
import middlewar.xmwp.client.*;

/**
 * Server link (communication)
 * @author higurashi
 */
public class XMWPClientThread implements Runnable{

    public static final int historySize = 5; // total (recv + send)
    public static final int delay = 100; // inter-messages delay (ms)

    protected String[] recvRequestHistory = new String[historySize];
    protected String[] sendRequestHistory = new String[historySize];
    protected String[] recvInformHistory = new String[historySize];
    protected String[] sendInformHistory = new String[historySize];
    protected Date[] recvDateHistory = new Date[historySize];
    protected Date[] sendDateHistory = new Date[historySize];

    protected int historyIndexSend = 0;
    protected int historyIndexRecv = 0;

    protected ArrayDeque<ClientMessage> messages = new ArrayDeque<ClientMessage>();

    protected String serverServletUrl;
    protected String key;

    private Game game = Game.getInstance();

    // Thread
    private boolean running;
    private Thread thread;

    /**
     * Constructor
     * @param key security key
     * @param server the server url
     */
    public XMWPClientThread(String key,String server) {
        this.serverServletUrl = server;
        this.key = key;
    }

    public int getMessageStackSize() {
        return messages.size();
    }

    public ClientMessage popMessage(){
        if(this.messages.isEmpty()) return null;
        return this.messages.pop();
    }

    public Game getGame(){
        return game;
    }

    public void pushMessage(ClientMessage message){
        this.messages.addLast(message);
    }

    public String[] getRecvInformHistory() {
        return recvInformHistory;
    }

    public String[] getRecvRequestHistory() {
        return recvRequestHistory;
    }

    public String[] getSendInformHistory() {
        return sendInformHistory;
    }

    public String[] getSendRequestHistory() {
        return sendRequestHistory;
    }

    public Date[] getRecvDateHistory() {
        return recvDateHistory;
    }

    public Date[] getSendDateHistory() {
        return sendDateHistory;
    }

    public void addToSendHistory(String inform,String request) {
        if(historyIndexSend == historySize) historyIndexSend = 0;
        this.sendInformHistory[historyIndexSend]=inform;
        this.sendRequestHistory[historyIndexSend]=request;
        this.sendDateHistory[historyIndexSend]=new Date();
        this.historyIndexSend++;
    }

    public void addToRecvHistory(String inform,String request) {
        if(historyIndexRecv == historySize) historyIndexRecv = 0;
        this.recvInformHistory[historyIndexRecv]=inform;
        this.recvRequestHistory[historyIndexRecv]=request;
        this.recvDateHistory[historyIndexRecv]=new Date();
        this.historyIndexRecv++;
    }

    public void flushMessages() {
        this.messages.clear();
    }

    public void start() {
        thread = new Thread(this);
        running = true;
        thread.start();
    }

    public void stop() {
        if(running){

            System.out.println("Shutting down Server link ("+this.serverServletUrl+") ...");

            while(!this.messages.isEmpty()){
                try { Thread.sleep(500); } catch (Exception e) {}
            }
            
            // stop thread
            try {
                running = false;
                thread.join(15000);
            } catch (InterruptedException e) {
                System.err.print(e.getMessage());
            }

            System.out.println("Server link cut");
        }
    }

    public void run() {

        try {
        
            // messages
            ClientMessage currentMessage;
            ClientMessage nextMessage;
            
            // XMWP logic
            XMWPClientLogic logic = new XMWPClientLogic(this);
            
            // Server
            URL url = new URL(this.serverServletUrl);

            while (running) {

                currentMessage = this.popMessage();


                if (currentMessage != null) {

                    try {

                        URLConnection connection = url.openConnection();
                        connection.setDoOutput(true);
                        connection.setDoInput(true);

                        // tell message to server
                        OutputStream out = connection.getOutputStream();
                        currentMessage.printMessageToStream(out);
                        addToSendHistory(currentMessage.getInform().toString(),currentMessage.getRequest().toString());

                        // receive response from server
                        InputStream in = connection.getInputStream();

                        /*
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        String l;
                        while((l =br.readLine())!=null){
                            System.out.println(l);
                        }
                        */

                        Message responseMessage = Message.parseMessageFromStream(in);
                        addToRecvHistory(responseMessage.getInform().toString(),responseMessage.getRequest().toString());

                        // modify next message (adding response elements)
                        nextMessage = this.popMessage();
                        if (nextMessage == null) {
                            nextMessage = new ClientMessage(this.key);
                            
                        }
                        responseMessage.processLogicOnMessage(logic, nextMessage);

                        if(!nextMessage.isEmpty())
                            this.pushMessage(nextMessage); // re add the message

                   
                    } catch (XMWPException e) {
                        e.printStackTrace();
                        game.addError(e.getMessage());
                        this.stop();
                    } catch (ConnectException e) {
                        e.printStackTrace();
                        game.addError(e.getMessage()+" : "+this.serverServletUrl);
                        this.stop();
                    } catch (IOException e) {
                        e.printStackTrace();
                        game.addError(e.getMessage());
                        this.stop();
                    } 

                }
                else {

                    try {
                        Thread.sleep(delay);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

        } catch (MalformedURLException e) {
            // Stop.
            game.addError(e.getMessage());
        } catch (Exception e) {
            // Stop.
            game.addError(e.getMessage());
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
