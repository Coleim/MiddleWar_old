/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

/**
 * XMWP Content Handler
 * @author higurashi
 */
public class XMWPContentHandler extends DefaultHandler {

    private Message message;
    private boolean request = false;
    private boolean inform = false;

    /**
     * XMWP Parser
     * @param message xmwp message
     */
    public XMWPContentHandler(Message message) {
        super();
        this.message = message;
    }

    @Override
    public void setDocumentLocator(Locator locator){}
    @Override
    public void startDocument() throws SAXException{}
    @Override
    public void endDocument() throws SAXException{}
    @Override
    public void processingInstruction(String target, String data){}
    @Override
    public void startPrefixMapping(String prefix, String uri){}
    @Override
    public void endPrefixMapping(String prefix){}
    @Override
    public void endElement(String namespaceURI, String localName, String rawName) throws SAXException{}
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{}
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException{}
    @Override
    public void skippedEntity(String name)throws SAXException{}

    @Override
    public void startElement(String namespaceURI, String localName, String raxName, Attributes atts) throws SAXException{

        try {

            if(raxName.equals("xmwp:security")){ message.setKey(atts.getValue("key")); }
            else if(raxName.equals("request")){ request = true; inform = false; }
            else if(raxName.equals("inform")){ inform = true; request = false; }
            else{

                // INFORM elements
                if(inform){
                    message.addInform(getInformXMWPElement(namespaceURI,localName,raxName,atts));
                }
                // REQUEST elements
                else if(request){
                    message.addRequest(getRequestXMWPElement(namespaceURI,localName,raxName,atts));
                }

            }

        } catch (XMWPException e){
            throw new SAXException(e);
        }

    }

    private Element getInformXMWPElement(String namespaceURI, String localName, String raxName, Attributes atts) throws XMWPException{
        ElementType type;
        try{
            type = ElementType.valueOf(raxName.substring(5));
        }catch(Exception e){
            throw new XMWPException("unknown inform xmwp element : "+raxName.substring(5));
        }
        Element element = type.newInformInstance();
        element.setAttributes(atts);
        return element;
    }

    private Element getRequestXMWPElement(String namespaceURI, String localName, String raxName, Attributes atts) throws XMWPException{
        ElementType type;
        try{
            type = ElementType.valueOf(raxName.substring(5));
        }catch(Exception e){
            throw new XMWPException("unknown request xmwp element : "+raxName.substring(5));
        }
        Element element = type.newRequestInstance();
        element.setAttributes(atts);
        return element;
    }

}
