/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.request;

import middlewar.xmwp.*;

/**
 * UPDATE / Inform
 * @author higurashi
 */
public class UpdateRequestElement extends Element{

    private String map = null;
    private boolean subscribe = false;

    public UpdateRequestElement() throws XMWPException {
        super(ElementType.update, "onReceivedRequestUpdate");
    }

    public UpdateRequestElement(String map,boolean subscribe) throws XMWPException {
        super(ElementType.update, "onReceivedRequestUpdate");
        this.map = map;
        this.subscribe = subscribe;
    }

    public String getMap() {
        return map;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        elt.setAttribute("map", map);
        elt.setAttribute("subscribe", String.valueOf(subscribe));
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        map = attributes.getValue("map");
        subscribe = Boolean.valueOf(attributes.getValue("subscribe"));
    }

}
