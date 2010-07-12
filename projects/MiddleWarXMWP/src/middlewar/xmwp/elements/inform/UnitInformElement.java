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
    private String map = null;
    private String[] maps = null;
    private int x = 0;
    private int y = 0;
    private boolean focus = false;

    public UnitInformElement() throws XMWPException {
        super(ElementType.unit, "onReceivedInformUnit");
    }

    public UnitInformElement(String id,String playerId,String map,int x,int y,String[] maps,boolean focus) throws XMWPException {
        super(ElementType.unit, "onReceivedInformUnit");
        this.id = id;
        this.focus = focus;
        this.playerId = playerId;
        this.map = map;
        this.maps = maps;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getMap() {
        return map;
    }

    public boolean isFocus() {
        return focus;
    }

    public String[] getMaps() {
        return maps;
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
        elt.setAttribute("id", id);
        elt.setAttribute("playerId", playerId);
        elt.setAttribute("x", String.valueOf(x));
        elt.setAttribute("y", String.valueOf(y));
        elt.setAttribute("map", map);
        String mapsList = new String();
        if(maps.length>0){
            mapsList = mapsList+maps[0];
            for(int i=1;i<maps.length;i++){
                mapsList = mapsList + "," + maps[i];
            }
            elt.setAttribute("maps",mapsList);
        }
        elt.setAttribute("focus", String.valueOf(focus));
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        id = attributes.getValue("id");
        playerId = attributes.getValue("playerId");
        String mapsList = attributes.getValue("maps");
        if(mapsList != null) maps = mapsList.split(",");
        focus = Boolean.valueOf(attributes.getValue("focus"));
        map = attributes.getValue("map");
        x = Integer.parseInt(attributes.getValue("x"));
        y = Integer.parseInt(attributes.getValue("y"));
    }

}
