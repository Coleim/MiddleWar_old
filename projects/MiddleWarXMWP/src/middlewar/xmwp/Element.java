/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import middlewar.xmwp.logic.XMWPBaseLogic;
import middlewar.xmwp.logic.XMWPLogic;

/**
 * XMWP element
 * @author higurashi
 */
public abstract class Element {

    protected ElementType type;
    protected Method callOnReceive;

    /**
     * XMWP element
     * @param type the type of the element
     */
    public Element(ElementType type, String onReceivedStringMethodName) throws XMWPException{
        try {
            Class[] params = new Class[2];
            params[0] = this.getClass();
            params[1] = Message.class;
            callOnReceive = XMWPLogic.class.getDeclaredMethod(onReceivedStringMethodName, params);
            this.type = type;
        } catch (NoSuchMethodException e) {
             throw new XMWPException("Implémenter la methode " + onReceivedStringMethodName + " dans l'interface XMWPLogic : "+ e.getMessage() );
        } catch (SecurityException e) {
             throw new XMWPException(e.getMessage());
        }
    }

    /**
     * Return the type of the element
     * @return the type
     * @see ElementType
     */
    public final ElementType getType(){
        return type;
    }

    /**
     * Add the element to an xml document
     * @param doc the xml document
     */
    public final void addToDoc(org.w3c.dom.Element root,org.w3c.dom.Document doc){
        build(root,doc);
    }

    /**
     * Add the element to an xml document (private implementation)
     * @param doc the xml document
     */
    protected abstract void build(org.w3c.dom.Element root,org.w3c.dom.Document doc);

    /**
     * Set the attributes of the class (from sax parsing)
     */
    protected abstract void setAttributes(org.xml.sax.Attributes attributes);

    public void onReceived(XMWPLogic logic, Message message) throws XMWPException{
        Object[] params = new Object[2];
        params[0] = this;
        params[1] = message;
        try {
            this.callOnReceive.invoke(logic, params);
        } catch (IllegalAccessException e) {
            throw new XMWPException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new middlewar.xmwp.XMWPException(e.getMessage());
        } catch (InvocationTargetException e) {
            throw new middlewar.xmwp.XMWPException(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return this.type.name();
    }

}
