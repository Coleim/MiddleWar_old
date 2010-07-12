/*
 * Middle War Client
 *
 */

package middlewar.client.business;


import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import middlewar.client.business.units.Unit;
import middlewar.client.business.xmwp.*;
import middlewar.client.exception.ClientException;
import middlewar.common.BlockPosition;
import middlewar.xmwp.*;
import middlewar.xmwp.client.*;
import middlewar.xmwp.elements.inform.*;
import middlewar.xmwp.elements.request.*;

/**
 * XMWP game agent
 * @author higurashi
 */
public class AgentXMWP extends AbstractAgent{

    private XMWPClientThread communicator;

    /*
     * Agent management methods
     */

    private static AgentXMWP instance = null;

    public static AgentXMWP getInstance() throws ClientException{
        if(instance == null) throw new ClientException("AgentXMWP not initialized (call init())");
        return instance;
    }

    public static void init(String key, String serverUrl) throws ClientException {
        instance = new AgentXMWP(key, serverUrl);
    }

    private AgentXMWP(String key, String serverUrl) {
        this.communicator = new XMWPClientThread(key, serverUrl);
    }

    /*
     * AbstractAgent methods implementation
     */

    @Override
    public void stop(){ this.communicator.stop(); }

    @Override
    public void start() { this.communicator.start(); }

    @Override
    public void mouseClicked(MouseEvent e, int x, int y, BlockPosition mapPosition) throws ClientException {
        if(Game.getAgentUnits().getSelectedUnit()!=null){
            try {
                BlockPosition selected = Game.getAgentUnits().getSelectedUnit().getPosition();
                ClientMessage message = new ClientMessage(communicator.getKey());
                if (selected.up().equals(mapPosition)) {
                    message.addRequest(new MoveRequestElement(Game.getAgentUnits().getSelectedUnit().getId(), Game.getAgentUnits().getSelectedUnit().getMap(), selected.getBlockX(), selected.up().getBlockY()));
                } else if (selected.down().equals(mapPosition)) {
                    message.addRequest(new MoveRequestElement(Game.getAgentUnits().getSelectedUnit().getId(), Game.getAgentUnits().getSelectedUnit().getMap(), selected.getBlockX(), selected.down().getBlockY()));
                } else if (selected.right().equals(mapPosition)) {
                    message.addRequest(new MoveRequestElement(Game.getAgentUnits().getSelectedUnit().getId(), Game.getAgentUnits().getSelectedUnit().getMap(), selected.right().getBlockX(), selected.getBlockY()));
                } else if (selected.left().equals(mapPosition)) {
                    message.addRequest(new MoveRequestElement(Game.getAgentUnits().getSelectedUnit().getId(), Game.getAgentUnits().getSelectedUnit().getMap(), selected.left().getBlockX(), selected.getBlockY()));
                }
                this.communicator.pushMessage(message);
            } catch (XMWPException ex) {
                throw new ClientException(ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e, char keyChar) throws ClientException {
        Game.getInstance().addInfo("!!!"+keyChar);
        Unit u = Game.getAgentUnits().getSelectedUnit();
        if(u!=null){
            try {
                BlockPosition selected = u.getPosition();
                ClientMessage message = new ClientMessage(communicator.getKey());
                if (e.getKeyCode()==KeyEvent.VK_UP) {
                    message.addRequest(new MoveRequestElement(Game.getAgentUnits().getSelectedUnit().getId(), Game.getAgentUnits().getSelectedUnit().getMap(), selected.getBlockX(), selected.up().getBlockY()));
                } else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
                    message.addRequest(new MoveRequestElement(Game.getAgentUnits().getSelectedUnit().getId(), Game.getAgentUnits().getSelectedUnit().getMap(), selected.getBlockX(), selected.down().getBlockY()));
                } else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    message.addRequest(new MoveRequestElement(Game.getAgentUnits().getSelectedUnit().getId(), Game.getAgentUnits().getSelectedUnit().getMap(), selected.right().getBlockX(), selected.getBlockY()));
                } else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                    message.addRequest(new MoveRequestElement(Game.getAgentUnits().getSelectedUnit().getId(), Game.getAgentUnits().getSelectedUnit().getMap(), selected.left().getBlockX(), selected.getBlockY()));
                }
                this.communicator.pushMessage(message);
            } catch (XMWPException ex) {
                throw new ClientException(ex);
            }
        }
    }



    @Override
    public void onChatSendMessageClicked(String message) throws ClientException {
        try {
            //Collection<Unit> destinations = Game.getAgentUnits().getUnitsAtSpeakRange(Game.getAgentUnits().getSelectedUnit());
            sayIm(Game.getAgentUnits().getSelectedUnit(), message);
        } catch (XMWPException e) {
            Game.getInstance().addError(e.getMessage());
        }
    }

    /*
     * Business methods
     */

    public String[] getRecvInformHistory() {
        return communicator.getRecvInformHistory();
    }

    public String[] getRecvRequestHistory() {
        return communicator.getRecvRequestHistory();
    }

    public String[] getSendInformHistory() {
        return communicator.getSendInformHistory();
    }

    public String[] getSendRequestHistory() {
        return communicator.getSendRequestHistory();
    }

    public Date[] getRecvDateHistory() {
        return communicator.getRecvDateHistory();
    }

    public Date[] getSendDateHistory() {
        return communicator.getSendDateHistory();
    }

    public void sayRefreshMeToServer() throws XMWPException {
        if(communicator.getMessageStackSize() == 0){
            ClientMessage message = new ClientMessage(communicator.getKey());
            message.addRequest(new AckRequestElement());
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
     * Send a instant message
     * @param source the source unit of the message
     * @param message the message
     * @throws XMWPException
     */
    void sayIm(Unit source, String message) throws XMWPException {
        ClientMessage m = new ClientMessage(communicator.getKey());
        
        m.addInform(new ImInformElement(source.getId(),
                                        null,
                                        message));
        
        this.communicator.pushMessage(m);
    }

}
