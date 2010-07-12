/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;
import middlewar.xmwp.XMWPException;

/**
 * ACK / Inform
 * @author higurashi
 */
public class AckInformElement extends Element{

    public AckInformElement() throws XMWPException {
        super(ElementType.ack, "onReceivedInformAck");
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
