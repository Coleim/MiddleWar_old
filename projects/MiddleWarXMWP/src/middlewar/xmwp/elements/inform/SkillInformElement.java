/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * SKILL / Inform
 * @author higurashi
 */
public class SkillInformElement extends Element{

    private String name = null;
    private String icon = null;
    private String unitId = null;
    private int value = -1;

    public SkillInformElement() throws XMWPException {
        super(ElementType.skill, "onReceivedInformSkill");
    }

    public SkillInformElement(String unitId,String name,String icon,int value) throws XMWPException {
        super(ElementType.skill, "onReceivedInformSkill");
        this.unitId = unitId;
        this.value = value;
        this.icon = icon;
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getUnitId() {
        return unitId;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        if(unitId != null) elt.setAttribute("unitId", unitId);
        if(value > 0) elt.setAttribute("value", String.valueOf(value));
        if(icon != null) elt.setAttribute("icon", icon);
        if(name != null) elt.setAttribute("name", name);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        value = Integer.valueOf(attributes.getValue("value"));
        unitId = attributes.getValue("unitId");
        icon = attributes.getValue("icon");
        name = attributes.getValue("name");
    }

}
