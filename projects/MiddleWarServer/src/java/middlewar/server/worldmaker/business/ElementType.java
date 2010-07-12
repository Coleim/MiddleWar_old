/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.ElementType.java
 *
 * History :
 * 1.0     : Add to wm, basic types
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.server.worldmaker.business.elements.*;
import java.io.Serializable;

/**
 * Every types of elements
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public enum ElementType implements Serializable{

    DOR1(WeDoor1.class,"grotte"),
    HOU1(WeHouse1.class,"maison 1 "),
    NAT3(WeNature3.class,"arbre (sapin) pot "),
    NAT2(WeNature2.class,"grand arbre sans feuilles"),
    NAT1(WeNature1.class,"grand arbre feuilles"),
    STR1(WeStrairs1.class,"stairs 1"),
    OBJ6(WeObject6.class,"deamon deco 3"),
    OBJ5(WeObject5.class,"deamon deco 2"),
    OBJ4(WeObject4.class,"deamon deco 1"),
    OBJ3(WeObject3.class,"pont bois (h) (sizable)"),
    OBJ2(WeObject2.class,"pot de fleurs"),
    OBJ1(WeObject1.class,"small red wall flag (deco)");

    private Class elementClass;       // element
    private String description;       // description of the element

    private ElementType(Class elementClass, String description) {
        this.elementClass = elementClass;
        this.description = description;
    }

    /**
     * Return the class
     * @return modificator
     */
    public Class getElementClass() {
        return elementClass;
    }

    /**
     * Return description of the element
     * @return description the description
     */
    public String getDescription() {
        return description;
    }

}
