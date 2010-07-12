/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : WorldSizableElement.java
 *
 * History :
 * 1.0     : Add to wm
 *
 */

package middlewar.server.worldmaker.business.elements;

import java.io.Serializable;

/**
 * World Element (see ElementType), varialble size
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public abstract class WorldSizableElement  extends WorldElement implements Serializable{

    // Size of pattern (used by subclasses)
    protected int x = 3;
    protected int y = 3;

    /**
     * @see WorldElement
     * size (x, y) is set by world builder
     */
    public WorldSizableElement() {
        super();
    }

    /**
     * Modify the size of the element (x)
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Modify the size of the element (y)
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

}
