/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.request;

import middlewar.xmwp.*;

/**
 * PLAYER / Request
 * @author higurashi
 */
public class PlayerRequestElement extends Element{

    private String id = null; // player id , null => implicit the sender of the message

    public PlayerRequestElement() throws XMWPException {
        super(ElementType.player, "onReceivedRequestPlayer");
    }

    public PlayerRequestElement(String id) throws XMWPException {
        super(ElementType.player, "onReceivedRequestPlayer");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        if(id != null) elt.setAttribute("id", id);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        if(attributes.getValue("id") != null) id = attributes.getValue("id");
    }

}
