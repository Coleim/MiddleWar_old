/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * PLAYER / Inform
 * @author higurashi
 */
public class PlayerInformElement extends Element{

    private String[] units = null; // units ids of the player
    private String id = null;

    public PlayerInformElement() throws XMWPException {
        super(ElementType.player, "onReceivedInformPlayer");
    }

    public PlayerInformElement(String[] units,String id) throws XMWPException {
        super(ElementType.player, "onReceivedInformPlayer");
        this.units = units;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String[] getUnits() {
        return units;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        String unitsList = new String();
        if(units.length>0){
            unitsList = unitsList+units[0];
            for(int i=1;i<units.length;i++){
                unitsList = unitsList + "," + units[i];
            }
            elt.setAttribute("units",unitsList);
        }
        if(id != null) elt.setAttribute("id", id);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        String unitsList = attributes.getValue("units");  
        if(unitsList != null) units = unitsList.split(",");
        id = attributes.getValue("id");
    }

}
