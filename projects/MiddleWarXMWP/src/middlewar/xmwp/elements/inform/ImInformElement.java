/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * IM / Inform
 * @author higurashi
 */
public class ImInformElement extends Element{

    private String message = null;
    private String unitId = null;
    private String playerId = null;

    public ImInformElement() throws XMWPException {
        super(ElementType.im, "onReceivedInformIm");
    }

    public ImInformElement(String unitId,String playerId,String message) throws XMWPException {
        super(ElementType.im, "onReceivedInformIm");
        this.unitId = unitId;
        this.playerId = playerId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getUnitId() {
        return unitId;
    }

    public String getPlayerId() {
        return playerId;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        if(unitId != null) elt.setAttribute("unitId", unitId);
        if(playerId != null) elt.setAttribute("playerId", playerId);
        if(message != null) elt.setAttribute("message", message);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        message = attributes.getValue("message");
        unitId = attributes.getValue("unitId");
        playerId = attributes.getValue("playerId");
    }

}
