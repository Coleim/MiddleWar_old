/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.request;

import middlewar.xmwp.*;

/**
 * MOVE UNIT / Request
 * @author higurashi
 */
public class MoveRequestElement extends Element{

    private String id = null;
    private String map = null;
    private int x = 0;
    private int y = 0;

    public MoveRequestElement() throws XMWPException {
        super(ElementType.move, "onReceivedRequestMove");
    }

    public MoveRequestElement(String id,String map,int x,int y) throws XMWPException {
        super(ElementType.move, "onReceivedRequestMove");
        this.id = id;
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public String getId() {
        return id;
    }

    public String getMap() {
        return map;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        if(id != null) elt.setAttribute("id", id);
        elt.setAttribute("x", String.valueOf(x));
        elt.setAttribute("y", String.valueOf(y));
        if(map != null) elt.setAttribute("map", map);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        id = attributes.getValue("id");
        map = attributes.getValue("map");
        x = Integer.valueOf(attributes.getValue("x"));
        y = Integer.valueOf(attributes.getValue("y"));
    }

}
