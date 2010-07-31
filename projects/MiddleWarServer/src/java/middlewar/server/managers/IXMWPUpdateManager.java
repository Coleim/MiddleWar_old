/*
 * Middle War - Server
 *
 */

package middlewar.server.managers;

import middlewar.xmwp.*;

/**
 * Manage XMWP Updates
 * @author Higurashi
 */
public interface IXMWPUpdateManager extends IManager{

    /**
     * Add updates to tell all player in a specified map
     * @param m the message containing updates
     * @param name the name of the map
     * @param source the player id sender of the updates (will not receive updates)
     */
    public void addUpdatesInMap(Message m,String name, String source);

    /**
     * Add an update to tell all player in a specified map
     * @param e the update
     * @param name the name of the map
     * @param source the player id sender of the updates (will not receive updates)
     */
    public void addUpdateInMap(Element e,String name,String source);

    /**
     * Add an update to tell all player in a specified map
     * @param e the update
     * @param name the name of the map
     */
    public void addUpdateInMap(Element e,String name);

}
