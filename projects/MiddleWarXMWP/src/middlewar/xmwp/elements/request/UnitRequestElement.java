/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.request;

import middlewar.xmwp.*;

/**
 * UNIT / Request
 * @author higurashi
 */
public class UnitRequestElement extends Element{

    private String id = null;

    public UnitRequestElement() throws XMWPException {
        super(ElementType.unit, "onReceivedRequestUnit");
    }

    public UnitRequestElement(String id) throws XMWPException {
        super(ElementType.unit, "onReceivedRequestUnit");
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
        id = attributes.getValue("id");
    }

}
