/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MidddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.AnimationType.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business;

import middlewar.server.worldmaker.business.animations.*;
import java.io.Serializable;

/**
 * Every types of animations
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public enum AnimationType implements Serializable{

    EFFECT1(WaEffect1.class,"fire"),
    OBJ1(WaObject1.class,"fire");

    private Class elementClassLayer0; // layer 0 animation
    private String description;       // description of the animation

    private AnimationType(Class elementClassLayer0, String description) {
        this.elementClassLayer0 = elementClassLayer0;
        this.description = description;
    }

    /**
     * Return the layer 0 pattern
     * @return modificator
     */
    public Class getElementClass() {
        return elementClassLayer0;
    }

  
    /**
     * Return description of the animation
     * @return description the description
     */
    public String getDescription() {
        return description;
    }

    
}
