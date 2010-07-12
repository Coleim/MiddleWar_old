/*
 * Middle War - Client
 *
 */

package middlewar.client.business;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

import middlewar.client.MainApplet.ChatPanel;
import middlewar.client.MainApplet.MainPanel;
import middlewar.common.*;

import middlewar.client.business.board.*;
import middlewar.client.business.xmwp.*;
import middlewar.client.business.units.*;
import middlewar.client.exception.*;

import middlewar.xmwp.XMWPException;

/**
 * Game (all data) representation
 * @author higurashi
 */
public class Game implements Agent{

    public static final String DATA_URL_IMAGES = MiddlewarConfiguration.getImageDistPath();
    public static final String DATA_URL_ICONS = DATA_URL_IMAGES+"interface/icons/";
    public static final String DATA_URL_BLOCKS = DATA_URL_IMAGES+"blocks/";
    public static final String DATA_URL_SCREEN = DATA_URL_IMAGES+"interface/screen/";
    public static final String DATA_URL_NUMBERS = DATA_URL_IMAGES+"interface/numbers/";
    public static final String DATA_URL_UNITS = DATA_URL_IMAGES+"units/";

    // Global
    private String key;
    private Vector<String> errors;
    private Vector<String> infos;

    // Agents
    private AgentXMWP xmwp;
    private AgentWorld world;
    private AgentBoard board;
    private AgentUnits units;

    // Data
    private static MediaTracker tracker = null;
    private static Hashtable<URL,Image> images = new Hashtable<URL, Image>();

    // panels
    private ChatPanel chatPanel;

    /**
     * MiddleWar game
     * @param key the key used for security (with server)
     * @param serverUrl the url of server servlet
     * @param panel main game panel
     * @throws middlewar.client.exception.ClientException
     */
    public Game(String key, String serverUrl, MainPanel mainPanel,ChatPanel chatPanel) throws ClientException {
        // loader
        if(tracker == null) tracker = new MediaTracker(mainPanel);
        // agents
        this.world = new AgentWorld();
        this.xmwp = new AgentXMWP(new XMWPCommunicator(key,serverUrl,this));
        this.board = new AgentBoard();
        this.units = new AgentUnits(new UnitBoard());
        // others
        this.errors = new Vector<String>();
        this.infos = new Vector<String>();
        this.key = key;
        // panels
        this.chatPanel = chatPanel;
    }


    /**
     * Preload images
     * @param bar the progress bar used to show process
     * @throws middlewar.client.exception.ClientException
     */
    public static void preloadImages(JProgressBar bar) throws ClientException{
        String[] list = {
            DATA_URL_SCREEN + "cursor_circle.png"
        };

        bar.setMinimum(0);
        bar.setMaximum(list.length);

        try {
            for(int i=0;i<list.length;i++){
                getImage(new URL(list[i]));
                bar.setValue(i+1);
                //bar.repaint();
            }
        } catch (MalformedURLException e) {
            throw new DataException(e);
        }
    }

    /**
     * Return a image (object)
     * @param url the url of a image
     * @return the image
     * @throws middlewar.client.exception.ClientException
     */
    public static Image getImage(URL url) throws ClientException{
        if(!images.containsKey(url)){
            Image image = Toolkit.getDefaultToolkit().getImage(url);
            loadImage(image);
            images.put(url, image);
        }
        return images.get(url);
    }

    /**
     * Load a image in memory
     * @param image the image to load
     * @throws middlewar.client.exception.ClientException
     */
    private static void loadImage(Image image) throws ClientException{
        Game.tracker.addImage(image, 0);
        try {
            Game.tracker.waitForID(0);
        }
        catch(InterruptedException e) {
            throw new ClientException(e);
        }
    }

    /**
     * Add a error message
     * @param message the error
     */
    public void addError(String message) {
        this.errors.add(message);
    }

    /**
     * Return all errors
     * @return the errors
     */
    public Vector<String> getErrors() {
        return this.errors;
    }


    /**
     * @see MouseEvent
     */
    public void mouseEntered(MouseEvent e) throws ClientException {
        int x = (int)(e.getX()/Constains.blockPxSize);
        int y = (int)(e.getY()/Constains.blockPxSize);
       
    }

    /**
     * @see MouseEvent
     */
    public void mouseExited(MouseEvent e) throws ClientException {
        this.board.setBlockCursorVisible(false);
    }

    /**
     * @see MouseEvent
     */
    public void mouseClicked(MouseEvent e) throws ClientException {
        int x = (int)(e.getX()/Constains.blockPxSize);
        int y = (int)(e.getY()/Constains.blockPxSize);

        // TODO

    }

    /**
     * @see MouseEvent
     */
    public void mouseMoved(MouseEvent e) throws ClientException {
        int x = (int)(e.getX()/Constains.blockPxSize);
        int y = (int)(e.getY()/Constains.blockPxSize);


        if(world.isBlockInWorld(x, y)){

            if(this.units.getUnit(x,y) != null){
                this.board.setBlockCursor(x, y, true, "cursor_circle.png");
            }
            else{

                if(world.isBlockPassing(x, y)){
                    this.board.setBlockCursor(x, y, true, "cursor_case.png");
                }else{
                    this.board.setBlockCursor(x, y, true, "cursor_case.png");
                }


                
            }

            /*
            Orientation border = this.world.getBorder(x,y);

            this.board.setCursor(TacticBoard.Cursor.HAND);
            this.board.setCursorPosition(e.getX(),e.getY());

            if(border != null){
                switch(border){
                    case UP : {
                        this.board.setCursor(TacticBoard.Cursor.UP);
                    } break;
                    case DOWN : {
                        this.board.setCursor(TacticBoard.Cursor.DOWN);
                    } break;
                    case RIGHT : {
                        this.board.setCursor(TacticBoard.Cursor.RIGHT);
                    } break;
                    case LEFT : {
                        this.board.setCursor(TacticBoard.Cursor.LEFT);
                    } break;
                }
            }*/

        }else this.board.setBlockCursorVisible(false);

    }

    public void onChatSendMessageClicked(String message){

        try {
            Collection<Unit> destinations = units.getUnitsAtSpeakRange(units.getSelectedUnit());
            xmwp.sayIm(units.getSelectedUnit(), destinations, message);
        } catch (XMWPException e) {
            addError(e.getMessage());
        }

    }

    /**
     * Add a info message
     * @param message the error
     */
    public void addInfo(String message) {
        this.infos.add(message);
    }

    /**
     * Return all infos
     * @return the errors
     */
    public Vector<String> getInfos() {
        return this.infos;
    }


    /*
     * Call agents
     *
     */

    public void start() {
        xmwp.start();
        world.start();
        board.start();
        units.start();
    }

    public void stop() {
        xmwp.stop();
        world.stop();
        board.stop();
        units.stop();
    }

    public void notifyUnit(Unit u) {
        xmwp.notifyUnit(u);
        world.notifyUnit(u);
        board.notifyUnit(u);
        units.notifyUnit(u);
    }

    public void mouseEntered(int x, int y) throws ClientException {
        xmwp.mouseEntered(x,y);
        world.mouseEntered(x,y);
        board.mouseEntered(x,y);
        units.mouseEntered(x,y);
    }


}
