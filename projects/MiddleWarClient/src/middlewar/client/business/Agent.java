/*
 * Middle War Client
 *
 */

package middlewar.client.business;

import java.awt.event.MouseEvent;
import middlewar.client.business.units.Unit;
import middlewar.client.exception.ClientException;

/**
 * Game agent
 * @author higurashi
 */
public interface Agent {

    /**
     * Start the agent
     */
    public void start();
    
    /**
     * Stop the agent
     */
    public void stop();

    public void notifyUnit(Unit u);

    public void mouseEntered(int x, int y) throws ClientException;

}
