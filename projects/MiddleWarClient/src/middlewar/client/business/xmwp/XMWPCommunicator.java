/*
 * Middle War - Client
 * version 1.0
 */

package middlewar.client.business.xmwp;

import middlewar.client.business.Game;

/**
 * Send messages to the server
 * @author higurashi
 */
public class XMWPCommunicator extends XMWPClientThread{

    public XMWPCommunicator(String key,String server,Game game) {
        this.serverServletUrl = server;
        this.key = key;
        this.game = game;
    }

}
