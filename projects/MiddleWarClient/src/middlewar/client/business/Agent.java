/*
 * Middle War Client
 *
 */

package middlewar.client.business;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import middlewar.client.business.units.Unit;
import middlewar.client.exception.ClientException;
import middlewar.common.BlockPosition;

/**
 * Game agent
 * @author higurashi
 */
public interface Agent {

    /**
     * Actions to do when the client start
     */
    public void start() throws ClientException;
    
    /**
     * Actions to do when the client stop
     */
    public void stop() throws ClientException;

    /**
     * Mouse enter the client
     * @param e the mouse event generated
     * @param x the x position of the mouse in blocks
     * @param y the y position of the mouse in blocks
     * @param mapPosition the position in the map
     * @throws ClientException
     */
    public void mouseEntered(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException;

    /**
     * Mouse exit the client
     * @param e the mouse event generated
     * @param x the x position of the mouse in blocks
     * @param y the y position of the mouse in blocks
     * @param mapPosition the position in the map
     * @throws ClientException
     */
    public void mouseExited(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException;

    /**
     * Mouse is clicked in the client
     * @param e the mouse event generated
     * @param x the x position of the mouse in blocks
     * @param y the y position of the mouse in blocks
     * @param mapPosition the position in the map
     * @throws ClientException
     */
    public void mouseClicked(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException;

    /**
     * Mouse move in the client
     * @param e the mouse event generated
     * @param x the x position of the mouse in blocks
     * @param y the y position of the mouse in blocks
     * @param mapPosition the position in the map
     * @throws ClientException
     */
    public void mouseMoved(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException;

    /**
     * Key typed
     * @param e the key event
     * @param keyChar the char typed
     * @throws ClientException
     */
    public void keyTyped(KeyEvent e, char keyChar) throws ClientException;

    /**
     * Key pressed
     * @param e the key event
     * @param keyChar the char pressed
     * @throws ClientException
     */
    public void keyPressed(KeyEvent e, char keyChar) throws ClientException;

    /**
     * Key released
     * @param e the key event
     * @param keyChar the char released
     * @throws ClientException
     */
    public void keyReleased(KeyEvent e, char keyChar) throws ClientException;

    /**
     * Add a new unit in the game
     * @param u the unit to add
     * @throws ClientException
     */
    public void addUnit(Unit u) throws ClientException;

    /**
     * Modify a unit of the game
     * @param u the modified unit
     * @throws ClientException
     */
    public void modifyUnit(Unit u) throws ClientException;

    /**
     * Remove a unit from the game
     * @param id the id of the unit to delete
     * @throws ClientException
     */
    public void deleteUnit(String id) throws ClientException;

    /**
     * Send a chat message
     * @param message the message
     * @throws ClientException
     */
    public void onChatSendMessageClicked(String message) throws ClientException;

}
