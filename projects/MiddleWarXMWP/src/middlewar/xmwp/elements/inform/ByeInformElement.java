/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * BYE / Inform
 * @author higurashi
 */
public class ByeInformElement extends Element{

    public ByeInformElement() throws XMWPException {
        super(ElementType.bye, "onReceivedInformBye");
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
