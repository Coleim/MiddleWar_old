/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp.elements.inform;

import middlewar.xmwp.*;

/**
 * IM / Inform
 * @author higurashi
 */
public class ImInformElement extends Element{

    private String message = null;
    private String source_unit_id = null;
    private String destination_user_id = null;

    public ImInformElement() throws XMWPException {
        super(ElementType.im, "onReceivedInformIm");
    }

    public ImInformElement(String source_unit_id,String destination_user_id,String message) throws XMWPException {
        super(ElementType.im, "onReceivedInformIm");
        this.source_unit_id = source_unit_id;
        this.destination_user_id = destination_user_id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getSourceUnitId() {
        return source_unit_id;
    }

    public String getDestinationUserId() {
        return destination_user_id;
    }

    @Override
    protected void build(org.w3c.dom.Element root,org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt = doc.createElement(this.type.getTag());
        if(source_unit_id != null) elt.setAttribute("source_unit_id", source_unit_id);
        if(destination_user_id != null) elt.setAttribute("destination_user_id", destination_user_id);
        if(message != null) elt.setAttribute("message", message);
        root.appendChild(elt);
    }

    @Override
    protected void setAttributes(org.xml.sax.Attributes attributes) {
        message = attributes.getValue("message");
        source_unit_id = attributes.getValue("source_unit_id");
        destination_user_id = attributes.getValue("destination_user_id");
    }

}
