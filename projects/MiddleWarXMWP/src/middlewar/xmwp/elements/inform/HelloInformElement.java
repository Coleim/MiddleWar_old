/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * HELLO / Inform
 * @author higurashi
 */
public class HelloInformElement extends Element{

    private String name = null;

    public HelloInformElement() throws XMWPException {
        super(ElementType.hello, "onReceivedInformHello");
    }

    public HelloInformElement(String name) throws XMWPException {
        super(ElementType.hello, "onReceivedInformHello");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        if(name != null) elt.setAttribute("name", name);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        name = attributes.getValue("name"); // may be null
    }

}
