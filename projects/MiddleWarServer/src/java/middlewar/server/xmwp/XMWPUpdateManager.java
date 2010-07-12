/*
 * Middle War - Server
 *
 */

package middlewar.server.xmwp;

import middlewar.server.Server;
import middlewar.server.business.player.Player;
import middlewar.xmwp.Element;
import middlewar.xmwp.Message;
import middlewar.xmwp.elements.inform.UnitInformElement;


/**
 * Manage players
 * @author higurashi
 */
public class XMWPUpdateManager {


    public XMWPUpdateManager() {}

    /**
     * Add updates to tell all player in a specified map
     * @param m the message containing updates
     * @param name the name of the map
     * @param source the player id sender of the updates (will not receive updates)
     */
    public void addUpdatesInMap(Message m,String name, String source){
        for(Element e : m.getInform()){
            addUpdateInMap(e,name,source);
        }
    }

    /**
     * Add an update to tell all player in a specified map
     * @param e the update
     * @param name the name of the map
     * @param source the player id sender of the updates (will not receive updates)
     */
    public void addUpdateInMap(Element e,String name,String source){
        for(Player p : Server.playerManager.getPlayersConnected()){
            if(p.getXmwpMapWatch().contains(name) && !p.getId().equals(source)){
                p.addXMWPUpdate(e);
            }
        }
    }

    /**
     * Add an update to tell all player in a specified map
     * @param e the update
     * @param name the name of the map
     */
    public void addUpdateInMap(Element e,String name){
        for(Player p : Server.playerManager.getPlayersConnected()){
            p.addXMWPUpdate(e);
        }
    }

}