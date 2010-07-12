/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * ERROR / Inform
 * @author higurashi
 */
public class ErrorInformElement extends Element{

    private String message = null;

    public ErrorInformElement() throws XMWPException {
        super(ElementType.error, "onReceivedInformError");
    }

    public ErrorInformElement(String message) throws XMWPException {
        super(ElementType.error, "onReceivedInformError");
        this.message = message;
    }

    public String getMessage() {
        if(message != null) return message; else return new String("unknown error (no message)");
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        if(message != null) elt.setAttribute("message", message);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        message = attributes.getValue("message");
    }

}
