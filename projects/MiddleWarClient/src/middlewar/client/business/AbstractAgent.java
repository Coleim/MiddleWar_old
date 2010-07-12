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
 * @author higurashi
 */
public abstract class AbstractAgent implements Agent{

    // Agent methods

    @Override
    public void start() throws ClientException {}

    @Override
    public void stop() throws ClientException {}

    @Override
    public void mouseEntered(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {}

    @Override
    public void mouseExited(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {}

    @Override
    public void mouseClicked(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {}

    @Override
    public void mouseMoved(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {}

    @Override
    public void keyTyped(KeyEvent e, char keyChar) throws ClientException {}

    @Override
    public void keyPressed(KeyEvent e, char keyChar) throws ClientException {}

    @Override
    public void keyReleased(KeyEvent e, char keyChar) throws ClientException {}

    @Override
    public void addUnit(Unit u) throws ClientException {}

    @Override
    public void modifyUnit(Unit u) throws ClientException {}

    @Override
    public void deleteUnit(String id) throws ClientException {}

    @Override
    public void onChatSendMessageClicked(String message) throws ClientException {}

    // Methods to implement in subclasses

    public static void init() throws ClientException {
        throw new ClientException("init() not implemented");
    }

    public static Object getInstance() throws ClientException{
        throw new ClientException("getInstance() not implemented");
    }

}
