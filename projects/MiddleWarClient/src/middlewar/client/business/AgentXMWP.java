/*
 * Middle War - Client
 *
 */

package middlewar.client.business;

import middlewar.xmwp.elements.inform.HelloInformElement;
import middlewar.xmwp.elements.inform.ImInformElement;
import middlewar.xmwp.elements.request.PlayerRequestElement;
import java.util.Collection;
import middlewar.client.business.units.Unit;
import middlewar.client.business.xmwp.*;
import middlewar.xmwp.*;
import middlewar.xmwp.client.*;
import middlewar.xmwp.elements.*;

/**
 * XMWP game agent
 * @author higurashi
 */
public class AgentXMWP implements Agent{

    private XMWPCommunicator communicator;

    public AgentXMWP(XMWPCommunicator communicator) {
        this.communicator = communicator;
    }

    public XMWPCommunicator getCommunicator() {
        return communicator;
    }

    public void sayRefreshMeToServer() throws XMWPException {
        if(communicator.getMessageStackSize() == 0){
            ClientMessage message = new ClientMessage(communicator.getKey());
            message.SendAck();
            this.communicator.pushMessage(message);
        }
    }

    /**
     * Send a HELLO message to the server
     * @throws middlewar.xmwp.XMWPException
     */
    public void sayHelloToServer() throws XMWPException{
        ClientMessage message = new ClientMessage(communicator.getKey());
        message.addInform(new HelloInformElement("middlewar-client-applet"));
        message.addRequest(new PlayerRequestElement());
        //message.addRequest(new GetBlockElement("basic"));
        this.communicator.pushMessage(message);
    }

    /**
     * Send a BYE message to the server
     * @throws middlewar.xmwp.XMWPException
     */
    public void sayByeToServer() throws XMWPException{
        this.communicator.flushMessages();
        ClientMessage message = new ClientMessage(communicator.getKey());
        message.SendBye();
        this.communicator.pushMessage(message);
    }

    /**
     * @see GameAgent
     */
    public void stop(){ this.communicator.stop(); }

    /**
     * @see GameAgent
     */
    public void start() { this.communicator.start(); }

    void sayIm(Unit source, Collection<Unit> destinations, String message) throws XMWPException {
        ClientMessage m = new ClientMessage(communicator.getKey());
        for(Unit u : destinations){
            m.addInform(new ImInformElement(source.getId(),
                                    u.getUserId(),
                                    message)
                     );
        }
        this.communicator.pushMessage(m);
    }

}
