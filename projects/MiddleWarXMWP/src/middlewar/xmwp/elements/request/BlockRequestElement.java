/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.request;

import middlewar.xmwp.*;

/**
 * BLOCK / Request
 * @author higurashi
 */
public class BlockRequestElement extends Element{

    private String map = null;

    public BlockRequestElement() throws XMWPException {
        super(ElementType.block, "onReceivedRequestBlock");
    }

    public BlockRequestElement(String map) throws XMWPException {
        super(ElementType.block, "onReceivedRequestBlock");
        this.map = map;
    }

    public String getMap() {
        return map;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        elt.setAttribute("map", map);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        map = attributes.getValue("map");
    }

}
