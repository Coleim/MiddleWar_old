/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.logic;

import middlewar.xmwp.elements.inform.*;
import middlewar.xmwp.elements.request.*;
import middlewar.xmwp.Element;
import middlewar.xmwp.Message;
import middlewar.xmwp.XMWPException;

/**
 * XMWP minimum logic
 * @author higurashi
 */
public class XMWPBaseLogic implements XMWPLogic{

    //////////////// GEN. //////////////////////////////////////////////////////

    public void onReceived(Element elt, Message message) throws XMWPException {
        elt.onReceived(this, message);
    }

    //////////////// Inform. ///////////////////////////////////////////////////

    public void onReceivedInformBye(ByeInformElement element, Message message) throws XMWPException {
        message.SendAck();
    }

    public void onReceivedInformHello(HelloInformElement element, Message message) throws XMWPException {
        message.SendAck();
    }

    public void onReceivedInformAck(AckInformElement element, Message message) throws XMWPException {
        // nop
    }

    public void onReceivedInformError(ErrorInformElement element, Message message) throws XMWPException {
        message.SendAck();
    }

    public void onReceivedInformBlock(BlockInformElement element, Message message) throws XMWPException {
        message.SendAck();
    }

    public void onReceivedInformIm(ImInformElement element, Message message) throws XMWPException {
        // nop
    }

    public void onReceivedInformPlayer(PlayerInformElement element,Message message) throws XMWPException {
        // nop
    }

    public void onReceivedInformUnit(UnitInformElement element,Message message) throws XMWPException {
        // nop
    }

    public void onReceivedInformMove(MoveInformElement element, Message message) throws XMWPException {
        // nop
    }

    public void onReceivedInformSkill(SkillInformElement element, Message message) throws XMWPException {
        // nop
    }

    //////////////// req. //////////////////////////////////////////////////////


    public void onReceivedRequestAck(AckRequestElement element, Message message) throws XMWPException {
        message.SendAck();
    }

    public void onReceivedRequestBlock(BlockRequestElement element, Message message) throws XMWPException {
        // nop
    }

    public void onReceivedRequestIm(ImRequestElement element, Message message) throws XMWPException {
        // nop
    }

    public void onReceivedRequestPlayer(PlayerRequestElement element, Message message) throws XMWPException {
        // nop
    }

    public void onReceivedRequestUnit(UnitRequestElement element,Message message) throws XMWPException {
        // nop
    }

    public void onReceivedRequestMove(MoveRequestElement element,Message message) throws XMWPException {
        // nop
    }

    public void onReceivedRequestUpdate(UpdateRequestElement element, Message message) throws XMWPException {
        // nop
    }







}
