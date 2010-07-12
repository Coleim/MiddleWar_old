/*
 * Middle War - Client
 *
 */

package middlewar.client.business.xmwp;

import middlewar.xmwp.elements.inform.*;
import middlewar.xmwp.elements.request.*;
import middlewar.client.business.units.*;
import middlewar.client.exception.ClientException;
import middlewar.common.BlockPosition;
import middlewar.xmwp.*;
import middlewar.xmwp.logic.*;

/**
 * XMWP logic
 * @author higurashi
 */
public class XMWPClientLogic extends XMWPBaseLogic{

    private XMWPClientThread link;

    public XMWPClientLogic(XMWPClientThread link) {
        this.link = link;
    }

    @Override
    public void onReceivedInformPlayer(PlayerInformElement element, Message message) throws XMWPException {
        String ids[] = element.getUnits();
        for(String id : ids){
            message.addRequest(new UnitRequestElement(id));
        }
    }

    @Override
    public void onReceivedInformUnit(UnitInformElement element, Message message) throws XMWPException {

        link.getGame().addInfo("toto");
        Unit u = new Unit("toto");
        u.setX(1);
        u.setY(1);
        u.addGraphicalPart("m_1", 0, 0, 0, 0);
        link.getGame().getAgentUnit().addUnit(u);
        link.getGame().getAgentUnit().setSelectedUnit(u);

        link.getGame().getAgentWorld().setFocusPosition(u.getPosition());
        link.getGame().getAgentWorld().setFocusWorld(element.getWorld());

    }



    @Override
    public void onReceivedInformIm(ImInformElement element, Message message)  {
        Unit u = link.getGame().getAgentUnit().getUnit(element.getSourceUnitId());
        UnitSpeak us = new UnitSpeak(element.getMessage(), u);
        link.getGame().getAgentUnit().addUnitSpeak(us);
        link.getGame().getChatPanel().addChatHistory(u.getId(), element.getMessage());
    }

    @Override
    public void onReceivedInformError(ErrorInformElement element, Message message) {
        link.getGame().addError("<srv err> "+element.getMessage());
    }

    @Override
    public void onReceivedInformBlock(BlockInformElement element, Message message) {
        
        
        try {
            link.getGame().getAgentWorld().setBlock(
                    element.getX(),
                    element.getY(),
                    element.getLayer(),
                    element.getOrder(),
                    element.getWorld(),
                    element.getImage()
            );
        } catch (ClientException e) {
            link.getGame().addError(e.getMessage());
        }
        
    }

}
