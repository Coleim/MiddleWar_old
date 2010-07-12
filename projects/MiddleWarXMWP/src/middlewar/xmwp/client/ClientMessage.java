/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.client;

import middlewar.xmwp.*;

/**
 * XMWP client message
 * @author higurashi
 */
public class ClientMessage extends Message{

    public ClientMessage(String key) throws XMWPException {
        super();
        this.key = key;
    }



}
