/*
 * XMWP - Xml Middle War Protocol
 *
 */

package middlewar.xmwp;

import middlewar.xmwp.elements.inform.*;
import middlewar.xmwp.elements.request.*;

/**
 * XMWP keywords
 * @author higurashi
 */
public enum ElementType {

    hello(HelloInformElement.class,null,"xmwp:hello"),
    bye(ByeInformElement.class,null,"xmwp:bye"),
    ack(AckInformElement.class,AckRequestElement.class,"xmwp:ack"),
    error(ErrorInformElement.class,null,"xmwp:error"),
    block(BlockInformElement.class,BlockRequestElement.class,"xmwp:block"),
    im(ImInformElement.class,ImRequestElement.class,"xmwp:im"),
    player(PlayerInformElement.class,PlayerRequestElement.class,"xmwp:player"),
    move(MoveInformElement.class,MoveRequestElement.class,"xmwp:move"),
    update(null,UpdateRequestElement.class,"xmwp:update"),
    skill(SkillInformElement.class,null,"xmwp:skill"),
    unit(UnitInformElement.class,UnitRequestElement.class,"xmwp:unit");
    

    private Class elementInformClass;
    private Class elementRequestClass;
    private String tag;

    private ElementType(Class elementInformClass,Class elementRequestClass,String tag){
        this.elementRequestClass = elementRequestClass;
        this.elementInformClass = elementInformClass;
        this.tag = tag;
    }

    public Class getElementInformClass(){
        return elementInformClass;
    }

    public Class getElementRequestClass() {
        return elementRequestClass;
    }

    public String getTag() {
        return tag;
    }
    
    public Element newInformInstance() {
        Element elt = null;
        try {
            elt = (Element) elementInformClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return elt;
    }

    public Element newRequestInstance() {
        Element elt = null;
        try {
            elt = (Element) elementRequestClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return elt;
    }

}
