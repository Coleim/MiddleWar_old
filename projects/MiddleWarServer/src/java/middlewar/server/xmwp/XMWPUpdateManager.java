/*
 * Middle War - Server
 *
 */

package middlewar.server.xmwp;

import middlewar.server.managers.IXMWPUpdateManager;
import middlewar.server.Server;
import middlewar.server.business.player.Player;
import middlewar.xmwp.*;



/**
 * Manage XMWP Updates
 * @author higurashi
 */
public class XMWPUpdateManager implements IXMWPUpdateManager{

    /**
     * Initialise the manager
     */
    public XMWPUpdateManager() {
        Server.logs.logMainInfo("start XMWPUpdateManager");
        Server.logs.logInfo("XMWPUpdateManager started");
    }

    @Override
    public void addUpdatesInMap(Message m,String name, String source){
        for(Element e : m.getInform()){
            addUpdateInMap(e,name,source);
        }
    }

    @Override
    public void addUpdateInMap(Element e,String name,String source){
        for(Player p : Server.playerManager.getPlayersConnected()){
            if(p.getXmwpMapWatch().contains(name) && !p.getId().equals(source)){
                p.addXMWPUpdate(e);
            }
        }
    }

    @Override
    public void addUpdateInMap(Element e,String name){
        for(Player p : Server.playerManager.getPlayersConnected()){
            p.addXMWPUpdate(e);
        }
    }

}