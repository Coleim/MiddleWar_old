/*
 * Middle War Client
 *
 */

package middlewar.client.business;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

import middlewar.client.MainApplet;
import middlewar.client.MainPanel;
import middlewar.common.*;

import middlewar.client.business.units.*;
import middlewar.client.exception.*;

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
    private final String key;
    private String playerId;
    private Vector<String> errors;
    private Vector<String> infos;
    private Vector<String> chat;
    private static Game instance = null;
    private MainApplet mainApplet; // a utiliser avec parcimonie

    // Data
    private static MediaTracker tracker = null;
    private static Hashtable<URL,Image> images = new Hashtable<URL, Image>();

    /**
     * MiddleWar game
     * @param key the key used for security (with server)
     * @param serverUrl the url of server servlet
     * @param panel main game panel
     * @throws middlewar.client.exception.ClientException
     */
    public Game(String key, String serverUrl, MainApplet mainApplet) throws ClientException, GameAlreadyStartedException {
        if(instance != null) throw new GameAlreadyStartedException("Game instance aleady exist");
        if(mainApplet == null) throw new ClientException("mainApplet is null");
        instance = this;
        // others
        this.errors = new Vector<String>();
        this.infos = new Vector<String>();
        this.chat = new Vector<String>();
        this.key = key;
        this.playerId = null;
        this.mainApplet = mainApplet;
        // loader
        if(tracker == null) tracker = new MediaTracker(mainApplet.getMainPanel());
        // agents
        AgentBoard.init();
        AgentXMWP.init(key,serverUrl);
        AgentWorld.init();
        AgentUnits.init();
        AgentWorld.getInstance();
        AgentXMWP.getInstance();
        AgentBoard.getInstance();
        AgentUnits.getInstance();

    }

    /**
     * Return the Id of the player
     * @return the id (server side)
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     * Modify the Id of the player
     * @param playerId the new player Id
     */
    public void setPlayerId(String playerId) throws ClientException {
        if(this.playerId==null){
            this.playerId = playerId;
        }else throw new ClientException("can no re-set player ID ("+this.playerId+")");
    }

    /**
     * Return the security key used to communicate with the server
     * @return the security key
     */
    public String getKey() {
        return key;
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

    /**
     * Add a unit speak to the chat box
     * @param us the message
     */
    public void addUnitSpeakToChat(UnitSpeak us){
        Date d = new Date();
        this.chat.add(us.getUnitId()+"@"+d+" > "+us.getText());
        mainApplet.getChatPanel().updateChat();
    }

    /**
     * Return the unit speaks
     * @return a list a speaks
     */
    public Iterable<String> getChatUnitSpeaks(){
        return this.chat;
    }

    /**
     * Return the game instance
     * @return the instance
     */
    public static Game getInstance(){
        return instance;
    }

    /**
     * @see MouseEvent
     */
    public void mouseEntered(MouseEvent e) throws ClientException {
        int x = (int)(e.getX()/Constants.blockPxSize);
        int y = (int)(e.getY()/Constants.blockPxSize);
        this.mouseEntered(e, x, y,getAgentWorld().convertBoardPositionToMapPosition(x,y));
    }

    /**
     * @see MouseEvent
     */
    public void mouseExited(MouseEvent e) throws ClientException {
        int x = (int)(e.getX()/Constants.blockPxSize);
        int y = (int)(e.getY()/Constants.blockPxSize);
        this.mouseExited(e, x, y,getAgentWorld().convertBoardPositionToMapPosition(x,y));
    }

    /**
     * @see MouseEvent
     */
    public void mouseClicked(MouseEvent e) throws ClientException {
        int x = (int)(e.getX()/Constants.blockPxSize);
        int y = (int)(e.getY()/Constants.blockPxSize);
        this.mouseClicked(e, x, y,getAgentWorld().convertBoardPositionToMapPosition(x,y));
    }

    /**
     * @see MouseEvent
     */
    public void mouseMoved(MouseEvent e) throws ClientException {
        int x = (int)(e.getX()/Constants.blockPxSize);
        int y = (int)(e.getY()/Constants.blockPxSize);
        this.mouseMoved(e, x, y,getAgentWorld().convertBoardPositionToMapPosition(x,y));
    }

    /**
     * @see KeyEvent
     */
    public void keyTyped(KeyEvent e) throws ClientException {
        this.keyTyped(e,e.getKeyChar());
    }

    /**
     * @see KeyEvent
     */
    public void keyPressed(KeyEvent e) throws ClientException {
        this.keyPressed(e,e.getKeyChar());
    }

    /**
     * @see KeyEvent
     */
    public void keyReleased(KeyEvent e) throws ClientException {
        this.keyReleased(e,e.getKeyChar());
    }


    /*
     * Call agents methods
     *
     */

    public static AgentWorld getAgentWorld() throws ClientException{
        return AgentWorld.getInstance();
    }

    public static AgentUnits getAgentUnits() throws ClientException{
        return AgentUnits.getInstance();
    }

    public static AgentBoard getAgentBoard() throws ClientException{
        return AgentBoard.getInstance();
    }

    public static AgentXMWP getAgentXMWP() throws ClientException{
        return AgentXMWP.getInstance();
    }

    @Override
    public void start() throws ClientException{
        AgentWorld.getInstance().start();
        AgentXMWP.getInstance().start();
        AgentBoard.getInstance().start();
        AgentUnits.getInstance().start();
    }

    @Override
    public void stop() throws ClientException{
        AgentWorld.getInstance().stop();
        AgentXMWP.getInstance().stop();
        AgentBoard.getInstance().stop();
        AgentUnits.getInstance().stop();
    }

    @Override
    public void mouseEntered(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {
        AgentWorld.getInstance().mouseEntered(e, x, y, mapPosition);
        AgentXMWP.getInstance().mouseEntered(e, x, y, mapPosition);
        AgentBoard.getInstance().mouseEntered(e, x, y, mapPosition);
        AgentUnits.getInstance().mouseEntered(e, x, y, mapPosition);
    }

    @Override
    public void mouseExited(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {
        AgentWorld.getInstance().mouseExited(e, x, y, mapPosition);
        AgentXMWP.getInstance().mouseExited(e, x, y, mapPosition);
        AgentBoard.getInstance().mouseExited(e, x, y, mapPosition);
        AgentUnits.getInstance().mouseExited(e, x, y, mapPosition);
    }

    @Override
    public void mouseClicked(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {
        AgentWorld.getInstance().mouseClicked(e, x, y, mapPosition);
        AgentXMWP.getInstance().mouseClicked(e, x, y, mapPosition);
        AgentBoard.getInstance().mouseClicked(e, x, y, mapPosition);
        AgentUnits.getInstance().mouseClicked(e, x, y, mapPosition);
    }

    @Override
    public void mouseMoved(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {
        AgentWorld.getInstance().mouseMoved(e, x, y, mapPosition);
        AgentXMWP.getInstance().mouseMoved(e, x, y, mapPosition);
        AgentBoard.getInstance().mouseMoved(e, x, y, mapPosition);
        AgentUnits.getInstance().mouseMoved(e, x, y, mapPosition);
    }

    @Override
    public void addUnit(Unit u) throws ClientException {
        AgentWorld.getInstance().addUnit(u);
        AgentXMWP.getInstance().addUnit(u);
        AgentBoard.getInstance().addUnit(u);
        AgentUnits.getInstance().addUnit(u);
    }

    @Override
    public void modifyUnit(Unit u) throws ClientException {
        AgentWorld.getInstance().modifyUnit(u);
        AgentXMWP.getInstance().modifyUnit(u);
        AgentBoard.getInstance().modifyUnit(u);
        AgentUnits.getInstance().modifyUnit(u);
    }

    @Override
    public void deleteUnit(String id) throws ClientException {
        AgentWorld.getInstance().deleteUnit(id);
        AgentXMWP.getInstance().deleteUnit(id);
        AgentBoard.getInstance().deleteUnit(id);
        AgentUnits.getInstance().deleteUnit(id);
    }

    @Override
    public void onChatSendMessageClicked(String message) throws ClientException{
        AgentWorld.getInstance().onChatSendMessageClicked(message);
        AgentXMWP.getInstance().onChatSendMessageClicked(message);
        AgentBoard.getInstance().onChatSendMessageClicked(message);
        AgentUnits.getInstance().onChatSendMessageClicked(message);
    }

    @Override
    public void keyTyped(KeyEvent e, char keyChar) throws ClientException{
        AgentWorld.getInstance().keyTyped(e,keyChar);
        AgentXMWP.getInstance().keyTyped(e,keyChar);
        AgentBoard.getInstance().keyTyped(e,keyChar);
        AgentUnits.getInstance().keyTyped(e,keyChar);
    }

    @Override
    public void keyPressed(KeyEvent e, char keyChar) throws ClientException{
        AgentWorld.getInstance().keyPressed(e,keyChar);
        AgentXMWP.getInstance().keyPressed(e,keyChar);
        AgentBoard.getInstance().keyPressed(e,keyChar);
        AgentUnits.getInstance().keyPressed(e,keyChar);
    }

    @Override
    public void keyReleased(KeyEvent e, char keyChar) throws ClientException{
        AgentWorld.getInstance().keyReleased(e,keyChar);
        AgentXMWP.getInstance().keyReleased(e,keyChar);
        AgentBoard.getInstance().keyReleased(e,keyChar);
        AgentUnits.getInstance().keyReleased(e,keyChar);
    }

    /*
     * Business Game methods
     *
     */

    /**
     * Preload images
     * @param bar the progress bar used to show process
     * @throws middlewar.client.exception.ClientException
     */
    public static void preloadImages(JProgressBar bar) throws ClientException{

        if(instance == null) throw new ClientException("Game instance do not exist");

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
            try{
                loadImage(image);
            }
            catch(Exception e){
                throw new ClientException("Error loading image ("+e.toString()+") : \n"+url.toString());
            }
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




}
