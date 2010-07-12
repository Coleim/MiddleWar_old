/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * UNIT / Inform
 * @author higurashi
 */
public class UnitInformElement extends Element{

    private String id = null;
    private String playerId = null;
    private String world = null;

    public UnitInformElement() throws XMWPException {
        super(ElementType.unit, "onReceivedInformUnit");
    }

    public UnitInformElement(String id,String playerId,String world) throws XMWPException {
        super(ElementType.unit, "onReceivedInformUnit");
        this.id = id;
        this.playerId = playerId;
        this.world = world;
    }

    public String getId() {
        return id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getWorld() {
        return world;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        elt.setAttribute("id", id);
        elt.setAttribute("playerId", playerId);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        id = attributes.getValue("id");
        playerId = attributes.getValue("playerId");
    }

}
