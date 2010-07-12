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

    private String world = null;

    public BlockRequestElement() throws XMWPException {
        super(ElementType.block, "onReceivedRequestBlock");
    }

    public BlockRequestElement(String world) throws XMWPException {
        super(ElementType.block, "onReceivedRequestBlock");
        this.world = world;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        elt.setAttribute("world", world);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        world = attributes.getValue("world");
    }

}
