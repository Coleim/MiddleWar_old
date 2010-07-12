/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * PUTBLOCK / Inform
 * @author higurashi
 */
public class BlockInformElement extends Element{

    private String map = null;
    private String image = null;

    private int x = 0;
    private int y = 0;
    private int order = 0;
    private int layer = 0;

    private boolean passing = false;

    public BlockInformElement() throws XMWPException {
        super(ElementType.block, "onReceivedInformBlock");
    }

    public BlockInformElement(String map,String image,int x,int y,int order,int layer,boolean passing) throws XMWPException {
        super(ElementType.block, "onReceivedInformBlock");
        this.map = map;
        this.image = image;
        this.x = x;
        this.y = y;
        this.order = order;
        this.layer = layer;
        this.passing = passing;
    }

    public String getImage() {
        return image;
    }

    public int getLayer() {
        return layer;
    }

    public int getOrder() {
        return order;
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

    public boolean isPassing() {
        return passing;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        elt.setAttribute("map", map);
        elt.setAttribute("image", image);
        elt.setAttribute("x", String.valueOf(x));
        elt.setAttribute("y", String.valueOf(y));
        elt.setAttribute("order", String.valueOf(order));
        elt.setAttribute("layer", String.valueOf(layer));
        elt.setAttribute("passing", String.valueOf(passing));
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        map = attributes.getValue("map");
        image = attributes.getValue("image");
        x = Integer.valueOf(attributes.getValue("x"));
        y = Integer.valueOf(attributes.getValue("y"));
        order = Integer.valueOf(attributes.getValue("order"));
        layer = Integer.valueOf(attributes.getValue("layer"));
        passing = Boolean.valueOf(attributes.getValue("passing"));
    }

}
