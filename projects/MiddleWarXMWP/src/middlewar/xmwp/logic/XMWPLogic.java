/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.logic;

import middlewar.xmwp.elements.inform.*;
import middlewar.xmwp.elements.request.*;
import middlewar.xmwp.*;

/**
 * XMWP compute logic
 * @author higurashi
 */
public interface XMWPLogic {

    /*
     * The methods, modify a message according a
     * received element.
     *
     * others treatments must be implemented in
     * new implementation (subclass)
     */

    // Request
    public void onReceivedRequestAck(AckRequestElement element,Message message) throws XMWPException;
    public void onReceivedRequestBlock(BlockRequestElement element,Message message) throws XMWPException;
    public void onReceivedRequestIm(ImRequestElement element,Message message) throws XMWPException;
    public void onReceivedRequestPlayer(PlayerRequestElement element,Message message) throws XMWPException;
    public void onReceivedRequestUnit(UnitRequestElement element,Message message) throws XMWPException;
    public void onReceivedRequestMove(MoveRequestElement element,Message message) throws XMWPException;
    public void onReceivedRequestUpdate(UpdateRequestElement element,Message message) throws XMWPException;

    // Inform
    public void onReceivedInformBye(ByeInformElement element,Message message) throws XMWPException;
    public void onReceivedInformHello(HelloInformElement element,Message message) throws XMWPException;
    public void onReceivedInformAck(AckInformElement element,Message message) throws XMWPException;
    public void onReceivedInformError(ErrorInformElement element,Message message) throws XMWPException;
    public void onReceivedInformBlock(BlockInformElement element,Message message) throws XMWPException;
    public void onReceivedInformIm(ImInformElement element,Message message) throws XMWPException;
    public void onReceivedInformPlayer(PlayerInformElement element,Message message) throws XMWPException;
    public void onReceivedInformUnit(UnitInformElement element,Message message) throws XMWPException;

    // generic
    public abstract void onReceived(Element elt, Message message) throws XMWPException;


}
