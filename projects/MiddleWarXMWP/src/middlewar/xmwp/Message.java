/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp;

import middlewar.xmwp.elements.inform.HelloInformElement;
import middlewar.xmwp.elements.inform.ErrorInformElement;
import middlewar.xmwp.elements.inform.ByeInformElement;
import middlewar.xmwp.elements.inform.AckInformElement;
import java.io.*;
import java.util.Vector;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;
import middlewar.xmwp.elements.*;
import middlewar.xmwp.logic.XMWPLogic;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 * XMWP message
 * @author higurashi
 */
public class Message {

    protected String key = null;
    protected Vector<Element> inform;
    protected Vector<Element> request;
    protected org.w3c.dom.Document doc;
    protected org.w3c.dom.Element root = null;

    /**
     * XMWP Message
     * @throws middlewar.xmwp.XMWPException
     */
    public Message() throws XMWPException {
        inform = new Vector<Element>();
        request = new Vector<Element>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            doc = parser.newDocument();
        } catch (ParserConfigurationException e) {
            throw new XMWPException(e.getMessage());
        }
    }

    /**
     * Return the org.w3c.dom.Document representing the message.
     * @return the message document
     */
    public Document getDocument(){
        return doc;
    }

    /**
     * Build the XML document
     */
    protected void build(){

        // remove old
        if(doc.hasChildNodes() && root != null){
            doc.removeChild(root);
        }

        // root
        root = doc.createElement("xmwp");
        doc.appendChild(root);

        // security
        org.w3c.dom.Element securityElt = doc.createElement("xmwp:security");
        root.appendChild(securityElt);
        securityElt.setAttribute("key", key);

        // request
        org.w3c.dom.Element requestElt = doc.createElement("request");
        root.appendChild(requestElt);
        for(Element elt : request){
            elt.addToDoc(requestElt,doc);
        }

        // inform
        org.w3c.dom.Element informElt = doc.createElement("inform");
        root.appendChild(informElt);
        for(Element elt : inform){
            elt.addToDoc(informElt,doc);
        }
        
    }

    /**
     * Print the XML Message in an outputstream.
     * @param out the stream
     * @throws middlewar.xmwp.XMWPException
     */
    public void printMessageToStream(OutputStream out) throws XMWPException{
        try {
            build(); // build the message
            Source xml = new DOMSource(doc);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xml, new StreamResult(out));
        } catch (TransformerException e) {
            throw new XMWPException(e.getMessage());
        }
    }

    @Override
    public String toString(){
        String s = new String();
        //s += "SECURITY KEY : "+key+" \n";
        s += "REQUEST : \n";
        for(Element elt : request){
            s += "" + elt.getType().toString() + ",\n";
        }
        s += "INFORM : \n";
        for(Element elt : inform){
            s += "" + elt.getType().toString() + ",\n";
        }
        return s;
    }

    /**
     * Parse a xml (xmwp) message
     * @param in the xml message
     */
    public static Message parseMessageFromStream(InputStream in) throws XMWPException{
        Message message = new Message();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxReader = factory.newSAXParser();
            InputSource source = new InputSource(in);
            saxReader.parse(source,new XMWPContentHandler(message));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new XMWPException(e.getMessage());
        } catch (SAXException e) {
            e.printStackTrace();
            throw new XMWPException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new XMWPException(e.getMessage());
        }
        return message;
    }

    /**
     * Add a inform element.
     * @param element the new element
     */
    public void addInform(Element element){
        inform.add(element);
    }

    /**
     * Add a request element.
     * @param element the new element
     */
    public void addRequest(Element element){
        request.add(element);
    }

    /**
     * Return a message (the andswer to the current message)
     * @param logic the reponse logic
     * @param Message the response message
     * @return the response
     */
    public void processLogicOnMessage(XMWPLogic logic,Message message) throws XMWPException{

        for(Element elt : request){
            logic.onReceived(elt, message);
        }

        for(Element elt : inform){
            logic.onReceived(elt, message);
        }
    }

    /**
     * Return the request elements
     * @return the elements
     */
    public Vector<middlewar.xmwp.Element> getRequest() {
        return request;
    }

    /**
     * Return the inform elements
     * @return the elements
     */
    public Vector<middlewar.xmwp.Element> getInform() {
        return inform;
    }

    public boolean isEmpty() {
        return inform.isEmpty() && request.isEmpty();
    }

    /**
     * Say hello
     */
    public void SendHello() throws XMWPException {
        addInform(new HelloInformElement());
    }

    /**
     * Say bye
     */
    public void SendBye() throws XMWPException{
        addInform(new ByeInformElement());
    }

    /**
     * Say ok (ack)
     */
    public void SendAck() throws XMWPException {
        addInform(new AckInformElement());
    }

    /**
     * Say WTF
     */
    public void SendUnsuported() throws XMWPException {
        addInform(new ErrorInformElement("Unsuported operation"));
    }

    /**
     * Return the security key
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * Modify the security key
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

}

