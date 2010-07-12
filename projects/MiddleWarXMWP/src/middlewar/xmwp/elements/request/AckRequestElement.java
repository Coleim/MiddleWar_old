/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.request;

import middlewar.xmwp.*;
import middlewar.xmwp.XMWPException;

/**
 * ACK / Request
 * @author higurashi
 */
public class AckRequestElement extends Element{

    public AckRequestElement() throws XMWPException {
        super(ElementType.ack, "onReceivedRequestAck");
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        // None
    }

}
