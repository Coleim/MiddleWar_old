/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.request;

import middlewar.xmwp.*;

/**
 * IM / Request
 * @author higurashi
 */
public class ImRequestElement extends Element{

    private String playerId = null;
    private boolean activate = true;

    public ImRequestElement() throws XMWPException {
        super(ElementType.im, "onReceivedRequestIm");
    }

    public ImRequestElement(String playerId,boolean activate) throws XMWPException {
        super(ElementType.im, "onReceivedRequestIm");
        this.playerId = playerId;
        this.activate = activate;
    }

    public boolean isActivate() {
        return activate;
    }

    public String getPlayerId() {
        return playerId;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        if(playerId != null) elt.setAttribute("playerId", playerId);
        elt.setAttribute("activate", String.valueOf(activate));
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        playerId = attributes.getValue("playerId");
        activate = Boolean.valueOf(attributes.getValue("activate"));
    }

}
